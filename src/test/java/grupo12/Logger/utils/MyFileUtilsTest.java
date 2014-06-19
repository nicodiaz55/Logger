package grupo12.Logger.utils;

import static org.junit.Assert.*;
import grupo12.Logger.utils.MyFileUtils;

import org.junit.Test;

public class MyFileUtilsTest {
	
	@Test
	public void test() {
		MyFileUtils util = new MyFileUtils();
		assertNotEquals(null, util);
	}
	
	@Test
	public void getBaseName() {
		String base = MyFileUtils.getBaseName("a.b.c.d.e.f");
		assertEquals("a.b.c.d.e", base);
		
		base = MyFileUtils.getBaseName("abcde.f");
		assertEquals("abcde", base);
		
		base = MyFileUtils.getBaseName("abc");
		assertEquals("abc", base);
		
		base = MyFileUtils.getBaseName("");
		assertEquals("", base);
		
		base = MyFileUtils.getBaseName(null);
		assertEquals(null, base);
	}
	
	@Test
	public void getExtension() {
		String base = MyFileUtils.getExtension("a.b.c.d.e.f");
		assertEquals("f", base);
		
		base = MyFileUtils.getExtension("abcde.f");
		assertEquals("f", base);
		
		base = MyFileUtils.getExtension("abc");
		assertEquals("", base);
		
		base = MyFileUtils.getExtension("");
		assertEquals("", base);
		
		base = MyFileUtils.getExtension(null);
		assertEquals(null, base);
	}
}
