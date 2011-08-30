package net.lshimokawa.ejemplos.springjms;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class QueueListenerIntegrationTest {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Test
	public void testSend() {
		try {
			jmsTemplate.convertAndSend("queue_request", "Hello World");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
}
