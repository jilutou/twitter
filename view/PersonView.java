/*
 * PersonView.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

/**
 *
 * @author  __USER__
 */
public class PersonView extends javax.swing.JPanel {

	/** Creates new form PersonView */
	public PersonView() {
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel4 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel132 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jLabel113 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox();
		jComboBox2 = new javax.swing.JComboBox();
		jComboBox3 = new javax.swing.JComboBox();
		jLabel114 = new javax.swing.JLabel();
		jButton38 = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jLabel6 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();

		jPanel4.setFocusable(false);
		jPanel4.setVerifyInputWhenFocusTarget(false);
		jPanel4.setLayout(null);

		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("\u5934\u50cf");
		jPanel4.add(jLabel1);
		jLabel1.setBounds(220, 40, 200, 200);

		jLabel132.setText("\u4e2a\u6027\u7b7e\u540d\uff1a");
		jPanel4.add(jLabel132);
		jLabel132.setBounds(30, 390, 75, 20);

		jTextField3
				.setText("\u8fd9\u4e2a\u4eba\u5f88\u61d2\uff0c\u6ca1\u6709\u4e2a\u6027\u7b7e\u540d\u3002");
		jPanel4.add(jTextField3);
		jTextField3.setBounds(100, 390, 520, 30);

		jLabel113.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel113.setText("\u751f\u65e5\uff1a");
		jPanel4.add(jLabel113);
		jLabel113.setBounds(30, 440, 42, 19);

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"-请选择年份-", "2019", "2018", "2017", "2016", "2015", "2014",
				"2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006",
				"2005", "2004", "2004", "2003", "2002", "1993", "2001", "2000",
				"1999", "1998", "1997", "1996", "1995", "1994", "1992", "1991",
				"1990" }));
		jComboBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox1ActionPerformed(evt);
			}
		});
		jPanel4.add(jComboBox1);
		jComboBox1.setBounds(100, 440, 118, 26);

		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"-请选择月份-", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3",
				"2", "1" }));
		jPanel4.add(jComboBox2);
		jComboBox2.setBounds(210, 440, 118, 26);

		jComboBox3
				.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
						"-请选择日期-", "30", "29", "28", "27", "26", "25", "24",
						"23", "22", "21", "20", "19", "18", "17", "16", "15",
						"14", "13", "12", "11", "10", "9", "8", "7", "6", "5",
						"4", "3", "2", "1" }));
		jPanel4.add(jComboBox3);
		jComboBox3.setBounds(320, 440, 118, 26);

		jLabel114.setText("\u4e2a\u4eba\u7b80\u4ecb\uff1a");
		jPanel4.add(jLabel114);
		jLabel114.setBounds(30, 560, 75, 20);

		jButton38.setForeground(new java.awt.Color(0, 153, 255));
		jButton38.setText("\u4fdd\u5b58\u4fee\u6539");
		jPanel4.add(jButton38);
		jButton38.setBounds(280, 830, 93, 29);

		jLabel2.setText("\u5173\u6ce8\uff1a");
		jPanel4.add(jLabel2);
		jLabel2.setBounds(230, 270, 45, 20);

		jLabel3.setText("\u5173\u6ce8\u6570");
		jPanel4.add(jLabel3);
		jLabel3.setBounds(270, 270, 45, 20);

		jLabel4.setText("\u7c89\u4e1d\uff1a");
		jPanel4.add(jLabel4);
		jLabel4.setBounds(340, 270, 45, 20);

		jLabel5.setText("\u7c89\u4e1d\u6570");
		jPanel4.add(jLabel5);
		jLabel5.setBounds(380, 270, 45, 20);

		jTextField1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
		jTextField1.setText("\u6635\u79f0");
		jPanel4.add(jTextField1);
		jTextField1.setBounds(220, 310, 210, 25);

		jLabel6.setForeground(new java.awt.Color(153, 153, 153));
		jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel6.setText("\u7528\u6237\u540d");
		jPanel4.add(jLabel6);
		jLabel6.setBounds(220, 350, 210, 20);

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jPanel4.add(jScrollPane1);
		jScrollPane1.setBounds(30, 600, 600, 190);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 635,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addComponent(jPanel4,
						javax.swing.GroupLayout.PREFERRED_SIZE, 900,
						javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
	}// </editor-fold>
	//GEN-END:initComponents

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
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
	private javax.swing.JLabel jLabel132;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField3;
	// End of variables declaration//GEN-END:variables

}