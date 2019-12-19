package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Tweet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9116724589444334903L;
	private int id;
	private int type;
	private String to_uid;
	private int to_tid;
	private String uid;
	private String uname;
	private String picfname;
	private String contents;
	private int mediaType;
	private ArrayList<String>media;
	private String time;
	private int replays;
	private int retweets;
	private int likes;
	private boolean retweeted;
	private boolean liked;
	private boolean marked;
	private int counts;
	
	
	
	public Tweet(int id, int type, String toUid, int toTid, String uid,
			String contents, int mediaType, String time, int replays,
			int retweets, int likes, int counts) {
		super();
		this.id = id;
		this.type = type;
		to_uid = toUid;
		to_tid = toTid;
		this.uid = uid;
		this.contents = contents;
		this.mediaType = mediaType;
		this.time = time;
		this.replays = replays;
		this.retweets = retweets;
		this.likes = likes;
		this.counts = counts;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTo_uid() {
		return to_uid;
	}
	public void setTo_uid(String toUid) {
		to_uid = toUid;
	}
	public int getTo_tid() {
		return to_tid;
	}
	public void setTo_tid(int toTid) {
		to_tid = toTid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPicfname() {
		return picfname;
	}
	public void setPicfname(String picfname) {
		this.picfname = picfname;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getMediaType() {
		return mediaType;
	}
	public void setMediaType(int mediaType) {
		this.mediaType = mediaType;
	}
	public ArrayList<String> getMedia() {
		return media;
	}
	public void setMedia(ArrayList<String> media) {
		this.media = media;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getReplays() {
		return replays;
	}
	public void setReplays(int replays) {
		this.replays = replays;
	}
	public int getRetweets() {
		return retweets;
	}
	public void setRetweets(int retweets) {
		this.retweets = retweets;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public boolean isRetweeted() {
		return retweeted;
	}
	public void setRetweeted(boolean retweeted) {
		this.retweeted = retweeted;
	}
	public boolean isLiked() {
		return liked;
	}
	public void setLiked(boolean liked) {
		this.liked = liked;
	}
	public boolean isMarked() {
		return marked;
	}
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
}
