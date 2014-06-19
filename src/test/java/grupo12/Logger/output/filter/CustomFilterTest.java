package grupo12.Logger.output.filter;

import static org.junit.Assert.*;
import grupo12.Logger.level.Level;
import grupo12.Logger.message.LogMessage;
import grupo12.Logger.output.filter.CustomFilter;
import grupo12.Logger.output.filter.Filter;

import org.junit.Test;

public class CustomFilterTest {

	Filter filter;
	
	@Test
	public void badCustomFilterDoesntFilter() {
		filter = new CustomFilter("this class doesnt exists.class");
		assertTrue(filter.filter(new LogMessage(Level.INFO,"foo",null,null,"bar")));
	}

	@Test
	public void goodCustomFilterFilters() {
		filter = new CustomFilter("grupo12.Logger.output.filter.Foo.class");
		// This filter always returns false:
		assertFalse(filter.filter(new LogMessage(Level.INFO,"foo",null,null,"bar")));
		
		filter = new CustomFilter("grupo12.Logger.output.filter.Bar.class");
		// This filter always returns true:
		assertTrue(filter.filter(new LogMessage(Level.INFO,"foo",null,null,"bar")));
	}
}
