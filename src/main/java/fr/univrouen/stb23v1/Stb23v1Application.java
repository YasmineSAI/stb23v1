package fr.univrouen.stb23v1;

/*import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import repositories.STBRepositoryImpl;

import org.springframework.data.mongodb.MongoDbFactory;


@SpringBootApplication
@EnableMongoRepositories("repositories.stbRepositoryImp") 
@ComponentScan(basePackages = "fr.univrouen.stb23v1.controllers")
@Service( "STBservices")
public class Stb23v1Application {

	public static void main(String[] args) {
		SpringApplication.run(Stb23v1Application.class, args);
	}

	
	@Bean
	public STBRepositoryImpl stbRepositoryImp(MongoTemplate mongoTemplate) {
	    return new STBRepositoryImpl(mongoTemplate);
	}
	
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	        MappingJackson2XmlHttpMessageConverter xmlConverter = new MappingJackson2XmlHttpMessageConverter();
	        converters.add(xmlConverter);
	    }
	 @Bean
	    public ViewResolver thymeleafViewResolver() {
	        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
	        resolver.setTemplateEngine(thymeleafTemplateEngine());
	        resolver.setCharacterEncoding("UTF-8");
	        return resolver;
	    }

	    @Bean
	    public SpringTemplateEngine thymeleafTemplateEngine() {
	        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
	        return templateEngine;
	    }

	    @Bean
	    public ClassLoaderTemplateResolver thymeleafTemplateResolver() {
	        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
	        templateResolver.setPrefix("/templates/"); // Chemin relatif du dossier des templates
	        templateResolver.setSuffix(".html");
	        templateResolver.setTemplateMode(TemplateMode.HTML);
	        templateResolver.setCharacterEncoding("UTF-8");
	        return templateResolver;
	    }
	}

*/


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring4.view.ThymeleafView;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import repositories.STBRepositoryImpl;


@SpringBootApplication
@EnableMongoRepositories("repositories.stbRepositoryImp") 
@ComponentScan(basePackages = {"fr.univrouen.stb23v1.controllers", "services"})
public class Stb23v1Application {

    public static void main(String[] args) {
        SpringApplication.run(Stb23v1Application.class, args);
    }

    @Bean
    public STBRepositoryImpl stbRepository(MongoTemplate mongoTemplate) {
        return new STBRepositoryImpl(mongoTemplate);
    }
  

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2XmlHttpMessageConverter xmlConverter = new MappingJackson2XmlHttpMessageConverter();
        converters.add(xmlConverter);
    }

   
    @Bean
    public ClassLoaderTemplateResolver thymeleafTemplateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/"); // Chemin relatif du dossier des templates
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }
  

   
}

	    
