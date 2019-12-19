/*
 * PictureView.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author  __USER__
 */
public class PictureView extends javax.swing.JFrame {
	private ArrayList<String> media = new ArrayList<String>();
	private int number;

	/** Creates new form PictureView */
	public PictureView(ArrayList<String> media, int number) {
		initComponents();
		this.setLocationRelativeTo(null);
		this.media = media;
		this.number = number;
		setImg(media.get(number));
		if (number == 0)
			jLabel2.setVisible(false);
		if (number == media.size() - 1)
			jLabel3.setVisible(false);
	}

	public void setImg(String picfname) {
		ImageIcon img = new ImageIcon("C:Twitter/CLIB/picture/" + picfname);
		img.setImage(img.getImage().getScaledInstance(jLabel1.getWidth(),
				jLabel1.getHeight(), Image.SCALE_DEFAULT));
		jLabel1.setIcon(img);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jPanel1.setLayout(null);

		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jPanel1.add(jLabel1);
		jLabel1.setBounds(80, 0, 1160, 620);

		jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/下一个.png"))); // NOI18N
		jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel3MouseClicked(evt);
			}
		});
		jPanel1.add(jLabel3);
		jLabel3.setBounds(1260, 280, 50, 50);

		jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/img/上一个.png"))); // NOI18N
		jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel2MouseClicked(evt);
			}
		});
		jPanel1.add(jLabel2);
		jLabel2.setBounds(10, 280, 50, 50);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1321,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 620,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {
		setImg(media.get(++number));
		if (number == 1)
			jLabel2.setVisible(true);
		if (number == media.size() - 1)
			jLabel3.setVisible(false);
	}

	private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
		setImg(media.get(--number));
		if (number == 0)
			jLabel2.setVisible(false);
		if (number == media.size() - 2)
			jLabel3.setVisible(true);
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
				new PictureView().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	// End of variables declaration//GEN-END:variables

}