package view;

import java.awt.GridBagConstraints;
import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import server.TClient;

import model.RLTweet;
import model.Tweet;
import model.User;

/*
 * Tweet_1.java
 *
 * Created on __DATE__, __TIME__
 */

/**
 *
 * @author  __USER__
 */
public class Tweet_1 extends javax.swing.JPanel {
	public MainView mv;
	public ArrayList<MyJPanel> panels;
	private User u;
	public MyJPanel thispane;
	private Tweet tw;
	private String opuid;
	private String time;
	private boolean flag = false;

	/** Creates new form Tweet_1改 */
	public Tweet_1(MainView mv, ArrayList<MyJPanel> panels, User u,
			MyJPanel mp, RLTweet tw, int type) {
		initComponents();
		this.mv = mv;
		this.panels = panels;
		this.u = u;
		this.thispane = mp;
		this.tw = tw;
		this.opuid = tw.getOpuid();
		time = tw.getOptime();
		if (type == 1) {
			jLabel15.setText(tw.getOpuname() + "转发");
		} else if (type == 2) {
			jLabel15.setText(tw.getOpuname() + "点了赞");
			jLabel15.setIcon(new ImageIcon(getClass().getResource(
					"/img/喜欢-黑色.png")));
		}
		getTweet();
	}

	public Tweet_1(MainView mv, ArrayList<MyJPanel> panels, User u,
			MyJPanel mp, Tweet tw, int type) {
		initComponents();
		this.mv = mv;
		this.panels = panels;
		this.u = u;
		this.thispane = mp;
		this.tw = tw;
		jLabel15.setVisible(false);
		time = tw.getTime();
		getTweet();
	}

