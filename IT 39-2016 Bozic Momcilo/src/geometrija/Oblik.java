package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Oblik implements Pomerljiv,Comparable{
	private String bojaUnutrasnjosti = "crna";
	private String bojaIvice = "bela";
	private boolean selektovan;
	
	public Oblik() {
		
	}
	public Oblik(String boja) {
		this.bojaUnutrasnjosti = boja;
	}
	
	public abstract void crtajSe(Graphics g);
	public abstract void selektovan(Graphics g);
	public abstract boolean sadrzi(int x, int y);
	
	public static Color pronadjiBoju(String boja) {
		if(boja.equalsIgnoreCase("bela"))
			return Color.WHITE;
		else if(boja.equalsIgnoreCase("plava"))
			return Color.BLUE;
		else if(boja.equalsIgnoreCase("zelena"))
			return Color.GREEN;
		else if(boja.equalsIgnoreCase("crvena"))
			return Color.RED;
		else if(boja.equalsIgnoreCase("roze"))
			return Color.PINK;
		else if(boja.equalsIgnoreCase("zuta"))
			return Color.YELLOW;
		else
			return Color.BLACK;
	}
	
	
	
	public String getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}
	public void setBojaUnutrasnjosti(String bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}
	public String getBojaIvice() {
		return bojaIvice;
	}
	public void setBojaIvice(String bojaIvice) {
		this.bojaIvice = bojaIvice;
	}

	public boolean isSelektovan() {
		return selektovan;
	}
	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}
}
