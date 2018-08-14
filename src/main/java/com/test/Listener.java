package com.test;

import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;


import javax.jms.JMSException;

@PropertySource("classpath:application.properties")
@Component
public class Listener {

//    @JmsListener(destination = "${in.queue:default_in_queue}")
//    @JmsListener(destination = "${in.queue:${in2.queue:default_in_queue}}")
    @JmsListener(destination = "${in.queue:${in3.queue:default_in_queue}}")
    @SendTo("${out.queue:default_out_queue}")
    public String receiveMessage(final Message jsonMessage) throws JMSException {



        return processTextMessage(jsonMessage);
    }

//    @JmsListener(destination = "inbound.topic")
//    @SendTo("outbound.topic")
//    public String receiveMessageFromTopic(final Message jsonMessage) throws JMSException {
//        return processTextMessage(jsonMessage);
//    }

    private String processTextMessage(Message jsonMessage) throws JMSException {
        System.out.println(" ***** The processed message is : " + jsonMessage.getPayload().toString() + "");
        return jsonMessage.getPayload().toString();
    }
}