package games.model;

import games.controller.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import games.view.GamesFrame;
import java.util.ArrayList;

public class Hangman
{
	private ArrayList<String> wordList;
	private ArrayList<Integer> correctLetters;
	private GamesController baseController;
	private GamesFrame baseFrame;
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
		
		this.winGame();
	}

	public String randomWord()
	{
		int wordPosition = (int) (Math.random() * wordList.size());
		
		return wordList.get(wordPosition);
	}
	
	public ArrayList<String> getWordList()
	{
		return wordList;
	}


	public void setWordList(ArrayList<String> wordList)
	{
		this.wordList = wordList;
	}
	
	public void winGame()
	{
		if(word.length() == correctLetters.size())
		{
			System.out.println("hey you won good for u man");
		}
	}
}
