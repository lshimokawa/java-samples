package net.lshimokawa.ejemplos.springjms;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;

public class CorrelationIdMessageSender {
	private JmsTemplate jmsTemplate;
	private String requestDestination;
	private String responseDestination;

	public String send(String message) {
		final String correlationId = UUID.randomUUID().toString();
		// Setear el JMSCorrelationID
		jmsTemplate.convertAndSend(requestDestination, message,
				new CorrelationIdPostProcessor(correlationId));

		// Llamada s’ncrona, recuperar el mensaje
		String responseMessage = (String) jmsTemplate
				.receiveSelectedAndConvert(responseDestination,
						"JMSCorrelationID='" + correlationId + "'");

		return responseMessage;
	}

	private class CorrelationIdPostProcessor implements MessagePostProcessor {
		private final String correlationId;

		public CorrelationIdPostProcessor(final String correlationId) {
			this.correlationId = correlationId;
		}

		@Override
		public Message postProcessMessage(final Message msg)
				throws JMSException {
			msg.setJMSCorrelationID(correlationId);
			return msg;
		}
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setRequestDestination(String requestDestination) {
		this.requestDestination = requestDestination;
	}

	public void setResponseDestination(String responseDestination) {
		this.responseDestination = responseDestination;
	}

}
