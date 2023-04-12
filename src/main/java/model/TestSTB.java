package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class TestSTB {
	public String loadFileXML() {
       Resource resource = new DefaultResourceLoader().getResource("classpath:test0.xml");
        
        try (InputStream inputStream = resource.getInputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            return "Error while reading XML file: " + e.getMessage();
        }
    }
}
