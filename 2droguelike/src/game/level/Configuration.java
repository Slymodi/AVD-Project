package level;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Configuration {
	
	Properties properties = new Properties();
	int[] level;
	String path = "resources/levels/level.xml";
	public void saveConfiguration(String key, int value) {
		try {
			File file = new File(path);
			boolean exist  = file.exists();
			
			if (!exist) {
				file.createNewFile();
			}
		OutputStream write = new FileOutputStream(path);
		properties.setProperty(key,Integer.toString(value));
		properties.storeToXML(write, "resolution");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		
	}
	
	public void LoadConfiguration(String path) {
		try {
			InputStream read = new FileInputStream(path);
			properties.loadFromXML(read);
			String Level=properties.getProperty("level");
			//String width = properties.getProperty("width");
			//String height = properties.getProperty("height");
			read.close();
			String[] levcharr=Level.split(",");
			level = new int[(levcharr.length)];
			for (int i =0; i < level.length;i++) {
				int j = Integer.parseInt(levcharr[i]);
				level[i]=j;
			}
			System.out.println(Level);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}

	
	
	
}