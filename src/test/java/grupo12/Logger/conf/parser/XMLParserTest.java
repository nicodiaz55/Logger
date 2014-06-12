package grupo12.Logger.conf.parser;

import static org.junit.Assert.*;
import grupo12.Logger.conf.Configuration;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class XMLParserTest {

	List<Configuration> configurations;
	Parser parser;
	
	private void loadConf(String file) {
		// Setup:
		parser = new XMLParser(file);
		parser.init();
		configurations = parser.loadConfigurations();
	}
	
	@Test
	public void cantInitIfFileDoesntExists() {
		parser = new XMLParser("");
		assertFalse(parser.init());
		assertFalse(parser.canParse());
	}

	@Test
	public void cantLoadConfigurationIfFileDoesntExists() {
		configurations = new ArrayList<Configuration>();
		parser = new XMLParser("");
		parser.init();
		configurations = parser.loadConfigurations();
		assertTrue(configurations.isEmpty());
	}
	
	@Test
	public void loadsOneSimpleConfiguration() {
		// Setup:
		loadConf("one.xml");
				
		// Check:
		assertEquals(1, configurations.size());
		
		Configuration conf = configurations.get(0);
		
		assertEquals("Logger", conf.getName());
		assertEquals("INFO", conf.getLevel());
		assertEquals("%d{HH:mm:ss} - %p - %t - %m", conf.getFormatters().get(0));
		assertEquals("-", conf.getSeparators().get(0));
		assertEquals("console", conf.getOutputs().get(0));
	}

	@Test
	public void loadsTwoSimpleConfigurations() {
		// Setup:
		loadConf("two.xml");
		
		// Check:
		assertEquals(2, configurations.size());
		assertEquals("Logger1", configurations.get(0).getName());
		assertEquals("Logger2", configurations.get(1).getName());
		assertEquals(configurations.get(0).getLevel(), configurations.get(1).getLevel());
		assertEquals(configurations.get(0).getFormatters().get(0), configurations.get(1).getFormatters().get(0));
		assertEquals(configurations.get(0).getSeparators().get(0), configurations.get(1).getSeparators().get(0));
		assertEquals(configurations.get(0).getOutputs().get(0), configurations.get(1).getOutputs().get(0));
	}
	
	@Test
	public void loadFileWithMultipleOutputsInfo() {
		// Setup:
		loadConf("oneLoggerMultipleFields.xml");
		List<String> strings;
		
		// Check output:
		strings = configurations.get(0).getOutputs();
		
		assertEquals(3, strings.size());
		assertEquals("log1.txt", strings.get(0));
		assertEquals("log2.txt", strings.get(1));
		assertEquals("console", strings.get(2));
	}
	
	@Test
	public void loadFileWithMultipleFormattersInfo() {
		// Setup:
		loadConf("oneLoggerMultipleFields.xml");
		List<String> strings;
		
		// Check formatter:
		strings = configurations.get(0).getFormatters();
		
		assertEquals(3, strings.size());
		assertEquals("%d{HH:mm:ss} %n %m", strings.get(0));
		assertEquals("%d{HH:mm:ss} %n %p %n %m", strings.get(1));
		assertEquals("%d{HH:mm:ss} %n %t %n %m", strings.get(2));
	}
	
	@Test
	public void loadFileWithMultipleSeparatorInfo() {
		// Setup:
		loadConf("oneLoggerMultipleFields.xml");
		List<String> strings;
		
		// Check separator:
		strings = configurations.get(0).getSeparators();
		
		assertEquals(3, strings.size());
		assertEquals("|", strings.get(0));
		assertEquals("-", strings.get(1));
		assertEquals("/", strings.get(2));
	}
	
	@Test
	public void loadFileWithMultipleOutputsInfoAndMultipleLoggers() {
		// Setup:
		loadConf("twoLoggerMultipleFields.xml");
		List<String> strings1, strings2;
		
		// Check outputs:
		strings1 = configurations.get(0).getOutputs();
		strings2 = configurations.get(1).getOutputs();
		
		assertEquals(strings1.size(), strings2.size());
		assertEquals(strings1.get(0), strings2.get(0));
		assertEquals(strings1.get(1), strings2.get(1));
		assertEquals(strings1.get(2), strings2.get(2));
	}
	
	@Test
	public void loadFileWithMultipleFormattersInfoAndMultipleLoggers() {
		// Setup:
		loadConf("twoLoggerMultipleFields.xml");
		List<String> strings1, strings2;
		
		// Check formatters:
		strings1 = configurations.get(0).getFormatters();
		strings2 = configurations.get(1).getFormatters();
		
		assertEquals(strings1.size(), strings2.size());
		assertEquals(strings1.get(0), strings2.get(0));
		assertEquals(strings1.get(1), strings2.get(1));
		assertEquals(strings1.get(2), strings2.get(2));
	}
	
	@Test
	public void loadFileWithMultipleSeparatorInfoAndMultipleLoggers() {
		// Setup:
		loadConf("twoLoggerMultipleFields.xml");
		List<String> strings1, strings2;
		
		// Check separators:
		strings1 = configurations.get(0).getSeparators();
		strings2 = configurations.get(1).getSeparators();
		
		assertEquals(strings1.size(), strings2.size());
		assertEquals(strings1.get(0), strings2.get(0));
		assertEquals(strings1.get(1), strings2.get(1));
		assertEquals(strings1.get(2), strings2.get(2));
	}
}