	public void getTweet() {
		if (flag) {
			try {
				tw = (RLTweet) TClient.getTweet(u, tw.getId());
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
		jLabel2.setText(tw.getUname());
		jLabel3.setText("@" + tw.getUid() + " · " + time);
		if (tw.getTo_tid() != 0)
			jLabel4.setText("@" + tw.getTo_uid());
		else
			jLabel4.setVisible(false);
		jTextArea1.setText(tw.getContents());
		jLabel7.setText(tw.getReplays() + "");
		jLabel8.setText(tw.getRetweets() + "");
		jLabel9.setText(tw.getLikes() + "");
		if (tw.getPicfname() != null)
			setImg(tw.getPicfname(), jLabel1);
		if (tw.isRetweeted())
			jLabel8.setIcon(new ImageIcon(getClass().getResource(
					"/img/转发-蓝色.png")));
		else
			jLabel8
					.setIcon(new ImageIcon(getClass()
							.getResource("/img/转发.png")));
		if (tw.isLiked())
			jLabel9.setIcon(new ImageIcon(getClass().getResource(
					"/img/喜欢-蓝色.png")));
		else
			jLabel9
					.setIcon(new ImageIcon(getClass()
							.getResource("/img/喜欢.png")));
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
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jLabel4 = new javax.swing.JLabel();
		jLabel15 = new javax.swing.JLabel();

		jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jPanel1MouseClicked(evt);
			}
		});
		jPanel1.setLayout(null);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/资料.png"))); // NOI18N
		jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel1MouseClicked(evt);
			}
		});
		jPanel1.add(jLabel1);
		jLabel1.setBounds(20, 10, 50, 50);

		jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/评论.png"))); // NOI18N
		jLabel7.setText("  \u6570\u5b57");
		jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel7MouseClicked(evt);
			}
		});
		jPanel1.add(jLabel7);
		jLabel7.setBounds(130, 230, 67, 25);

		jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/转发.png"))); // NOI18N
		jLabel8.setText("  \u6570\u5b57");
		jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel8MouseClicked(evt);
			}
		});
		jPanel1.add(jLabel8);
		jLabel8.setBounds(300, 230, 67, 25);

		jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/喜欢.png"))); // NOI18N
		jLabel9.setText("  \u6570\u5b57");
		jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel9MouseClicked(evt);
			}
		});
		jPanel1.add(jLabel9);
		jLabel9.setBounds(470, 230, 67, 25);

		jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/收藏+瞬间.png"))); // NOI18N
		jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel11MouseClicked(evt);
			}
		});
		jPanel1.add(jLabel11);
		jLabel11.setBounds(650, 230, 25, 25);

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jLabel2.setText("\u6635\u79f0");
		jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel2MouseClicked(evt);
			}
		});
		jPanel1.add(jLabel2);
		jLabel2.setBounds(90, 10, 120, 32);

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16));
		jLabel3.setForeground(new java.awt.Color(153, 153, 153));
		jLabel3.setText("\u7528\u6237\u540d");
		jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel3MouseClicked(evt);
			}
		});
		jPanel1.add(jLabel3);
		jLabel3.setBounds(240, 20, 110, 22);

		jPanel2.setBackground(new java.awt.Color(230, 230, 230));
		jPanel2.setLayout(null);

		jScrollPane1
				.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		jTextArea1.setColumns(20);
		jTextArea1.setEditable(false);
		jTextArea1.setLineWrap(true);
		jTextArea1.setRows(5);
		jTextArea1.setWrapStyleWord(true);
		jTextArea1.setAutoscrolls(false);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel2.add(jScrollPane1);
		jScrollPane1.setBounds(10, 10, 660, 120);

		jPanel1.add(jPanel2);
		jPanel2.setBounds(80, 70, 680, 140);

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16));
		jLabel4.setForeground(new java.awt.Color(0, 153, 255));
		jLabel4.setText("@\u6635\u79f0\uff1a");
		jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel4MouseClicked(evt);
			}
		});
		jPanel1.add(jLabel4);
		jLabel4.setBounds(90, 50, 100, 22);

		jLabel15.setForeground(new java.awt.Color(153, 153, 153));
		jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/转发.png"))); // NOI18N
		jLabel15.setText("  \u6635\u79f0\u559c\u6b22\u4e86");
		jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel15MouseClicked(evt);
			}
		});
		jPanel1.add(jLabel15);
		jLabel15.setBounds(640, 20, 112, 25);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 782,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 267,
				Short.MAX_VALUE));
	}// </editor-fold>
	//GEN-END:initComponents

	private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {
		panels.add(thispane);
		MyJPanel mp = new MyJPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		try {
			if (tw.getTo_tid() != 0) {
				/*ArrayList<Tweet> ftws = TClient.getFatherTweets(u, tw
						.getTo_tid());
				for (Tweet tw : ftws) {
					if (tw.getMediaType() == 0) {
						mp.add(new Tweet_1(mv, panels, u, mp, tw, 0), gbc);
					} else
						mp.add(new Tweet_2(mv, panels, u, mp, tw, 0), gbc);
				}
				mp.add(this);
				mv.getMvsp().setViewportView(mp);
				JScrollBar sBar = jScrollPane1.getVerticalScrollBar();
				sBar.setValue(sBar.getMaximum());*/
				ArrayList<Tweet> ctws = TClient.getComment(u, tw.getId());
				for (Tweet tw : ctws) {
					if (tw.getMediaType() == 0) {
						mp.add(new Tweet_1(mv, panels, u, mp, tw, 0), gbc);
					} else
						mp.add(new Tweet_2(mv, panels, u, mp, tw, 0), gbc);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {
		panels.add(thispane);
		OtherPersonPanel pp = new OtherPersonPanel(mv, panels, u, opuid);
		pp.setVisible(true);
		mv.getMvsp().setViewportView(pp);
	}

	private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {
		panels.add(thispane);
		mv.getMvsp().setViewportView(
				(new OtherPersonPanel(mv, panels, u, tw.getTo_uid())));
	}

	private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {
		panels.add(thispane);
		mv.getMvsp().setViewportView(
				(new OtherPersonPanel(mv, panels, u, tw.getUid())));
	}

	private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
		panels.add(thispane);
		mv.getMvsp().setViewportView(
				(new OtherPersonPanel(mv, panels, u, tw.getUid())));
	}

	private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
		panels.add(thispane);
		mv.getMvsp().setViewportView(
				(new OtherPersonPanel(mv, panels, u, tw.getUid())));
	}

	private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {
		try {
			TClient.like(u, tw.getId(), tw.isLiked());
			flag = true;
			getTweet();
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

	private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {
		new ForwardView(mv, u,tw).setVisible(true);
	}

	private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {
		new SelectView().setVisible(true);
	}

	private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {
		try {
			TClient.retweet(u, tw.getId(), tw.isRetweeted());
			flag = true;
			getTweet();
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
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	// End of variables declaration//GEN-END:variables

}