package prviZadatak;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Kvadrat;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.List;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class FrmZadatakStek extends JFrame {

	private JPanel contentPane;
	private static DefaultListModel dlm = new DefaultListModel();
	protected static Stack<Kvadrat> stekKvadrata = new Stack();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmZadatakStek frame = new FrmZadatakStek();
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
	public FrmZadatakStek() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("IT 39-2016 Bozic Momcilo, Zadatak1");
		setBounds(100, 100, 450, 302);
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
		
		JList listPrikazi = new JList();
		scrollPane.setViewportView(listPrikazi);
		listPrikazi.setModel(dlm);
		
		JPanel pnlDugmici = new JPanel();
		GridBagConstraints gbc_pnlDugmici = new GridBagConstraints();
		gbc_pnlDugmici.fill = GridBagConstraints.BOTH;
		gbc_pnlDugmici.gridx = 0;
		gbc_pnlDugmici.gridy = 1;
		contentPane.add(pnlDugmici, gbc_pnlDugmici);
		
		JButton btnDodajNaStek = new JButton("Dodaj na Stek");
		btnDodajNaStek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgKvadrat dijalog = new DlgKvadrat();
				dijalog.setVisible(true);
				Kvadrat noviKvadrat = dijalog.getKvadrat();
				
				if(noviKvadrat!=null) {
					stekKvadrata.push(noviKvadrat);
					dlm.clear();
					for (int i = 0; i < stekKvadrata.size(); i++) {
						dlm.addElement(stekKvadrata.elementAt(i));
					}
					JOptionPane.showMessageDialog(null, "Kvadrat dodat na stek, izaberite sledecu naredbu!");
					System.out.println("Trenutno stanje na steku!");
					for (int i = 0; i < stekKvadrata.size(); i++) {
						System.out.println(stekKvadrata.elementAt(i));
					}
				}
			}
		});
		pnlDugmici.add(btnDodajNaStek);
		
		JButton btnUkloniSaSteka = new JButton("Ukloni sa Steka");
		btnUkloniSaSteka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(dlm.getSize() != 0) {
					obrisi();
					int velicinaSteka = stekKvadrata.size();
					if (velicinaSteka != 0) {
						System.out.println("Trenutno stanje na steku!");
						for (int i = 0; i < stekKvadrata.size(); i++) {
							System.out.println(stekKvadrata.elementAt(i));
						}
					} else {
						System.out.println("Stek je prazan!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Stek je prazan! Nema elemenata da se uklone!");
				}
			}
		});
		pnlDugmici.add(btnUkloniSaSteka);
	}
	
	public static void obrisi() {
		DlgKvadrat dijalog = new DlgKvadrat();
		dijalog.setBrisanje(true);
		dijalog.getTxtXKoordinata().setText(""+stekKvadrata.peek().getGoreLevo().getX());
		dijalog.getTxtXKoordinata().setEditable(false);
		
		dijalog.getTxtYKoordinata().setText(""+stekKvadrata.peek().getGoreLevo().getY());
		dijalog.getTxtYKoordinata().setEditable(false);
		
		dijalog.getTxtStranica().setText(""+stekKvadrata.peek().getStranica());
		dijalog.getTxtStranica().setEditable(false);
		
		//dijalog.getCbxBojaIvice().(stekKvadrata.peek().getBojaIvice());
		dijalog.getCbxBojaIvice().setEnabled(false);
		
		//dijalog.getCbxBojaUnutrasnjosti().setToolTipText(stekKvadrata.peek().getBojaUnutrasnjosti());
		dijalog.getCbxBojaUnutrasnjosti().setEnabled(false);

		dijalog.setVisible(true);
		

		dlm.clear();

		for (int i = 0; i < stekKvadrata.size(); i++) {
			dlm.addElement(stekKvadrata.elementAt(i));
		}

		
	}

}
