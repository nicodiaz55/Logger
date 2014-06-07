package grupo12.Logger.output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FileWriterTest {

	private FileWriter writer;
	private static final String filetest = "test.txt";
	
	@Before
	public void setUp() throws Exception {
		writer = new FileWriter(filetest);
	}
	
	@Test
	public void cantWriteIfNotIntialized() {		
		assertFalse(writer.canWrite());
	}

	@Test
	public void fileDoesntExistsIfNotIntialized() {
		File file = new File(filetest);
		assertFalse(file.exists());
	}
	
	@Test
	public void canWriteIfIntialized() {	
		try {
			writer.init();
		} catch (NotInitializedException e) {
			assertFalse(writer.canWrite());
			fail(e.getMessage());
		}
		
		assertTrue(writer.canWrite());
		
		writer.end();
		
		File file = new File(filetest);
		if (file.exists()) {
			file.delete();
		}
	}	

	@Test
	public void fileExistsAfterIntialized() {	
		try {
			writer.init();
		} catch (NotInitializedException e) {
			assertFalse(writer.canWrite());
			fail(e.getMessage());
		}
		
		File file = new File(filetest);
		assertTrue(file.exists());
		
		writer.end();
		
		if (file.exists()) {
			file.delete();
		}
	}
	
	@Test
	public void cantWriteAfterEnd() {	
		try {
			writer.init();
		} catch (NotInitializedException e) {
			assertFalse(writer.canWrite());
			fail(e.getMessage());
		}
		
		writer.end();
		assertFalse(writer.canWrite());
		
		File file = new File(filetest);
		if (file.exists()) {
			file.delete();
		}
	}	

	@Test
	public void endUninitializedFileWriter() {		
		writer.end();

		assertFalse(writer.canWrite());
	}	
	
	@Test
	public void writeAString() throws IOException {
		try {
			writer.init();
		} catch (NotInitializedException e) {
			assertFalse(writer.canWrite());
			fail(e.getMessage());
		}

		assertTrue(writer.canWrite());

		String message = "message";
		writer.write(message);

		writer.end();
		
		BufferedReader br = new BufferedReader(new FileReader(filetest));		
		String content = br.readLine();
		br.close();
		
		assertEquals(message, content);
		
		
		File file = new File(filetest);
		if (file.exists()) {
			file.delete();
		}
	}
}
