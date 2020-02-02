package main;

import gui.InitFrame;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * gestisce l'avvio del programma
 * @author antoc
 *
 */
public class Main {
	
	static String saveName = "IESave";
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		new InitFrame();

	}

}
