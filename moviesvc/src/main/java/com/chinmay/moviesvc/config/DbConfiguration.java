package com.chinmay.moviesvc.config;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;

@Configuration
public class DbConfiguration {

    @Value("${custom.uri}")
    String customUrl;

    @Bean
    public MongoClientFactoryBean mongo() throws Exception {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        ConnectionString conn = new ConnectionString(customUrl);
        mongo.setConnectionString(conn);

//        MongoClient client = mongo.getObject();
//        client.listDatabaseNames()
//                .forEach(System.out::println);
        return mongo;
    }

}
