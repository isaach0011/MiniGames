package games.model;

import games.controller.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Hangman
{
	private ArrayList<String> wordList;
	private ArrayList<Integer> correctLetters;
	private GamesController baseController;
	private File file;
	private String word;
	
	public Hangman()
	{
		this.wordList = new ArrayList<String>();
		this.correctLetters = new ArrayList<Integer>();
		this.file = new File("src/games/model/files/words.txt");
		this.buildWordList();
	}
	
	/*
	 *Great idea, looking forward to seeing it finished.
	 */
	
	//I like this buildWordList() method, you can add your own words from what I can see.
	public void buildWordList()
	{
		try 
		{

	        Scanner sc = new Scanner(file);

	        while (sc.hasNextLine()) 
	        {
	            String i = sc.nextLine();
	            wordList.add(i);
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) 
		{
	        e.printStackTrace();
	    }
	}

	public void buildCorrectLettersList(int position)
	{
		correctLetters.add(position);
		System.out.println(position);
		System.out.println(correctLetters.size());
		
		
	}
	public void addWordToFile(String word)
	{
		wordList.add(word);
		System.out.println(word);
		System.out.println(wordList.size());
	}

	public String randomWord()
	{
		int wordPosition = (int) (Math.random() * wordList.size());
		word = wordList.get(wordPosition);
		return word;
	}
	
	public boolean checkIfInWord(String guessedLetter)
	{
		int position = word.indexOf(guessedLetter);
		
		if(position == -1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public ArrayList<String> getWordList()
	{
		return wordList;
	}


	public void setWordList(ArrayList<String> wordList)
	{
		this.wordList = wordList;
	}
}
