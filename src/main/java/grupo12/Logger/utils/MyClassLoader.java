package grupo12.Logger.utils;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * Loads a class and returns its instance.
 * 
 * @author Grupo 12
 */
public class MyClassLoader {

	/**
	 * Loads a class by name. It must implement the interface passed by parameter.
	 * 
	 * @param className to load
	 * @param interfaceName the class must implement
	 * @return instance of the class, or null if can't be loaded
	 */
	public static Object loadClass(String className, String interfaceName) {
		try {
			Class<?> theClass = Class.forName(className);
			Class<?>[] implementations = theClass.getInterfaces();
			Class<?> anInterface = Class.forName(interfaceName);
			for (int i = 0; i < implementations.length; i++) {
				if (implementations[i].equals(anInterface)) {
					return theClass.newInstance();
				}
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	public static Object loadClassWithStringParameters(String className, String interfaceName, List<String> parameters){
		try{		
			Class<?> theClass = Class.forName(className);
			
			List<Class<?>> paramTypes = new ArrayList<Class<?>>();	
			for (int i = 0; i < parameters.size(); i++) {				
				paramTypes.add(String.class);
			}
			
			Constructor<?> constructor = theClass.getConstructor(paramTypes.toArray(new Class<?>[paramTypes.size()]));
			
			Class<?>[] implementations = theClass.getInterfaces();
			Class<?> anInterface = Class.forName(interfaceName);
			for (int i = 0; i < implementations.length; i++) {
				if (implementations[i].equals(anInterface)) {
					return constructor.newInstance(parameters.toArray(new Object[parameters.size()]));
				}
			}
			
		} catch (Exception e){
			return null;
		}
		return null;
	}
}
