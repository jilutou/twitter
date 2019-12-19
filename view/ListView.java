/*
 * ListView.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

/**
 *
 * @author  __USER__
 */
public class ListView extends javax.swing.JPanel {

	/** Creates new form ListView */
	public ListView() {
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

		jTabbedPane1 = new javax.swing.JTabbedPane();
		jScrollPane1 = new javax.swing.JScrollPane();
		jPanel1 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		jPanel3 = new javax.swing.JPanel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		jTabbedPane1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 1029,
				Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 859,
				Short.MAX_VALUE));

		jScrollPane1.setViewportView(jPanel1);

		jTabbedPane1.addTab("\u62e5\u6709", jScrollPane1);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 793,
				Short.MAX_VALUE));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 867,
				Short.MAX_VALUE));

		jScrollPane2.setViewportView(jPanel2);

		jTabbedPane1.addTab("\u8ba2\u9605", jScrollPane2);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 793,
				Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 867,
				Short.MAX_VALUE));

		jScrollPane3.setViewportView(jPanel3);

		jTabbedPane1.addTab("\u6210\u5458", jScrollPane3);

		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jButton1.setForeground(new java.awt.Color(0, 153, 255));
		jButton1.setText("\u6dfb\u52a0\u5217\u8868");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jButton2.setForeground(new java.awt.Color(0, 153, 255));
		jButton2.setText("\u5c06\u7528\u6237\u6dfb\u52a0\u81f3\u5217\u8868");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jTabbedPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 800,
								Short.MAX_VALUE)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addGap(40, 40, 40)
										.addComponent(
												jButton1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												250,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												211, Short.MAX_VALUE)
										.addComponent(
												jButton2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												250,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(49, 49, 49)));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								layout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jButton2)
														.addComponent(jButton1))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												jTabbedPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												844,
												javax.swing.GroupLayout.PREFERRED_SIZE)));
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		new AddUserView().setVisible(true);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		new AddListView().setVisible(true);
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTabbedPane jTabbedPane1;
	// End of variables declaration//GEN-END:variables

}