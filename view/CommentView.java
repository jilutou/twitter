/*
 * CommentView.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

/**
 *
 * @author  __USER__
 */
public class CommentView extends javax.swing.JPanel {

	/** Creates new form CommentView */
	public CommentView() {
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

		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jPanel2 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jButton1 = new javax.swing.JButton();

		jPanel1.setLayout(null);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 798,
				Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 828,
				Short.MAX_VALUE));

		jScrollPane1.setViewportView(jPanel2);

		jPanel1.add(jScrollPane1);
		jScrollPane1.setBounds(0, 70, 800, 590);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/����.png"))); // NOI18N
		jPanel1.add(jLabel1);
		jLabel1.setBounds(20, 10, 60, 40);

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jLabel2.setText("\u8bc4\u8bba");
		jPanel1.add(jLabel2);
		jLabel2.setBounds(220, 10, 50, 50);

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setText("\u6635\u79f0");
		jPanel1.add(jLabel3);
		jLabel3.setBounds(280, 20, 220, 30);

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));
		jLabel4.setText("\u7684\u63a8\u6587");
		jPanel1.add(jLabel4);
		jLabel4.setBounds(510, 20, 80, 30);

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane2.setViewportView(jTextArea1);

		jPanel1.add(jScrollPane2);
		jScrollPane2.setBounds(20, 670, 760, 160);

		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jButton1.setForeground(new java.awt.Color(0, 153, 255));
		jButton1.setText("\u53d1\u9001\u8bc4\u8bba");
		jPanel1.add(jButton1);
		jButton1.setBounds(320, 850, 110, 30);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 900,
				javax.swing.GroupLayout.PREFERRED_SIZE));
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea jTextArea1;
	// End of variables declaration//GEN-END:variables

}