package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class TestSTB {
	public static String loadFileAccueil() {
       Resource resource = new DefaultResourceLoader().getResource("classpath:html/Accueil.html");
        
        try (InputStream inputStream = resource.getInputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            return "Error while reading Welcome file: " + e.getMessage();
        }
        
    }
	
	public static String loadFileAide() {
	       Resource resource = new DefaultResourceLoader().getResource("classpath:html/Aide.html");
	        
	        try (InputStream inputStream = resource.getInputStream()) {
	            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	            StringBuilder sb = new StringBuilder();
	            String line;
	            while ((line = reader.readLine()) != null) {
	                sb.append(line);
	            }
	            return sb.toString();
	        } catch (IOException e) {
	            return "Error while reading Help file: " + e.getMessage();
	        }
	        
	    }
	
}
