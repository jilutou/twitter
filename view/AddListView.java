/*
 * AddListView.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

/**
 *
 * @author  __USER__
 */
public class AddListView extends javax.swing.JFrame {

	/** Creates new form AddListView */
	public AddListView() {
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
		jTextField2 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();


		jPanel1.setLayout(null);

		jTextField1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jTextField1.setText("\u8f93\u5165\u5217\u8868\u6807\u9898");
		jPanel1.add(jTextField1);
		jTextField1.setBounds(50, 20, 290, 40);

		jTextField2.setText("\u8f93\u5165\u63cf\u8ff0");
		jPanel1.add(jTextField2);
		jTextField2.setBounds(50, 70, 290, 30);

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/����ͼƬ.png"))); // NOI18N
		jLabel1.setText("\u6dfb\u52a0\u5c01\u9762");
		jPanel1.add(jLabel1);
		jLabel1.setBounds(140, 120, 90, 25);

		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jButton1.setForeground(new java.awt.Color(0, 153, 255));
		jButton1.setText("\u4fdd\u5b58\u5217\u8868");
		jPanel1.add(jButton1);
		jButton1.setBounds(140, 160, 100, 25);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

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
				new AddListView().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	// End of variables declaration//GEN-END:variables

}