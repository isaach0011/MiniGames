package games.view;

import javax.swing.*;
import games.controller.GamesController;
import games.model.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

public class HangmanPanel extends JPanel
{
	private GamesController baseController;
	private GamesFrame baseFrame;
	private Hangman hangman;
	private SpringLayout baseLayout;
	private ImageIcon gallowsIcon;
	private JTextArea hangmanDisplay;
	private JTextField hangmanInput;
	private JButton exitButton;
	private JButton submitButton;
	private JLabel gameLabel;
	private JLabel gallowsLabel;
	private String word;
	
	public HangmanPanel(GamesController baseController)
	{
		super();
		this.baseController = baseController;
		this.hangman = new Hangman();
		this.baseLayout = new SpringLayout();
		//this.gallowsIcon = new ImageIcon(getClass().getResource("images/ .png");
		this.hangmanDisplay = new JTextArea(5, 25);
		this.hangmanInput = new JTextField(25);
		this.exitButton = new JButton("Exit Game");
		this.submitButton = new JButton("Submit");
		this.gameLabel = new JLabel("Hangman");
		this.word = "";
		//this.gallowsLabel = new JLabel(gallowsIcon);
		
		setupHangmanGame();
		setupHangmanDisplay();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupHangmanGame()
	{
		word = baseController.getRandomWord();
		System.out.println(word);
	}
	
	private void setupHangmanDisplay()
	{
		hangmanDisplay.setEditable(false);
		hangmanDisplay.setEnabled(false);
		hangmanDisplay.setLineWrap(true);
		hangmanDisplay.setWrapStyleWord(true);
		
		
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(900,600));
		this.setBackground(Color.gray);
		
		gameLabel.setFont(new Font("Impact", Font.PLAIN, 50));
		
		this.add(hangmanDisplay);
		this.add(hangmanInput);
		this.add(exitButton);
		this.add(gameLabel);
		this.add(submitButton);
		//this.add(gallowsLabel);
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, gameLabel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, gameLabel, -316, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, hangmanDisplay, 0, SpringLayout.WEST, exitButton);
		baseLayout.putConstraint(SpringLayout.WEST, exitButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, exitButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, hangmanInput, -75, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, hangmanInput, -244, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, hangmanDisplay, 217, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 6, SpringLayout.SOUTH, hangmanInput);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -365, SpringLayout.EAST, this);
	}
	
	public void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String guessLetter = hangmanInput.getText();
				//String response = baseController.useCheckers(guessLetter);
				baseController.checkIfInWord(guessLetter);
				hangmanInput.setText("");
			}
		});
		
		exitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseFrame = baseController.getBaseFrame();
				baseFrame.switchScreenToMenu();
			}
		});
	}
	
	
}
