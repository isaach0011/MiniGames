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
	private GamesController baseController;
	private GamesFrame baseFrame;
	private File file;
	
	public Hangman()
	{
		this.wordList = new ArrayList<String>();
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

	public void addWordToFile(String word)
	{
		baseController = new GamesController();
		baseFrame = baseController.getBaseFrame();

		wordList.add(word);
		JOptionPane.showMessageDialog(baseFrame, "Note that the words you add will be deleted after you close this program");
	}

	public String getRandomWord()
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
}
