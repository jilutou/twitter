/*
 * ProfileView.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import javax.swing.ImageIcon;

import model.User;

/**
 *
 * @author  __USER__
 */
public class ProfileView extends javax.swing.JFrame {

	/** Creates new form ProfileView */
	public ProfileView(User u) {
		initComponents();
		jLabel1.setIcon(new ImageIcon("C:Twitter/CLIB/picture/"
				+ u.getPicfname()));
		jTextField1.setText(u.getName());
		jTextArea1.setText(u.getBio());
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel4 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel113 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		jComboBox2 = new javax.swing.JComboBox();
		jComboBox3 = new javax.swing.JComboBox();
		jLabel114 = new javax.swing.JLabel();
		jButton38 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jLabel2 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel4.setFocusable(false);
		jPanel4.setVerifyInputWhenFocusTarget(false);
		jPanel4.setLayout(null);

		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel1MouseClicked(evt);
			}
		});
		jPanel4.add(jLabel1);
		jLabel1.setBounds(200, 30, 200, 200);

		jLabel113.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel113.setText("\u751f\u65e5\uff1a");
		jPanel4.add(jLabel113);
		jLabel113.setBounds(20, 530, 42, 19);

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"-请选择年份-", "2019", "2018", "2017", "2016", "2015", "2014",
				"2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006",
				"2005", "2004", "2004", "2003", "2002", "1993", "2001", "2000",
				"1999", "1998", "1997", "1996", "1995", "1994", "1992", "1991",
				"1990" }));
		jPanel4.add(jComboBox1);
		jComboBox1.setBounds(70, 530, 118, 26);

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"-请选择月份-", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3",
				"2", "1" }));
		jPanel4.add(jComboBox2);
		jComboBox2.setBounds(210, 530, 118, 26);

		jComboBox3
				.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
						"-请选择日期-", "30", "29", "28", "27", "26", "25", "24",
						"23", "22", "21", "20", "19", "18", "17", "16", "15",
						"14", "13", "12", "11", "10", "9", "8", "7", "6", "5",
						"4", "3", "2", "1" }));
		jPanel4.add(jComboBox3);
		jComboBox3.setBounds(340, 530, 118, 26);

		jLabel114.setText("\u4e2a\u4eba\u7b80\u4ecb\uff1a");
		jPanel4.add(jLabel114);
		jLabel114.setBounds(20, 360, 75, 20);

		jButton38.setForeground(new java.awt.Color(0, 153, 255));
		jButton38.setText("\u4fdd\u5b58\u4fee\u6539");
		jButton38.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton38ActionPerformed(evt);
			}
		});
		jPanel4.add(jButton38);
		jButton38.setBounds(260, 630, 93, 29);

		jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
		jTextField1.setText("\u6635\u79f0");
		jPanel4.add(jTextField1);
		jTextField1.setBounds(20, 300, 580, 30);

		jTextArea1.setColumns(20);
		jTextArea1.setLineWrap(true);
		jTextArea1.setRows(5);
		jTextArea1.setWrapStyleWord(true);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel4.add(jScrollPane1);
		jScrollPane1.setBounds(20, 390, 580, 110);

		jLabel2.setText("\u6635\u79f0\uff1a");
		jPanel4.add(jLabel2);
		jLabel2.setBounds(20, 270, 50, 20);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel4, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 699,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ProfileView().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton38;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JComboBox jComboBox2;
	private javax.swing.JComboBox jComboBox3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel113;
	private javax.swing.JLabel jLabel114;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration//GEN-END:variables

}