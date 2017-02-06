package games.view;

import javax.swing.*;
import games.controller.GamesController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

public class GamesPanel extends JPanel
{
	private GamesController baseController;
	private GamesFrame baseFrame;
	private MenuPanel menuPanel;
	private SpringLayout baseLayout;
	private JButton backButton;
	private JButton goToHangmanGameButton;
	private JLabel gamesLabel;
	
	
	public GamesPanel(GamesController baseController)
	{
		super();
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		this.backButton = new JButton("Back");
		this.goToHangmanGameButton = new JButton("Hangman");
		this.gamesLabel = new JLabel("Games");
	
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(900,600));
		this.setBackground(Color.gray);
		
		gamesLabel.setFont(new Font("Impact", Font.PLAIN, 50));
		
		this.add(backButton);
		this.add(goToHangmanGameButton);
		this.add(gamesLabel);
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, goToHangmanGameButton, 6, SpringLayout.SOUTH, gamesLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, gamesLabel, 120, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, gamesLabel, -376, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, goToHangmanGameButton, -394, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, backButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, backButton, -10, SpringLayout.SOUTH, this);
	}
	
	public void setupListeners()
	{
		goToHangmanGameButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseFrame = baseController.getBaseFrame();
				baseFrame.switchScreenToHangman();
			}
		});
		
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
