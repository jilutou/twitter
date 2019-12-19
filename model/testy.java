package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import server.TClient;
import view.MainView;


public class testy {
	public static void main(String[] args) {
		String id="1";
		String password="123";
		try {
			User u=TClient.login(id, password);
			new MainView(u).setVisible(true);
//			ArrayList<Tweet> tw=TClient.getFatherTweets(u,8);
			System.out.println("Íê³É");
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
