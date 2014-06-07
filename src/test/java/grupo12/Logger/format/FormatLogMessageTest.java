package grupo12.Logger.format;

import static org.junit.Assert.*;
import grupo12.Logger.level.Info;
import grupo12.Logger.message.LogMessage;

import org.junit.Before;
import org.junit.Test;

public class FormatLogMessageTest {

	private LogMessage message;
	private Format format;
	
	private static String date = "%d{EEE MMM dd HH:mm:ss zzz yyyy}";
	private static String level = "%p";
	private static String thread = "%t";
	private static String literal = "%% ";
	private static String filename = "%F";
	private static String line = "%L";
	private static String text = "%m";
	private static String method = "%M";
	private static String separator = "%n";
	private static String name = "%g";
	
	// TODO: faltan test para Excepciones
	
	@Before
	public void setUp() throws Exception {
		StackTraceElement[] st = Thread.currentThread().getStackTrace();
		message = new LogMessage(new Info(), "Test message", st[0], null, "MyLogger");
		message.changeFormat(date + separator + name + separator + level + separator + thread + separator + literal + separator + filename + separator + line + separator + method + separator + text);
	}

	@Test
	public void formatDate() {
		format = new DateFormat();
		
		format.format(message);
		
		String expected = message.getTimestamp().toString() + separator + name + separator + level + separator + thread + separator + literal + separator + filename + separator + line + separator + method + separator + text;
		assertEquals(expected, message.toString());
	}
	
	@Test
	public void formatFileName() {
		format = new FileNameFormat();
		
		format.format(message);
		
		String expected = date + separator + name + separator + level + separator + thread + separator + literal + separator + message.getCallingFilename() + separator + line + separator + method + separator + text;
		assertEquals(expected, message.toString());
	}
	
	@Test
	public void formatLevel() {
		format = new LevelFormat();
		
		format.format(message);
		
		String expected = date + separator + name + separator + message.getLevel().toString() + separator + thread + separator + literal + separator + filename + separator + line + separator + method + separator + text;
		assertEquals(expected, message.toString());
	}

	@Test
	public void formatLineNumber() {
		format = new LineNumberFormat();
		
		format.format(message);
		
		String expected = date + separator + name + separator + level + separator + thread + separator + literal + separator + filename + separator + message.getLineNumber() + separator + method + separator + text;
		assertEquals(expected, message.toString());
	}
	
	@Test
	public void formatLiteral() {
		format = new LiteralFormat();
		
		format.format(message);
		
		String expected = date + separator + name + separator + level + separator + thread + separator + "% " + separator + filename + separator + line + separator + method + separator + text;
		assertEquals(expected, message.toString());
	}
	
	@Test
	public void formatMessageText() {
		format = new MessageTextFormat();
		
		format.format(message);
		
		String expected = date + separator + name + separator + level + separator + thread + separator + literal + separator + filename + separator + line + separator + method + separator + message.getMessage();
		assertEquals(expected, message.toString());
	}
	
	@Test
	public void formatMethodName() {
		format = new MethodNameFormat();
		
		format.format(message);
		
		String expected = date + separator + name + separator + level + separator + thread + separator + literal + separator + filename + separator + line + separator + message.getCallingMethodName() + separator + text;
		assertEquals(expected, message.toString());
	}
	
	@Test
	public void formatSeparator() {
		format = new SeparatorFormat(" - ");
		
		format.format(message);
		
		String expected = date + " - " + name + " - " + level + " - " + thread + " - " + literal + " - " + filename + " - " + line + " - " + method + " - " + text;
		assertEquals(expected, message.toString());
	}
	
	@Test
	public void formatThread() {
		format = new ThreadFormat();
		
		format.format(message);
		
		String expected = date + separator + name + separator + level + separator + message.getThreadName() + separator + literal + separator + filename + separator + line + separator + method + separator + text;
		assertEquals(expected, message.toString());
	}
	
	@Test
	public void formatLoggerName() {
		format = new LoggerNameFormat();
		
		format.format(message);
		
		String expected = date + separator + message.getLoggerName() + separator + level + separator + thread + separator + literal + separator + filename + separator + line + separator + method + separator + text;
		assertEquals(expected, message.toString());
	}
	
	@Test
	public void fullFormat() {
		Pattern formatter = new Pattern(date + separator + name + separator + level + separator + thread + separator + literal + separator + filename + separator + line + separator + method + separator + text, " - ");
		
		formatter.format(message);
		
		String expected = message.getTimestamp() + " - " + message.getLoggerName() + " - " + message.getLevel().toString() + " - " + message.getThreadName() + " - %  - " + message.getCallingFilename() + " - " + message.getLineNumber() + " - " + message.getCallingMethodName() + " - " + message.getMessage();
		assertEquals(expected, message.toString());
	}
}
