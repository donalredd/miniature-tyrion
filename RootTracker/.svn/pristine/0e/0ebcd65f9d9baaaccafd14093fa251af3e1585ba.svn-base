package com.receipt.vault.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

public class EventListener implements MessageListener {

    public void onMessage(Message message) {

	try {
	    String eventName = message.getStringProperty("eventType");
	    processEvent(eventName);
	} catch (JMSException e) {
	    e.printStackTrace();
	}
    }

    void processEvent(String eventName) {

	System.out.println(eventName);
    }
}
