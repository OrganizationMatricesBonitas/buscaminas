package pruebasSanti;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.border.TitledBorder;

public class propieddesBotones extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					propieddesBotones frame = new propieddesBotones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public propieddesBotones() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 3, 0, 0));
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setContentAreaFilled(false);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn3.setBorder(new LineBorder(new Color(0, 0, 0)));
		btn3.setContentAreaFilled(false);
		contentPane.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn4.setBorderPainted(false);
		btn4.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(btn4);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn6.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.GRAY));
		contentPane.add(btn6);
		
		JButton btn6_1 = new JButton("6");
		btn6_1.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.GRAY));
		contentPane.add(btn6_1);
		
		JButton btn7 = new JButton("7");
		contentPane.add(btn7);
		
		JButton btn6_2 = new JButton("6");
		btn6_2.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.GRAY));
		contentPane.add(btn6_2);
		
		JButton btn6_3 = new JButton("6");
		btn6_3.setBorder(new TitledBorder(new LineBorder(new Color(128, 128, 128)), "", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, Color.GRAY));
		contentPane.add(btn6_3);
	}

}
