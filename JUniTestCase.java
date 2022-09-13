package pokemon;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.TreeSet;

public class JUnitTestCase 
{
	 CSVReader cs = new CSVReader();
	 
	 int pokemonWithLessThan300HP = 801;
	 int pokemonWith50OrLessHP = 220;
	 
	 int legendaryPokemon = 70;
	 int actualLegendary = 81;
	 
	 @Test 
	 //Testing the getHitPointList method
	 public void testGetHitPointList()
	 {
		 cs.readFile("data/pokemonFinal.csv");
		 assertEquals(pokemonWithLessThan300HP, Pokemon.getHitPointList(300, cs.getCharacterSet()).size());
		 //returns true, 801 pokemon (all of the ones in the list) have less than 300hp
		 
		 assertEquals(pokemonWith50OrLessHP, Pokemon.getHitPointList(50, cs.getCharacterSet()).size());
		 //returns false, there are actually 217 pokemon with 50 or less hp, not 220
	 }
	 
	 @Test
	 //Testing getIsLegendaryCount method
	 public void getIsLengendaryCount()
	 {
		 assertEquals(legendaryPokemon, Pokemon.getIsLegendaryCount());
		 //returns true, there are 70 legendary pokemon in the list
		 
		 assertEquals(actualLegendary, Pokemon.getIsLegendaryCount());
		 //return false, there are 70 legendary pokemon in this list, despite there
		 //being around 81 in reality
	 }
 
	 @Test
	 //testing the getCharacterByFirstLetter method
	 public void testGetCharacterByFirstLetter()
	 {
		 
		 assertEquals("Zangoose", Pokemon.getCharacterByFirstLetter('z').first().getName());
		 //return true, the first pokemon whose name starts with Z after being ordered
		 //in the TreeSet is Zangoose
		 
		 assertEquals("Charmander", Pokemon.getCharacterByFirstLetter('c').first().getName());
		 //returns false, the first pokemon whose name starts with C after geing ordered
		 //in the TreeSet is Cacnea, not Charmander
	 }
}
