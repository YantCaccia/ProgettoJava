package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * questo frame e' utilizzato semplicemente per ospitare un pannello
 * @author antoc
 *
 */
public class FrameCreator extends JFrame{
	
	private static final long serialVersionUID = 8064769819352646250L;

	/**
	 * istanzia un frame che ospita il pannello specificato come parametro
	 * @param panel il pannello che questo frame ospitera'
	 */
	public FrameCreator(JPanel panel) {
		add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400,750);
		setVisible(true);
	}
}
