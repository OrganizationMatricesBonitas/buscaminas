package utiles;

import java.awt.Color;
import java.util.LinkedList;

public class Colores {
	
	public Color getColorVersionUno(int numero) {
		Color[] colores = {Color.BLACK, Color.BLUE, Color.CYAN,Color.YELLOW,
							Color.MAGENTA,Color.RED,Color.GREEN,Color.WHITE};
		Color respuesta = null;
		if(numero<8 && numero>0) {
			return colores[numero-1];
		}
		return respuesta;
	}
	
	public Color getColor(int numero) {
		
		LinkedList<Color> colores = new LinkedList<Color>();
		// Entre mas valores metas al array. mayor gama de colores tendras
		int valores[]= {0,255};
		int combinaciones = valores.length;
		int cont=0;
		
		for (int i = 0; i < combinaciones; i++) {
			for (int j = 0; j < combinaciones; j++) {
				for (int k = 0; k < combinaciones; k++) {
						colores.add(new Color(valores[i], valores[j], valores[k]));
				}
			}
		}
		if(numero<=colores.size() && numero>0) {
			return colores.get(numero-1);
		}
		return null;
	}
	
	/*
	 * Como lo hubiera hecho santi
	 */
	public Color getColorSanti(int numero) {
		
		LinkedList<Color> colores = new LinkedList<Color>();
		// Entre mas valores metas al array. mayor gama de colores tendras
		int valores[]= {0,255};
		int combinaciones = valores.length;
		int cont=0;
		
		for (int i = 0; i < combinaciones; i++) {
			for (int j = 0; j < combinaciones; j++) {
				for (int k = 0; k < combinaciones; k++) {
					if(cont == numero) {
						return new Color(valores[i], valores[j], valores[k]);
					}
				}
			}
		}
		return null;
	}
	
	/*
	 * @return Lista de gama de colores
	 */
	public LinkedList<Color> generarGama(int numero) {
		LinkedList<Color> colores = new LinkedList<Color>();
		// Entre mas valores metas al array. mayor gama de colores tendras
		int valores[]= {0,255};
		int combinaciones = valores.length;
		int cont=0;
		
		for (int i = 0; i < combinaciones; i++) {
			for (int j = 0; j < combinaciones; j++) {
				for (int k = 0; k < combinaciones; k++) {
					if(cont == numero) {
						colores.add(new Color(valores[i], valores[j], valores[k]));
					}
				}
			}
		}
		return colores;
	}
	
	public Color getColorPeso(int color) {
		int peso = 4;
		int valores[]= new int[3];
		for (int i = 0; i < 3; i++) {
			if(color >=peso) {
				valores[i]=255;
				color-=peso;
			}
			peso /=2;
		}
		return new Color(valores[0], valores[1], valores[2]);
	}
	
}
