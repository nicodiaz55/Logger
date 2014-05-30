package grupo12.Logger.level;

import static org.junit.Assert.*;

import org.junit.Test;

public class LevelFactoryTest {

	@Test
	public void getCorrectLevel() {
		LevelFactory factory = new LevelFactory();
		
		assertEquals(new Trace(), factory.getLevel("TRACE"));
		assertEquals(new Debug(), factory.getLevel("DEBUG"));
		assertEquals(new Info(), factory.getLevel("INFO"));
		assertEquals(new Warning(), factory.getLevel("WARNING"));
		assertEquals(new Error(), factory.getLevel("ERROR"));
		assertEquals(new Fatal(), factory.getLevel("FATAL"));
		
		assertEquals(new Info(), factory.getLevel("asd"));
	}

}
