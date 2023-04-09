package modelo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Botonera extends JPanel {

	JPanel containerBotones;
	
	public Botonera(int lado) {
        
        setBounds(100, 100, 450, 300);
        containerBotones = new JPanel();
        containerBotones.setBorder(new EmptyBorder(5, 5, 5, 5));
        containerBotones.setLayout(new GridLayout(lado, lado, 0, 0));
        
        for (int i = 0; i < lado; i++) {
            for (int j = 0; j < lado; j++) {
                JButton comp = new JButton();
                
                comp.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                       System.out.println("Vivo");

                    }

                });
                containerBotones.add(comp);

            }

        }
    }
	// Para recuperar el JPanel con Botones
	public JPanel getContainerBotones() {
		return containerBotones;
	}
}
