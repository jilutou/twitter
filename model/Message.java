package model;

public class Message {
	private String to_uid;
	private String to_name;
	private String to_upicfname;
	private String log_fname;
	private String lastTime;
	private boolean notread;
	
	public Message(String toUid, String toName, String toUpicfname,
			String logFname, boolean notread) {
		super();
		to_uid = toUid;
		to_name = toName;
		to_upicfname = toUpicfname;
		log_fname = logFname;
		this.notread = notread;
	}
	public Message(String toUid, String toName, String logFname,
			String lastTime) {
		super();
		to_uid = toUid;
		to_name = toName;
		log_fname = logFname;
		this.lastTime = lastTime;
	}
	public String getTo_uid() {
		return to_uid;
	}
	public void setTo_uid(String toUid) {
		to_uid = toUid;
	}
	public String getTo_name() {
		return to_name;
	}
	public void setTo_name(String toName) {
		to_name = toName;
	}
	public String getTo_upicfname() {
		return to_upicfname;
	}
	public void setTo_upicfname(String toUpicfname) {
		to_upicfname = toUpicfname;
	}
	public String getLog_fname() {
		return log_fname;
	}
	public void setLog_fname(String logFname) {
		log_fname = logFname;
	}
	public String getLastTime() {
		return lastTime;
	}
	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}
	public boolean isNotread() {
		return notread;
	}
	public void setNotread(boolean notread) {
		this.notread = notread;
	}
}
