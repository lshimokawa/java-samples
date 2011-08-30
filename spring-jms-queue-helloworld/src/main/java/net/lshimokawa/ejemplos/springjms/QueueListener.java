package net.lshimokawa.ejemplos.springjms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

/**
 * 
 * @author lshimokawa
 * 
 */
public class QueueListener implements MessageListener {
	private static final Logger logger = Logger.getLogger(QueueListener.class);

	public void onMessage(final Message message) {
		if (message instanceof TextMessage) {
			final TextMessage textMessage = (TextMessage) message;
			try {
				logger.debug("QueueListener:" + textMessage.getText());
			} catch (final JMSException e) {
				e.printStackTrace();
			}
		}
	}
}