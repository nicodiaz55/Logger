package grupo12.Logger.conf;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void testCustomConfiguration() {
		// Setup:
		Configuration conf = new Configuration("user.cfg");
		
		// Check level:
		assertEquals("DEBUG", conf.getLevel());
		
		// Check message format:
		assertEquals("%d{HH:mm:ss} %n %p %n %m", conf.getPattern());
		
		// Check separator:
		assertEquals("|", conf.getSeparator());
		
		// Check outputs:
		ArrayList<String> output = conf.getOutputs();
		assertEquals(2, output.size());
		assertTrue(output.contains("console"));
		assertTrue(output.contains("log.txt"));
	}

	// TODO: Test para archivos "malos", ver que carga la configuracion default (probar Validator)
}
