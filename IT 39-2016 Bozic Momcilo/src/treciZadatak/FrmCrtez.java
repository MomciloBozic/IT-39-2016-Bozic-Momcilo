package treciZadatak;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Tacka;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmCrtez extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrtez frame = new FrmCrtez();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCrtez() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNaslov = new JLabel("Crte\u017E");
		lblNaslov.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaslov.setForeground(Color.BLUE);
		lblNaslov.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblNaslov, BorderLayout.NORTH);
		
		PnlCrtez pnlCrtez = new PnlCrtez();
		pnlCrtez.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				Tacka t = new Tacka(x, y);
				pnlCrtez.getOblici().add(t);				
			}
		});
		pnlCrtez.setBackground(Color.WHITE);
		contentPane.add(pnlCrtez, BorderLayout.CENTER);
	}

}
