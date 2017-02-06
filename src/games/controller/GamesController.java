package games.controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import games.model.*;
import games.view.GamesFrame;


public class GamesController
{
	private GamesFrame baseFrame;
	private Hangman hangman;
	
	public GamesController()
	{
		baseFrame = new GamesFrame(this);
		hangman = new Hangman();
	}
	
	public void start()
	{
		System.out.println(hangman.getWordList().size() + " words in the word list.");
	}
	
	public GamesFrame getBaseFrame()
	{
		return baseFrame;
	}
	
	public Hangman getHangman()
	{
		return hangman;
	}
}
