package net.lshimokawa.ejemplos.springjms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * 
 * @author lshimokawa
 * 
 */
public class EchoJmsServer implements MessageListener {
	private Logger logger = Logger.getLogger(EchoJmsServer.class);

	private JmsTemplate jmsTemplate;
	private String responseDestination;

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			final TextMessage requestMessage = (TextMessage) message;
			try {
				final String mensaje = requestMessage.getText();
				logger.debug("EchoJmsServer recibiendo: " + mensaje);
				jmsTemplate.send(responseDestination, new MessageCreator() {
					@Override
					public Message createMessage(Session session)
							throws JMSException {
						TextMessage responseMessage = session
								.createTextMessage();
						responseMessage.setJMSCorrelationID(requestMessage
								.getJMSCorrelationID());
						responseMessage.setText(mensaje);
						return responseMessage;
					}
				});
			} catch (final JMSException e) {
				logger.error("Error al procesar el mensaje JMS", e);
			}
		}

	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setResponseDestination(String responseDestination) {
		this.responseDestination = responseDestination;
	}
}