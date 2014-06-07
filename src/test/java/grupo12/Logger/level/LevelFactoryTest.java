package grupo12.Logger.level;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LevelFactoryTest {

	@Test
	public void getDefaultLevelByOrder() {
		List<String> levels = new ArrayList<String>();
		levels.add("TRACE");
		levels.add("DEBUG");
		levels.add("INFO");
		levels.add("WARNING");
		levels.add("ERROR");
		levels.add("FATAL");
		
		LevelFactory factory = new LevelFactory(levels);
		
		assertEquals(Level.TRACE, factory.getLevel("TRACE"));
		assertEquals(Level.DEBUG, factory.getLevel("DEBUG"));
		assertEquals(Level.INFO, factory.getLevel("INFO"));
		assertEquals(Level.WARNING, factory.getLevel("WARNING"));
		assertEquals(Level.ERROR, factory.getLevel("ERROR"));
		assertEquals(Level.FATAL, factory.getLevel("FATAL"));
	}

}