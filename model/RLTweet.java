package model;

public class RLTweet extends Tweet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String opuid;
	private String opuname;
	private String optime;
	
	public RLTweet(int id, int type, String toUid, int toTid, String uid,
			String contents, int mediaType, String time, int replays,
			int retweets, int likes, int counts) {
		super(id, type, toUid, toTid, uid, contents, mediaType, time, replays,
				retweets, likes, counts);
	}
	public RLTweet(int id, int type, String toUid, int toTid, String uid,
			String contents, int mediaType, String time, int replays,
			int retweets, int likes, int counts, String opuid, String opuname,
			String optime) {
		super(id, type, toUid, toTid, uid, contents, mediaType, time, replays,
				retweets, likes, counts);
		this.opuid = opuid;
		this.opuname = opuname;
		this.optime = optime;
	}
	public String getOpuid() {
		return opuid;
	}
	public void setOpuid(String opuid) {
		this.opuid = opuid;
	}
	public String getOpuname() {
		return opuname;
	}
	public void setOpuname(String opuname) {
		this.opuname = opuname;
	}
	public String getOptime() {
		return optime;
	}
	public void setOptime(String optime) {
		this.optime = optime;
	}
}
