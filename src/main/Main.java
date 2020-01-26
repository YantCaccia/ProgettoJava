package main;

import dirigenza.ImpresaEdile;
import gui.MainFrame;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

/**
 * gestisce l'avvio del programma
 * @author antoc
 *
 */
public class Main {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream o1 = new ObjectInputStream(new FileInputStream("IESave"));
		ImpresaEdile ie = (ImpresaEdile) o1.readObject();
		o1.close();
				
		JFrame mainFrame = new MainFrame(ie.getRopOp(), ie.getRepAmm());
		mainFrame.setVisible(true);
		mainFrame.setTitle("Impresa Edile");
		mainFrame.setSize(1000, 800);
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {

				ObjectOutputStream ob1;
				try {
					ob1 = new ObjectOutputStream(new FileOutputStream("IESave"));
					ob1.writeObject(ie);
					ob1.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

	}

}
