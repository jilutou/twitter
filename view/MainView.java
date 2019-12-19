/*
 * MainView.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import server.TClient;

import model.RLTweet;
import model.Tweet;
import model.User;

/**
 *
 * @author  __USER__
 */
public class MainView extends javax.swing.JFrame {
	public ArrayList<MyJPanel> panels = new ArrayList<MyJPanel>();
	private User u;
	private ArrayList<Tweet> tws = new ArrayList<Tweet>();
	private ArrayList<RLTweet> rtws = new ArrayList<RLTweet>();
	private ArrayList<RLTweet> ltws = new ArrayList<RLTweet>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/** Creates new form MainView */
	public MainView(User u) {
		initComponents();
		this.setLocationRelativeTo(null);
		this.u = u;
		getMainTw();
	}

	public void getMainTw() {
		jLabel10.setIcon(null);
		try {
			MyJPanel mp = new MyJPanel();
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			Date d1, d2, d3;
			tws = TClient.getAllTweets(u);
			rtws = TClient.getAllLRTweets(u, "retweets");
			ltws = TClient.getAllLRTweets(u, "likes");
			int i = tws.size() - 1, j = rtws.size() - 1, k = ltws.size() - 1;
			if (i > -1)
				d1 = sdf.parse(tws.get(i).getTime());
			else
				d1 = sdf.parse("2000-01-01 00:00:00");
			if (j > -1)
				d2 = sdf.parse(rtws.get(j).getTime());
			else
				d2 = sdf.parse("2000-01-01 00:00:00");
			if (k > -1)
				d3 = sdf.parse(ltws.get(k).getTime());
			else
				d3 = sdf.parse("2000-01-01 00:00:00");
			while (i > -1 || j > -1 || k > -1) {
				if (!d1.before(d2) && !d1.before(d3)) {
					if (tws.get(i).getMediaType() == 0) {
						mp.add(new Tweet_1(this, panels, u, mp, tws.get(i), 0),
								gbc);
					} else {
						mp.add(new Tweet_2(this, panels, u, mp, tws.get(i), 0),
								gbc);
					}
					if (--i > -1)
						d1 = sdf.parse(tws.get(i).getTime());
					else
						d1 = sdf.parse("2000-01-01 00:00:00");
				} else if (d2.after(d1) && !d2.before(d3)) {
					if (rtws.get(j).getMediaType() == 0) {
						mp
								.add(new Tweet_1(this, panels, u, mp, rtws
										.get(j), 1), gbc);
					} else {
						mp
								.add(new Tweet_2(this, panels, u, mp, rtws
										.get(j), 1), gbc);
					}
					if (--j > -1)
						d2 = sdf.parse(rtws.get(j).getOptime());
					else
						d2 = sdf.parse("2000-01-01 00:00:00");
				} else if (d3.after(d1) && d3.after(d2)) {
					if (ltws.get(k).getMediaType() == 0) {
						mp
								.add(new Tweet_1(this, panels, u, mp, ltws
										.get(k), 2), gbc);
					} else {
						mp
								.add(new Tweet_2(this, panels, u, mp, ltws
										.get(k), 2), gbc);
					}
					if (--k > -1)
						d3 = sdf.parse(ltws.get(k).getOptime());
					else
						d3 = sdf.parse("2000-01-01 00:00:00");
				}
			}
			mvsp.setViewportView(mp);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public javax.swing.JScrollPane getMvsp() {
		return mvsp;
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel3 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		jLabel10 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel11 = new javax.swing.JLabel();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jLabel14 = new javax.swing.JLabel();
		jPanel5 = new javax.swing.JPanel();
		jLabel12 = new javax.swing.JLabel();
		jPanel6 = new javax.swing.JPanel();
		jLabel13 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		mvsp = new javax.swing.JScrollPane();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel2.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 60));
		jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/后退.png"))); // NOI18N
		jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel10MouseClicked(evt);
			}
		});

		jTextField1.setBackground(new java.awt.Color(204, 204, 204));
		jTextField1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 36));
		jTextField1.setForeground(new java.awt.Color(102, 102, 102));
		jTextField1.setText("\u641c\u7d22Twitter");
		jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTextField1MouseClicked(evt);
			}
		});

		jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/探索.png"))); // NOI18N

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel2Layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel10).addGap(172, 172, 172)
						.addComponent(jTextField1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 652,
								javax.swing.GroupLayout.PREFERRED_SIZE).addGap(
								42, 42, 42).addComponent(jLabel11,
								javax.swing.GroupLayout.PREFERRED_SIZE, 66,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(199, Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel10)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel11))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jPanel1.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 60));
		jLabel1.setForeground(new java.awt.Color(118, 169, 234));
		jLabel1.setText("Twitter");

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 40));
		jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/主页.png"))); // NOI18N
		jLabel2.setText(" \u4e3b\u9875");
		jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel2MouseClicked(evt);
			}
		});

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 40));
		jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/探索.png"))); // NOI18N
		jLabel3.setText(" \u63a2\u7d22");
		jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel3MouseClicked(evt);
			}
		});

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 40));
		jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/私信.png"))); // NOI18N
		jLabel4.setText(" \u79c1\u4fe1");

		jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 40));
		jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/书签.png"))); // NOI18N
		jLabel5.setText(" \u4e66\u7b7e");
		jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel5MouseClicked(evt);
			}
		});

		jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 40));
		jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/列表.png"))); // NOI18N
		jLabel6.setText(" \u5217\u8868");
		jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel6MouseClicked(evt);
			}
		});

		jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 40));
		jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/资料.png"))); // NOI18N
		jLabel7.setText(" \u4e2a\u4eba");
		jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel7MouseClicked(evt);
			}
		});

		jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 40));
		jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/通知.png"))); // NOI18N
		jLabel8.setText(" \u901a\u77e5");
		jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel8MouseClicked(evt);
			}
		});

		jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 40));
		jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/瞬间.png"))); // NOI18N
		jLabel9.setText(" \u77ac\u95f4");
		jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel9MouseClicked(evt);
			}
		});

		jButton1.setBackground(new java.awt.Color(255, 255, 255));
		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 48));
		jButton1.setForeground(new java.awt.Color(0, 153, 255));
		jButton1.setText("\u63a8\u6587");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/LOGO.png"))); // NOI18N

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel9)
																						.addComponent(
																								jLabel7,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								243,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								jPanel1Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												false)
																										.addComponent(
																												jLabel6,
																												javax.swing.GroupLayout.Alignment.LEADING,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												jLabel8,
																												javax.swing.GroupLayout.Alignment.LEADING,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												jLabel5,
																												javax.swing.GroupLayout.Alignment.LEADING,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												jLabel3,
																												javax.swing.GroupLayout.Alignment.LEADING,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												jLabel4,
																												javax.swing.GroupLayout.Alignment.LEADING,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												162,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								jLabel2)
																						.addComponent(
																								jLabel1)))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(
																				70,
																				70,
																				70)
																		.addComponent(
																				jButton1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				248,
																				Short.MAX_VALUE)))
										.addGap(68, 68, 68)).addGroup(
								jPanel1Layout.createSequentialGroup().addGap(
										39, 39, 39).addComponent(jLabel14,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										300,
										javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(47, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jLabel14,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												100,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel1)
										.addGap(29, 29, 29)
										.addComponent(jLabel2)
										.addGap(29, 29, 29)
										.addComponent(jLabel3)
										.addGap(28, 28, 28)
										.addComponent(jLabel4)
										.addGap(36, 36, 36)
										.addComponent(jLabel5)
										.addGap(33, 33, 33)
										.addComponent(jLabel8)
										.addGap(34, 34, 34)
										.addComponent(jLabel6)
										.addGap(35, 35, 35)
										.addComponent(jLabel7)
										.addGap(31, 31, 31)
										.addComponent(jLabel9)
										.addGap(41, 41, 41)
										.addComponent(
												jButton1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												61,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(31, 31, 31)));

		jPanel5.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		jPanel5.setLayout(null);

		jLabel12.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel12.setText("\u63a8\u8350\u5173\u6ce8");
		jPanel5.add(jLabel12);
		jLabel12.setBounds(10, 10, 96, 32);

		jPanel6.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		jPanel6.setLayout(null);

		jLabel13.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jLabel13.setText("\u63a8\u8350\u8bdd\u9898");
		jPanel6.add(jLabel13);
		jLabel13.setBounds(10, 10, 96, 32);

		jPanel4.setLayout(null);

		mvsp
				.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mvsp.setPreferredSize(new java.awt.Dimension(1, 2));
		jPanel4.add(mvsp);
		mvsp.setBounds(0, 0, 800, 900);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout
				.setHorizontalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addComponent(
												jPanel1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel3Layout
																		.createSequentialGroup()
																		.addComponent(
																				jPanel4,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				800,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel3Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jPanel6,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								389,
																								Short.MAX_VALUE)
																						.addComponent(
																								jPanel5,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								389,
																								Short.MAX_VALUE)))
														.addComponent(
																jPanel2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel3Layout
										.createSequentialGroup()
										.addComponent(
												jPanel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel3Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																jPanel3Layout
																		.createSequentialGroup()
																		.addComponent(
																				jPanel5,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				440,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				18,
																				18,
																				18)
																		.addComponent(
																				jPanel6,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				440,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(
																jPanel4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																900,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addComponent(jPanel1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 1004,
								Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel3, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {
		if (panels.size() == 0) {
			JOptionPane.showMessageDialog(this, "没有前一页");
		} else {
			mvsp.setViewportView(panels.get(panels.size() - 1));
			panels.remove(panels.size() - 1);
		}
	}

	private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {
		jTextField1.setText("");
	}

	private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {
		panels = new ArrayList<MyJPanel>();
	}

	private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {
		panels = new ArrayList<MyJPanel>();
		OtherPersonPanel opp = new OtherPersonPanel(this, panels, u, u.getId());
		mvsp.setViewportView(opp);
	}

	private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {
		panels = new ArrayList<MyJPanel>();
	}

	private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {
		panels = new ArrayList<MyJPanel>();
	}

	private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {
		panels = new ArrayList<MyJPanel>();
		try {
			ArrayList<Tweet> bms = TClient.getBookMarks(u);
			MyJPanel mp = new MyJPanel();
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			for (Tweet tw : bms) {
				if (tw.getMediaType() == 0) {
					mp.add(new Tweet_1(this, panels, u, mp, tw, 0));
				} else {
					mp.add(new Tweet_2(this, panels, u, mp, tw, 0));
				}
			}
			mvsp.setViewportView(mp);
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

	private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {
		panels = new ArrayList<MyJPanel>();
	}

	private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
		panels = new ArrayList<MyJPanel>();
		getMainTw();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		new SentTweetView(this, u).setVisible(true);
	}

	//	/**
	//	 * @param args the command line arguments
	//	 */
	//	public static void main(String args[]) {
	//		try {
	//			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	//		} catch (Exception e) {
	//			//TODO exception
	//		}
	//		java.awt.EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				new MainView(null).setVisible(true);
	//			}
	//		});
	//	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JScrollPane mvsp;
	// End of variables declaration//GEN-END:variables

}