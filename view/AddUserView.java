/*
 * AddUserView.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

/**
 *
 * @author  __USER__
 */
public class AddUserView extends javax.swing.JFrame {

	/** Creates new form AddUserView */
	public AddUserView() {
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
		jButton1 = new javax.swing.JButton();


		jPanel1.setLayout(null);

		jTextField1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jTextField1.setText("\u8bf7\u8f93\u5165\u7528\u6237\u540d");
		jPanel1.add(jTextField1);
		jTextField1.setBounds(60, 40, 270, 30);

		jTextField2.setText("\u8bf7\u8f93\u5165\u5217\u8868\u540d");
		jPanel1.add(jTextField2);
		jTextField2.setBounds(60, 90, 270, 23);

		jButton1.setForeground(new java.awt.Color(0, 153, 255));
		jButton1.setText("\u786e\u8ba4\u6dfb\u52a0");
		jPanel1.add(jButton1);
		jButton1.setBounds(150, 140, 81, 25);

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
				new AddUserView().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	// End of variables declaration//GEN-END:variables

}