package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Botonera;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import java.awt.GridLayout;
import javax.swing.JButton;

public class UI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 397);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mnitInicar = new JMenuItem("Start");
		menuBar.add(mnitInicar);
		
		JMenu mnLevels = new JMenu("Niveles");
		menuBar.add(mnLevels);
		ButtonGroup group = new ButtonGroup();
		
		JCheckBoxMenuItem mnitFacil = new JCheckBoxMenuItem("Facil");
		mnLevels.add(mnitFacil);
		group.add(mnitFacil);
		mnitFacil.setSelected(true);
		
		JCheckBoxMenuItem mnitMedio = new JCheckBoxMenuItem("Medio");
		mnLevels.add(mnitMedio);
		group.add(mnitMedio);
		
		JCheckBoxMenuItem mnitDificil = new JCheckBoxMenuItem("Dificil");
		mnLevels.add(mnitDificil);
		group.add(mnitDificil);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// Pincho facil
		Botonera panelbotones = new Botonera(3);
//		panelbotones.setVisible(true);
		contentPane.add(panelbotones.getContainerBotones(), BorderLayout.CENTER);
		
		
	}

}	
