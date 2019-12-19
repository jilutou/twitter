package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Admin;
import model.List;
import model.Message;
import model.Moment;
import model.Notification;
import model.RLTweet;
import model.Tweet;
import model.User;

public class TClient implements TProtocal{
	
	private static Socket s;
	private static ObjectInputStream ois;
	private static ObjectOutputStream oos;
	
	private static void init() throws UnknownHostException, IOException{
		s = new Socket("127.0.0.1",1017);
		oos = new ObjectOutputStream(s.getOutputStream());
		ois = new ObjectInputStream(s.getInputStream());
	}
	public static User login(String id,String password) throws SQLException, ClassNotFoundException,Exception{
		init();
		oos.writeInt(U_LOGIN);
		oos.flush();
		oos.writeUTF(id);
		oos.flush();
		oos.writeUTF(password);
		oos.flush();
		User u = (User) ois.readObject();
		return u;
	}
	public static void register(String name,String password1) throws IOException{
		init();
		oos.writeInt(U_REGISTER);
		oos.flush();
		oos.writeUTF(name);
		oos.flush();
		oos.writeUTF(password1);
		oos.flush();
	}
	
	
	@SuppressWarnings("unchecked")
	public static ArrayList<User> searchUsers(User u,String keyword) throws IOException, ClassNotFoundException{
		init();
		oos.writeInt(U_SEARCHUSERS);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeUTF(keyword);
		oos.flush();
		ArrayList<User>users=(ArrayList<User>) ois.readObject();
		for(User user:users)
			getPic(user.getPicfname());
		return users;
	}
	public static ArrayList<Tweet> searchTweets(User u,String keyword) throws IOException, ClassNotFoundException{
		init();
		oos.writeInt(U_SERCHTWEETS);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeUTF(keyword);
		oos.flush();
		ArrayList<Tweet>tweets=(ArrayList<Tweet>) ois.readObject();
		for(Tweet tweet:tweets)
			for(String picfname:tweet.getMedia()){
				getPic(picfname);
			}
		getTUPic(tweets);
		return tweets;
	}
	
	
	public static ArrayList<User> getRecommend(User u) throws IOException, ClassNotFoundException{
		init();
		oos.writeObject(u);
		oos.flush();
		ArrayList<User>users=(ArrayList<User>) ois.readObject();
		for(User user:users){
			getPic(user.getPicfname());
		}
		return users;
	}
	
	
	
	
	
	public void editProfile(User u) throws IOException{
		init();
		oos.writeInt(U_EDITPROFILE);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
	}
	public static void setPic(User u,File f,String fe) throws IOException{
		init();
		oos.writeInt(U_SETPIC);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeUTF(sendPic(f, fe));
		oos.flush();
	}
	public void setBG(User u,File f,String fe) throws IOException{
		init();
		oos.writeInt(U_SETBG);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeUTF(sendPic(f, fe));
		oos.flush();
	}
	
	
	
