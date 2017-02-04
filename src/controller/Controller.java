/**
 *	@author Ariana Fairbanks
 *	Base control for running the game.
 */

package controller;

import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Hangman;
import view.WindowFrame;

public class Controller 
{
	
	private List<String> wordList = new ArrayList<String>();
	private ArrayList<String> alreadyGuessed = new ArrayList<String>();
	private boolean currentlyPlayingGame;
	private Hangman game;
	private WindowFrame frame;
	private FileChooser fileChooser;
	private int wordsInList = 0;

	/**
	 * Starts the first game if possible.
	 * Catches a file not found error, if thrown.
	 */
	public void start()
	{
		fileChooser = new FileChooser();
		try 
		{
			readWords(fileChooser.pickAFile());
		} 
		catch (FileNotFoundException fnf) 
		{
			System.err.println("File Not Found");
			quit();
		}
		if(wordsInList > 0)
		{
			this.game = new Hangman(wordList);
		}
		else
		{
			System.err.println("No words found in file");
			quit();
		}
		frame = new WindowFrame(this);
			
	}
	
	
	/**
	 * Read in a list of words. 
	 */
	public void readWords(String fileName) throws FileNotFoundException 
	{
		Scanner s = new Scanner(new File(fileName));
		while (s.hasNext())
		{
			wordList.add(s.next());
			wordsInList++;
		}
		s.close();
	}

	/**
	 * Returns one of 4 outcomes:
	 * win, correct guess, incorrect guess, or loss
	 */
	public int determineSituation(String input)
	{
		int outcome = 8;
		boolean guessedBefore = checkList(input);
		if(guessedBefore)
		{
			outcome = 4;
		}
		else
		{
			boolean contains = game.wordContains(input);
			if(contains)
			{
				if(game.checkForCompletion())
				{
					outcome = 0;
				}
				else
				{
					outcome = 1;
				}
			}
			else
			{
				if(!(game.getIncorrectGuess()==6))
				{
					outcome = 2;
				}
				else
				{
					outcome = 3;
				}
			}
		}
		return outcome;
	}
	
	private boolean checkList(String input)
	{
		boolean contains = false;
		for(String value: alreadyGuessed)
		{
			if(value.equals(input))
			{
				contains = true;
			}
		}
		if(!contains)
		{
			alreadyGuessed.add(input);
		}
		return contains;
	}

	public String update()
	{
		return updateWordDisplay() + "\n\n\n\n" + updateStatus() + "\n\n";
	}
	
	
	public String updateWordDisplay() 
	{
		return game.getWordDisplay();
	}
	
	public String revealWord()
	{
		return game.getCurrentWord();
	}
	
	public String updateStatus()
	{
		String result = new String("");
		int remaining = 6 - game.getIncorrectGuess();
		if(remaining == 1)
		{
			result = new String("Status: You are naught but a head...");
		}
		else if(remaining == 0)
		{
			result = new String("Status: You lost all your limbs...    : 0");
		}
		else if(remaining == 6)
		{
			result = new String("Status: You still have all your limbs... For now...");
		}
		else
		{
			result = new String("Status: You have " + remaining + " limbs left.");
		}
		
		return result;
	}

	//exits the program
	public void quit()
	{
		System.exit(0);
	}

}
