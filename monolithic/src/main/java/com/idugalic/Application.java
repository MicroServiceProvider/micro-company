package com.idugalic;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String... args) throws UnknownHostException {
    	 SpringApplication app = new SpringApplication(Application.class);
         Environment env = app.run(args).getEnvironment();
         LOG.info("\n----------------------------------------------------------\n\t" +
                 "Application '{}' is running! Access URLs:\n\t" +
                 "Local: \t\thttp://127.0.0.1:{}\n\t" +
                 "External: \thttp://{}:{}\n----------------------------------------------------------",
             env.getProperty("spring.application.name"),
             env.getProperty("server.port"),
             InetAddress.getLocalHost().getHostAddress(),
             env.getProperty("server.port"));
    }
    
    @Bean
    @Primary
    public ObjectMapper fooObjectMapper() {
        return new ObjectMapper();
    }
    
//    @Bean
//    AggregateAnnotationCommandHandler<BlogPostAggregate> blogPostAggregateCommandHandler(Repository<BlogPostAggregate> eventSourcingRepository, CommandBus commandBus) {
//        AggregateAnnotationCommandHandler<BlogPostAggregate> handler = new AggregateAnnotationCommandHandler<BlogPostAggregate>(
//                BlogPostAggregate.class,
//                eventSourcingRepository);
//        return handler;
//    }
//    
//    @Bean
//    AggregateAnnotationCommandHandler<ProjectAggregate> projectAggregateCommandHandler(Repository<ProjectAggregate> eventSourcingRepository, CommandBus commandBus) {
//        AggregateAnnotationCommandHandler<ProjectAggregate> handler = new AggregateAnnotationCommandHandler<ProjectAggregate>(
//                ProjectAggregate.class,
//                eventSourcingRepository);
//        return handler;
//    }

}