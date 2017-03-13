package testProject4;

import java.sql.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JScrollBar;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Receptie extends JPanel {
	private JTextField txtNume;
	private JTextField textPrenume;
	private JTextField textCNP;
	private JTextField textAdresa;
	private JTextField textData;
	private JTextField textPlata;
	private JTextField textDataLab;
	private JTable table;

	/**
	 * Create the panel.
	 */
	Connection connection = null;
	public Receptie() {
		connection=sqliteConnection.dbConnector();
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		JLabel Label_DatePacienti = new JLabel("DATE PACIENTI");
		Label_DatePacienti.setFont(new Font("Arial", Font.BOLD, 14));
		Label_DatePacienti.setBounds(54, 30, 117, 20);
		panel.add(Label_DatePacienti);
		
		JLabel Label_Nume = new JLabel("NUME");
		Label_Nume.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Nume.setBounds(49, 74, 55, 14);
		panel.add(Label_Nume);
		
		txtNume = new JTextField();
		txtNume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNume.setBackground(SystemColor.info);
		txtNume.setBounds(103, 72, 201, 20);
		panel.add(txtNume);
		txtNume.setColumns(10);
		
		JLabel Label_Prenume = new JLabel("PRENUME");
		Label_Prenume.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Prenume.setBounds(49, 122, 80, 14);
		panel.add(Label_Prenume);
		
		textPrenume = new JTextField();
		textPrenume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPrenume.setBackground(SystemColor.info);
		textPrenume.setBounds(129, 120, 175, 20);
		panel.add(textPrenume);
		textPrenume.setColumns(10);
		
		JLabel LabelCNP = new JLabel("CNP");
		LabelCNP.setFont(new Font("Arial", Font.BOLD, 14));
		LabelCNP.setBounds(49, 170, 46, 14);
		panel.add(LabelCNP);
		
		textCNP = new JTextField();
		textCNP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCNP.setBackground(SystemColor.info);
		textCNP.setBounds(87, 168, 217, 20);
		panel.add(textCNP);
		textCNP.setColumns(10);
		
		JLabel Label_Adresa = new JLabel("ADRESA");
		Label_Adresa.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Adresa.setBounds(47, 214, 68, 14);
		panel.add(Label_Adresa);
		
		textAdresa = new JTextField();
		textAdresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAdresa.setBackground(SystemColor.info);
		textAdresa.setBounds(111, 212, 228, 20);
		panel.add(textAdresa);
		textAdresa.setColumns(10);
		
		JLabel lblProgramareConsultatii = new JLabel("PROGRAMARE CONSULTATII");
		lblProgramareConsultatii.setFont(new Font("Arial", Font.BOLD, 14));
		lblProgramareConsultatii.setBounds(48, 268, 256, 20);
		panel.add(lblProgramareConsultatii);
		
		JLabel Label_Data = new JLabel("DATA");
		Label_Data.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Data.setBounds(45, 315, 46, 14);
		panel.add(Label_Data);
		
		textData = new JTextField();
		textData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		textData.setBackground(SystemColor.info);
		textData.setBounds(91, 313, 213, 20);
		panel.add(textData);
		textData.setColumns(10);
		
		JLabel Label_Cabinet = new JLabel("CABINET");
		Label_Cabinet.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Cabinet.setBounds(45, 375, 68, 14);
		panel.add(Label_Cabinet);
		
		JLabel Label_Doctor = new JLabel("DOCTOR");
		Label_Doctor.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Doctor.setBounds(61, 441, 68, 14);
		panel.add(Label_Doctor);
		
		JButton btnNewButton_Salveaza = new JButton("SALVEAZA");
		btnNewButton_Salveaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Salveaza.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_Salveaza.setBounds(45, 488, 117, 54);
		panel.add(btnNewButton_Salveaza);
		
		JLabel Label_Plata = new JLabel("TOTAL PLATA");
		Label_Plata.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Plata.setBounds(488, 211, 103, 20);
		panel.add(Label_Plata);
		
		textPlata = new JTextField();
		textPlata.setHorizontalAlignment(SwingConstants.CENTER);
		textPlata.setFont(new Font("Arial", Font.BOLD, 14));
		textPlata.setBackground(SystemColor.info);
		textPlata.setBounds(601, 207, 103, 30);
		panel.add(textPlata);
		textPlata.setColumns(10);
		
		JButton btnNewButton_Chitanta = new JButton("GENEREAZA CHITANTA");
		btnNewButton_Chitanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Chitanta.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_Chitanta.setBounds(512, 248, 201, 20);
		panel.add(btnNewButton_Chitanta);
		
		JLabel Label_progLab = new JLabel("PROGRAMARE LABORATOR");
		Label_progLab.setFont(new Font("Arial", Font.BOLD, 14));
		Label_progLab.setBounds(501, 30, 213, 20);
		panel.add(Label_progLab);
		
		JLabel Label_Laborator = new JLabel("LABORATOR");
		Label_Laborator.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Laborator.setBounds(501, 85, 97, 14);
		panel.add(Label_Laborator);
		
		JLabel Label_DataLab = new JLabel("DATA");
		Label_DataLab.setFont(new Font("Arial", Font.BOLD, 14));
		Label_DataLab.setBounds(501, 122, 46, 14);
		panel.add(Label_DataLab);
		
		textDataLab = new JTextField();
		textDataLab.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDataLab.setHorizontalAlignment(SwingConstants.CENTER);
		textDataLab.setBackground(SystemColor.info);
		textDataLab.setBounds(554, 122, 157, 20);
		panel.add(textDataLab);
		textDataLab.setColumns(10);
		
		JButton btnNewButton_SalveazaLab = new JButton("SALVEAZA");
		btnNewButton_SalveazaLab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_SalveazaLab.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_SalveazaLab.setBounds(554, 167, 117, 20);
		panel.add(btnNewButton_SalveazaLab);
		
		JRadioButton RadioButton_Analiza = new JRadioButton("ANALIZE");
		RadioButton_Analiza.setFont(new Font("Arial", Font.BOLD, 12));
		RadioButton_Analiza.setBounds(596, 57, 109, 23);
		panel.add(RadioButton_Analiza);
		
		JRadioButton RadioButton_Radiologie = new JRadioButton("RADIOLOGIE");
		RadioButton_Radiologie.setFont(new Font("Arial", Font.BOLD, 12));
		RadioButton_Radiologie.setBounds(596, 96, 122, 23);
		panel.add(RadioButton_Radiologie);
		
		JRadioButton RadioButton_MedGenerala = new JRadioButton("MEDICINA GENERALA");
		RadioButton_MedGenerala.setFont(new Font("Arial", Font.BOLD, 12));
		RadioButton_MedGenerala.setBounds(128, 352, 157, 23);
		panel.add(RadioButton_MedGenerala);
		
		JRadioButton RadioButton_Pediatrie = new JRadioButton("PEDIATRIE");
		RadioButton_Pediatrie.setFont(new Font("Arial", Font.BOLD, 12));
		RadioButton_Pediatrie.setBounds(129, 389, 109, 23);
		panel.add(RadioButton_Pediatrie);
		
		
		JList list_Doctori = new JList();
		list_Doctori.setBackground(SystemColor.info);
		list_Doctori.setBounds(129, 441, 175, 20);
		panel.add(list_Doctori);
		
		JButton btnNewButton_RaportProgramari = new JButton("Raport Programari");
		btnNewButton_RaportProgramari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query="SELECT nume, prenume, Cabinet, Doctor, DataSiOra FROM Programari";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
				
			}
		
		});
		btnNewButton_RaportProgramari.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_RaportProgramari.setBounds(182, 503, 169, 25);
		panel.add(btnNewButton_RaportProgramari);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(361, 315, 418, 258);
		panel.add(scrollPane);
		scrollPane.getViewport().add(table);
		 
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}
}
