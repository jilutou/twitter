/*
 * OtherPersonPanel.java

 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.awt.Image;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import server.TClient;

import model.RLTweet;
import model.Tweet;
import model.User;

/**
 *
 * @author  __USER__
 */
public class OtherPersonPanel extends javax.swing.JPanel {
	public MainView mv;
	public ArrayList<MyJPanel> panels;
	private User u;
	private String uid;
	private User user;
	private Tweet pinnedtw;
	private ArrayList<Tweet> tws;
	private ArrayList<RLTweet> rtws;
	private ArrayList<RLTweet> ltws;

	/** Creates new form OtherPersonPanel */
	public OtherPersonPanel(MainView mv, ArrayList<MyJPanel> panels, User u,
			String uid) {
		initComponents();
		this.mv = mv;
		this.panels = panels;
		this.u = u;
		this.uid = uid;
		getMessage();
		getTweet();
	}

	public void getMessage() {
		try {
			user = TClient.getUser(u, uid);
			setImg(u.getPicfname(), jLabel1);
			jLabel5.setText(user.getId());
			jLabel3.setText(user.getName());
			jTextArea1.setText(user.getBio());
			if (user.getPicfname() != null)
				setImg(user.getPicfname(), jLabel1);
			jLabel9
					.setText("于" + user.getJoin() + "加入 · 出生于"
							+ user.getBirth());
			jLabel11.setText(user.getFollowing() + "");
			jLabel13.setText(user.getFollower() + "");
			if (u.getId().equals(uid))
				jButton1.setVisible(false);
			else if (user.isFollowed()) {
				jButton1.setText("取消关注");
			}
			pinnedtw = TClient.getTweet(u, user.getPinnedtid());
			tws = TClient.getUTweets(u, user.getId());
			rtws = TClient.getURLTweets(u, user.getId(), user.getName(),
					"retweets");
			ltws = TClient.getURLTweets(u, user.getId(), user.getName(),
					"likes");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			int i = tws.size() - 1, j = rtws.size() - 1;
			//			Date d1 = sdf.parse(tws.get(i).getTime()), d2 = sdf.parse(rtws.get(
			//					i).getTime());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getTweet() {
		try {
			MyJPanel mp = new MyJPanel();
			ArrayList<Tweet> tws = TClient.getUTweets(u, uid);
			for (Tweet tw : tws) {
				if (tw.getMediaType() == 0) {
					mp.add(new Tweet_1(mv, panels, u, mp, tw, 0));
				} else {
					mp.add(new Tweet_2(mv, panels, u, mp, tw, 0));
				}
			}
			jScrollPane2.setViewportView(mp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setImg(String picfname, JLabel jlb) {
		ImageIcon img = new ImageIcon("C:Twitter/CLIB/picture/" + picfname);
		img.setImage(img.getImage().getScaledInstance(jlb.getWidth(),
				jlb.getHeight(), Image.SCALE_DEFAULT));
		jlb.setIcon(img);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel12 = new javax.swing.JLabel();
		jLabel13 = new javax.swing.JLabel();
		jLabel14 = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jTabbedPane1 = new javax.swing.JTabbedPane();
		jScrollPane2 = new javax.swing.JScrollPane();
		jScrollPane4 = new javax.swing.JScrollPane();
		jScrollPane3 = new javax.swing.JScrollPane();
		jScrollPane5 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();

		jPanel1.setLayout(null);

		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/资料.png"))); // NOI18N
		jPanel1.add(jLabel1);
		jLabel1.setBounds(20, 20, 110, 110);

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel3.setText("\u6635\u79f0");
		jPanel1.add(jLabel3);
		jLabel3.setBounds(160, 20, 210, 30);

		jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16));
		jLabel5.setForeground(new java.awt.Color(153, 153, 153));
		jLabel5.setText("\u7528\u6237\u540d");
		jPanel1.add(jLabel5);
		jLabel5.setBounds(160, 60, 110, 22);

		jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/加入时间.png"))); // NOI18N
		jLabel9.setText("\u52a0\u5165\u65f6\u95f4");
		jPanel1.add(jLabel9);
		jLabel9.setBounds(20, 210, 210, 25);

		jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12));
		jLabel11.setText("\u6570\u5b57");
		jPanel1.add(jLabel11);
		jLabel11.setBounds(30, 140, 50, 17);

		jLabel12.setText("\u6b63\u5728\u5173\u6ce8");
		jPanel1.add(jLabel12);
		jLabel12.setBounds(70, 140, 60, 20);

		jLabel13.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12));
		jLabel13.setText("\u6570\u5b57");
		jPanel1.add(jLabel13);
		jLabel13.setBounds(30, 170, 48, 17);

		jLabel14.setText("\u4e2a\u5173\u6ce8\u8005");
		jPanel1.add(jLabel14);
		jLabel14.setBounds(70, 170, 60, 20);

		jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/聊天.png"))); // NOI18N
		jPanel1.add(jLabel17);
		jLabel17.setBounds(630, 10, 50, 50);

		jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/添加.png"))); // NOI18N
		jPanel1.add(jLabel18);
		jLabel18.setBounds(700, 10, 50, 50);

		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jButton1.setForeground(new java.awt.Color(0, 153, 255));
		jButton1.setText("\u5173\u6ce8");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jPanel1.add(jButton1);
		jButton1.setBounds(430, 10, 177, 55);

		jTabbedPane1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));

		jScrollPane2
				.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jTabbedPane1.addTab("\u63a8\u6587\u548c\u56de\u590d", jScrollPane2);

		jScrollPane4
				.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jTabbedPane1.addTab("\u559c\u6b22", jScrollPane4);

		jScrollPane3
				.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jTabbedPane1.addTab("\u8f6c\u53d1", jScrollPane3);

		jPanel1.add(jTabbedPane1);
		jTabbedPane1.setBounds(20, 240, 730, 660);

		jScrollPane5
				.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane5
				.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		jTextArea1.setColumns(20);
		jTextArea1.setEditable(false);
		jTextArea1.setRows(5);
		jScrollPane5.setViewportView(jTextArea1);

		jPanel1.add(jScrollPane5);
		jScrollPane5.setBounds(150, 100, 600, 90);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 783,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addComponent(jPanel1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 900,
						javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			TClient.follow(u, user.getId(), user.isFollowed());
			if (user.isFollowed()) {
				jButton1.setText("关注");
				user.setFollowed(false);
			} else {
				jButton1.setText("取消关注");
				user.setFollowed(true);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JTabbedPane jTabbedPane1;
	private javax.swing.JTextArea jTextArea1;
	// End of variables declaration//GEN-END:variables

}