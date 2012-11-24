package com.receipt.vault.integration;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.receipt.vault.jms.EventGateway;

@Ignore
@ContextConfiguration(locations = { "classpath:spring-beans.xml ",
		"classpath:spring-jms.xml" })
public class MessagingIntegrationTest extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private EventGateway eventGateway;

	@Test
	public void testMessageSending() {

		eventGateway.sendEventInfo("Hello");

	}
}
