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
import javax.swing.JOptionPane;

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
	private JTable table;

	/**
	 * Create the panel.
	 */
	Connection connection = null;
	private JTextField textCabinet;
	private JTextField textDoctor;
	private JTextField textLab;
	public Receptie() {
		connection=sqliteConnection.dbConnector();
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		JLabel Label_DatePacienti = new JLabel("DATE PACIENTI");
		Label_DatePacienti.setFont(new Font("Arial", Font.BOLD, 14));
		Label_DatePacienti.setBounds(49, 11, 117, 20);
		panel.add(Label_DatePacienti);
		
		JLabel Label_Nume = new JLabel("NUME");
		Label_Nume.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Nume.setBounds(49, 54, 55, 14);
		panel.add(Label_Nume);
		
		txtNume = new JTextField();
		txtNume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNume.setBackground(SystemColor.info);
		txtNume.setBounds(99, 51, 201, 20);
		panel.add(txtNume);
		txtNume.setColumns(10);
		
		JLabel Label_Prenume = new JLabel("PRENUME");
		Label_Prenume.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Prenume.setBounds(50, 92, 80, 14);
		panel.add(Label_Prenume);
		
		textPrenume = new JTextField();
		textPrenume.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textPrenume.setBackground(SystemColor.info);
		textPrenume.setBounds(128, 89, 175, 20);
		panel.add(textPrenume);
		textPrenume.setColumns(10);
		
		JLabel LabelCNP = new JLabel("CNP");
		LabelCNP.setFont(new Font("Arial", Font.BOLD, 14));
		LabelCNP.setBounds(49, 135, 46, 14);
		panel.add(LabelCNP);
		
		textCNP = new JTextField();
		textCNP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCNP.setBackground(SystemColor.info);
		textCNP.setBounds(99, 132, 217, 20);
		panel.add(textCNP);
		textCNP.setColumns(10);
		
		JLabel Label_Adresa = new JLabel("ADRESA");
		Label_Adresa.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Adresa.setBounds(49, 170, 68, 14);
		panel.add(Label_Adresa);
		
		textAdresa = new JTextField();
		textAdresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAdresa.setBackground(SystemColor.info);
		textAdresa.setBounds(119, 167, 228, 20);
		panel.add(textAdresa);
		textAdresa.setColumns(10);
		
		JLabel lblProgramareConsultatii = new JLabel("PROGRAMARE CONSULTATII / LABORATOR");
		lblProgramareConsultatii.setFont(new Font("Arial", Font.BOLD, 14));
		lblProgramareConsultatii.setBounds(461, 11, 318, 20);
		panel.add(lblProgramareConsultatii);
		
		JLabel Label_Data = new JLabel("DATA");
		Label_Data.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Data.setBounds(452, 54, 46, 14);
		panel.add(Label_Data);
		
		textData = new JTextField();
		textData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textData.setHorizontalAlignment(SwingConstants.CENTER);
		textData.setBackground(SystemColor.info);
		textData.setBounds(508, 51, 239, 20);
		panel.add(textData);
		textData.setColumns(10);
		
		JLabel Label_Cabinet = new JLabel("CABINET");
		Label_Cabinet.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Cabinet.setBounds(452, 92, 68, 14);
		panel.add(Label_Cabinet);
		
		JLabel Label_Doctor = new JLabel("DOCTOR");
		Label_Doctor.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Doctor.setBounds(452, 135, 68, 14);
		panel.add(Label_Doctor);
		
		JButton btnNewButton_Salveaza = new JButton("SALVEAZA");
		btnNewButton_Salveaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query="insert into Pacienti (Nume, Prenume, CNP, Adresa, Cabinet, Doctor, DataSiOra) values(?,?,?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,txtNume.getText());
					pst.setString(2,textPrenume.getText());
					pst.setString(3,textCNP.getText());
					pst.setString(4,textAdresa.getText());
					pst.setString(5,textCabinet.getText());
					pst.setString(6,textDoctor.getText());
					pst.setString(7,textData.getText());
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Date Salvate!");
					
					pst.close();
				
					String query2="insert into Programari (Nume, Prenume, Cabinet, Doctor, DataSiOra, Laborator) values(?,?,?,?,?,?)";
					PreparedStatement pst2 = connection.prepareStatement(query2);
					pst2.setString(1,txtNume.getText());
					pst2.setString(2,textPrenume.getText());
					pst2.setString(3,textCabinet.getText());
					pst2.setString(4,textDoctor.getText());
					pst2.setString(5,textData.getText());
					pst2.setString(6,textLab.getText());
					
					pst2.execute();
					
					JOptionPane.showMessageDialog(null, "Date Salvate!");
					
					pst2.close();
					
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_Salveaza.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_Salveaza.setBounds(619, 223, 117, 47);
		panel.add(btnNewButton_Salveaza);
		
		JLabel Label_Plata = new JLabel("TOTAL PLATA");
		Label_Plata.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Plata.setBounds(45, 223, 103, 20);
		panel.add(Label_Plata);
		
		textPlata = new JTextField();
		textPlata.setHorizontalAlignment(SwingConstants.CENTER);
		textPlata.setFont(new Font("Arial", Font.BOLD, 14));
		textPlata.setBackground(SystemColor.info);
		textPlata.setBounds(147, 219, 103, 30);
		panel.add(textPlata);
		textPlata.setColumns(10);
		
		JButton btnNewButton_Chitanta = new JButton("GENEREAZA CHITANTA");
		btnNewButton_Chitanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Chitanta.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_Chitanta.setBounds(49, 273, 201, 20);
		panel.add(btnNewButton_Chitanta);
		
		JLabel Label_Laborator = new JLabel("LABORATOR");
		Label_Laborator.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Laborator.setBounds(452, 170, 97, 14);
		panel.add(Label_Laborator);
		
		JButton btnNewButton_RaportProgramari = new JButton("Raport Programari");
		btnNewButton_RaportProgramari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query="SELECT nume, prenume, Cabinet, Doctor, DataSiOra, Laborator FROM Programari";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					pst.close();
					rs.close();
				}catch(Exception ex) 
				{
					ex.printStackTrace();
				}
				
			}
		
		});
		btnNewButton_RaportProgramari.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_RaportProgramari.setBounds(299, 326, 169, 25);
		panel.add(btnNewButton_RaportProgramari);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(34, 362, 745, 211);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		 
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textCabinet = new JTextField();
		textCabinet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCabinet.setBackground(SystemColor.info);
		textCabinet.setBounds(534, 89, 213, 20);
		panel.add(textCabinet);
		textCabinet.setColumns(10);
		
		textDoctor = new JTextField();
		textDoctor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDoctor.setBackground(SystemColor.info);
		textDoctor.setBounds(530, 132, 217, 20);
		panel.add(textDoctor);
		textDoctor.setColumns(10);
		
		textLab = new JTextField();
		textLab.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textLab.setBackground(SystemColor.info);
		textLab.setBounds(549, 170, 198, 20);
		panel.add(textLab);
		textLab.setColumns(10);
		
	}
}
