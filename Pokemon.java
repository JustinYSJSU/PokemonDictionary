package pokemon;

public class Character implements Comparable<Character> 
{
	//constants that refer to a stat's column in the csv file
	//ex: HP is column 27 (starting from 0), etc
	private static final int HP = 27;
	private static final int NAME = 29;
	private static final int IS_LEGENDARY = 39;
	
	private String name;
	private int hp;	
	private int is_legendary;
    private String realAbilities;
	private String abilities;
	
	
	

	/*
	 * Constructor for a Pokemon character given a line of data
	 * 
	 * @param dataLine the line of data for the pokemon
	 * 
	 */
	public Character(String dataLine)
	{
		//read in the abilities
		String abilities = dataLine.substring(0, dataLine.indexOf("]")); //gets the section with abilities
		String[] abilitiesList = abilities.split(","); //gets an array of the abilities
		
		for(int x = 0; x < abilitiesList.length; x++)
		{
			String ability = abilitiesList[x];
			this.abilities += ability += ""; //adds each ability to the pokemon's ability String
			
		}
		realAbilities = this.abilities;
		
		//read in the rest of the data
		String restOfData = dataLine.substring(dataLine.indexOf("]") + 3); //starts at the index after the abilities
		String[] restOfDataList = restOfData.split(","); //gets an array of the rest of the data
		for(int x = 0; x < restOfDataList.length; x++) //go through the rest of the data, and assign data appropriately
		{
		    if(x == HP) //assign hp
			{
				this.hp = Integer.parseInt(restOfDataList[x]);
			}
			else if(x == NAME) //assign name
			{
				this.name = restOfDataList[x];
			}
			
		    else if(x == IS_LEGENDARY) //assign is_Legendary
		    {
		    	this.is_legendary = Integer.parseInt(restOfDataList[x]);
		    }		    
		}
		System.out.println(this.toString()); //prints out the character that was created
	}

	/*
	 * Compares two pokemon characters by name
	 * 
	 */
	@Override
	public int compareTo(Character c)
	{
		return this.name.compareTo(c.name);
	}
	
	/*
	 * Checks if two Characters are deeply equal
	 * 
	 */
	public boolean equals(Object o)
	{
		Character c = (Character) o;
		return this.compareTo(c) == 0; //checks if the two characters are deeply equal
	}
	
	/*
	 * Returns a hashCode for each character
	 *
	 * @return hashCode for each character
	 * 
	 */
	@Override
	public int hashCode()
	{
		return this.name.hashCode() + this.hp;
	}
	
	/*
	 * Shows the pokemon character's name, hp, and legendary status
	 * 
	 * @return the pokemon character's name, hp, and legendary status
	 */
	public String toString()
	{
		return "Name: " + this.name + "\n" + " HP: " + this.hp + "\n" + " Legendary Status: " + (this.is_legendary == 1);
	}
	
	public String getRealAbilities() 
	{
		return realAbilities;
	}
	

	public String getName() 
	{
		return name;
	}
     
	public int getHP()
	{
		return hp;
	}
	
	public int getIs_legendary() 
	{
		return is_legendary;
	}

}
