

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JScrollBar;

public class Receptie extends JPanel {
	private JTextField txtNume;
	private JTextField textPrenume;
	private JTextField textCNP;
	private JTextField textAdresa;
	private JTextField textData;
	private JTextField textCabinet;
	private JTextField textDoctor;

	/**
	 * Create the panel.
	 */
	public Receptie() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(null);
		
		JLabel Label_DatePacienti = new JLabel("Date Pacienti");
		Label_DatePacienti.setFont(new Font("Arial", Font.BOLD, 14));
		Label_DatePacienti.setBounds(22, 22, 117, 14);
		panel.add(Label_DatePacienti);
		
		JLabel Label_Nume = new JLabel("NUME");
		Label_Nume.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Nume.setBounds(10, 74, 55, 14);
		panel.add(Label_Nume);
		
		txtNume = new JTextField();
		txtNume.setBackground(SystemColor.info);
		txtNume.setBounds(65, 72, 201, 20);
		panel.add(txtNume);
		txtNume.setColumns(10);
		
		JLabel Label_Prenume = new JLabel("PRENUME");
		Label_Prenume.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Prenume.setBounds(10, 122, 80, 14);
		panel.add(Label_Prenume);
		
		textPrenume = new JTextField();
		textPrenume.setBackground(SystemColor.info);
		textPrenume.setBounds(91, 120, 175, 20);
		panel.add(textPrenume);
		textPrenume.setColumns(10);
		
		JLabel LabelCNP = new JLabel("CNP");
		LabelCNP.setFont(new Font("Arial", Font.BOLD, 14));
		LabelCNP.setBounds(10, 170, 46, 14);
		panel.add(LabelCNP);
		
		textCNP = new JTextField();
		textCNP.setBackground(SystemColor.info);
		textCNP.setBounds(49, 168, 217, 20);
		panel.add(textCNP);
		textCNP.setColumns(10);
		
		JLabel Label_Adresa = new JLabel("ADRESA");
		Label_Adresa.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Adresa.setBounds(10, 214, 68, 14);
		panel.add(Label_Adresa);
		
		textAdresa = new JTextField();
		textAdresa.setBackground(SystemColor.info);
		textAdresa.setBounds(76, 212, 228, 20);
		panel.add(textAdresa);
		textAdresa.setColumns(10);
		
		JLabel lblProgramareConsultatii = new JLabel("PROGRAMARE CONSULTATII");
		lblProgramareConsultatii.setFont(new Font("Arial", Font.BOLD, 14));
		lblProgramareConsultatii.setBounds(10, 265, 256, 20);
		panel.add(lblProgramareConsultatii);
		
		JLabel Label_Data = new JLabel("DATA");
		Label_Data.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Data.setBounds(10, 315, 46, 14);
		panel.add(Label_Data);
		
		textData = new JTextField();
		textData.setBackground(SystemColor.info);
		textData.setBounds(53, 313, 213, 20);
		panel.add(textData);
		textData.setColumns(10);
		
		JLabel Label_Cabinet = new JLabel("CABINET");
		Label_Cabinet.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Cabinet.setBounds(10, 355, 68, 14);
		panel.add(Label_Cabinet);
		
		textCabinet = new JTextField();
		textCabinet.setBackground(SystemColor.info);
		textCabinet.setBounds(76, 353, 190, 20);
		panel.add(textCabinet);
		textCabinet.setColumns(10);
		
		JLabel Label_Doctor = new JLabel("DOCTOR");
		Label_Doctor.setFont(new Font("Arial", Font.BOLD, 14));
		Label_Doctor.setBounds(10, 395, 68, 14);
		panel.add(Label_Doctor);
		
		textDoctor = new JTextField();
		textDoctor.setBackground(SystemColor.info);
		textDoctor.setBounds(76, 393, 180, 20);
		panel.add(textDoctor);
		textDoctor.setColumns(10);

	}
}