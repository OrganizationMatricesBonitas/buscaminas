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
import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;

public class PanelBotones extends JPanel {
	
	JPanel panelBotones;
	
	public PanelBotones() {
		
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.black);
		panelBotones.setLayout(new GridLayout(5, 24, 0, 0));
		
		JButton btnNewButton_1 = new JButton("New button");
		panelBotones.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panelBotones.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panelBotones.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panelBotones.add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("New button");
		panelBotones.add(btnNewButton);
		
	}
	
	
	public void generatorButtons(int numero) {
		
		for (int i = 0; i < numero; i++) {
			
			new JButton(String.valueOf(i)) {
				
			};
			
		}
		
	}

}
