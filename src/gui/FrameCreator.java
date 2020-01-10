package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameCreator extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8064769819352646250L;

	public FrameCreator(JPanel panel) {
		add(panel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400,550);
		setVisible(true);
	}
}
