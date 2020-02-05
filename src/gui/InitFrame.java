package gui;

import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import dirigenza.ImpresaEdile;
import dirigenza.RepartoAmministrativo;
import dirigenza.RepartoOperativo;

/**
 * Questo frame gestisce il caricamento di un file di salvataggio o la creazione di uno nuovo
 * @author antoc
 *
 */
public class InitFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7698162515123200119L;
	
	String saveName;
	ImpresaEdile ie;
	
	public InitFrame() {
		
		ie = null;
		
		JPanel mainPanel = new JPanel(new GridLayout(4, 1));
		
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton caricaButton = new JRadioButton("Carica un'impresa esistente");
		caricaButton.setSelected(true);
		
		JRadioButton nuovaButton = new JRadioButton("Crea una nuova impresa");
		
		bg.add(caricaButton);
		bg.add(nuovaButton);
		
		
		JPanel fieldPanel = new JPanel(new GridLayout(2,1));
		
		JLabel label = new JLabel("Nome file:");
		
		JTextField tf = new JTextField();
		tf.setText("iesave.dat");
		
		fieldPanel.add(label);
		fieldPanel.add(tf);
		
		JButton okButton = new JButton("Ok");		
		okButton.addActionListener(e->{
			saveName = tf.getText();
			//se e' premuto carica
			if(caricaButton.isSelected()) {
				ObjectInputStream o1 = null;
				try {
					o1 = new ObjectInputStream(new FileInputStream(saveName));
					ie = (ImpresaEdile) o1.readObject();
					o1.close();
				} catch (IOException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
			//se e' premuto nuova
			else if(nuovaButton.isSelected()) {
				String nome = JOptionPane.showInputDialog("Inserisci nome Impresa Edile");
				ie = new ImpresaEdile(nome, new RepartoAmministrativo(), new RepartoOperativo());
			}
			//a prescindere
			startMainFrame();
			dispose();
		});
		
		mainPanel.add(caricaButton);
		mainPanel.add(nuovaButton);
		mainPanel.add(fieldPanel);
		mainPanel.add(okButton);
		
		add(mainPanel);
		setSize(300, 300);
		setTitle("Impresa Edile");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void startMainFrame() {
		JFrame mainFrame = new MainFrame(ie);
		mainFrame.setVisible(true);
		mainFrame.setTitle("Impresa Edile");
		mainFrame.setSize(1000, 800);
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.addWindowListener(new WindowListener() {
			
			
			public void windowOpened(WindowEvent e) {
				
			}
			
			public void windowIconified(WindowEvent e) {
				
			}
			
			public void windowDeiconified(WindowEvent e) {
				
			}
			
			public void windowDeactivated(WindowEvent e) {
				
			}
			
			public void windowClosing(WindowEvent e) {
				
				String[] options = {"Si", "No"};
		        int x = JOptionPane.showOptionDialog(null, "Salvare eventuali modifiche?", null,
		                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
		        
		        //se seleziono "Si" prova il salvataggio
		        if(x==0) {
					ObjectOutputStream ob1;
					try {
						ob1 = new ObjectOutputStream(new FileOutputStream(saveName));
						ob1.writeObject(ie);
						ob1.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		        }
		      
		        //altrimenti non fa nulla
		        
			}
			
			public void windowClosed(WindowEvent e) {
				
			}
			
			public void windowActivated(WindowEvent e) {
				
			}
		});
	}
	
}
