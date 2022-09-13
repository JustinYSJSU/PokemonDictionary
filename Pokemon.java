package pokemon;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.*;

public class Pokemon 
{
	private static CSVReader cs;
	
	public static void main(String[] args)
	{
		cs = new CSVReader();
		cs.readFile("data/pokemonFinal.csv");
	    System.out.println();
        System.out.println("**IsLegendarCounterTest**: " + getIsLegendaryCount() + "\n");
        System.out.println();
        System.out.println("**GetHitPointListTest**: " + getHitPointList(256, cs.getCharacterSet()).size() + "\n");
        System.out.println();
        System.out.println("**GetCharacterByFirstLetterTest**: ");
        getCharacterByFirstLetter('c');
	}
	
	/*
	 * gets list of pokemon that have an hp range of 0 - maxHP
	 * 
	 * @param maxHP, the maxHP a pokemon can have
	 * @param baseSet the base set of all the pokemon
	 * 
	 * @return set of pokemon that have an hp range of 0 - maxHP
	 * 
	 */
	public static HashSet<Character> getHitPointList(int maxHP, HashSet<Character> baseSet)
	{
		HashSet<Character> hpMon = new HashSet<Character>();
		//goes through the whole set and adds characters that meet the hp requirement to hpMon
		for(Character c : baseSet)
		{
			if(c.getHP() >= 0 && c.getHP() <= maxHP)
			{
				hpMon.add(c);
			}
		}
		return hpMon;
	}
	
	/*
	 * Gets the number of legendary pokemon in the set
	 * 
	 * @param baseSet the set of pokemon
	 * 
	 */
	public static int getIsLegendaryCount()
	{
		CSVReader cc = new CSVReader();
		cc.readFile("data/pokemonFinal.csv"); //read in the file
		int counter = 0;
		for(Character c : cc.getCharacterSet()) //for every pokemon 
		{
			if(c.getIs_legendary() == 1) //is a legendary
			{
				counter++;
			}
		}
		return counter;
	}

	/*
	 * Gets a set of pokemon ordered by the first letter of their name
	 * 
	 * @param firstLetter the first letter of the name
	 * 
	 * @return set of pokemon ordered by the first letter of their name
	 * 
	 */
	public static TreeSet<Character> getCharacterByFirstLetter(char firstLetter)
	{
		CSVReader cc = new CSVReader();
		cc.readFile("data/pokemonFinal.csv"); //read in the file
		TreeSet<Character> letterMon = new TreeSet<Character>();
		for(Character c : cc.getCharacterSet())
		{
			if(c.getName().charAt(0) == java.lang.Character.toUpperCase(firstLetter)) //starts with the appropiate letter
			{
				letterMon.add(c); //add to the TreeSet, sorted via compareTo()
			}
		}
		for(Character c : letterMon) 
		{
			System.out.println(c.toString()); //list out all the characters that were added
		}
		return letterMon;
	}
}
