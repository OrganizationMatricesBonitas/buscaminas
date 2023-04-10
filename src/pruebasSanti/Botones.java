package pruebasSanti;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.plaf.multi.MultiLookAndFeel;

import crontoller.Controlador;

import javax.swing.plaf.metal.MetalLookAndFeel;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
		
		System.out.println("Prueba");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					UIManager.setLookAndFeel(new MultiLookAndFeel()); // linea para cambiar LookAndFeel
					Botones frame = new Botones();
					frame.setVisible(true);
//				} catch (UnsupportedLookAndFeelException ex) {
//					Logger.getLogger(Botones.class.getName()).log(Level.SEVERE, null, ex);
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
		setBounds(new Rectangle(450, 500));
		setResizable(false);
		setLocationRelativeTo(null);

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

		// EVENTO AL INICIAR
//		PanelBotones panelBotones= new PanelBotones(6);
//		contentPane.add(panelBotones.getPanelBotones(), BorderLayout.CENTER);
		contentPane.add(new PanelBotones(10, new Controlador(null)).getPanelBotones(), BorderLayout.CENTER);

	}

}
