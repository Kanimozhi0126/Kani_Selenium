package assignmentWeek3;

import java.util.LinkedHashSet;
import java.util.Set;


public class LearnSet { 

	public static void main(String[] args) {

		String text= "paypal India";
		
		System.out.println(text);
		
		//converting string to charArray
		char[] charArray = text.toCharArray();
		
		//creating an empty Set
		Set<Character> set = new LinkedHashSet<Character>();
		
		//Creating a duplicate Set
		Set<Character> dupSet = new LinkedHashSet<Character>();
		
		//storing the charArray to Set
		for (Character eachCharacter : charArray) 
		{

			boolean add = set.add(eachCharacter); 

			if (add==false) {

				dupSet.add(eachCharacter); // adding the duplicate characters to duplicate Set
				
			}

		}
		System.out.println(dupSet);

		System.out.println(set);
	
		// removing the duplicate characters from Set
		set.removeAll(dupSet);
		System.out.println(set); 
		
		//Iterate through Set and remove for empty spaces and print the values
		for (Character character : set) {
			
			if(character == ' ')
			{
				continue;
			}
			
			System.out.println(character);
		}
		
		

	}


}


