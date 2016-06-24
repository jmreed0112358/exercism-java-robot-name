package robot;

import exceptions.NotImplementedException;
import utilities.NameTracker;

public class Robot
{
	private String name;
	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private NameTracker nameTracker;
	
	public Robot( NameTracker nameTracker ) {
		this.nameTracker = nameTracker;
		this.name = this.generateName();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	public void reset() {
		this.name = this.generateName( );
	}
	
	/**
	 * Randomly generate a name with the format: "[A-Z]{2}\\d{3}"
	 * @return
	 */
	private String generateName( ) {
		String tempName = "";
		StringBuilder sb = new StringBuilder();
		
		do {
		
			for ( int i = 0 ; i < 2 ; i++ ) {
				sb.append( this.getRandomCharacter( ) );
			}
		
			sb.append( this.getRandomNumberString( ) );
			
			tempName = sb.toString( );
		} while ( this.nameTracker.isNameUsed( tempName ) );
		
		return tempName;
	}
	
	/**
	 * Get one random Character in the range [A-Z].
	 * @return
	 */
	private Character getRandomCharacter() {
		return alphabet.charAt( (int)(Math.random( ) * 26 ) );
	}
	
	/**
	 * Get a random String with three numeric digits.
	 * @return
	 */
	private String getRandomNumberString() {
		StringBuilder sb = new StringBuilder();
		
		for ( int i = 0 ; i < 3 ; i++ ) {
			sb.append( Integer.toString( (int)(Math.random( ) * 10) ) );
		}
		
		return sb.toString( );
	}
}
