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

// herada de UI, no sabemos si estaira bien implementado
public class ParaUI implements ActionListener {

	JPanel panel;
	JCheckBoxMenuItem facil, medio, dificil;
	Botonera botonesFacil, botonesMedio, botonesDificil;
	Dificultad dificultad;
	Botonera panelbotones;
	
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

	public void actionPerformed(ActionEvent e) {
		try {
			panel.remove(panelbotones);
		}catch (Exception error) {
			
		}
//		hideBotonera();
//		showBotoneraSelected();
		setDificultad();
		panelbotones = new Botonera(dificultad.getLongitud());

		panel.add(panelbotones.getPanel(), BorderLayout.CENTER);
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
