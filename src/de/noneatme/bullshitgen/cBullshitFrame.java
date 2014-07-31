package de.noneatme.bullshitgen;

import javax.swing.JFrame;
import java.awt.Dimension;

import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;

import de.noneatme.bullshitgen.bullshit.cNSAXKeyscoreBullshit;
import de.noneatme.bullshitgen.listener.cFileChooseActionListener;
import de.noneatme.bullshitgen.listener.cStartenActionListener;

public class cBullshitFrame extends JFrame
{
	private JTextField textField;
	private JLabel lblBereit;
	private JComboBox<String> comboBox;
	protected JFileChooser	fileChooser;
	private JTextField textField_1;
	
	public JButton btnStarten;
	public String currentFolder;
	
	public cConverter converter;
	
	public cBullshitFrame()
	{
		setTitle(cSettings.frameTitle);

		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel lblBullshitAuswaehlen = new JLabel("Bullshit auswaehlen:");
		lblBullshitAuswaehlen.setBounds(10, 11, 108, 14);
		getContentPane().add(lblBullshitAuswaehlen);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(131, 8, 168, 20);
		getContentPane().add(comboBox);
		
		comboBox.addItem("XKeyscore Bridge Generator");
		
		JLabel lblOrdnerpfad = new JLabel("Ordnerpfad:");
		lblOrdnerpfad.setBounds(10, 36, 108, 14);
		getContentPane().add(lblOrdnerpfad);
		
		textField = new JTextField();
		textField.setBounds(131, 33, 168, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEnabled(false);
		
		JButton btnAuswaehlen = new JButton("Waehlen");
		btnAuswaehlen.setBounds(310, 32, 102, 23);
		getContentPane().add(btnAuswaehlen);
		btnAuswaehlen.addActionListener(new cFileChooseActionListener());
		
		btnStarten = new JButton("Starten");
		btnStarten.setBounds(10, 195, 89, 23);
		getContentPane().add(btnStarten);
		btnStarten.addActionListener(new cStartenActionListener());
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 248, 432, 20);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblBereit = new JLabel("Bereit");
		lblBereit.setBounds(10, 0, 402, 20);
		panel.add(lblBereit);
		
		JLabel lblAnzahlDateien = new JLabel("Anzahl Aktionen:");
		lblAnzahlDateien.setBounds(10, 61, 108, 14);
		getContentPane().add(lblAnzahlDateien);
		
		textField_1 = new JTextField("10");

		textField_1.setColumns(10);
		textField_1.setBounds(131, 58, 168, 20);
		getContentPane().add(textField_1);
		
		setSize(cSettings.frameSize);
		setLocationRelativeTo(null);
		
		fileChooser	= new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setCurrentDirectory(new java.io.File("."));
		
	}
	
	public void setStatus(String status)
	{
		this.lblBereit.setText(status);
	}
	
	public void openFilechooser() throws IOException
	{
		int sucess = this.fileChooser.showDialog(null, "Ordner auswaehlen");
		System.out.println(sucess);
		if(sucess == JFileChooser.APPROVE_OPTION)
		{
			String folder	= this.fileChooser.getSelectedFile().getAbsolutePath();
			this.textField.setText(folder);
			this.currentFolder	= folder;
			
			this.setStatus("Ordner ausgewaehlt");
		
		}
		else
			this.setStatus("Kein Ordner ausgewaehlt");
	}
	
	public void start()
	{
		if(this.textField.getText().length() < 3)
		{
			JOptionPane.showMessageDialog(null, "Bitte waehle ein gueltiges Verzeichnis aus!", "Fehler", 0);
			this.setStatus("Kein Ordner ausgewaehlt!");
		}
		else
		{
			try
			{
				switch(this.comboBox.getSelectedIndex())
				{
					case 0:
						new cNSAXKeyscoreBullshit(Integer.parseInt(this.textField_1.getText())).execute();
						break;
					case 1:
						
						break;
					case 2:
						break;
						
					case 3:
						break;
						
					default:
						break;
				}
				
				this.setStatus("Aktion erfolgreich");
			}
			catch(Exception ex)
			{
				this.setStatus("Fehler! Bitte Eingabe ueberpruefen");
			}
		}
	}
}
