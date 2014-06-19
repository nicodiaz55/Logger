package grupo12.Logger.utils;

import static org.junit.Assert.*;
import grupo12.Logger.output.filter.Foo;
import grupo12.Logger.output.filter.Filter;
import grupo12.Logger.output.writer.Writer;
import grupo12.Logger.utils.MyClassLoader;

import org.junit.Test;

public class MyClassLoaderTest {

	@Test
	public void test() {
		MyClassLoader loader = new MyClassLoader();
		assertNotEquals(null, loader);
	}
	
	@Test
	public void loadGoodClass() {
		Filter filter = (Filter) MyClassLoader.loadClass("grupo12.Logger.output.filter.Foo", "grupo12.Logger.output.filter.Filter");
		assertEquals(new Foo(), filter);
	}

	@Test
	public void loadBadClass() {
		// I want it to implement another interface, for example, Writer.
		Writer writer = (Writer) MyClassLoader.loadClass("grupo12.Logger.output.filter.Foo", "grupo12.Logger.output.writer.Writer");
		assertEquals(null, writer);
	}
}
