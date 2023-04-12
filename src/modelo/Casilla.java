package modelo;


public class Casilla {
	
	private boolean mina;
	private boolean velada;
	private boolean marcada;
	private int minasAlrededor;
	
	public Casilla(boolean mina, boolean velada, boolean marcada, int minasAlrededor) {
		super();
		this.mina = mina;
		this.velada = velada;
		this.marcada = marcada;
		this.minasAlrededor = minasAlrededor;
	}
	public Casilla() {
		mina=false;
		velada=true;
		marcada=false;
		minasAlrededor=0;
	}
	public boolean isMina() {
		return mina;
	}
	public void setMina(boolean mina) {
		this.mina = mina;
	}
	public boolean isVelada() {
		return velada;
	}
	public void setVelada(boolean velada) {
		this.velada = velada;
	}
	public boolean isMarcada() {
		return marcada;
	}
	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}
	public int getMinasAlrededor() {
		return minasAlrededor;
	}
	public void setMinasAlrededor(int minasAlrededor) {
		this.minasAlrededor = minasAlrededor;
	}
	@Override
	public String toString() {
		return String.valueOf(mina);
	}
	
	
	
}
