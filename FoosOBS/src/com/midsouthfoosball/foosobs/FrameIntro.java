package com.midsouthfoosball.foosobs;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameIntro {

	private JFrame frmFoosOBSIntro;
	public TimeClock tc;

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
		frmFoosOBSIntro.setBounds(100, 100, 292, 199);
		frmFoosOBSIntro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFoosOBSIntro.getContentPane().setLayout(null);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmFoosOBSIntro.dispose();

				JFrame f = new JFrame("Foos OBS");
				f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
				
				TimeClock tc = new TimeClock();

				MainJPanel p = new MainJPanel();
//				p.setPreferredSize(new Dimension(800, 800));

				f.getContentPane().add(p);
				f.pack();
				f.setVisible(true);
				
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnContinue.setForeground(Color.BLACK);
		btnContinue.setBackground(new Color(0, 255, 255));
		btnContinue.setBounds(81, 103, 100, 23);
		frmFoosOBSIntro.getContentPane().add(btnContinue);
		
		JLabel lblFoosObs = new JLabel("Foos OBS");
		lblFoosObs.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFoosObs.setBounds(81, 11, 100, 46);
		frmFoosOBSIntro.getContentPane().add(lblFoosObs);
	}
}
