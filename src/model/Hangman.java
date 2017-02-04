package model;

/**
 * @author Ariana Fairbanks
 * The hangman game 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman 
{

	private List<String> wordList;
	private int incorrectGuess;
	private String currentWord;
	private String wordDisplay;
	
	public Hangman(List<String> wordList)
	{
		this.wordList = wordList;
		this.currentWord = findWord();
		this.wordDisplay = findWordDisplay();
		this.incorrectGuess = 0;
	}
	
	/**
	 * Returns a random word from the list in all caps.
	 */
	private String findWord() 
	{
		Random r = new Random();
		return wordList.get(r.nextInt(wordList.size())).toUpperCase();
	}
	
	/**
	 * Returns the initial word display value.
	 */
	private String findWordDisplay()
	{
		char[] temp = new char[currentWord.length()*2];
		for(int i = 0; i < currentWord.length();i++)
		{
			temp[i*2] = '_';
			temp[i*2+1] = ' ';
		}
		String displayTemp = new String(temp);
		return displayTemp;
	}


	public boolean wordContains(String input)
	{
		boolean doesContain = this.currentWord.contains(input);
		if(doesContain)
		{
			updateWordDisplay(input.charAt(0));
		}
		else
		{
			incorrectGuess++;
		}
		return doesContain;
	}
	
	
	private void updateWordDisplay(char input)
	{
		char[] values = new char[currentWord.length()*2];
		for(int i = 0; i < currentWord.length(); i++)
		{
			char value = wordDisplay.charAt(i*2);
			if(currentWord.charAt(i) == input)
			{
				value = input;
			}
			values[i*2] = value;
			values[i*2+1] = ' ';
		}
		wordDisplay = new String(values);
	}
	
	public boolean checkForCompletion()
	{
		boolean complete = false;
		char[] values = new char[currentWord.length()*2];
		for(int i = 0; i < currentWord.length(); i++)
		{
			values[i*2] = currentWord.charAt(i);
			values[i*2+1] = ' ';
		}
		String temp = new String(values);
		if(wordDisplay.equals(temp))
		{
			complete = true;
		}
		return complete;
	}

	public int getIncorrectGuess() 
	{
		return incorrectGuess;
	}
	
	public String getWordDisplay()
	{
		return wordDisplay;
	}
	
	public String getCurrentWord()
	{
		return currentWord;
	}
	
}
