package model;

import java.io.Serializable;

public class Moment implements Serializable{
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
	private String cover_fname;
	private String time;
	private int count;
	
	public Moment(int id, String uid, String title, String description,
			String coverFname, String time, int count) {
		super();
		this.id = id;
		this.uid = uid;
		this.title = title;
		this.description = description;
		cover_fname = coverFname;
		this.time = time;
		this.count = count;
	}
	public Moment(int id, String uid, String uname, String upicfname,
			String title, String description, String coverFname, String time,
			int count) {
		super();
		this.id = id;
		this.uid = uid;
		this.uname = uname;
		this.upicfname = upicfname;
		this.title = title;
		this.description = description;
		cover_fname = coverFname;
		this.time = time;
		this.count = count;
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
	public String getCover_fname() {
		return cover_fname;
	}
	public void setCover_fname(String coverFname) {
		cover_fname = coverFname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
