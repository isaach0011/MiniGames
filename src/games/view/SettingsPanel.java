package games.view;

import javax.swing.*;
import games.controller.GamesController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

public class SettingsPanel extends JPanel
{
	private GamesController baseController;
	private GamesFrame baseFrame;
	private SpringLayout baseLayout;
	private JLabel titleLabel;
	private JLabel hangmanLabel;
	private JLabel addWordLabel;
	private JTextField wordInput;
	private JButton submitButton;
	private JButton backButton;
	
	
	public SettingsPanel(GamesController baseController)
	{
		super();
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		this.titleLabel = new JLabel("Settings");
		baseLayout.putConstraint(SpringLayout.NORTH, titleLabel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, titleLabel, 355, SpringLayout.WEST, this);
		this.hangmanLabel = new JLabel("Hangman");
		baseLayout.putConstraint(SpringLayout.NORTH, hangmanLabel, 13, SpringLayout.SOUTH, titleLabel);
		baseLayout.putConstraint(SpringLayout.WEST, hangmanLabel, 379, SpringLayout.WEST, this);
		this.addWordLabel = new JLabel("Type words to add to the list here: ");
		this.wordInput = new JTextField(10);
		baseLayout.putConstraint(SpringLayout.NORTH, wordInput, 29, SpringLayout.SOUTH, hangmanLabel);
		baseLayout.putConstraint(SpringLayout.WEST, wordInput, 423, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, addWordLabel, 5, SpringLayout.NORTH, wordInput);
		baseLayout.putConstraint(SpringLayout.EAST, addWordLabel, -6, SpringLayout.WEST, wordInput);
		this.submitButton = new JButton("Submit");
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, -5, SpringLayout.NORTH, addWordLabel);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 6, SpringLayout.EAST, wordInput);
		this.backButton = new JButton("Back");
		baseLayout.putConstraint(SpringLayout.WEST, backButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, backButton, -10, SpringLayout.SOUTH, this);
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(900,600));
		this.setBackground(Color.gray);
		
		titleLabel.setFont(new Font("Impact", Font.BOLD, 50));
		hangmanLabel.setFont(new Font("Impact", Font.PLAIN, 30));
		
		this.add(titleLabel);
		this.add(hangmanLabel);
		this.add(addWordLabel);
		this.add(wordInput);
		this.add(submitButton);
		this.add(backButton);
		
	}
	
	public void setupLayout()
	{
		
	}
	
	public void setupListeners()
	{
		backButton.addActionListener(new ActionListener()
		{		
			public void actionPerformed(ActionEvent click)
			{

				baseFrame = baseController.getBaseFrame();
				baseFrame.switchScreenToMenu();
			}			
		});
	}
}
