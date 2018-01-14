package geometrija;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public class Kvadrat extends  PovrsinskiOblik{
	protected Tacka goreLevo;
	protected int stranica;

	public Kvadrat() {

	}

	public Kvadrat(Tacka goreLevo, int stranica) {
		this.goreLevo = goreLevo;
		this.stranica = stranica;
	}

	public Kvadrat(Tacka goreLevo, int stranica, String bojaUnutrasnjosti) {
		this(goreLevo, stranica);
		setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}
	
	public Kvadrat(Tacka goreLevo, int stranica, String bojaUnutrasnjosti, String bojaIvice ) {
		this(goreLevo, stranica, bojaUnutrasnjosti);
		setBojaIvice(bojaIvice);
	}
	public double obim() {
		return 4*this.stranica;
	}
	public double povrsina() {
		return stranica * stranica;
	}
	
	public void pomeriZa(int poX, int poY){
		goreLevo.pomeriZa(poX, poY);
	}
	public void pomeriNa(int x, int y) {
		goreLevo.pomeriNa(x, y);
	}
	public Linija dijagonala() {
		Tacka doleDesno = new Tacka(goreLevo.getX()+stranica, goreLevo.getY()+stranica);
		return new Linija(goreLevo, doleDesno);
	}
	public Tacka centar() {
		return dijagonala().sredinaLinije();
	}
	public boolean equals(Object obj) {
		if(obj instanceof Kvadrat) {
			Kvadrat prosledjen = (Kvadrat) obj;
			if(goreLevo.equals(prosledjen.goreLevo) && stranica == prosledjen.stranica)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public void crtajSe(Graphics g) {
		g.setColor(pronadjiBoju(getBojaUnutrasnjosti()));
		g.drawRect(goreLevo.getX(), goreLevo.getY(), stranica, stranica);
		if (isSelektovan())
			selektovan(g);
	}
	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+stranica, getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+stranica)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX()+stranica, getGoreLevo().getY()), dijagonala().getKrajnja()).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+stranica), dijagonala().getKrajnja()).selektovan(g);
	}
	public int compareTo(Object o) {
		if(o instanceof Kvadrat){
			Kvadrat pomocni = (Kvadrat) o;
			return (int) (this.povrsina()-pomocni.povrsina());
		}
		else 
			return 0;
	}
	
	public void popuni(Graphics g) {
		g.setColor(pronadjiBoju(getBojaUnutrasnjosti()));
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, stranica-1, stranica-1);
	}
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + stranica)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + stranica))
			return true;
		else 
			return false;
	}
	//Tacka gore levo=(xGoreLevo,yGoreLevo), duzina stranice=stranica
		public String toString() {
			return "Tacka gore levo = "+getGoreLevo()+", duzina stranice = "+stranica+", boja ivice= "
					+ this.getBojaIvice() +", boja unutrasnjosti= "+ this.getBojaUnutrasnjosti();
		}
	public Tacka getGoreLevo() {
		return goreLevo;
	}
	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}
	public int getStranica() {
		return stranica;
	}
	public void setStranica(int stranica) {
		this.stranica = stranica;
	}

}