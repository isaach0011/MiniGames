package games.view;

import javax.swing.*;
import games.controller.GamesController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

public class WinPanel extends JPanel
{
	private GamesController baseController;
	private GamesFrame baseFrame;
	private SpringLayout baseLayout;
	
	public WinPanel(GamesController baseController)
	{
		super();
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(900,600));
		this.setBackground(Color.gray);
	}
	
	public void setupLayout()
	{
		
	}
	
	public void setupListeners()
	{
		
	}
}
