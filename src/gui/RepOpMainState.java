package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import dirigenza.*;
import dipendenti.*;
import utils.*;

public class RepOpMainState extends JPanel{
	public RepOpMainState(CardLayout cl, JPanel mainPanel, RepartoOperativo ro) {
		setLayout(new BorderLayout());
		
		Cantiere[] larray = new Cantiere[ro.getCantieri().size()];
		JList<Cantiere> list = new JList<Cantiere>(ro.getCantieri().toArray(larray));
		list.setCellRenderer(new Renderer());
		JScrollPane sb = new JScrollPane(list);
		add(sb, BorderLayout.NORTH);
		
		JButton print = new JButton("Print");
		print.addActionListener(e -> System.out.println(list.getSelectedValue()));
		add(print, BorderLayout.CENTER);
		
		JButton back = new JButton("Back");
		back.addActionListener(e -> cl.show(mainPanel, "initState"));
		add(back, BorderLayout.SOUTH);
	}
}
