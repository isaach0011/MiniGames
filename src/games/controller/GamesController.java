package games.controller;

import javax.swing.JOptionPane;
import games.model.*;
import games.view.*;


public class GamesController
{
	private GamesFrame baseFrame;
	private Hangman hangman;
	private HangmanPanel hangmanPanel;
	private String word;
	public GamesController()
	{
		hangman = new Hangman();
		word = hangman.randomWord();
		baseFrame = new GamesFrame(this);
		hangmanPanel = new HangmanPanel(this);
	}
	
	public void start()
	{
		System.out.println(hangman.getWordList().size() + " words in the word list.");
	}
	
	public boolean checkIfInWord(String guessedLetter)
	{
		if(word.indexOf(guessedLetter) < 0)
		{
			return false;
		}
		else
		{
			return true;
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
	
	public void playGameRound(String guessedLetter)
	{
		if(guessedLetter.equals(""))
		{
			JOptionPane.showMessageDialog(baseFrame, "Please input a letter");
		}
		else if(guessedLetter.length() > 1)
		{
			JOptionPane.showMessageDialog(baseFrame, "Please type in only ONE letter.");
		}
		else
		{
			if(this.checkIfInWord(guessedLetter))
			{
				this.addToCorrectlyGuessedLetters();
				if(this.winTheGame() == true)
				{
					baseFrame.switchScreenToWin();
				}
			}
			else
			{
				//put word in the incorrect text area
			}
		}
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
