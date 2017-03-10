
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PanelOptions extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelOptions() {
    
		setLayout(new GridLayout(4, 0, 0, 0));
		
		JButton btnNewButton_receptie = new JButton("RECEPTIE");
		btnNewButton_receptie.setForeground(Color.RED);
		btnNewButton_receptie.setFont(new Font("Arial", Font.BOLD, 14));
		add(btnNewButton_receptie);
		
		JButton btnNewButton_cabinete = new JButton("CABINETE");
		btnNewButton_cabinete.setForeground(Color.RED);
		btnNewButton_cabinete.setFont(new Font("Arial", Font.BOLD, 14));
		add(btnNewButton_cabinete);
		
		JButton btnNewButton_LabAnalize = new JButton("LABORATOR ANALIZE");
		btnNewButton_LabAnalize.setForeground(Color.RED);
		btnNewButton_LabAnalize.setFont(new Font("Arial", Font.BOLD, 14));
		add(btnNewButton_LabAnalize);
		
		JButton btnNewButton_LabRadiologie = new JButton("LABORATOR RADIOLOGIE");
		btnNewButton_LabRadiologie.setForeground(Color.RED);
		btnNewButton_LabRadiologie.setFont(new Font("Arial", Font.BOLD, 14));
		add(btnNewButton_LabRadiologie);
		
		btnNewButton_LabRadiologie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				try{
					LaboratorRadiologie radiologie = new LaboratorRadiologie();
					Login.frame.setContentPane(radiologie);
					Login.frame.invalidate();
					Login.frame.validate();
				} catch (Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				} 
			}
		});
		
		btnNewButton_LabAnalize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				try{
					LaboratorAnalize analize = new LaboratorAnalize();
					Login.frame.setContentPane(analize);
					Login.frame.invalidate();
					Login.frame.validate();
				} catch (Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				} 
			}
		});
		
		btnNewButton_cabinete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				try{
					Cabinete cabinete = new Cabinete();
					Login.frame.setContentPane(cabinete);
					Login.frame.invalidate();
					Login.frame.validate();
				} catch (Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				} 
			}
		});
		
		btnNewButton_receptie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				try{
					Receptie receptie = new Receptie();
					Login.frame.setContentPane(receptie);
					Login.frame.invalidate();
					Login.frame.validate();
				} catch (Exception ex){
					JOptionPane.showMessageDialog(null, ex);
				} 
			}
		});
	}
		
		
		

	

}