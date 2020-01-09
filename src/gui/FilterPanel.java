package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import dirigenza.RepartoOperativo;

public class FilterPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8746574196794838966L;

	public FilterPanel(RepOpMainState repOp, RepartoOperativo ro) {
		
		setLayout(new BorderLayout());
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3, 1));
		
		JPanel north = new JPanel(new BorderLayout());
		JLabel firstLabel = new JLabel("Minimo");
		JTextField firstField = new JTextField();
		north.add(firstLabel, BorderLayout.NORTH);
		north.add(firstField, BorderLayout.SOUTH);
		
		JPanel center = new JPanel(new BorderLayout());
		JLabel secondLabel = new JLabel("Massimo");
		JTextField secondField = new JTextField();
		center.add(secondLabel, BorderLayout.NORTH);
		center.add(secondField, BorderLayout.SOUTH);
		
		JPanel south = new JPanel(new BorderLayout());
		JButton ok = new JButton("Ok");
		ok.addActionListener(l -> {
			int minimo = Integer.parseInt(firstField.getText());
			int massimo = Integer.parseInt(secondField.getText());
			repOp.populateList(ro.getCantieriByValue(minimo, massimo));
			((JFrame)SwingUtilities.getWindowAncestor(this)).dispose();
		});
		south.add(ok, BorderLayout.CENTER);
		
		mainPanel.add(north);
		mainPanel.add(center);
		
		add(south, BorderLayout.SOUTH);
		add(mainPanel, BorderLayout.NORTH);
	}
}
