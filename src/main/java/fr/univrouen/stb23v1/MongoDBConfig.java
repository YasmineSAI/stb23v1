package fr.univrouen.stb23v1;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClientSettings;

@Configuration
@EnableMongoRepositories(basePackages = "model")

public class MongoDBConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        // Spécifiez le nom de votre base de données MongoDB
        return "STB";
    }
/*
    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        // Configurez les paramètres du client MongoDB si nécessaire
    }*/
}
