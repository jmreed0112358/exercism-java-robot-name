package utilities;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Test;

public class NameTrackerTest
{

	@Test
	public void test_isNameUsed_EmptyMap_ValidName_ReturnsFalse( ) {
		NameTracker tracker = new NameTracker();
		assertFalse( tracker.isNameUsed( "Foo" ) );
	}

	@Test
	public void test_isNameUsed_NonEmptyMap_ValidNameInMap_ReturnsTrue() {
		NameTracker tracker = new NameTracker();
		tracker.isNameUsed( "Foo" );
		assertTrue( tracker.isNameUsed( "Foo" ) );
	}
	
	@Test
	public void test_isNameUsed_EmptyMap_EmptyName_ThrowsException() {
		try {
			NameTracker tracker = new NameTracker();
			tracker.isNameUsed( "" );
			fail("Supposed to catch InvalidParameterException");
		} catch ( InvalidParameterException ipe ) {
			
		} catch ( Exception e ) {
			fail("Expected to catch InvalidParameterException");
		}
	}
	
	@Test
	public void test_isNameUsed_EmptyMap_NullName_ThrowsException() {
		try {
			NameTracker tracker = new NameTracker();
			tracker.isNameUsed( null );
			fail("Supposed to catch NullPointerException");
		} catch ( NullPointerException npe ) {
			
		} catch ( Exception e ) {
			fail("Expected to catch NullPointerException");
		}
	}
}
