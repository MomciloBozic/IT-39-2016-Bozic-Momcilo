package drugiZadatak;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Kvadrat;
import geometrija.Tacka;
import prviZadatak.DlgKvadrat;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class FrmZadatakSort extends JFrame {

	private JPanel contentPane;
	DefaultListModel dlm = new DefaultListModel();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmZadatakSort frame = new FrmZadatakSort();
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
	public FrmZadatakSort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("IT 39-2016 Bozic Momcilo, Zadatak2");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		JList listaKvadrata = new JList();
		scrollPane.setViewportView(listaKvadrata);
		listaKvadrata.setModel(dlm);

		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		
		JButton btnDodajUListu = new JButton("Dodaj u listu");
		btnDodajUListu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgKvadrat dijalog = new DlgKvadrat();
				dijalog.setVisible(true);
				Kvadrat noviKvadrat = dijalog.getKvadrat();
				if(noviKvadrat!=null) {
					dlm.add(dlm.getSize(), noviKvadrat);
					JOptionPane.showMessageDialog(null, "Kvadrat dodat u listu, izaberite sledecu naredbu!");
				}
			}
		});
		panel.add(btnDodajUListu);
		
		JButton btnSortirajListu = new JButton("Sortiraj listu");
		btnSortirajListu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Kvadrat[] nizKvadrata = new Kvadrat[dlm.getSize()];
				for (int i = 0; i < nizKvadrata.length; i++) {
					nizKvadrata[i]=(Kvadrat) dlm.elementAt(i);
				}
				dlm.clear();
				
				for (int j = 0; j < nizKvadrata.length-1; j++) {
					for (int i = 0; i < nizKvadrata.length-1; i++) {
						if(nizKvadrata[i].getStranica() > nizKvadrata[i+1].getStranica()) {
							Kvadrat privremena = nizKvadrata[i];
							nizKvadrata[i] = nizKvadrata[i+1];
							nizKvadrata[i+1] = privremena;
						}
					}
				}
				
				for (int i = 0; i < nizKvadrata.length; i++) {
					dlm.addElement(nizKvadrata[i]);
				}
				
				
			}
		});
		panel.add(btnSortirajListu);
	}

}
