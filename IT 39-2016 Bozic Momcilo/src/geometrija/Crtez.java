package geometrija;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Crtez extends JPanel {

	public static void main(String[] args) {
		JFrame prozor = new JFrame("Crtez");
		prozor.setSize(800, 600);
		prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Crtez crtez = new Crtez();
		prozor.getContentPane().add(crtez);
		prozor.setVisible(true);
		
	}
	public void paint(Graphics g) {
		Tacka t1 = new Tacka(50, 50);
		t1.setBojaUnutrasnjosti("plava");
		t1.crtajSe(g);
		Tacka t2 = new Tacka(75, 50, "roze");
		t2.setBojaUnutrasnjosti("zelena");
		t2.crtajSe(g);
		
		Linija l1 = new Linija(new Tacka(100, 50), new Tacka(200, 100), "zuta");
		l1.setSelektovan(true);
		l1.crtajSe(g);
		//l1.getPocetna().crtajSe(g);
		l1.getKrajnja().setBojaUnutrasnjosti("crvena");
		//l1.getKrajnja().crtajSe(g);
		
		Kvadrat kv1 = new Kvadrat(new Tacka(100, 300), 100, "plava");
		kv1.setSelektovan(true);
		
		
		Pravougaonik p1 = new Pravougaonik(new Tacka(300, 300), 100, 50, "zelena");
		
		
		Krug kr1 = new Krug(new Tacka(500, 300), 100, "milos");
		kr1.crtajSe(g);
		
		kv1.setBojaUnutrasnjosti("zuta");
		kv1.popuni(g);
		kv1.crtajSe(g);
		
		p1.setBojaUnutrasnjosti("roze");
		p1.popuni(g);
		p1.setSelektovan(true);
		p1.crtajSe(g);
		
		kr1.setBojaUnutrasnjosti("zuta");
		kr1.setSelektovan(true);
		kr1.popuni(g);
		kr1.crtajSe(g);
		
		
		t2.setSelektovan(true);
		t2.crtajSe(g);
		repaint();
	}
}
