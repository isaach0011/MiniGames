package games.controller;

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
		hangman = new Hangman();
		word = hangman.randomWord();
		baseFrame = new GamesFrame(this);
	}
	
	public void start()
	{
		System.out.println(hangman.getWordList().size() + " words in the word list.");
	}
	
	public boolean checkIfInWord(String guessedLetter)
	{
//		int position = word.indexOf(guessedLetter);
//		
//		if(position == -1)
//		{
//			return false;
//		}
//		else
//		{
//			return true;
//		}
//		
		if(word.contains(guessedLetter))
			
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void addToCorrectlyGuessedLetters()
	{
		hangman.addCorrectlyGuessedLetters();
	}
	
	public void addWord(String word)
	{
		if(word.contains(" ") || word.contains(".") || word.contains("-") || word.contains(","))
		{
			JOptionPane.showMessageDialog(baseFrame, "Please type in a valid word.");
		}
		else
		{
			hangman.addWordToFile(word);
			JOptionPane.showMessageDialog(baseFrame, "Added " + word + " to word list.");
			JOptionPane.showMessageDialog(baseFrame, "Note: All words you add will be deleted after ending the program until next update.");
		}
	}
	
	public int getLetterPosition(String guessedLetter)
	{
		int position = word.indexOf(guessedLetter);
		
		return position;
	}
	
	public boolean winTheGame()
	{
		return hangman.winGame();
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
