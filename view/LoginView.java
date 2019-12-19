/*
 * LoginView.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.User;

import server.TClient;

/**
 *
 * @author  __USER__
 */
public class LoginView extends javax.swing.JFrame {

	/** Creates new form LoginView */
	public LoginView() {
		initComponents();
		this.setLocationRelativeTo(null);
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
		jTextField1 = new javax.swing.JTextField();
		jPasswordField1 = new javax.swing.JPasswordField();
		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(96, 168, 220));
		jPanel1.setForeground(new java.awt.Color(255, 255, 255));
		jPanel1.setLayout(null);
		jPanel1.add(jTextField1);
		jTextField1.setBounds(80, 320, 350, 40);
		jPanel1.add(jPasswordField1);
		jPasswordField1.setBounds(80, 390, 350, 40);

		jLabel1.setBackground(new java.awt.Color(255, 255, 255));
		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/Twitter.png"))); // NOI18N
		jLabel1.setText("jLabel1");
		jPanel1.add(jLabel1);
		jLabel1.setBounds(0, 0, 500, 300);

		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jButton1.setForeground(new java.awt.Color(0, 153, 255));
		jButton1.setText("\u767b\u5f55");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jPanel1.add(jButton1);
		jButton1.setBounds(210, 520, 90, 40);

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel2.setForeground(new java.awt.Color(255, 255, 255));
		jLabel2
				.setText("\u6ca1\u6709\u8d26\u53f7\uff1f\u73b0\u5728\u53bb\u6ce8\u518c");
		jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel2MouseClicked(evt);
			}
		});
		jPanel1.add(jLabel2);
		jLabel2.setBounds(180, 570, 150, 19);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String id=jTextField1.getText();
		String password=jPasswordField1.getText();
		try {
			User u=TClient.login(id, password);
			if(u==null)
				JOptionPane.showMessageDialog(this,"��¼ʧ��");
			else{
				JOptionPane.showMessageDialog(this,"��¼�ɹ�");
				new MainView(u).setVisible(true);
				this.dispose();
			}
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

	private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
		new RegisterView().setVisible(true);
		this.dispose();
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
				new LoginView().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration//GEN-END:variables

}