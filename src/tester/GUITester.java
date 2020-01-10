package tester;

import dirigenza.LavoratoreImpegnatoException;
import dirigenza.RepartoAmministrativo;
import dirigenza.RepartoOperativo;
import dirigenza.ResponsabileNonDirigenteExcpetion;
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

public class GUITester {
	
	public static void main(String[] args) throws LavoratoreImpegnatoException, ResponsabileNonDirigenteExcpetion, FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream o1 = new ObjectInputStream(new FileInputStream("RepAmmSave"));
		RepartoAmministrativo ra = (RepartoAmministrativo) o1.readObject();
		o1.close();
		
		ObjectInputStream o2 = new ObjectInputStream(new FileInputStream("RepOpSave"));
		RepartoOperativo ro = (RepartoOperativo) o2.readObject();
		o2.close();
				
		JFrame mainFrame = new MainFrame(ro, ra);
		mainFrame.setTitle("Impresa Edile");
		mainFrame.setSize(1000, 800);
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.setVisible(true);
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
				// TODO Auto-generated method stub
				ObjectOutputStream ob1;
				try {
					ob1 = new ObjectOutputStream(new FileOutputStream("RepOpSave"));
					ob1.writeObject(ro);
					ob1.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				ObjectOutputStream ob2;
				try {
					ob2 = new ObjectOutputStream(new FileOutputStream("RepAmmSave"));
					ob2.writeObject(ra);
					ob2.close();
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
