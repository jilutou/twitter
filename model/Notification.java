package model;

public class Notification {
	private int id;
	private String uid;
	private String uname;
	private String picfname;
	private int type;
	private String to_id;
	private String to_uname;
	private String time;
	
	
	public Notification(int id, String uid, String uname, String picfname,
			int type, String toId, String toUname, String time) {
		super();
		this.id = id;
		this.uid = uid;
		this.uname = uname;
		this.picfname = picfname;
		this.type = type;
		to_id = toId;
		to_uname = toUname;
		this.time = time;
	}
	public Notification(int id, String uid, int type, String toId, String time) {
		super();
		this.id = id;
		this.uid = uid;
		this.type = type;
		to_id = toId;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTo_id() {
		return to_id;
	}
	public void setTo_id(String toId) {
		to_id = toId;
	}
	public String getTo_uname() {
		return to_uname;
	}
	public void setTo_uname(String toUname) {
		to_uname = toUname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
