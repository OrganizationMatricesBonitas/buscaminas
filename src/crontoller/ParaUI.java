package crontoller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPanel;

import modelo.Botonera;
import modelo.Dificultad;
import view.UI;

// herada de UI, no sabemos si estaira bien implementado
public class ParaUI implements ActionListener {

	JPanel panel;
	JCheckBoxMenuItem facil, medio, dificil;
	Dificultad dificultad;
	Botonera panelbotones;
	Botonera botonesFacil, botonesMedio, botonesDificil;
	UI frame;
	
	public ParaUI(JPanel contentPane, JCheckBoxMenuItem mnitFacil, JCheckBoxMenuItem mnitMedio,
			JCheckBoxMenuItem mnitDificil, Botonera botoneraFacil, Botonera botoneraMedio, Botonera botoneraDificil) {
		this.panel = contentPane;
		facil = mnitFacil;
		medio = mnitMedio;
		dificil = mnitDificil;
		botonesFacil = botoneraFacil;
		botonesMedio = botoneraMedio;
		botonesDificil = botoneraDificil;

	}

	public ParaUI(JPanel contentPane, JCheckBoxMenuItem mnitFacil, JCheckBoxMenuItem mnitMedio,
			JCheckBoxMenuItem mnitDificil) {
		this.panel = contentPane;
		facil = mnitFacil;
		medio = mnitMedio;
		dificil = mnitDificil;
	}
	public ParaUI(JPanel contentPane, JCheckBoxMenuItem mnitFacil, JCheckBoxMenuItem mnitMedio,
			JCheckBoxMenuItem mnitDificil, Botonera botonera) {
		this.panel = contentPane;
		facil = mnitFacil;
		medio = mnitMedio;
		dificil = mnitDificil;
		panelbotones = botonera;
	}

	public ParaUI(JPanel contentPane, JCheckBoxMenuItem mnitFacil, JCheckBoxMenuItem mnitMedio,
			JCheckBoxMenuItem mnitDificil, Botonera botonera, UI ui) {
		this.panel = contentPane;
		facil = mnitFacil;
		medio = mnitMedio;
		dificil = mnitDificil;
		panelbotones = botonera;
		frame=ui;
		
	}

	public void actionPerformed(ActionEvent e) {
		try {
//			panel.remove(panelbotones);
			panel.removeAll();
//			frame.revalidate();
//			frame.repaint();
			System.out.println("Entro");
			
		}catch (Exception error) {
			System.out.println(error.getMessage());
		}
//		hideBotonera();
//		showBotoneraSelected();
		setDificultad();
		panelbotones = new Botonera(dificultad.getLongitud());

		panel.add(panelbotones.getPanel(), BorderLayout.CENTER);
		frame.revalidate();
		frame.repaint();
	}

	private void showBotoneraSelected() {
		if(facil.isSelected()) {
			dificultad = Dificultad.facil;
			botonesFacil.getPanel().setVisible(true);
			//botonesFacil.resetController();
		}else if(medio.isSelected()) {
			dificultad = Dificultad.medio;
			botonesMedio.getPanel().setVisible(true);
			//botonesMedio.resetController();
		}else {
			dificultad = Dificultad.dificil;
			botonesDificil.getPanel().setVisible(true);
			//botonesDificil.resetController();
		}
	}

	private void setDificultad() {
		if (facil.isSelected()) {
			dificultad = Dificultad.facil;
			// botonesFacil.resetController();
		} else if (medio.isSelected()) {
			dificultad = Dificultad.medio;
			// botonesMedio.resetController();
		} else {
			dificultad = Dificultad.dificil;
			// botonesDificil.resetController();
		}
	}

	private void hideBotonera() {
		botonesFacil.getPanel().setVisible(false);
		botonesMedio.getPanel().setVisible(false);
		botonesDificil.getPanel().setVisible(false);
	}

}
