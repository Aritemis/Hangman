/**
 *	@author Ariana Fairbanks
 *	Sets up the frame for the window.
 */

package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controller.Controller;

public class WindowFrame extends JFrame 
{
	private Controller baseControl;
	private Panel panel;
	
	public WindowFrame(Controller baseControl)
	{
		this.baseControl = baseControl;
		this.panel = new Panel(baseControl);
		setUpFrame();
	}
	
	public void resetPanel()
	{
		panel.reset();
	}
	
	private void setUpFrame() 
	{
		this.setContentPane(panel);
		this.setSize(400, 400);
		this.setMinimumSize(new Dimension(250, 250));
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
