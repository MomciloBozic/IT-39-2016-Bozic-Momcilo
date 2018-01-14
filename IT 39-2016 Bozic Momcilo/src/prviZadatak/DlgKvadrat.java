package prviZadatak;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Kvadrat;
import geometrija.Tacka;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgKvadrat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtStranica;
	private int stranica;
	private String bojaUnutrasnjosti;
	private String bojaIvice;
	private JComboBox cbxBojaUnutrasnjosti;
	private JComboBox cbxBojaIvice;
	private JTextField txtXKoordinata;
	private JTextField txtYKoordinata;
	private Tacka goreLevo;
	private Kvadrat kvadrat;
	private static boolean brisanje = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgKvadrat dialog = new DlgKvadrat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgKvadrat() {
		setModal(true);
		setTitle("Kvadrat");
		setBounds(100, 100, 242, 254);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXTackeGore = new JLabel("X Tacke Gore Levo");
			GridBagConstraints gbc_lblXTackeGore = new GridBagConstraints();
			gbc_lblXTackeGore.insets = new Insets(0, 0, 5, 5);
			gbc_lblXTackeGore.anchor = GridBagConstraints.EAST;
			gbc_lblXTackeGore.gridx = 0;
			gbc_lblXTackeGore.gridy = 0;
			contentPanel.add(lblXTackeGore, gbc_lblXTackeGore);
		}
		{
			txtXKoordinata = new JTextField();
			GridBagConstraints gbc_txtXKoordinata = new GridBagConstraints();
			gbc_txtXKoordinata.insets = new Insets(0, 0, 5, 0);
			gbc_txtXKoordinata.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXKoordinata.gridx = 1;
			gbc_txtXKoordinata.gridy = 0;
			contentPanel.add(txtXKoordinata, gbc_txtXKoordinata);
			txtXKoordinata.setColumns(10);
		}
		{
			JLabel lblYTackeGore = new JLabel("Y Tacke Gore Levo");
			GridBagConstraints gbc_lblYTackeGore = new GridBagConstraints();
			gbc_lblYTackeGore.insets = new Insets(0, 0, 5, 5);
			gbc_lblYTackeGore.anchor = GridBagConstraints.EAST;
			gbc_lblYTackeGore.gridx = 0;
			gbc_lblYTackeGore.gridy = 1;
			contentPanel.add(lblYTackeGore, gbc_lblYTackeGore);
		}
		{
			txtYKoordinata = new JTextField();
			GridBagConstraints gbc_txtYKoordinata = new GridBagConstraints();
			gbc_txtYKoordinata.insets = new Insets(0, 0, 5, 0);
			gbc_txtYKoordinata.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYKoordinata.gridx = 1;
			gbc_txtYKoordinata.gridy = 1;
			contentPanel.add(txtYKoordinata, gbc_txtYKoordinata);
			txtYKoordinata.setColumns(10);
		}
		{
			JLabel lblStranica = new JLabel("Stranica");
			GridBagConstraints gbc_lblStranica = new GridBagConstraints();
			gbc_lblStranica.insets = new Insets(0, 0, 5, 5);
			gbc_lblStranica.anchor = GridBagConstraints.WEST;
			gbc_lblStranica.gridx = 0;
			gbc_lblStranica.gridy = 2;
			contentPanel.add(lblStranica, gbc_lblStranica);
		}
		{
			txtStranica = new JTextField();
			GridBagConstraints gbc_txtStranica = new GridBagConstraints();
			gbc_txtStranica.insets = new Insets(0, 0, 5, 0);
			gbc_txtStranica.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtStranica.gridx = 1;
			gbc_txtStranica.gridy = 2;
			contentPanel.add(txtStranica, gbc_txtStranica);
			txtStranica.setColumns(10);
		}
		{
			JLabel lblBojaIvice = new JLabel("Boja ivice");
			GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
			gbc_lblBojaIvice.anchor = GridBagConstraints.WEST;
			gbc_lblBojaIvice.insets = new Insets(0, 0, 5, 5);
			gbc_lblBojaIvice.gridx = 0;
			gbc_lblBojaIvice.gridy = 3;
			contentPanel.add(lblBojaIvice, gbc_lblBojaIvice);
		}
		{
			cbxBojaIvice = new JComboBox();
			cbxBojaIvice.setModel(new DefaultComboBoxModel(new String[] {"Crna", "Plava", "Zuta"}));
			GridBagConstraints gbc_cbxBojaIvice = new GridBagConstraints();
			gbc_cbxBojaIvice.insets = new Insets(0, 0, 5, 0);
			gbc_cbxBojaIvice.fill = GridBagConstraints.HORIZONTAL;
			gbc_cbxBojaIvice.gridx = 1;
			gbc_cbxBojaIvice.gridy = 3;
			contentPanel.add(cbxBojaIvice, gbc_cbxBojaIvice);
		}
		{
			JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutra\u0161njosti");
			GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
			gbc_lblBojaUnutrasnjosti.anchor = GridBagConstraints.EAST;
			gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
			gbc_lblBojaUnutrasnjosti.gridx = 0;
			gbc_lblBojaUnutrasnjosti.gridy = 4;
			contentPanel.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);
		}
		{
			cbxBojaUnutrasnjosti = new JComboBox();
			cbxBojaUnutrasnjosti.setModel(new DefaultComboBoxModel(new String[] {"Crna", "Bela", "Zelena"}));
			GridBagConstraints gbc_cbxBojaUnutrasnjosti = new GridBagConstraints();
			gbc_cbxBojaUnutrasnjosti.fill = GridBagConstraints.HORIZONTAL;
			gbc_cbxBojaUnutrasnjosti.gridx = 1;
			gbc_cbxBojaUnutrasnjosti.gridy = 4;
			contentPanel.add(cbxBojaUnutrasnjosti, gbc_cbxBojaUnutrasnjosti);
		}
		{
			JPanel pnlDugmici = new JPanel();
			pnlDugmici.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(pnlDugmici, BorderLayout.SOUTH);
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(brisanje == true){
							FrmZadatakStek.stekKvadrata.pop();
							JOptionPane.showMessageDialog(null, "Kvadrat uklonjen sa steka!");
							setBrisanje(false);
							dispose();
						} else {
							goreLevo = new Tacka(Integer.parseInt(txtXKoordinata.getText()), Integer.parseInt(txtYKoordinata.getText()));
							stranica = Integer.parseInt(txtStranica.getText());
							bojaUnutrasnjosti = (String) cbxBojaUnutrasnjosti.getSelectedItem();
							bojaIvice = (String) cbxBojaIvice.getSelectedItem();
							kvadrat = new Kvadrat(goreLevo, stranica, bojaUnutrasnjosti, bojaIvice);
							dispose();
						}
					}
				});
				btnPotvrdi.setActionCommand("OK");
				pnlDugmici.add(btnPotvrdi);
				getRootPane().setDefaultButton(btnPotvrdi);
			}
			{
				JButton btnOdustani = new JButton("Odustani");
				btnOdustani.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnOdustani.setActionCommand("Cancel");
				pnlDugmici.add(btnOdustani);
			}
		}
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

	public Kvadrat getKvadrat() {
		return kvadrat;
	}

	public void setKvadrat(Kvadrat kvadrat) {
		this.kvadrat = kvadrat;
	}

	public JTextField getTxtXKoordinata() {
		return txtXKoordinata;
	}

	public void setTxtXKoordinata(JTextField txtXKoordinata) {
		this.txtXKoordinata = txtXKoordinata;
	}

	public static boolean isBrisanje() {
		return brisanje;
	}

	public static void setBrisanje(boolean brisanje) {
		DlgKvadrat.brisanje = brisanje;
	}

	public JTextField getTxtStranica() {
		return txtStranica;
	}

	public void setTxtStranica(JTextField txtStranica) {
		this.txtStranica = txtStranica;
	}

	public JComboBox getCbxBojaUnutrasnjosti() {
		return cbxBojaUnutrasnjosti;
	}

	public void setCbxBojaUnutrasnjosti(JComboBox cbxBojaUnutrasnjosti) {
		this.cbxBojaUnutrasnjosti = cbxBojaUnutrasnjosti;
	}

	public JComboBox getCbxBojaIvice() {
		return cbxBojaIvice;
	}

	public void setCbxBojaIvice(JComboBox cbxBojaIvice) {
		this.cbxBojaIvice = cbxBojaIvice;
	}

	public JTextField getTxtYKoordinata() {
		return txtYKoordinata;
	}

	public void setTxtYKoordinata(JTextField txtYKoordinata) {
		this.txtYKoordinata = txtYKoordinata;
	}
	
	
	


}
