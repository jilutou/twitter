package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import server.DBConnect;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8221019950935884745L;
	private String id;
	private boolean isLogin;
	private int power;
	private String name;
	private String picfname;
	private String bgfname;
	private String bio;
	private String birth;
	private String join;
	private int following;
	private int follower;
	private int pinnedtid;
	private boolean followed;
	
	public User(){
		isLogin=false;
	}
	public User(String id,boolean isLogin,int power, String name,
			String picfname, String bgfname, String bio, String birth,
			String join, int following, int follower, int pinnedtid) {
		super();
		this.id = id;
		this.isLogin=isLogin;
		this.power = power;
		this.name = name;
		this.picfname = picfname;
		this.bgfname = bgfname;
		this.bio = bio;
		this.birth = birth;
		this.join = join;
		this.following = following;
		this.follower = follower;
		this.pinnedtid = pinnedtid;
	}
	public User(String id, int power, String name, String picfname, String bgfname,
			String bio, String birth, String join, int following, int follower,
			int pinnedtid, boolean followed) {
		super();
		this.id = id;
		this.isLogin=false;
		this.power = power;
		this.name = name;
		this.picfname = picfname;
		this.bgfname = bgfname;
		this.bio = bio;
		this.birth = birth;
		this.join = join;
		this.following = following;
		this.follower = follower;
		this.pinnedtid = pinnedtid;
		this.followed = followed;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicfname() {
		return picfname;
	}
	public void setPicfname(String picfname) {
		this.picfname = picfname;
	}
	public String getBgfname() {
		return bgfname;
	}
	public void setBgfname(String bgfname) {
		this.bgfname = bgfname;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getJoin() {
		return join;
	}
	public void setJoin(String join) {
		this.join = join;
	}
	public int getFollowing() {
		return following;
	}
	public void setFollowing(int following) {
		this.following = following;
	}
	public int getFollower() {
		return follower;
	}
	public void setFollower(int follower) {
		this.follower = follower;
	}
	public int getPinnedtid() {
		return pinnedtid;
	}
	public void setPinnedtid(int pinnedtid) {
		this.pinnedtid = pinnedtid;
	}
	public boolean isFollowed() {
		return followed;
	}
	public void setFollowed(boolean followed) {
		this.followed = followed;
	}
}
