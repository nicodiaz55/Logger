package grupo12.Logger.level;

import static org.junit.Assert.*;
import grupo12.Logger.level.Level;

import org.junit.Before;
import org.junit.Test;

public class LevelTest {

	private Level trace;
	private Level debug;
	private Level info;
	private Level warn;
	private Level error;
	private Level fatal;

	@Before
	public void setUp() throws Exception {
		trace = Level.TRACE;
		debug = Level.DEBUG;
		info = Level.INFO;
		warn = Level.WARNING;
		error = Level.ERROR;
		fatal = Level.FATAL;
	}

	@Test
	public void equalsTesting() {
		assertTrue(Level.INFO.equals(Level.INFO));
		assertFalse(Level.INFO.equals(Level.ERROR));
		
		// Tricky tests:
		Level sameName = new Level("INFO", 100000);
		assertFalse(Level.INFO.equals(sameName));
		
		Level samePriority = new Level("foo", 1); 
		assertFalse(Level.DEBUG.equals(samePriority));
		
		Level same = new Level("DEBUG", 1);
		assertTrue(Level.DEBUG.equals(same));
		
		// Other object:
		Object foo = new Object();
		assertFalse(Level.INFO.equals(foo));
	}
	
	@Test
	public void traceTesting() {
		assertEquals("TRACE", trace.toString());
		assertTrue(trace.majorThan(trace));
		assertTrue(trace.majorThan(debug));
		assertTrue(trace.majorThan(info));
		assertTrue(trace.majorThan(warn));
		assertTrue(trace.majorThan(error));
		assertTrue(trace.majorThan(fatal));
	}

	@Test
	public void debugTesting() {
		assertEquals("DEBUG", debug.toString());
		assertFalse(debug.majorThan(trace));
		assertTrue(debug.majorThan(debug));
		assertTrue(debug.majorThan(info));
		assertTrue(debug.majorThan(warn));
		assertTrue(debug.majorThan(error));
		assertTrue(debug.majorThan(fatal));
	}

	@Test
	public void infoTesting() {
		assertEquals("INFO", info.toString());
		assertFalse(info.majorThan(trace));
		assertFalse(info.majorThan(debug));
		assertTrue(info.majorThan(info));
		assertTrue(info.majorThan(warn));
		assertTrue(info.majorThan(error));
		assertTrue(info.majorThan(fatal));
	}

	@Test
	public void warnTesting() {
		assertEquals("WARNING", warn.toString());
		assertFalse(warn.majorThan(trace));
		assertFalse(warn.majorThan(debug));
		assertFalse(warn.majorThan(info));
		assertTrue(warn.majorThan(warn));
		assertTrue(warn.majorThan(error));
		assertTrue(warn.majorThan(fatal));
	}

	@Test
	public void errorTesting() {
		assertEquals("ERROR", error.toString());
		assertFalse(error.majorThan(trace));
		assertFalse(error.majorThan(debug));
		assertFalse(error.majorThan(info));
		assertFalse(error.majorThan(warn));
		assertTrue(error.majorThan(error));
		assertTrue(error.majorThan(fatal));
	}

	@Test
	public void fatalTesting() {
		assertEquals("FATAL", fatal.toString());
		assertFalse(fatal.majorThan(trace));
		assertFalse(fatal.majorThan(debug));
		assertFalse(fatal.majorThan(info));
		assertFalse(fatal.majorThan(warn));
		assertFalse(fatal.majorThan(error));
		assertTrue(fatal.majorThan(fatal));
	}

	@Test
	public void nullTesting() {
		assertFalse(trace.majorThan(null));
		assertFalse(debug.majorThan(null));
		assertFalse(info.majorThan(null));
		assertFalse(warn.majorThan(null));
		assertFalse(error.majorThan(null));
		assertFalse(fatal.majorThan(null));
	}
	
	@Test
	public void sameHashCode(){
		Level l1 = new Level("INFO", 100000);
		Level l2 = new Level("INFO", 100000);

		assertTrue(l1.hashCode()==l2.hashCode());
		
	}
}
