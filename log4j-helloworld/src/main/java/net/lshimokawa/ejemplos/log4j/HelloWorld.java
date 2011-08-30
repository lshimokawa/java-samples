package net.lshimokawa.ejemplos.log4j;

import org.apache.log4j.Logger;

/**
 * 
 * @author lshimokawa
 *
 */
public class HelloWorld {
	private static final Logger logger = Logger.getLogger(HelloWorld.class);

	public static void main(String[] args) {
		logger.trace("Hello World Trace");
		logger.debug("Hello World Debug");
		logger.info("Hello World Info");
		logger.warn("Hello World Warn");
		logger.fatal("Hello World Fatal");
	}
}
