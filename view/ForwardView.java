/*
 * ForwardView.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import server.TClient;

import model.Tweet;
import model.User;

/**
 *
 * @author  __USER__
 */
public class ForwardView extends javax.swing.JFrame {
	private MainView mv;
	private User u;
	private Tweet tw;
	private int mediaType = 0;
	private int mediaCount = 0;
	private ArrayList<File> media = new ArrayList<File>();
	private ArrayList<String> fe = new ArrayList<String>();

	/** Creates new form ForwardView */
	public ForwardView(MainView mv, User u, Tweet tw) {
		initComponents();
		this.setLocationRelativeTo(null);
		this.mv = mv;
		this.u = u;
		this.tw = tw;
		jLabel8.setText(tw.getUname());
		jLabel9.setText(tw.getUid() + " �� " + tw.getTime());
		jTextArea2.setText(tw.getContents());
		jLabel2.setText("@" + tw.getUid());
		setImg(tw.getPicfname(), jLabel3);
		setImg(u.getPicfname(), jLabel4);
	}

	public void setImg(String picfname, JLabel jlb) {
		ImageIcon img = new ImageIcon("C:Twitter/CLIB/picture/" + picfname);
		img.setImage(img.getImage().getScaledInstance(jlb.getWidth(),
				jlb.getHeight(), Image.SCALE_DEFAULT));
		jlb.setIcon(img);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jButton1 = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea2 = new javax.swing.JTextArea();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setLayout(null);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16));
		jLabel1.setForeground(new java.awt.Color(0, 153, 255));
		jLabel1.setText("\u56de\u590d");
		jPanel1.add(jLabel1);
		jLabel1.setBounds(90, 170, 40, 20);

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel1.add(jScrollPane1);
		jScrollPane1.setBounds(90, 200, 660, 160);

		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jButton1.setForeground(new java.awt.Color(0, 153, 255));
		jButton1.setText("\u56de\u590d");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jPanel1.add(jButton1);
		jButton1.setBounds(670, 370, 81, 27);

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16));
		jLabel2.setForeground(new java.awt.Color(0, 153, 255));
		jLabel2.setText("@");
		jPanel1.add(jLabel2);
		jLabel2.setBounds(130, 170, 150, 20);

		jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/����.png"))); // NOI18N
		jPanel1.add(jLabel3);
		jLabel3.setBounds(20, 20, 50, 50);

		jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/����.png"))); // NOI18N
		jPanel1.add(jLabel4);
		jLabel4.setBounds(20, 190, 50, 50);

		jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/����ͼƬ.png"))); // NOI18N
		jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel5MouseClicked(evt);
			}
		});
		jPanel1.add(jLabel5);
		jLabel5.setBounds(90, 370, 40, 30);
		jPanel1.add(jLabel6);
		jLabel6.setBounds(90, 20, 0, 0);
		jPanel1.add(jLabel7);
		jLabel7.setBounds(290, 20, 0, 0);

		jScrollPane2
				.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		jTextArea2.setColumns(20);
		jTextArea2.setEditable(false);
		jTextArea2.setLineWrap(true);
		jTextArea2.setRows(5);
		jTextArea2.setWrapStyleWord(true);
		jScrollPane2.setViewportView(jTextArea2);

		jPanel1.add(jScrollPane2);
		jScrollPane2.setBounds(90, 50, 660, 100);

		jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jLabel8.setText("jLabel8");
		jPanel1.add(jLabel8);
		jLabel8.setBounds(90, 10, 140, 32);

		jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16));
		jLabel9.setForeground(new java.awt.Color(153, 153, 153));
		jLabel9.setText("jLabel9");
		jPanel1.add(jLabel9);
		jLabel9.setBounds(310, 20, 53, 22);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 782,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 416,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {
		if (mediaCount < 4) {
			JFileChooser jfc = new JFileChooser();
			jfc.showOpenDialog(this);
			File f = jfc.getSelectedFile();
			if (f == null || !f.exists()) {
				JOptionPane.showMessageDialog(this, "��ѡ���ļ�");
				return;
			}
			media.add(f);
			fe.add(f.getName().substring(f.getName().lastIndexOf(".") + 1));
			jLabel5.setText(++mediaCount + "");
			mediaType = 2;
		}
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String cont = jTextArea1.getText();
		if (cont.equals("")) {
			JOptionPane.showMessageDialog(this, "���ݲ���Ϊ�գ�����");
		} else {
			try {
				TClient.tweet(u, 0, tw.getTo_uid(), tw.getTo_tid(), cont,
						mediaType, media, fe);
				mv.getMainTw();
				this.dispose();
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
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		} catch (Exception e) {
			//TODO exception
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ForwardView().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextArea jTextArea2;
	// End of variables declaration//GEN-END:variables

}