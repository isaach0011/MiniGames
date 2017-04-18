package games.view;

import javax.swing.*;
import games.controller.GamesController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

public class WinPanel extends JPanel
{
	private GamesController baseController;
	private GamesFrame baseFrame;
	private SpringLayout baseLayout;
	private ImageIcon winPicture;
	private JLabel winPictureLabel;
	private JLabel winLabel;
	private JButton returnToMenuButton;
	private JButton playAgainButton;
	
	public WinPanel(GamesController baseController)
	{
		super();
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		
		this.winPicture = new ImageIcon(getClass().getResource("images/youdidit.jpeg"));
		this.winLabel = new JLabel("You Win!");
		this.returnToMenuButton = new JButton("Return to Menu");
		this.playAgainButton = new JButton("Play Again");
		this.winPictureLabel = new JLabel(winPicture);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(900,600));
		this.setBackground(Color.gray);
		
		winLabel.setFont(new Font("BigNoodleTitling", Font.PLAIN, 50));
		
		this.add(winPictureLabel);
		this.add(winLabel);
		this.add(returnToMenuButton);
		this.add(playAgainButton);
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, winLabel, 38, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, winLabel, 366, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, returnToMenuButton, 183, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, playAgainButton, 0, SpringLayout.NORTH, returnToMenuButton);
		baseLayout.putConstraint(SpringLayout.EAST, playAgainButton, -215, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, returnToMenuButton, 75, SpringLayout.SOUTH, winPictureLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, winPictureLabel, 77, SpringLayout.SOUTH, winLabel);
		baseLayout.putConstraint(SpringLayout.WEST, winPictureLabel, 296, SpringLayout.WEST, this);
	}
	
	public void setupListeners()
	{
		
	}
}
