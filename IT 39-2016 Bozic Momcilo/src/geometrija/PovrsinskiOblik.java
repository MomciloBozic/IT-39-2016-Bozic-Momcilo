package geometrija;

import java.awt.Graphics;

public abstract class PovrsinskiOblik extends Oblik{
	private String bojaUnutrasnjosti = "bela";
	private String bojaIvice = "crna";

	public abstract double povrsina();
    public abstract double obim();
		
    public abstract void popuni(Graphics g);
    
    
	public String getBojaIvice() {
		return bojaIvice;
	}
	public void setBojaIvice(String bojaIvice) {
		this.bojaIvice = bojaIvice;
	}
	public String getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(String bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	} 
	
	
}
