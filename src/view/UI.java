package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crontoller.ParaUI;
import modelo.Botonera;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI extends JFrame {
	ParaUI paraUI;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(new Rectangle(400 , 500));
		setLocationRelativeTo(null);
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
		Botonera botoneraFacil = new Botonera(5);
		botoneraFacil.getPanel().setVisible(false);
		contentPane.add(botoneraFacil.getPanel(), BorderLayout.EAST);
		
		Botonera botoneraMedio = new Botonera(8);
		botoneraMedio.getPanel().setVisible(false);
		contentPane.add(botoneraMedio.getPanel(), BorderLayout.CENTER);
		
		Botonera botoneraDificil = new Botonera(12);
		botoneraDificil.getPanel().setVisible(false);
		contentPane.add(botoneraDificil.getPanel(), BorderLayout.WEST);
		
		paraUI = new ParaUI(contentPane, mnitFacil, mnitMedio,mnitDificil, botoneraFacil, botoneraMedio, botoneraDificil);
		mnitInicar.addActionListener(paraUI);
		
		
		
	}

}	
