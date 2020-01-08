package gui;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InitState extends JPanel {
	public InitState(CardLayout cl, JPanel mainPanel) {
		setLayout(new GridLayout(2,1));
		
		JButton goToRa = new JButton("Reparto Amministrativo");
		//goToRa.addActionListener(e -> cl.show(mainPanel, "RepAmm"));
		JButton goToRo = new JButton("Reparto Operativo");
		goToRo.addActionListener(e -> cl.show(mainPanel, "RepOp"));
		
		add(goToRa);
		add(goToRo);
	}
}
