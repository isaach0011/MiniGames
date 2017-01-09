package games.controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import games.model.*;
import games.view.GamesFrame;


public class GamesController
{
	private GamesFrame baseFrame;
	
	public GamesController()
	{
		baseFrame = new GamesFrame(this);
	}
	
	public void start()
	{
		
	}
	
	public GamesFrame getBaseFrame()
	{
		return baseFrame;
	}
}
