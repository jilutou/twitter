package model;

import java.io.Serializable;

public class List implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String uid;
	private String uname;
	private String upicfname;
	private String title;
	private String description;
	private boolean isprivate;
	private int members;
	private int subscribers;
	private String time;
	private boolean subscribed;
	
	
	public List(int id, String uid, String uname, String upicfname,
			String title, String description, boolean isprivate, int members,
			int subscribers, String time) {
		super();
		this.id = id;
		this.uid = uid;
		this.uname = uname;
		this.upicfname = upicfname;
		this.title = title;
		this.description = description;
		this.isprivate = isprivate;
		this.members = members;
		this.subscribers = subscribers;
		this.time = time;
	}
	public List(int id, String uid, String title, String description,
			boolean isprivate, int members, int subscribers, String time,
			boolean subscribed) {
		super();
		this.id = id;
		this.uid = uid;
		this.title = title;
		this.description = description;
		this.isprivate = isprivate;
		this.members = members;
		this.subscribers = subscribers;
		this.time = time;
		this.subscribed = subscribed;
	}
	public List(int id, String uid, String title, String description,
			boolean isprivate, int members, int subscribers, String time) {
		super();
		this.id = id;
		this.uid = uid;
		this.title = title;
		this.description = description;
		this.isprivate = isprivate;
		this.members = members;
		this.subscribers = subscribers;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpicfname() {
		return upicfname;
	}
	public void setUpicfname(String upicfname) {
		this.upicfname = upicfname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isIsprivate() {
		return isprivate;
	}
	public void setIsprivate(boolean isprivate) {
		this.isprivate = isprivate;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getMembers() {
		return members;
	}
	public void setMembers(int members) {
		this.members = members;
	}
	public int getSubscribers() {
		return subscribers;
	}
	public void setSubscribers(int subscribers) {
		this.subscribers = subscribers;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public boolean isSubscribed() {
		return subscribed;
	}
	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}
}
