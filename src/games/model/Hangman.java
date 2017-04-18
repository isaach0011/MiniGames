package games.model;

import games.controller.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Hangman
{
	private ArrayList<String> wordList;
	private ArrayList<Integer> correctLetters;
	private ArrayList<String> wordLetterList;
	private int correctlyGuessedLetters;
	private GamesController baseController;
	private File file;
	private String word;
	
	
	public Hangman()
	{
		this.wordList = new ArrayList<String>();
		this.correctLetters = new ArrayList<Integer>();
		this.wordLetterList = new ArrayList<String>();
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
		
		winGame();
	}
	
	public void addWordToFile(String addedWord)
	{
		wordList.add(addedWord);
		System.out.println(word);
		System.out.println(wordList.size());
	}

	public String randomWord()
	{
		int wordPosition = (int) (Math.random() * wordList.size());
		word = wordList.get(wordPosition);
		return word;
	}
	
	public ArrayList<String> getWordList()
	{
		return wordList;
	}

	public ArrayList<String> getWordLetterList()
	
	{
		return wordLetterList;
	}

	public void setWordList(ArrayList<String> wordList)
	{
		this.wordList = wordList;
	}
	
	public boolean winGame()
	{
		if(correctLetters.size() == word.length())
		{
			System.out.println("you win");
			return true;
		}
		else
		{
			return false;
		}
	}
}
