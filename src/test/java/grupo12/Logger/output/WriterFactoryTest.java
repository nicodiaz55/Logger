package grupo12.Logger.output;

import static org.junit.Assert.*;

import org.junit.Test;

public class WriterFactoryTest {

	@Test
	public void getCorrectWriter() {
		WriterFactory factory = new WriterFactory();
		
		assertEquals(new ConsoleWriter(), factory.getWriter("console"));
		assertEquals(new FileWriter("asd"), factory.getWriter("asd"));
	}

}