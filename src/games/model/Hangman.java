package games.model;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class Hangman
{
	private ArrayList<String> wordList;
	private String fileName;
	private String line;
	
	public Hangman()
	{
		this.wordList = new ArrayList<String>();
		this.fileName = "/files/words.txt";
		this.line = null;
		
		this.buildWordList();
	}
	

	public void buildWordList()
	{
		try 
		{
            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) 
            {
                wordList.add(line);
            }   
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) 
		{
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) 
		{
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
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
