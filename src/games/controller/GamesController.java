package games.controller;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import games.model.*;
import games.view.GamesFrame;


public class GamesController
{
	private GamesFrame baseFrame;
	private Hangman hangman;
	private String word;
	public GamesController()
	{
		baseFrame = new GamesFrame(this);
		hangman = new Hangman();
		word = hangman.randomWord();
	}
	
	public void start()
	{
		System.out.println(hangman.getWordList().size() + " words in the word list.");
	}
	
	public boolean checkIfInWord(String guessedLetter)
	{
		int position = word.indexOf(guessedLetter);
		
		if(position == -1)
		{
			System.out.println("You failed goodbye.");
			System.exit(0);
			return false;
		}
		else
		{
			return true;
		}
	}
	public GamesFrame getBaseFrame()
	{
		return baseFrame;
	}
	
	public Hangman getHangman()
	{
		return hangman;
	}
	
	public String getRandomWord()
	{
		return word;
	}
}
