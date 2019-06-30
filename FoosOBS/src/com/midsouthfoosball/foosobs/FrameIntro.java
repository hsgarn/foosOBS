package com.midsouthfoosball.foosobs;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class FrameIntro {

	private JFrame frmFoosOBSIntro;
//	public TimeClock timeClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameIntro window = new FrameIntro();
					window.frmFoosOBSIntro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameIntro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFoosOBSIntro = new JFrame();
		frmFoosOBSIntro.setTitle("Foos OBS");
		frmFoosOBSIntro.setBackground(new Color(240, 240, 240));
		frmFoosOBSIntro.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 15));
		frmFoosOBSIntro.setBounds(100, 100, 320, 200);
		frmFoosOBSIntro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFoosOBSIntro.getContentPane().setLayout(null);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmFoosOBSIntro.dispose();

				JFrame f = new JFrame("Foos OBS");
				f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
				
				MainJPanel p;
				try {
					p = new MainJPanel();
					p.setPreferredSize(new Dimension(850, 550));
	
					f.getContentPane().add(p);
					f.pack();
					f.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnContinue.setForeground(Color.BLACK);
		btnContinue.setBackground(new Color(0, 255, 255));
		btnContinue.setBounds(91, 100, 125, 23);
		frmFoosOBSIntro.getContentPane().add(btnContinue);
		
		JLabel lblFoosObs = new JLabel("Foos OBS");
		lblFoosObs.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoosObs.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblFoosObs.setBounds(71, 27, 156, 47);
		frmFoosOBSIntro.getContentPane().add(lblFoosObs);
	}
}
