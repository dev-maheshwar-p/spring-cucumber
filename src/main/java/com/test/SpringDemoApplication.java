package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.web.client.RestTemplate;

//@EnableJms
//@Import({AppConfig.class, JmsConfig.class})

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);
        System.out.println("****************** This is the first line that is executed ***************");

    }

}
