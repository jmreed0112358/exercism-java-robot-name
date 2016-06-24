package utilities;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class NameTracker
{
	private Map<String, Boolean> nameMap;
	
	public NameTracker() {
		this.nameMap = new HashMap<String, Boolean>();
	}
	
	/**
	 * Checks to see if the name already exists in the map.
	 * If the name exists in the map, return true.
	 * If the name does not exist in the map, add it, and return false.
	 * @param name
	 * @return
	 */
	public boolean isNameUsed(String name) {
		if ( name == null ) {
			throw new NullPointerException();
		} else if ( name.isEmpty( ) ) {
			throw new InvalidParameterException();
		}
		
		Boolean value = this.nameMap.get( name );
		
		if ( value == null ) {
			this.nameMap.put( name, true );
			return false;
		}
		
		return true;
	}
}
