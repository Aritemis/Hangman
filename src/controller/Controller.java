/**
 *	@author Ariana Fairbanks
 *	Base control for running the game.
 */

package controller;

import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Hangman;
import view.WindowFrame;

public class Controller 
{
	
			private List<String> wordList = new ArrayList<>(Arrays.asList("abashes", "academic", "acclimation", "adhesive", "admitting",
					"adoring", "adverbial", "amicable", "anagram", "antipasto", "apathy", "aping", "appeased", "apposite",
					"approvals", "arrays", "artery", "atmosphere", "attitudes", "awash", "backbone", "bagels", "balloon",
					"barbarian", "barber", "based", "batting", "bearded", "beers", "beggarly", "beige", "bellyful", "bided",
					"bivalve", "blinds", "blowgun", "blued", "boodles", "bootie", "booting", "borrowing", "bossy", "botanist",
					"bratty", "breakups", "brokering", "broomsticks", "buckle", "bugling", "buildings", "bulbous", "bullet",
					"burials", "busyness", "caddied", "caffeine", "cagney", "calibrate", "calking", "calvert", "campiest",
					"cannonading", "capably", "carded", "celesta", "certifying", "chaise", "changing", "charmin", "chiffon",
					"chilli", "chose", "cigarettes", "cinders", "cleaners", "clergy", "clouts", "cockpits", "colloids",
					"colonials", "comeuppance", "communal", "compensate", "conceits", "concierges", "condominium", "conjugate",
					"conscience", "contends", "contractor", "convexity", "corporal", "corrupted", "cosies", "coterie",
					"counselors", "couriers", "covenant", "crackles", "cranky", "crossbeams", "crouched", "cruelest", "cubit",
					"curators", "curvaceous", "cybernetics", "cypress", "deadlocking", "deafen", "decompress", "decoys",
					"decreeing", "deficits", "delved", "demean", "demitass", "deranging", "derivatives", "desecrated",
					"diaries", "diphtheria", "dirks", "disapproval", "disobeyed", "disowning", "disparage", "dispels",
					"distention", "dotage", "drizzle", "dulcimers", "dwindled", "edginess", "educable", "eeriness", "elbows",
					"emperor", "emulate", "emulator", "endowment", "enfeebled", "engulfing", "enrolment", "enslaves", "enrich",
					"essential", "evinced", "explicating", "expressive", "fains", "false", "falseness", "feistier", "fence",
					"fishy", "flapjacks", "flaunting", "fledglings", "fleetest", "flirtation", "flyswatter", "foosball",
					"fostering", "foundry", "fours", "fridges", "fringes", "frisks", "furtively", "fuzing", "gaunted", "genies",
					"germination", "gilded", "glossiest", "gowns", "granularity", "gruelling", "guilty", "guttural",
					"hamiltonian", "hammer", "handballs", "handgun", "harming", "headdress", "headstone", "hearkened",
					"highjacked", "hightail", "hogwash", "honchos", "horsewhip", "housebroken", "huckleberry", "hunger",
					"humanizing", "hungrily", "hyperbola", "impiously", "impulsive", "inculpates", "inducements", "informative",
					"inked", "innovation", "inquiring", "insoles", "instil", "integral", "interdicted", "intermezzos",
					"interracial", "invigorated", "iroquois", "irrelevancy", "jealous", "jilted", "jingle", "joyless",
					"juxtaposing", "khaki", "kibitzed", "kicker", "kidder", "kilobyte", "knoll", "knows", "layout", "lectures",
					"libreville", "licence", "licking", "lineups", "lionize", "livens", "located", "loopiest", "lubricator",
					"luncheoned", "mains", "malice", "maliciously", "manicures", "manifold", "mansion", "mantel", "mantra",
					"marital", "marsala", "matchmakers", "meekness", "mendicant", "merlot", "migrated", "misdealt", "modelled",
					"monikers", "monogamous", "monotonous", "moody", "mulberry", "muscled", "musicology", "namely", "napkin",
					"needle", "nicest", "noise", "nostalgia", "nought", "nudging", "omniscient", "orate", "outstrip", "overawe",
					"overgrowth", "overshot", "pacifist", "palate", "paneling", "paramour", "parrots", "paunchy", "peanut",
					"pervaded", "pictorial", "pikers", "pirate", "planes", "plantations", "plumbing", "poisons", "prairie",
					"precipices", "precluded", "pretenses", "probation", "propagating", "pucker", "puffballs", "pugilism",
					"reeducated", "reexamining", "regulation", "relatives", "releasable", "resistance", "retool", "rifling",
					"ringlet", "roaring", "ruffle", "satisfying", "saucepan", "scanning", "schoolchild", "schoolwork",
					"scotching", "scuffle", "seascapes", "seceding", "secrete", "separator", "sequential", "serfs", "settle",
					"seventieth", "shaker", "sheepish", "shied", "shoveled", "shovelful", "showgirl", "shrill", "shrubbery",
					"sidelining", "similarly", "sincerest", "singular", "sizeable", "skits", "skittering", "sleepwalked",
					"sloppiest", "smuggle", "snowy", "sociable", "softener", "south", "spares", "spent", "spicier", "spoons",
					"squawked", "staler", "stancher", "stanford", "steels", "stinging", "stirrings", "students", "stupid",
					"sturdy", "sublime", "suffusing", "sulkily", "summons", "sunken", "sunny", "surrounding", "suspends",
					"swirl", "taffy", "taring", "tension", "theocracies", "theology", "theorize", "timber", "timid", "toasted",
					"touting", "traffic", "transposing", "treasurers", "tributaries", "triteness", "trudge", "trumpeting",
					"trundles", "trying", "turnout", "twerp", "unalterably", "unceasingly", "underpay", "uneasy", "uniformity",
					"unsaddle", "unsparing", "until", "untrue", "usurped", "vaguer", "venturing", "verily", "victimizes",
					"viler", "vineyards", "vitiates", "waggle", "wangles", "wantoning", "wattled", "wayne", "weakened",
					"wearable", "wheel", "where", "whisker", "whistle", "wicket", "wildfires", "windlass", "wintriest",
					"wither", "worries", "worsened", "worsted", "writs", "yelps", "zeros", "zippered"));
	
	private ArrayList<String> alreadyGuessed = new ArrayList<String>();
	private boolean currentlyPlayingGame = true;
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
		
		
		
		//enables use of a file chooser
//		fileChooser = new FileChooser();
//		try 
//		{
//			readWords(fileChooser.pickAFile());
//		} 
//		catch (FileNotFoundException fnf) 
//		{
//			System.err.println("File Not Found");
//			quit();
//		}
//		if(wordsInList > 0)
//		{
//			this.game = new Hangman(wordList);
//		}
//		else
//		{
//			System.err.println("No words found in file");
//			quit();
//		}
		
		this.game = new Hangman(wordList);
		
		frame = new WindowFrame(this);
		
	}
	
	public void newGame()
	{
		currentlyPlayingGame = true;
		this.game = new Hangman(wordList);
		alreadyGuessed = new ArrayList<String>();
		frame.resetPanel();
	}
	
	
	/**
	 * Read in a list of words. 
	 */
	public void readWords(String fileName) throws FileNotFoundException 
	{
		Scanner s = new Scanner(new File(fileName));
		wordList = new ArrayList<String>();
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
		if(currentlyPlayingGame)
		{
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
						currentlyPlayingGame = false;
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
						currentlyPlayingGame = false;
					}
				}
			}
			
		}
		else
		{
			outcome = 5;
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
