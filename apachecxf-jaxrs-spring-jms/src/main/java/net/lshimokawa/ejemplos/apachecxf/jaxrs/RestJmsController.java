package net.lshimokawa.ejemplos.apachecxf.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.jms.core.JmsTemplate;

/**
 * Ejemplo de Web Service REST
 * 
 * @author lshimokawa
 * 
 */
@Path("/jms")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class RestJmsController {

	private JmsTemplate jmsTemplate;
	private String destinationName;

	@POST
	public String send(String message) {
		jmsTemplate.convertAndSend(destinationName, message);
		return "Mensaje enviado";
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
}