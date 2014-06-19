package grupo12.Logger.output.filter;

import static org.junit.Assert.*;
import grupo12.Logger.output.filter.CustomFilter;
import grupo12.Logger.output.filter.FilterFactory;
import grupo12.Logger.output.filter.RegexFilter;

import org.junit.Test;

public class FilterFactoryTest {

	@Test
	public void getCorrectWriter() {
		FilterFactory factory = new FilterFactory();
		
		assertEquals(new RegexFilter("foo"), factory.getFilter("foo"));
		assertEquals(new CustomFilter("grupo12.Logger.filter.Foo.class"), factory.getFilter("grupo12.Logger.filter.Foo.class"));
	}
	
	@Test
	public void equalsTesting() {
		assertEquals(new RegexFilter("foo"), new RegexFilter("foo"));
		assertNotEquals(new RegexFilter("foo"), new RegexFilter("bar"));
		assertNotEquals(new RegexFilter("foo"), new Object());
		
		assertEquals(new CustomFilter("grupo12.Logger.filter.Foo.class"), new CustomFilter("grupo12.Logger.filter.Foo.class"));
		assertNotEquals(new CustomFilter("grupo12.Logger.filter.Foo.class"), new CustomFilter("grupo12.Logger.filter.Bar.class"));
		assertNotEquals(new CustomFilter("grupo12.Logger.filter.Foo.class"), new Object());
	}
}