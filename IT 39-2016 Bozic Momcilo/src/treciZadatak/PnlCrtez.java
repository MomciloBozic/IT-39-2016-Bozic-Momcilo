package treciZadatak;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import geometrija.Tacka;

public class PnlCrtez extends JPanel {
	private ArrayList<Tacka> oblici = new ArrayList<Tacka>();

	/**
	 * Create the panel.
	 */
	public PnlCrtez() {

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Tacka> it = oblici.iterator();
		while (it.hasNext()) {
			it.next().crtajSe(g);
		}
		repaint();
	}

	public ArrayList<Tacka> getOblici() {
		return oblici;
	}

	public void setOblici(ArrayList<Tacka> oblici) {
		this.oblici = oblici;
	}

}
