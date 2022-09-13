package pokemon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class CSVReader 
{
	private FileReader fr;
	private BufferedReader br;
	private HashSet<Character> pokedex;
	
	/*
	 * CSV Reader constructor. Initializes the pokedex
	 * 
	 */
	public CSVReader() 
	{
		pokedex = new HashSet<Character>();
	}
	
	public boolean readFile(String fileName)
	{
		File pokemon = new File(fileName);
		if(pokemon.exists() == false) //file not found, so it can't be read 
		{
			System.out.println("File not found.");
			return false;
		}
		try 
		{		
			fr = new FileReader(pokemon);
			br = new BufferedReader(fr);
		} 
		catch (FileNotFoundException e) //file not found, so it can't be read 
		{			
			System.out.println(e.getMessage());
			return false;
		}
		
		try 
		{		
			br.readLine(); //skips the first line of the file, which doesn't have data
			boolean reading = true;
			pokedex = new HashSet<Character>();
			while(reading)
			{
				String pokemonData = br.readLine(); //reads in a line of pokemon data
				if(pokemonData != null) //if it's null, the end of the file has been reached
				{
					//create and add new character from the csv file
					Character pkmn = new Character(pokemonData); 
					pokedex.add(pkmn);
				}
				else //pokemonData == null, end of file has been reached
				{
					reading = false;
				}
			}
			br.close();
			fr.close();
		} 
		catch (IOException e) //Error in the file, so it can't be read
		{
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	
	/*
	 * Gets the HashSet of the Pokemon characters that have been added via readFile
	 * 
	 */
	public HashSet<Character> getCharacterSet()
	{
		return this.pokedex;
	}
	

}
