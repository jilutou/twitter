package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import model.Admin;
import model.List;
import model.Message;
import model.Moment;
import model.Notification;
import model.RLTweet;
import model.Tweet;
import model.User;

public class TServer implements TProtocal, Runnable{
	private Socket s;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private ServerSocket ss;
	private String path="C:/Twitter/SLIB/picture/";
	
	public TServer() throws IOException{
		ss = new ServerSocket(1017);
		Thread t = new Thread(this);
		t.start();
	}
	
	public void login() throws SQLException, ClassNotFoundException, IOException{
		User u = null;
		String id = ois.readUTF();
		String password = ois.readUTF();
		String sql = "select * from user where id='"+id+"'and "+"password='"+password+"'";
		ResultSet rs = DBConnect.getStat().executeQuery(sql);
		if (rs.next())
			u = new User(rs.getString(1),true,rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12));
		oos.writeObject(u);
		oos.flush();
	}
	public void register() throws SQLException, ClassNotFoundException, IOException{
		String name = ois.readUTF();
		String password = ois.readUTF();
		String id=name;
		int i=0;
		String sql="select*from user where id='"+name+"'";
		ResultSet rs = DBConnect.getStat().executeQuery(sql);
		while(rs.next()){
			id=name+(++i);
			sql="select*from user where id='"+id+"'";
			rs = DBConnect.getStat().executeQuery(sql);
		}
		sql="insert into user(id,name,password) values('"+id+"','"+name+"','"+password+"')";
		DBConnect.getStat().executeUpdate(sql);
	}
	
	public void searchUsers() throws IOException, ClassNotFoundException, SQLException{
		User u=(User) ois.readObject();
		String[]keywords=ois.readUTF().split(" ");
		String sql="select * from user where id like'%"+keywords[0]+"%' or name like'%"+keywords[0]+"%'";
		for(int i=1;i<keywords.length;i++){
			sql+="or id like'%"+keywords[i]+"%' or name like'%"+keywords[i]+"%'";
		}
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		ArrayList<User>users=new ArrayList<User>();
		while(rs.next()){
			users.add(new User(rs.getString(1),false,rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12)));
		}
		User user;
		for(int i=0;i<users.size();i++){
			sql="select*from follows where uid='"+u.getId()+"'and to_uid='"+users.get(i).getId()+"'";
			rs=DBConnect.getStat().executeQuery(sql);
			if(rs.next()){
				user=users.get(i);
				user.setFollowed(true);
				users.set(i,user);
			}
		}
		oos.writeObject(users);
		oos.flush();
	}
	public void searchTweets() throws IOException, ClassNotFoundException, SQLException{
		User u=(User) ois.readObject();
		String[]keywords=ois.readUTF().split(" ");
		String sql="select*from tweets where contents like'%"+keywords[0]+"%'";
		for(int i=1;i<keywords.length;i++){
			sql+="or contents like'%"+keywords[i]+"%'";
		}
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		ArrayList<Tweet>tweets=new ArrayList<Tweet>();
		while(rs.next()){
			tweets.add(new Tweet(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getInt(4),rs.getString(5), rs.getString(6), rs.getInt(7),rs.getString(8),rs.getInt(9), rs.getInt(10),rs.getInt(11), rs.getInt(12)));
		}
		for(int i=0;i<tweets.size();i++)
			tweets.set(i,setTweetMsg(u,tweets.get(i)));
		oos.writeObject(tweets);
		oos.flush();
	}
	
	
	
	
	public void getRecommend() throws IOException, ClassNotFoundException, SQLException{
		User u=(User) ois.readObject();
		ArrayList<User>followings=getFollowings(u, u.getId());
		ArrayList<User> recommend=new ArrayList<User>();
		String sql="select count(*)from user";
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		rs.next();
		int count=rs.getInt(1);
		Random rd=new Random();
		for(int i=0;i<3;i++){
			sql="select*from user limit"+rd.nextInt(count);
			rs=DBConnect.getStat().executeQuery(sql);
			for(User following:followings){
				if(following.getId().equals(rs.getInt(1))){
					i--;
					break;
				}else
					recommend.add(new User(rs.getString(1),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),false));
			}
		}
		oos.writeObject(recommend);
		oos.flush();
	}
	
	public void editProfile() throws SQLException, ClassNotFoundException, IOException{
		User u=(User) ois.readObject();
		if(u.isLogin()){
			String sql="update user set name='"+u.getName()+"',bio='"+u.getBio()+"',birth='"+u.getBirth()+"' where id='"+u.getId()+"'";;
			DBConnect.getStat().executeUpdate(sql);
		}
	}
	public void setPic() throws SQLException, ClassNotFoundException, IOException{
		User u=(User) ois.readObject();
		sendPic();
		if(u.isLogin()){
			String sql="update user set picfname='"+ois.readUTF()+"'where id='"+u.getId()+"'";;
			DBConnect.getStat().executeUpdate(sql);
		}
	}
	public void setBG() throws SQLException, ClassNotFoundException, IOException{
		User u=(User) ois.readObject();
		sendPic();
		if(u.isLogin()){
			String sql="update user set bgfname='"+ois.readUTF()+"'where id='"+u.getId()+"'";;
			DBConnect.getStat().executeUpdate(sql);
		}
	}
	
	
	
	
	/*关注用户*/
	public void follow() throws SQLException, ClassNotFoundException, IOException{
		User u = (User) ois.readObject();
		String uid = ois.readUTF();
		boolean followed = ois.readBoolean();
		if(u.isLogin()){
			String sql;
			ResultSet rs;
			if(followed){
				sql="delete from follows where uid='"+u.getId()+"'and to_uid='"+uid+"'";
				DBConnect.getStat().executeUpdate(sql);
				sql="update user set following="+(u.getFollowing()-1)+" where id='"+u.getId()+"'";
				DBConnect.getStat().executeUpdate(sql);
				sql="select*from user where id='"+uid+"'";
				rs=DBConnect.getStat().executeQuery(sql);
				rs.next();
				sql="update user set follower="+(rs.getInt(11)-1)+" where id='"+uid+"'";
				DBConnect.getStat().executeUpdate(sql);
			}else{
				sql="insert into follows(uid,to_uid) values('"+u.getId()+"','"+uid+"')";
				DBConnect.getStat().executeUpdate(sql);
				sql="update user set following="+(u.getFollowing()+1)+" where id='"+u.getId()+"'";
				DBConnect.getStat().executeUpdate(sql);
				sql="select*from user where id='"+uid+"'";
				rs=DBConnect.getStat().executeQuery(sql);
				rs.next();
				sql="update user set follower="+(rs.getInt(11)+1)+" where id='"+uid+"'";
				DBConnect.getStat().executeUpdate(sql);
				createNotification(u.getId(),0,uid);
			}
		}
	}
	/*根据用户id获取用户*/
	public void getUser() throws SQLException, ClassNotFoundException, IOException{
		User u = (User) ois.readObject();
		String to_uid = ois.readUTF();
		boolean isFollow;
		String sql="select count(*) from follows where uid='"+u.getId()+"'and to_uid='"+to_uid+"'";
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		rs.next();
		if(rs.getInt(1)==0)isFollow=false;
		else isFollow=true;
		sql="select*from user where id='"+to_uid+"'";
		rs=DBConnect.getStat().executeQuery(sql);
		if(rs.next()){
			u=new User(rs.getString(1),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),isFollow);
		}else
			u=null;
		oos.writeObject(u);
		oos.flush();
	}
	/*获取关注列表*/
	public void getFollowings() throws SQLException, ClassNotFoundException, IOException{
		User u = (User) ois.readObject();
		ArrayList<User> users = new ArrayList<User>();
		String uid = ois.readUTF();
		ArrayList<String> to_uid=new ArrayList<String>();
		String sql = "select * from follows where uid='"+uid+"'";
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		while(rs.next())
			to_uid.add(rs.getString(2));
		for(String str:to_uid)
			users.add(getUser(u,str));
		oos.writeObject(users);
		oos.flush();
	}
	public void getFollowers() throws SQLException, ClassNotFoundException, IOException{
		User u = (User) ois.readObject();
		String uid = ois.readUTF();
		ArrayList<String> uids=new ArrayList<String>();
		ArrayList<User> users=new ArrayList<User>();
		String sql = "select * from follows where to_uid='"+uid+"'";
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		while(rs.next())
			uids.add(rs.getString(2));
		for(String str:uids)
			users.add(getUser(u,str));
		oos.writeObject(users);
		oos.flush();
	}
	
	
	
	/*发推文*/
	public void tweet1() throws SQLException, ClassNotFoundException, IOException{
		User u = (User) ois.readObject();
		if(u.isLogin()){
			String cont = ois.readUTF();
			int mediaType = ois.readInt();
			String sql="insert into tweets(uid,contents,mediatype)values('"+u.getId()+"','"+cont+"',"+mediaType+")";
			DBConnect.getStat().executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			ResultSet rs=DBConnect.getStat().getGeneratedKeys();
			if(mediaType==2||mediaType==3){
				rs.next();
				int tid=rs.getInt(1);
				ArrayList<String> media=(ArrayList<String>) ois.readObject();
				for(int i=0;i<media.size();i++){
					sql="insert into media values('"+media.get(i)+"',"+tid+")";
					DBConnect.getStat().executeUpdate(sql);
				}
			}
		}
	}
	public void tweet2() throws SQLException, ClassNotFoundException, IOException{
		User u = (User) ois.readObject();
		if(u.isLogin()){
			int type  =  ois.readInt();
			String to_uid = ois.readUTF();
			int to_tid = ois.readInt();
			String cont = ois.readUTF();
			int mediaType = ois.readInt();
			String sql="insert into tweets(type,to_uid,to_tid,uid,contents,mediatype)values("+type+",'"+to_uid+"',"+to_tid+",'"+u.getId()+"','"+cont+"',"+mediaType+")";
			DBConnect.getStat().executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			ResultSet rs=DBConnect.getStat().getGeneratedKeys();
			int tid=0;
			if(mediaType==2||mediaType==3){
				rs.next();
				tid=rs.getInt(1);
				ArrayList<String> media=(ArrayList<String>) ois.readObject();
				for(int i=0;i<media.size();i++){
					sql="insert into media values('"+media.get(i)+"',"+tid+")";
					DBConnect.getStat().executeUpdate(sql);
				}
			}
			if(type==0){
				sql="select*from tweets where id="+to_tid;
				rs=DBConnect.getStat().executeQuery(sql);
				rs.next();
				sql="update tweets set replays="+(rs.getInt(10)+1)+" where id="+to_tid;
				DBConnect.getStat().executeUpdate(sql);
				createNotification(u.getId(),1,tid+"");
			}
		}
	}
	public void delTweet() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		int tid = ois.readInt();
		if(u.isLogin()){
			String sql="delete from tweets where id="+tid;
			DBConnect.getStat().executeUpdate(sql);
		}
	}
	
	/*转发，点赞，收藏*/
	public void retweet() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		int tid = ois.readInt();
		boolean retweeted = ois.readBoolean();
		if(u.isLogin()){
			String sql;
			ResultSet rs;
			if(retweeted){
				sql="delete from retweets where uid='"+u.getId()+"'and tid="+tid;
				DBConnect.getStat().executeUpdate(sql);
				sql="select*from tweets where id="+tid;
				rs=DBConnect.getStat().executeQuery(sql);
				rs.next();
				sql="update tweets set retweets="+(rs.getInt(10)-1)+" where id="+tid;
				DBConnect.getStat().executeUpdate(sql);
			}else{
				sql="insert into retweets(uid,tid) values('"+u.getId()+"',"+tid+")";
				DBConnect.getStat().executeUpdate(sql);
				sql="select*from tweets where id="+tid;
				rs=DBConnect.getStat().executeQuery(sql);
				rs.next();
				sql="update tweets set retweets="+(rs.getInt(10)+1)+" where id="+tid;
				DBConnect.getStat().executeUpdate(sql);
				createNotification(u.getId(),2,""+tid);
			}
		}
	}
	public void like() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		int tid = ois.readInt();
		boolean liked = ois.readBoolean();
		if(u.isLogin()){
			String sql;
			ResultSet rs;
			if(liked){
				sql="delete from likes where uid='"+u.getId()+"'and tid="+tid;
				DBConnect.getStat().executeUpdate(sql);
				sql="select*from tweets where id="+tid;
				rs=DBConnect.getStat().executeQuery(sql);
				rs.next();
				sql="update tweets set likes="+(rs.getInt(11)-1)+" where id="+tid;
				DBConnect.getStat().executeUpdate(sql);
			}else{
				sql="insert into likes(uid,tid) values('"+u.getId()+"',"+tid+")";
				DBConnect.getStat().executeUpdate(sql);
				sql="select*from tweets where id="+tid;
				rs=DBConnect.getStat().executeQuery(sql);
				rs.next();
				sql="update tweets set likes="+(rs.getInt(11)+1)+" where id="+tid;
				DBConnect.getStat().executeUpdate(sql);
				createNotification(u.getId(),3,""+tid);
			}
		}
	}
	public void mark() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		int tid = ois.readInt();
		boolean marked = ois.readBoolean();
		if(u.isLogin()){
			String sql;
			if(marked){
				sql="delete from bookmarks where uid='"+u.getId()+"'and tid="+tid;
				DBConnect.getStat().executeUpdate(sql);
			}else{
				sql="insert into bookmarks(uid,tid) values('"+u.getId()+"',"+tid+")";
				DBConnect.getStat().executeUpdate(sql);
			}
		}
	}
	
	/*根据推文id获取推文*/
	public void getTweet() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		int tid = ois.readInt();
		String sql="select * from tweets where id="+tid;
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		Tweet tweet=null;
		if(rs.next()){
			tweet=new RLTweet(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8), rs.getInt(9),rs.getInt(10), rs.getInt(11),rs.getInt(12));
			tweet=setTweetMsg(u,tweet);
		}
		oos.writeObject(tweet);
		oos.flush();
		sql="select picfname from user where id='"+tweet.getUid()+"'";
		rs=DBConnect.getStat().executeQuery(sql);
		rs.next();
		oos.writeUTF(rs.getString(1));
		oos.flush();
	}
	/*获取当前用户关注的用户的推文*/
	public void getAllTweets() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		ArrayList<User> followings=getFollowings(u,u.getId());
		ArrayList<Tweet> tweets =new ArrayList<Tweet>();
		String sql="select * from tweets where uid='"+u.getId()+"'";
		for(int i=0;i<followings.size();i++)
			sql+="or uid='"+followings.get(i).getId()+"'";
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		while(rs.next())
			tweets.add(new Tweet(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getInt(12)));
		for(int i=0;i<tweets.size();i++)
			tweets.set(i,setTweetMsg(u,tweets.get(i)));
		oos.writeObject(tweets);
		oos.flush();
		oos.writeObject(followings);
		oos.flush();
	}
	/*获取当前用户关注的用户转发点赞的推文*/
	public void getAllLRTweets() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		String reli = ois.readUTF();
		ArrayList<User> followings=getFollowings(u,u.getId());
		ArrayList<RLTweet> rltweets=new ArrayList<RLTweet>();
		ArrayList<String> uids=new ArrayList<String>();
		ArrayList<Integer> tids=new ArrayList<Integer>();
		ArrayList<String>time=new ArrayList<String>();
		String sql="select * from "+reli+" where uid='"+u.getId()+"'";
		for(int i=0;i<followings.size();i++)
			sql+="or uid='"+followings.get(i).getId()+"'";
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		while(rs.next()){
			uids.add(rs.getString(1));
			tids.add(rs.getInt(2));
			time.add(rs.getString(3));
		}
		RLTweet rltweet;
		String uname = null;
		for(int i=0;i<tids.size();i++){
			rltweet=(RLTweet) getTweet(u,tids.get(i));
			rltweet.setOpuid(uids.get(i));
			for(User following:followings){
				if(following.getId().equals(uids.get(i))){
					uname=following.getName();
					break;
				}
			}
			rltweet.setOpuname(uname);
			rltweet.setOptime(time.get(i));
			rltweets.add(rltweet);
		}
		oos.writeObject(rltweets);
		oos.flush();
	}
	/*获取当前用户发的推文*/
	public void getUTweets() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		String uid = ois.readUTF();
		ArrayList<Tweet> tweets=new ArrayList<Tweet>();
		String sql="select * from tweets where uid='"+uid+"'";
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		while(rs.next())
			tweets.add(new Tweet(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getInt(4),rs.getString(5), rs.getString(6), rs.getInt(7),rs.getString(8),rs.getInt(9), rs.getInt(10),rs.getInt(11), rs.getInt(12)));
		for(int i=0;i<tweets.size();i++)
			tweets.set(i,setTweetMsg(u,tweets.get(i)));
		oos.writeObject(tweets);
		oos.flush();
	}
	/*获取当前用户转发点赞的推文*/
	public void getURLTweets() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		String uid = ois.readUTF();
		String uname = ois.readUTF();
		String reli = ois.readUTF();
		ArrayList<RLTweet> rltweets=new ArrayList<RLTweet>();
		ArrayList<Integer> tids=new ArrayList<Integer>();
		ArrayList<String>time=new ArrayList<String>();
		String sql="select * from "+reli+" where uid='"+uid+"'";
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		while(rs.next()){
			tids.add(rs.getInt(2));
			time.add(rs.getString(3));
		}
		RLTweet rltweet;
		for(int i=0;i<tids.size();i++){
			rltweet=(RLTweet) getTweet(u,tids.get(i));
			rltweet.setOpuid(uid);
			rltweet.setOpuname(uname);
			rltweet.setOptime(time.get(i));
			rltweets.add(rltweet);
		}
		oos.writeObject(rltweets);
		oos.flush();
	}
	public void getFatherTweets() throws SQLException, ClassNotFoundException, IOException{
		User u=(User) ois.readObject();
		int to_tid=ois.readInt();
		ArrayList<Tweet>ftweets=new ArrayList<Tweet>();
		String sql="select * from tweets where id="+to_tid;
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		while(rs.next()){
			to_tid=rs.getInt(4);
			ftweets.add(new Tweet(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getInt(4),rs.getString(5), rs.getString(6), rs.getInt(7),rs.getString(8),rs.getInt(9), rs.getInt(10),rs.getInt(11), rs.getInt(12)));
			sql="select * from tweets where id="+to_tid;
			rs=DBConnect.getStat().executeQuery(sql);
		}
		for(int i=0;i<ftweets.size();i++)
			ftweets.set(i,setTweetMsg(u,ftweets.get(i)));
		oos.writeObject(ftweets);
		oos.flush();
	}
	public void getComment() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		int tid = ois.readInt();
		ArrayList<Tweet> tweets=new ArrayList<Tweet>();
		String sql="select * from tweets where to_tid="+tid;
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		while(rs.next())
			tweets.add(new Tweet(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getInt(4),rs.getString(5), rs.getString(6), rs.getInt(7),rs.getString(8),rs.getInt(9), rs.getInt(10),rs.getInt(11), rs.getInt(12)));
		for(int i=0;i<tweets.size();i++)
			tweets.set(i,setTweetMsg(u,tweets.get(i)));
		oos.writeObject(tweets);
		oos.flush();
	}
	
	
	
	/*获取通知，私信，收藏*/
	public void getNoti() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		ArrayList<User> followings=getFollowings(u,u.getId());
		ArrayList<Notification> noti = new ArrayList<Notification>();
		if(followings.size()!=0){
			String sql="select * from notification where uid='"+u.getId()+"'";
			for(int i=0;i<followings.size();i++)
				sql+="or'"+followings.get(i).getId()+"'";
			ResultSet rs = DBConnect.getStat().executeQuery(sql);
			while (rs.next())
				noti.add(new Notification(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getString(4),rs.getString(5)));
		}
		oos.writeObject(noti);
		oos.flush();
	}
	public void getNewNoti() throws IOException, ClassNotFoundException, SQLException{
		User u=(User) ois.readObject();
		String sql="select * from newnotification where uid='"+u.getId();
		ResultSet rs = DBConnect.getStat().executeQuery(sql);
		oos.writeBoolean(rs.next());
	}
	public void readNoti() throws SQLException, ClassNotFoundException, IOException{
		User u=(User) ois.readObject();
		String sql="delete *from newnotification where uid='"+u.getId()+"'";
		DBConnect.getStat().executeUpdate(sql);
	}
	
	
	public void getMessages() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		ArrayList<Message> m = new ArrayList<Message>();
		String sql = "select * from Messages where id_1='"+u.getId()+"' or id_2='"+u.getId()+"'";
		ResultSet rs = DBConnect.getStat().executeQuery(sql);
		while (rs.next())
			m.add(new Message(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4)));
		oos.writeObject(m);
		oos.flush();
	}
	public void sendFile() throws IOException, SQLException, ClassNotFoundException{
		String fname=ois.readUTF();
		File f=new File("C:/Twitter/SLIB/record/"+fname);
		f.getParentFile().mkdirs();
		FileOutputStream fos=new FileOutputStream(f);
		InputStream is=s.getInputStream();
		byte[] b=new byte[1024];
		int len=0;
		while((len=is.read(b))!=-1)
			fos.write(b,0,len);
		fos.close();
	}
	public void getFile() throws IOException{
		String fname=ois.readUTF();
		File f=new File("C:/Twitter/SLIB/record/"+fname);
		FileInputStream fis=new FileInputStream(f);
		OutputStream os=s.getOutputStream();
		byte b[]=new byte[1024];
		int len=0;
		while((len=fis.read(b))!=-1)
			os.write(b,0,len);
		s.shutdownOutput();
	}
	
	public void getBookMarks() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		ArrayList<Integer>tids=new ArrayList<Integer>();
		ArrayList<Tweet> tw=new ArrayList<Tweet>();
		String sql = "select * from bookmarks where uid='"+u.getId()+"'" ;
		ResultSet rs = DBConnect.getStat().executeQuery(sql);
		while (rs.next())
			tids.add(rs.getInt(2));
		for(int tid:tids)
			tw.add(getTweet(u,tid));
		oos.writeObject(tw);
		oos.flush();
	}
	
	
	
	/*列表*/
	/*创建个人列表*/
	public void createOwnedList() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		String title = ois.readUTF();
		String description = ois.readUTF();
		boolean isprvate = ois.readBoolean();
		if(u.isLogin()){
			String sql="insert into lists(uid,title,description,isprivate) values('"+u.getId()+"','"+title+"','"+description+"',"+isprvate+")";
			DBConnect.getStat().executeUpdate(sql);
		}
	}
	/*删除*/
	public void delOwnedList() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		int id = ois.readInt();
		if(u.isLogin()){
			String sql="delete from lists where id="+id;
			DBConnect.getStat().executeUpdate(sql);
		}
	}
	/*获取拥有列表*/
	public void getOwned() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		User user = (User) ois.readObject();
		ArrayList<List> lists=new ArrayList<List>();
		String sql;
		if(u.getId().equals(user.getId()))
			sql="select * from lists where uid='"+user.getId()+"'";
		else
			sql="select * from lists where uid='"+user.getId()+"'and isprivate=false";
		ResultSet rs = DBConnect.getStat().executeQuery(sql);
		while(rs.next())
			lists.add(new List(rs.getInt(1),rs.getString(2),user.getName(),user.getPicfname(),rs.getString(3),rs.getString(4),rs.getBoolean(5),rs.getInt(6),rs.getInt(7),rs.getString(8)));
		int listid;
		List list;
		if(!user.getId().equals(u.getId())){
			
			for(int i=0;i<lists.size();i++){
				listid=lists.get(i).getId();
				sql="select*from subscribed where uid='"+u.getId()+"'and listid="+listid;
				rs = DBConnect.getStat().executeQuery(sql);
				if(rs.next()){
					list=lists.get(i);
					list.setSubscribed(true);
					lists.set(i,list);
				}else{
					list=lists.get(i);
					list.setSubscribed(false);
					lists.set(i,list);
				}
			}
		}
		oos.writeObject(lists);
		oos.flush();
	}
	/*订阅列表*/
	public void subscribe() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		int listid = ois.readInt();
		boolean subscribed = ois.readBoolean();
		if(u.isLogin()){
			String sql;
			ResultSet rs;
			if(subscribed){
				sql="delete from subscribed where uid='"+u.getId()+"'and listid="+listid;
				DBConnect.getStat().executeUpdate(sql);
				sql="select*from lists where id="+listid;
				rs=DBConnect.getStat().executeQuery(sql);
				rs.next();
				sql="update lists set likes="+(rs.getInt(7)-1)+" where id="+listid;
				DBConnect.getStat().executeUpdate(sql);
			}else{
				sql="insert into subscribed(uid,listid) values('"+u.getId()+"',"+listid+")";
				DBConnect.getStat().executeUpdate(sql);
				sql="select*from lists where id="+listid;
				rs=DBConnect.getStat().executeQuery(sql);
				rs.next();
				sql="update lists set likes="+(rs.getInt(7)+1)+" where id="+listid;
				DBConnect.getStat().executeUpdate(sql);
			}
		}
	}
	/*获取订阅列表*/
	public void getSubscribed() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		String uid = ois.readUTF();
		ArrayList<Integer> listids=new ArrayList<Integer>();
		ArrayList<List> subList=new ArrayList<List>();
		String sql = "select * from subscribed where uid='"+uid+"'";
		ResultSet rs = DBConnect.getStat().executeQuery(sql);
		while(rs.next())
			listids.add(rs.getInt(2));
		for(int listid:listids){
			sql = "select * from lists where id="+listid;
			rs = DBConnect.getStat().executeQuery(sql);
			rs.next();
			if(uid.equals(u.getId()))
				subList.add(new List(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5),rs.getInt(6),rs.getInt(7),rs.getString(8),true));
			else
				subList.add(new List(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5),rs.getInt(6),rs.getInt(7),rs.getString(8)));
		}
		List list;
		for(int i=0;i<subList.size();i++){
			sql="select * from user where id='"+uid+"'";
			rs = DBConnect.getStat().executeQuery(sql);
			rs.next();
			list=subList.get(i);
			list.setUname(rs.getString(4));
			subList.set(i,list);
			list.setUpicfname(rs.getString(5));
			subList.set(i,list);
		}
		if(!uid.equals(u.getId())){
			int listid;
			for(int i=0;i<subList.size();i++){
					listid=subList.get(i).getId();
					sql="select*from subscribed where uid='"+u.getId()+"'and listid="+listid;
					rs = DBConnect.getStat().executeQuery(sql);
					if(rs.next()){
						list=subList.get(i);
						list.setSubscribed(true);
						subList.set(i,list);
					}else{
						list=subList.get(i);
						list.setSubscribed(false);
						subList.set(i,list);
					}
			}
		}
		oos.writeObject(subList);
		oos.flush();
	}
	/*获取列表成员*/
	public void getListMembers() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		int listid = ois.readInt();
		ArrayList<String> uids=new ArrayList<String>();
		ArrayList<User> members=new ArrayList<User>();
		String sql="select * from members where listid="+listid;
		ResultSet rs = DBConnect.getStat().executeQuery(sql);
		User user;
		while(rs.next())
			uids.add(rs.getString(3));
		for(String uid:uids){
			user=getUser(u,uid);
			members.add(user);
		}
		oos.writeObject(members);
		oos.flush();
	}
	/*获取关注列表的用户*/
	public void getListSubscribers() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		int listid = ois.readInt();
		String sql="select * from subscribed where listid="+listid;
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		ArrayList<String> uids=new ArrayList<String>();
		ArrayList<User> subscribers=new ArrayList<User>();
		User user=null;
		while(rs.next())
			uids.add(rs.getString(1));
		for(String uid:uids){
			if((user=getUser(u,uid))!=null)
			subscribers.add(user);
		}
		oos.writeObject(subscribers);
		oos.flush();
	}
	/*获取列表的推文*/
	public void getListTweets() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		ArrayList<User> ulist=(ArrayList<User>) ois.readObject();
		ArrayList<Tweet> tweets =new ArrayList<Tweet>();
		if(ulist.size()!=0){
			String sql="select * from tweets where uid='"+ulist.get(0).getId()+"'";
			for(int i=1;i<ulist.size();i++)
				sql+="or id='"+ulist.get(i).getId()+"'";
			ResultSet rs=DBConnect.getStat().executeQuery(sql);
			while(rs.next())
				tweets.add(new Tweet(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getInt(4),rs.getString(5), rs.getString(6), rs.getInt(7),rs.getString(8),rs.getInt(9), rs.getInt(10),rs.getInt(11), rs.getInt(12)));
			for(int i=0;i<tweets.size();i++)
				tweets.set(i,setTweetMsg(u,tweets.get(i)));
		}
		oos.writeObject(tweets);
		oos.flush();
	}
	public void getListRetweets() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		ArrayList<User> members=(ArrayList<User>) ois.readObject();
		ArrayList<RLTweet> rtweets=new ArrayList<RLTweet>();
		if(members.size()!=0){
			ArrayList<String> uids=new ArrayList<String>();
			ArrayList<Integer> tids=new ArrayList<Integer>();
			ArrayList<String>time=new ArrayList<String>();
			String sql="select * from retweets where uid='"+members.get(0).getId()+"'";
			for(int i=1;i<members.size();i++)
				sql+="or id='"+members.get(i).getId()+"'";
			ResultSet rs=DBConnect.getStat().executeQuery(sql);
			while(rs.next()){
				uids.add(rs.getString(1));
				tids.add(rs.getInt(2));
				time.add(rs.getString(3));
			}
			oos.writeInt(tids.size());
			oos.flush();
			RLTweet rtweet;
			String uname = null;
			for(int i=0;i<tids.size();i++){
				rtweet=(RLTweet) getTweet(u,tids.get(i));
				rtweet.setOpuid(uids.get(i));
				for(User member:members){
					if(member.getId().equals(uids.get(i))){
						uname=member.getName();
						break;
					}
				}
				rtweet.setOpuname(uname);
				rtweet.setTime(time.get(i));
				rtweets.add(rtweet);
			}
		}
		oos.writeObject(rtweets);
		oos.flush();
	}
	/*获取用户被添加到的列表*/
	public void getMember() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		String uid = ois.readUTF();
		String sql = "select * from members where uid='"+uid+"'";
		ResultSet rs = DBConnect.getStat().executeQuery(sql);
		ArrayList<List> memberList=new ArrayList<List>();
		ArrayList<Integer> listids=new ArrayList<Integer>();
		while(rs.next())
			listids.add(rs.getInt(2));
		for(int listid:listids){
			sql="select * from lists where id="+listid;
			rs=DBConnect.getStat().executeQuery(sql);
			rs.next();
			memberList.add(new List(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5),rs.getInt(6),rs.getInt(7),rs.getString(8)));
		}
		List list;
		for(int i=0;i<memberList.size();i++){
			sql="select * from user where id='"+memberList.get(i).getUid()+"'";
			rs = DBConnect.getStat().executeQuery(sql);
			rs.next();
			list=memberList.get(i);
			list.setUname(rs.getString(4));
			memberList.set(i,list);
			list.setUpicfname(rs.getString(5));
			memberList.set(i,list);
		}
		int listid;
		for(int i=0;i<memberList.size();i++){
			listid=memberList.get(i).getId();
			sql="select*from subscribed where uid='"+u.getId()+"'and listid="+listid;
			rs = DBConnect.getStat().executeQuery(sql);
			if(rs.next()){
				list=memberList.get(i);
				list.setSubscribed(true);
				memberList.set(i,list);
			}else{
				list=memberList.get(i);
				list.setSubscribed(false);
				memberList.set(i,list);
			}
		}
		oos.writeObject(memberList);
		oos.flush();
	}
	public void updOwnList() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		List list = (List) ois.readObject();
		if(u.isLogin()){
			String sql="update lists set title='"+list.getTitle()+"',description='"+list.getDescription()+"',isprivate="+list.isIsprivate()+" where id="+list.getId();
			DBConnect.getStat().executeUpdate(sql);
		}
	}
	public void addUser() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		List list = (List) ois.readObject();
		String uid = ois.readUTF();
		String uname = ois.readUTF();
		if(u.isLogin()){
			if(list.getUid().equals(u.getId())){
				String sql="insert into members(listid,uid,uname) values("+u.getId()+",'"+uid+"','"+uname+"')";
				DBConnect.getStat().executeUpdate(sql);
			}
		}
	}
	public void delUser() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		List list = (List) ois.readObject();
		String uid = ois.readUTF();
		if(u.isLogin()){
			if(list.getUid().equals(u.getId())){
				String sql="delete from members where listid="+u.getId()+" and uid='"+uid+"'";
				DBConnect.getStat().executeUpdate(sql);
			}
		}
	}
	
	
	
	/*瞬间*/
	/*创建瞬间*/
	public void createMoment() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		String title = ois.readUTF();
		String description = ois.readUTF();
		int cover_fname = ois.readInt();
		ArrayList<Tweet> mtweets = (ArrayList<Tweet>) ois.readObject();
		if(u.isLogin()){
			String sql="insert into moments(uid,title,description,cover_fname) values('"+u.getId()+"','"+title+"','"+description+"',"+cover_fname+")";
			DBConnect.getStat().executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			ResultSet rs=DBConnect.getStat().getGeneratedKeys();
			rs.next();
			int mid=rs.getInt(1);
			for(int i=0;i<mtweets.size();i++){
				sql="insert into mtweets values('"+mid+"',"+mtweets.get(i).getId()+")";
				DBConnect.getStat().executeUpdate(sql);
			}
		}
	}
	/*获取瞬间*/
	public void getMoments() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		User user = (User) ois.readObject();
		String sql = "select * from moments where uid='"+user.getId()+"'";
		ResultSet rs = DBConnect.getStat().executeQuery(sql);
		ArrayList<Moment> moments=new ArrayList<Moment>();
		while(rs.next())
			moments.add(new Moment(rs.getInt(1),rs.getString(2),user.getName(),user.getBgfname(),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
		oos.writeObject(moments);
		oos.flush();
	}
	/*获取瞬间的推文*/
	public void getMTweets() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		int mid = ois.readInt();
		String sql = "select * from mtweets where mid="+mid;
		ResultSet rs = DBConnect.getStat().executeQuery(sql);
		ArrayList<Integer>tids=new ArrayList<Integer>();
		ArrayList<Tweet> mtweets=new ArrayList<Tweet>();
		while(rs.next())
			tids.add(rs.getInt(2));
		for(int i=0;i<tids.size();i++){
			Tweet mtweet=getTweet(u,tids.size());
			mtweets.add(mtweet);
		}
		oos.writeObject(mtweets);
		oos.flush();
	}
	/*编辑推文*/
	public void updMoment() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		Moment moment = (Moment) ois.readObject();
		ArrayList<Tweet> mtweets = (ArrayList<Tweet>) ois.readObject();
		if(u.isLogin()){
			String sql="update moments set title='"+moment.getTitle()+"',description='"+moment.getDescription()+"',cover_fname="+moment.getCover_fname()+" where id="+moment.getId();
			DBConnect.getStat().executeUpdate(sql);
			for(int i=0;i<mtweets.size();i++){
				sql="insert into mtweets values('"+moment.getId()+"',"+mtweets.get(i).getId()+")";
				DBConnect.getStat().executeUpdate(sql);
			}
			sql="delete from mtweets where mid="+u.getId();
			DBConnect.getStat().executeUpdate(sql);
		}
	}
	/*删除*/
	public void delMoment() throws SQLException, ClassNotFoundException, IOException{
		User u= (User) ois.readObject();
		int mid = ois.readInt();
		if(u.isLogin()){
			String sql="delete from moments where id="+mid;
			DBConnect.getStat().executeUpdate(sql);
		}
	}
	public void getAllMoments() throws SQLException, ClassNotFoundException, IOException{
		User u=(User) ois.readObject();
		String sql = "select * from moments order by id desc limit 10";
		ResultSet rs = DBConnect.getStat().executeQuery(sql);
		ArrayList<Moment> moments=new ArrayList<Moment>();
		Moment moment;
		ArrayList<String> uids=new ArrayList<String>();
		while(rs.next()){
			moments.add(new Moment(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)));
			uids.add(rs.getString(2));
		}
		for(int i=0;i<moments.size();i++){
			moment=moments.get(i);
			User user=getUser(u, moment.getUid());
			moment.setUname(user.getName());
			moment.setUpicfname(user.getPicfname());
			moments.set(i,moment);
		}
		oos.writeObject(moments);
		oos.flush();
	}
	
	
	
	
	
	
	
	
	public void sendPic() throws SQLException, ClassNotFoundException, IOException{
		String fe=ois.readUTF();
		String sql="insert into countor(objectid)values(1)";
		DBConnect.getStat().executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
		ResultSet rs=DBConnect.getStat().getGeneratedKeys();
		rs.next();
		int fnumber=rs.getInt(1);
		sql="delete from countor where id="+fnumber;
		DBConnect.getStat().executeUpdate(sql);
		File f=new File(path+fnumber+fe);
		f.getParentFile().mkdirs();
		FileOutputStream fos=new FileOutputStream(f);
		InputStream is=s.getInputStream();
		byte[] b=new byte[1024];
		int len=0;
		while((len=is.read(b))!=-1)
			fos.write(b,0,len);
		fos.close();
		oos.writeUTF(fnumber+fe);
		oos.flush();
	}
	public void getPic() throws IOException{
		String picfname=ois.readUTF();
		File f=new File(path+picfname);
		FileInputStream fis=new FileInputStream(f);
		OutputStream os=s.getOutputStream();
		byte b[]=new byte[1024];
		int len=0;
		while((len=fis.read(b))!=-1)
			os.write(b,0,len);
		s.shutdownOutput();
	}
	
	
	
	
	public User getUser(User u,String to_uid) throws SQLException, ClassNotFoundException{
		boolean isFollow;
		String sql="select count(*) from follows where uid='"+u.getId()+"'and to_uid='"+to_uid+"'";
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		rs.next();
		if(rs.getInt(1)==0)isFollow=false;
		else isFollow=true;
		sql="select*from user where id='"+to_uid+"'";
		rs=DBConnect.getStat().executeQuery(sql);
		if(rs.next())
			return new User(rs.getString(1),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12),isFollow);
		return null;
	}
	public ArrayList<User> getFollowings(User u,String uid) throws SQLException, ClassNotFoundException{
		ArrayList<String> to_uid=new ArrayList<String>();
		ArrayList<User> user = new ArrayList<User>();
		String sql = "select * from follows where uid='"+uid+"'";
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		while(rs.next())
			to_uid.add(rs.getString(2));
		for(String str:to_uid)
			user.add(getUser(u,str));
		return user;
	}
	
	public Tweet getTweet(User u,int tid) throws SQLException, ClassNotFoundException, IOException{
		String sql="select * from tweets where id="+tid;
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		Tweet tweet=null;
		if(rs.next()){
			tweet=new RLTweet(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8), rs.getInt(9),rs.getInt(10), rs.getInt(11),rs.getInt(12));
			tweet=setTweetMsg(u,tweet);
		}
		return tweet;
	}
	/*设置推文的视频图片及当前用户信息*/
	public Tweet setTweetMsg(User u,Tweet tweet) throws SQLException, ClassNotFoundException, IOException{
		String sql="select*from user where id='"+tweet.getUid()+"'";
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		rs.next();
		tweet.setUname(rs.getString(4));
		tweet.setPicfname(rs.getString(5));
		boolean retweeted=false,liked=false,marked=false;
		sql="select count(*) from retweets where uid='"+u.getId()+"' and tid="+tweet.getId();
		rs=DBConnect.getStat().executeQuery(sql);
		rs.next();
		if(rs.getInt(1)==1) retweeted=true;
		sql="select count(*) from likes where uid='"+u.getId()+"' and tid="+tweet.getId();
		rs=DBConnect.getStat().executeQuery(sql);
		rs.next();
		if(rs.getInt(1)==1) liked=true;
		sql="select count(*) from bookmarks where uid='"+u.getId()+"' and tid="+tweet.getId();
		rs=DBConnect.getStat().executeQuery(sql);
		rs.next();
		if(rs.getInt(1)==1) marked=true;
		sql="select * from media where tid="+tweet.getId();
		rs=DBConnect.getStat().executeQuery(sql);
		ArrayList<String> media=new ArrayList<String>();
		while(rs.next())
			media.add(rs.getString(1));
		tweet.setRetweeted(retweeted);
		tweet.setLiked(liked);
		tweet.setMarked(marked);
		tweet.setMedia(media);
		return tweet;
	}
	public void createNotification(String uid,int type,String nid) throws SQLException, ClassNotFoundException{
		String sql="insert into notification(uid,type,to_uid)values('"+uid+"',"+type+",'"+nid+"')";
		DBConnect.getStat().executeUpdate(sql);
		sql = "select * from follows where to_uid='"+uid+"'";
		ResultSet rs=DBConnect.getStat().executeQuery(sql);
		ArrayList<String>uids=new ArrayList<String>();
		while(rs.next())
			uids.add(rs.getString(2));
		for(String fid:uids){
			sql="select *from newnotification where uid='"+fid+"'";
			rs=DBConnect.getStat().executeQuery(sql);
			if(!rs.next()){
				sql="insert into newnotification(uid)values('"+fid+"')";
				System.out.println(sql);
				DBConnect.getStat().executeUpdate(sql);
			}
		}
	}
	
	
	
	public void deluser() throws SQLException, ClassNotFoundException, IOException{
		Admin a = (Admin) ois.readObject();
		String uid = ois.readUTF();
		String sql="delete from user where uid='"+uid+"'";
		DBConnect.getStat().executeUpdate(sql);
	}
	public void deltweet() throws SQLException, ClassNotFoundException, IOException{
		Admin a = (Admin) ois.readObject();
		int tid = ois.readInt();
		String sql="delete from tweets where id="+tid;
		DBConnect.getStat().executeUpdate(sql);
	}
	
	
	
	
	public static void main(String[] args) {
		try {
			new TServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run(){
		try {
			while(true){
				s = ss.accept();
				ois = new ObjectInputStream(s.getInputStream());
				oos = new ObjectOutputStream(s.getOutputStream());
				int command = ois.readInt();
				if(command == U_LOGIN){
					this.login();
				}if(command == U_REGISTER){
					this.register();
				}
				if(command==U_SEARCHUSERS){
					searchUsers();
				}if(command==U_SERCHTWEETS){
					searchTweets();
				}
				if(command==U_GETRECOMMEND){
					
				}
				if(command==U_EDITPROFILE){
					editProfile();
				}if(command==U_SETPIC){
					setPic();
				}if(command==U_SETBG){
					setBG();
				}
				if(command == U_FOLLOW){
					this.follow();
				}if(command == U_GETUSER){
					this.getUser();
				}
				if(command == U_GETFOLLOWING){
					this.getFollowings();
				}
				if(command == U_GETFOLLOWERS){
					this.getFollowers();
				}
				if(command == U_TWEET1){
					this.tweet1();
				}if(command == U_TWEET2){
					this.tweet2();
				}
				if(command == U_DELTWEET){
					this.delTweet();
				}
				if(command == U_RETWEET){
					this.retweet();
				}if(command==U_GETFATHERTWEETS){
					getFatherTweets();
				}if(command==U_GETCOMMENT){
					this.getComment();
				}
				if(command == U_LIKE){
					this.like();
				}
				if(command == U_MARK){
					this.mark();
				}
				if(command == U_GETTWEET){
					this.getTweet();
				}if(command == U_GETALLTWEETS){
					this.getAllTweets();
				}if(command == U_GETALLLRTWEETS){
					this.getAllLRTweets();
				}if(command == U_GETUTWEETS){
					this.getUTweets();
				}if(command == U_GETURLTWEETS){
					this.getURLTweets();
				}
				if(command == U_GETNOTI){
					this.getNoti();
				}if(command==U_GETNEWNOTI){
					getNewNoti();
				}
				if(command == U_GETMESSAGES){
					this.getMessages();
				}
				if(command == U_GETBOOKMARKS){
					this.getBookMarks();
				}if(command == U_CREATEOWNEDLIST){
					this.createOwnedList();
				}if(command == U_DELOWNEDLIST){
					this.delOwnedList();
				}if(command == U_GETOWNED){
					this.getOwned();
				}if(command == U_SUBSCRIBE){
					this.subscribe();
				}if(command == U_GETSUBSCRIBED){
					this.getSubscribed();
				}if(command == U_GETLISTMEMBERS){
					this.getListMembers();
				}if(command == U_GETLISTSUBSCRIBERS){
					this.getListSubscribers();
				}if(command == U_GETLISTTWEETS){
					this.getListTweets();
				}if(command == U_GETLISTRETWEETS){
					this.getListRetweets();
				}if(command == U_GETMEMBER){
					this.getMember();
				}if(command == U_UPDOWNLIST){
					this.updOwnList();
				}if(command == U_ADDUSER){
					this.addUser();
				}if(command == U_DELUSER){
					this.delUser();
				}
				if(command == U_CREATEMOMENT){
					this.createMoment();
				}if(command == U_GETMOMENTS){
					this.getMoments();
				}if(command == U_GETMTWEETS){
					this.getMTweets();
				}if(command == U_UPDMOMENT){
					this.updMoment();
				}if(command == U_DELMOMENT){
					this.delMoment();
				}
				if(command==U_GETALLMOMENTS){
					getAllMoments();
				}
				if(command == A_DELUSER){
					this.deluser();
				}if(command == A_DELTWEET){
					this.deltweet();
				}if(command==SENDPIC){
					this.sendPic();
				}if(command==GETPIC){
					this.getPic();
				}if(command==GETFILE){
					getFile();
				}if(command==SENDFILE){
					sendFile();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