	/*��ע�û�*/
	public static void follow(User u,String uid,boolean followed) throws SQLException, ClassNotFoundException, UnknownHostException, IOException{
		init();
		oos.writeInt(U_FOLLOW);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeUTF(uid);
		oos.flush();
		oos.writeBoolean(followed);
		oos.flush();
	}
	/*�����û�id��ȡ�û�*/
	public static User getUser(User u,String to_uid) throws SQLException, ClassNotFoundException, UnknownHostException, IOException{
		init();
		oos.writeInt(U_GETUSER);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeUTF(to_uid);
		oos.flush();
		User user = (User) ois.readObject();
		if(user!=null)
			getPic(user.getPicfname());
		return user;
	}
	/*��ȡ��ע�б�*/
	public static ArrayList<User> getFollowings(User u,String uid) throws SQLException, ClassNotFoundException, UnknownHostException, IOException{
		init();
		oos.writeInt(U_GETFOLLOWING);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeUTF(uid);
		oos.flush();
		ArrayList<User>users=(ArrayList<User>) ois.readObject();
		for(User user:users)
			getPic(user.getPicfname());
		return users;
	}
	public static ArrayList<User> getFollowers(User u,String uid) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_GETFOLLOWERS);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeUTF(uid);
		oos.flush();
		ArrayList<User> users = (ArrayList<User>) ois.readObject();
		for(User user:users)
			getPic(user.getPicfname());
		return users;
	}
	
	
	
	/*������*/
	public static void tweet(User u,String cont,int mediaType,ArrayList<File> media,ArrayList<String>fe) throws SQLException, ClassNotFoundException, IOException{
		ArrayList<String>fname=new ArrayList<String>();
		for(int i=0;i<media.size();i++)
			fname.add(sendPic(media.get(i), fe.get(i)));
		init();
		oos.writeInt(U_TWEET1);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		if(u.isLogin()){
			oos.writeUTF(cont);
			oos.flush();
			oos.writeInt(mediaType);
			oos.flush();
			if(mediaType==2||mediaType==3){
				oos.writeObject(fname);
				oos.flush();
			}
		}
	}
	public static void tweet(User u,int type,String to_uid,int to_tid,String cont,int mediaType,ArrayList<File> media,ArrayList<String>fe) throws SQLException, ClassNotFoundException, IOException{
		ArrayList<String>fname=new ArrayList<String>();
		for(int i=0;i<media.size();i++)
			fname.add(sendPic(media.get(i), fe.get(i)));
		init();
		oos.writeInt(U_TWEET2);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		if(u.isLogin()){
			oos.writeInt(type);
			oos.flush();
			oos.writeUTF(to_uid);
			oos.flush();
			oos.writeInt(to_tid);
			oos.flush();
			oos.writeUTF(cont);
			oos.flush();
			oos.writeInt(mediaType);
			oos.flush();
			if(mediaType==2||mediaType==3){
				oos.writeObject(fname);
				oos.flush();
			}
		}
	}
	public static void delTweet(User u,int tid) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_DELTWEET);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeInt(tid);
		oos.flush();
	}
	
	/*ת�������ޣ��ղ�*/
	public static void retweet(User u,int tid,boolean retweeted) throws SQLException, ClassNotFoundException, UnknownHostException, IOException{
		init();
		oos.writeInt(U_RETWEET);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeInt(tid);
		oos.flush();
		oos.writeBoolean(retweeted);
		oos.flush();
	}
	public static void like(User u,int tid,boolean liked) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_LIKE);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeInt(tid);
		oos.flush();
		oos.writeBoolean(liked);
		oos.flush();
	}
	public static void mark(User u,int tid,boolean marked) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_MARK);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeInt(tid);
		oos.flush();
		oos.writeBoolean(marked);
		oos.flush();
	}
	
	/*��������id��ȡ����*/
	public static Tweet getTweet(User u,int tid) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_GETTWEET);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeInt(tid);
		oos.flush();
		Tweet t = (Tweet) ois.readObject();
		getPic(ois.readUTF());
		return t;
	}
	/*��ȡ��ǰ�û���ע���û�������*/
	@SuppressWarnings("unchecked")
	public static ArrayList<Tweet> getAllTweets(User u) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_GETALLTWEETS);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		ArrayList<Tweet> tweets = (ArrayList<Tweet>) ois.readObject();
		ArrayList<User> users=(ArrayList<User>) ois.readObject();
		for(Tweet tweet:tweets)
			for(String picfname:tweet.getMedia())
				getPic(picfname);
		for(int i=0;i<users.size();i++)
			getPic(users.get(i).getPicfname());
		return tweets;
	}
	/*��ȡ��ǰ�û���ע���û�ת�����޵�����*/
	@SuppressWarnings("unchecked")
	public static ArrayList<RLTweet> getAllLRTweets(User u,String reli) throws SQLException, ClassNotFoundException, UnknownHostException, IOException{
		init();
		oos.writeInt(U_GETALLLRTWEETS);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeUTF(reli);
		oos.flush();
		ArrayList<RLTweet> rltweets = (ArrayList<RLTweet>) ois.readObject();
		for(Tweet tweet:rltweets)
			for(String picfname:tweet.getMedia()){
				getPic(picfname);
			}
		getTUPic(rltweets);
		return rltweets;
	}
	/*��ȡ��ǰ�û���������*/
	public static ArrayList<Tweet> getUTweets(User u,String uid) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_GETUTWEETS);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeUTF(uid);
		oos.flush();
		ArrayList<Tweet> tweets = (ArrayList<Tweet>) ois.readObject();
		for(Tweet tweet:tweets)
			for(String picfname:tweet.getMedia())
				getPic(picfname);
		return tweets;
	}
	/*��ȡ��ǰ�û�ת�����޵�����*/
	public static ArrayList<RLTweet> getURLTweets(User u,String uid,String uname,String reli) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_GETURLTWEETS);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeUTF(uid);
		oos.flush();
		oos.writeUTF(uname);
		oos.flush();
		oos.writeUTF(reli);
		oos.flush();
		ArrayList<RLTweet> rltweets = (ArrayList<RLTweet>) ois.readObject();
		for(Tweet tweet:rltweets)
			for(String picfname:tweet.getMedia())
				getPic(picfname);
		getTUPic(rltweets);
		return rltweets;
	}
	public static ArrayList<Tweet>getFatherTweets(User u,int to_tid) throws IOException, ClassNotFoundException{
		init();
		oos.writeInt(U_GETFATHERTWEETS);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeInt(to_tid);
		oos.flush();
		ArrayList<Tweet>fathertweets=(ArrayList<Tweet>) ois.readObject();
		for(Tweet tweet:fathertweets)
			for(String picfname:tweet.getMedia())
				getPic(picfname);
		getTUPic(fathertweets);
		return fathertweets;
	}
	public static ArrayList<Tweet> getComment(User u,int tid) throws IOException, ClassNotFoundException{
		init();
		oos.writeInt(U_GETCOMMENT);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeInt(tid);
		oos.flush();
		ArrayList<Tweet> tweets=(ArrayList<Tweet>)ois.readObject();
		for(Tweet tweet:tweets)
			for(String picfname:tweet.getMedia())
				getPic(picfname);
		getTUPic(tweets);
		return tweets;
	}
	
	/*��ȡ֪ͨ��˽�ţ��ղ�*/
	public static ArrayList<Notification> getNoti(User u) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_GETNOTI);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		ArrayList<Notification> noti = (ArrayList<Notification>) ois.readObject();
		return noti;
	}
	public static boolean getNewNoti(User u) throws IOException{
		init();
		oos.writeInt(U_GETNEWNOTI);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		return ois.readBoolean();
	}
	public static void readNoti(User u) throws IOException{
		init();
		oos.writeInt(U_READNOTI);
		oos.writeObject(u);
		oos.flush();
	}
	
	public static ArrayList<Message> getMessages(User u) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_GETMESSAGES);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		ArrayList<Message> m = (ArrayList<Message>) ois.readObject();
		return m;
	}
	public static void sendMessage(User u ){
		
	}
	public static void sendFile(File f,String fname) throws IOException{
		init();
		oos.writeInt(SENDFILE);
		oos.flush();
		oos.writeUTF(fname);
		oos.flush();
		FileInputStream fis=new FileInputStream(f);
		OutputStream os=s.getOutputStream();
		byte b[]=new byte[1024];
		int len=0;
		while((len=fis.read(b))!=-1){
			os.write(b, 0, len);
		}
		s.shutdownOutput();
	}
	public static void getFile(String fname) throws IOException{
		init();
		oos.writeInt(GETFILE);
		oos.flush();
		oos.writeUTF(fname);
		oos.flush();
		InputStream is=s.getInputStream();
		File f=new File("C:/Twitter/CLIB/record/"+fname);
		FileOutputStream fos=new FileOutputStream(f);
		byte b[]=new byte[1024];
		int len=0;
		while((len=is.read(b))!=-1){
			fos.write(b,0,len);
		}
		fos.close();
	}
	
	public static ArrayList<Tweet> getBookMarks(User u) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_GETBOOKMARKS);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		ArrayList<Tweet> tweets = (ArrayList<Tweet>) ois.readObject();
		for(Tweet tweet:tweets)
			for(String picfname:tweet.getMedia())
				getPic(picfname);
		getTUPic(tweets);
		return tweets;	
	}
	/*�б�*/
	/*���������б�*/
	public static void createOwnedList(User u,String title,String description,boolean isprvate,ArrayList<User>members) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_CREATEOWNEDLIST);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeUTF(title);
		oos.flush();
		oos.writeUTF(description);
		oos.flush();
		oos.writeBoolean(isprvate);
		oos.flush();
	}
	/*ɾ��*/
	public static void delOwnedList(User u,int id) throws SQLException, ClassNotFoundException, UnknownHostException, IOException{
		init();
		oos.writeInt(U_DELOWNEDLIST);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeInt(id);
		oos.flush();
	}
	/*��ȡӵ���б�*/
	public static ArrayList<List> getOwned(User u,User user) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_GETOWNED);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeObject(user);
		oos.flush();
		ArrayList<List> lists = (ArrayList<List>) ois.readObject();
		return lists;
	}
	/*�����б�*/
	public static void subscribe(User u,int listid,boolean subscribed) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_SUBSCRIBE);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeInt(listid);
		oos.flush();
		oos.writeBoolean(subscribed);
		oos.flush();
	}
	/*��ȡ�����б�*/
	public static ArrayList<List> getSubscribed(User u,String uid) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_GETSUBSCRIBED);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeUTF(uid);
		oos.flush();
		ArrayList<List> subList = (ArrayList<List>) ois.readObject();
		return subList;
	}
	/*��ȡ�б��Ա*/
	public static ArrayList<User> getListMembers(User u,int listid) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_GETLISTMEMBERS);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeInt(listid);
		oos.flush();
		ArrayList<User> member = (ArrayList<User>) ois.readObject();
		for(int i=0;i<member.size();i++)
			getPic(member.get(i).getPicfname());
		return member;
	}
	/*��ȡ��ע�б���û�*/
	public static ArrayList<User> getListSubscribers(User u,int listid) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_GETLISTSUBSCRIBERS);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeInt(listid);
		oos.flush();
		ArrayList<User> ulist = (ArrayList<User>) ois.readObject();
		for(int i=0;i<ulist.size();i++)
			getPic(ulist.get(i).getPicfname());
		return ulist;
	}
	/*��ȡ�б������*/
	public static ArrayList<Tweet> getListTweets(User u,List lists) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_GETLISTTWEETS);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeObject(lists);
		oos.flush();
		ArrayList<Tweet> tweets = (ArrayList<Tweet>) ois.readObject();
		for(Tweet tweet:tweets)
			for(String picfname:tweet.getMedia())
				getPic(picfname);
		return tweets;
	}
	public static ArrayList<RLTweet> getListRetweets(User u,List lists) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_GETLISTRETWEETS);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeObject(lists);
		oos.flush();
		ArrayList<RLTweet> rtweets = (ArrayList<RLTweet>) ois.readObject();
		for(Tweet tweet:rtweets)
			for(String picfname:tweet.getMedia())
				getPic(picfname);
		getTUPic(rtweets);
		return rtweets;
	}
	/*��ȡ�û�����ӵ����б�*/
	public static ArrayList<List> getMember(User u,String uid) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_GETMEMBER);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeUTF(uid);
		oos.flush();
		ArrayList<List> memberList = (ArrayList<List>) ois.readObject();
		return memberList;
	}
	public static void updOwnList(User u,List list) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_UPDOWNLIST);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeObject(list);
		oos.flush();
	}
	public static void addUser(User u,List list,String uid,String uname) throws SQLException, ClassNotFoundException, UnknownHostException, IOException{
		init();
		oos.writeInt(U_ADDUSER);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeObject(list);
		oos.flush();
		oos.writeUTF(uid);
		oos.flush();
		oos.writeUTF(uname);
		oos.flush();
	}
	public static void delUser(User u,List list,String uid) throws SQLException, ClassNotFoundException, UnknownHostException, IOException{
		init();
		oos.writeInt(U_DELUSER);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeObject(list);
		oos.flush();
		oos.writeUTF(uid);
		oos.flush();
	}
	/*˲��*/
	/*����˲��*/
	public static void createMoment(User u,String title,String description,int cover_fname,ArrayList<Tweet> mtweets) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_CREATEMOMENT);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeUTF(title);
		oos.flush();
		oos.writeUTF(description);
		oos.flush();
		oos.writeInt(cover_fname);
		oos.flush();
		oos.writeObject(mtweets);
		oos.flush();
	}
	/*��ȡ˲��*/
	public static ArrayList<Moment> getMoments(User u,User user) throws SQLException, ClassNotFoundException, UnknownHostException, IOException{
		init();
		oos.writeInt(U_GETMOMENTS);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeObject(user);
		oos.flush();
		ArrayList<Moment> moments = (ArrayList<Moment>) ois.readObject();
		for(Moment moment:moments)
			getPic(moment.getCover_fname());
		return moments;
	}
	/*��ȡ˲�������*/
	@SuppressWarnings("unchecked")
	public static ArrayList<Tweet> getMTweets(User u,int mid) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(U_GETMTWEETS);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeInt(mid);
		oos.flush();
		ArrayList<Tweet> mtweets = (ArrayList<Tweet>) ois.readObject();
		for(Tweet tweet:mtweets)
			for(String picfname:tweet.getMedia())
				getPic(picfname);
		getTUPic(mtweets);
		return mtweets;
	}
	/*�༭����*/
	public static void updMoment(User u,Moment mm,ArrayList<Tweet> mtweets) throws SQLException, ClassNotFoundException, UnknownHostException, IOException{
		init();
		oos.writeInt(U_UPDMOMENT);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeObject(mm);
		oos.flush();
		oos.writeObject(mtweets);
		oos.flush();
	}
	/*ɾ��*/
	public static void delMoment(User u,int mid) throws SQLException, ClassNotFoundException, UnknownHostException, IOException{
		init();
		oos.writeInt(U_DELMOMENT);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		oos.writeInt(mid);
		oos.flush();
	}
	public static ArrayList<Moment> getAllMoments(User u) throws IOException, ClassNotFoundException{
		init();
		oos.writeInt(U_GETALLMOMENTS);
		oos.flush();
		oos.writeObject(u);
		oos.flush();
		ArrayList<Moment>moments=(ArrayList<Moment>) ois.readObject();
		for(Moment moment:moments)
			getPic(moment.getCover_fname());
		ArrayList<String> picfname=new ArrayList<String>();
		for(Moment moment:moments)
			if(picfname.indexOf(moment.getUpicfname())!=-1)
				picfname.add(moment.getUpicfname());
		for(int i=0;i<picfname.size();i++)
			getPic(picfname.get(i));
		return moments;
	}
	
	
	
	public static void deluser(Admin a,String uid) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(A_DELUSER);
		oos.flush();
		oos.writeObject(a);
		oos.flush();
		oos.writeUTF(uid);
		oos.flush();
	}
	public static void deltweet(Admin a,int tid) throws SQLException, ClassNotFoundException, IOException{
		init();
		oos.writeInt(A_DELTWEET);
		oos.flush();
		oos.writeObject(a);
		oos.flush();
		oos.writeInt(tid);
		oos.flush();
	}
	
	
	
	
	public static String sendPic(File f,String fe) throws IOException{
		init();
		oos.writeInt(SENDPIC);
		oos.flush();
		oos.writeUTF(fe);
		oos.flush();
		FileInputStream fis=new FileInputStream(f);
		OutputStream os=s.getOutputStream();
		byte b[]=new byte[1024];
		int len=0;
		while((len=fis.read(b))!=-1){
			os.write(b, 0, len);
		}
		s.shutdownOutput();
		return ois.readUTF();
	}
	public static void getPic(String picfname) throws IOException{
		init();
		oos.writeInt(GETPIC);
		oos.flush();
		oos.writeUTF(picfname);
		oos.flush();
		InputStream is=s.getInputStream();
		File f=new File("C:/Twitter/CLIB/picture/"+picfname);
		FileOutputStream fos=new FileOutputStream(f);
		byte b[]=new byte[1024];
		int len=0;
		while((len=is.read(b))!=-1){
			fos.write(b,0,len);
		}
		fos.close();
	}
	
	
	public static void getTUPic(ArrayList<?extends Tweet>tweets) throws IOException, ClassNotFoundException{
		ArrayList<String> picfname=new ArrayList<String>(); 
		for(Tweet tweet:tweets)
			if(picfname.indexOf(tweet.getPicfname())!=-1)
				picfname.add(tweet.getPicfname());
		for(int i=0;i<picfname.size();i++)
			getPic(picfname.get(i));
	}
}