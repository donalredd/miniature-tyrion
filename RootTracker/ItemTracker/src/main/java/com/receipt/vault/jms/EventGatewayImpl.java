package com.receipt.vault.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class EventGatewayImpl implements EventGateway {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("eventDestination")
    private Destination destination;

    public void sendEventInfo(final String event) {

	jmsTemplate.send(destination, new MessageCreator() {

	    public Message createMessage(Session session) throws JMSException {

		Message message = session.createMessage();
		message.setStringProperty("eventType", event);
		return message;
	    }
	});
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
	this.jmsTemplate = jmsTemplate;
    }

    public void setDestination(Destination destination) {
	this.destination = destination;
    }

}
