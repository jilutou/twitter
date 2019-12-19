package model;

import java.io.Serializable;
import java.sql.SQLException;

import server.DBConnect;

public class Admin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int password;
	private boolean isLogin;
	private String name;
	private String picfname;
	private String join;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getPicfname() {
		return picfname;
	}
	public void setPicfname(String picfname) {
		this.picfname = picfname;
	}
	public String getJoin() {
		return join;
	}
	public void setJoin(String join) {
		this.join = join;
	}
	public void deluser(String uid) throws SQLException, ClassNotFoundException{
		String sql="delete from user where uid='"+uid+"'";
		DBConnect.getStat().executeUpdate(sql);
	}
	public void deltweet(int tid) throws SQLException, ClassNotFoundException{
		String sql="delete from tweets where id="+tid;
		DBConnect.getStat().executeUpdate(sql);
	}
}
