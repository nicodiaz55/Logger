package grupo12.Logger.utils;

/**
 * Basic file name functions
 * 
 * @author Grupo 12
 */
public class MyFileUtils {
	
	/**
	 * Returns the base name of a file name.
	 * For example, getBaseName("This.IsATextFile.txt") returns "This.IsATextFile"
	 * 
	 * @param file name
	 * @return the base name of the file
	 */
	public static String getBaseName(String file) {
		if (file == null) {
			return null;
		} else {
			return file.replaceFirst("[.][^.]+$", "");
		}
	}
	
	/**
	 * Returns the extension of a file. If the file has no extension, returns an empty String.
	 * For example, getExtension("This.IsATextFile.txt") returns "txt"
	 * 
	 * @param file name
	 * @return the extension of the file
	 */
	public static String getExtension(String file) {
		if (file == null) {
			return null;
		} else {
			String extension = "";
			int i = file.lastIndexOf('.');
			if (i >= 0) {
			    extension = file.substring(i+1);
			}
			return extension;
		}
	}
}
