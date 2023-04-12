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
	Botonera botoneraFacil;
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
		
		JMenu mnNewMenu = new JMenu("Densidad");
		menuBar.add(mnNewMenu);
		
		ButtonGroup groupDensidad = new ButtonGroup();
		JCheckBoxMenuItem mnitDensidadBaja = new JCheckBoxMenuItem("Baja");
		mnitDensidadBaja.setSelected(true);
		mnNewMenu.add(mnitDensidadBaja);
		groupDensidad.add(mnitDensidadBaja);
		
		JCheckBoxMenuItem mnitDensidadMedia = new JCheckBoxMenuItem("Media");
		mnNewMenu.add(mnitDensidadMedia);
		groupDensidad.add(mnitDensidadMedia);
		
		JCheckBoxMenuItem mnitDensidadAlta = new JCheckBoxMenuItem("Alta");
		groupDensidad.add(mnitDensidadAlta);
		mnNewMenu.add(mnitDensidadAlta);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// Inicial Facil
		botoneraFacil = new Botonera(5,3);
		contentPane.add(botoneraFacil.getPanel(), BorderLayout.CENTER);

		paraUI = new ParaUI(contentPane, mnitFacil, mnitMedio,mnitDificil,mnitDensidadBaja,
							mnitDensidadMedia, mnitDensidadAlta, botoneraFacil,this);
//		paraUI = new ParaUI(contentPane, mnitFacil, mnitMedio,mnitDificil, botoneraFacil,this);
		
		mnitInicar.addActionListener(paraUI);	
		
	}
}	
