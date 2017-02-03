package games.model;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Hangman
{
	private ArrayList<String> wordList;
	private File file;
	
	public Hangman()
	{
		this.wordList = new ArrayList<String>();
		this.file = new File("src/games/model/files/words.txt");
		
		this.buildWordList();
	}
	

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


	public ArrayList<String> getWordList()
	{
		return wordList;
	}


	public void setWordList(ArrayList<String> wordList)
	{
		this.wordList = wordList;
	}
}
