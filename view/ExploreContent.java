/*
 * NewsView.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

/**
 *
 * @author  __USER__
 */
public class ExploreContent extends javax.swing.JPanel {

	/** Creates new form NewsView */
	public ExploreContent() {
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

		jScrollPane1 = new javax.swing.JScrollPane();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();

		jPanel1.setLayout(null);

		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/����.png"))); // NOI18N
		jPanel1.add(jLabel1);
		jLabel1.setBounds(20, 10, 60, 40);

		jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel2.setText("\u5a92\u4f53\uff1a");
		jPanel1.add(jLabel2);
		jLabel2.setBounds(30, 70, 70, 20);

		jLabel3.setText("\u53d1\u5e03\u4e8e\uff1a");
		jPanel1.add(jLabel3);
		jLabel3.setBounds(30, 100, 48, 15);

		jLabel4.setText("\u65f6\u95f4");
		jPanel1.add(jLabel4);
		jLabel4.setBounds(80, 100, 90, 15);

		jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel5.setText("\u5185\u5bb9");
		jPanel1.add(jLabel5);
		jLabel5.setBounds(30, 130, 730, 750);

		jScrollPane1.setViewportView(jPanel1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 900,
				Short.MAX_VALUE));
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	// End of variables declaration//GEN-END:variables

}