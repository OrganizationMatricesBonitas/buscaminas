package pruebasSanti;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;

public class Botones extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Botones frame = new Botones();
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
	public Botones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Inicio");
		menuBar.add(mntmNewMenuItem);
		
		JMenu mnNewMenu = new JMenu("Niveles");
		menuBar.add(mnNewMenu);
		
		ButtonGroup nivelesGroup = new ButtonGroup();
		
		JCheckBoxMenuItem mnItemFacil = new JCheckBoxMenuItem("Facil");
		mnNewMenu.add(mnItemFacil);
		nivelesGroup.add(mnItemFacil);
		mnItemFacil.setSelected(true);
		
		JCheckBoxMenuItem mnItMedio = new JCheckBoxMenuItem("Medio");
		mnNewMenu.add(mnItMedio);
		nivelesGroup.add(mnItMedio);
		
		JCheckBoxMenuItem mnItemDificil = new JCheckBoxMenuItem("Dificil");
		mnNewMenu.add(mnItemDificil);
		nivelesGroup.add(mnItemDificil);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		//EVENTO AL INICIAR
		PanelBotones panelBotones= new PanelBotones();
		

		contentPane.add(panelBotones, BorderLayout.CENTER);
		panelBotones.setVisible(true);

		
	}

}
