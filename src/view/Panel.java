/**
 *	@author Ariana Fairbanks
 *	Sets up the rest of the GUI.
 */

package view;

import javax.swing.JPanel;
import controller.Controller;
import javax.swing.SpringLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;

public class Panel extends JPanel 
{
	private Controller baseControl;
	private JTextField inputField;
	private SpringLayout springLayout;
	private JButton enter;
	private JTextPane displayLog;
	private String validInput;
	
	
	public Panel(Controller baseControl)
	{
		setBackground(new Color(135, 206, 250));
		this.baseControl = baseControl;
		this.springLayout = new SpringLayout();
		this.enter = new JButton("Enter");
		enter.setBackground(new Color(240, 240, 240));
		this.inputField = new JTextField();
		this.displayLog = new JTextPane();
		displayLog.setBackground(new Color(224, 255, 255));
		
		//how I make sure only the input I want triggers the update method
		this.validInput = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	
		setUpPanel();
		setUpLayout();
		setUpListeners();
	}

	private void setUpLayout()
	{
		springLayout.putConstraint(SpringLayout.NORTH, inputField, 1, SpringLayout.NORTH, enter);
		springLayout.putConstraint(SpringLayout.EAST, inputField, -38, SpringLayout.WEST, enter);
		springLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, displayLog);
		springLayout.putConstraint(SpringLayout.NORTH, enter, 16, SpringLayout.SOUTH, displayLog);
		springLayout.putConstraint(SpringLayout.EAST, enter, 0, SpringLayout.EAST, displayLog);
		springLayout.putConstraint(SpringLayout.WEST, displayLog, 50, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, displayLog, -75, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, displayLog, -50, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.NORTH, displayLog, 50, SpringLayout.NORTH, this);
	}
	
	private void setUpPanel()
	{
		this.setLayout(springLayout);
		this.add(enter);
		this.add(inputField);
		this.inputField.setColumns(20);
		this.add(displayLog);
		displayLog.setText(baseControl.update());
		displayLog.setEditable(false);
	}
	
	private void setUpListeners()
	{
		enter.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent onClick) 
			{
				if(inputField.getText().length() > 0)
				{
					//only looks at the first value in the text field
					String input = new String(inputField.getText().substring(0, 1).toUpperCase());
					//only updates if the given value is a letter
					if(validInput.contains(input))
					{
						int outcome = baseControl.determineSituation(input);
						switch(outcome)
						{
							case 0:
								
								inputField.setText("");
								displayLog.setText(baseControl.update() + 
										"You Won! Well done.\nClose this window to exit.");
								inputField.setEditable(false);
								break;
								
								
							case 1:
								
								inputField.setText("");
								displayLog.setText(baseControl.update() +
										"The word in question does indeed contain the letter '"
										+ input + "'.\nAnd for your next guess...?");
								break;
								
								
							case 2:
								
								inputField.setText("");
								displayLog.setText(baseControl.update() +
										"The word in question does not contain the letter '"
										+ input + "'.\nAnd for your next guess...?");
								break;
								
								
							case 3:
								
								inputField.setText("");
								displayLog.setText(baseControl.update() 
										+ "The word was " + baseControl.revealWord() + "\n\n\n"
										+ "You Lost. Too bad.\nClose this window to exit.");
								inputField.setEditable(false);
								break;
								
								
							case 4:
								
								inputField.setText("");
								displayLog.setText(baseControl.update() +
										"You've already guessed that letter.");
								break;
								
								
							default:
								
								System.err.println("Default case reached");
								baseControl.quit();
								break;
						}
					}
				}
				
			}

		});
	}
	
}
