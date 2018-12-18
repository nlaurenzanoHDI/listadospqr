package ar.com.hdi.commons.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HDILogger {
	private static Logger logger;
	
	public static void warning(Class clase, String message) {
		logger = LoggerFactory.getLogger(clase);
		logger.warn(message);
	}
	public static void error(Class clase, String message) {
		logger = LoggerFactory.getLogger(clase);
		logger.error(message);
	}
	public static void info(Class clase, String message) {
		logger = LoggerFactory.getLogger(clase);
		logger.info(message);
	}
	public static void debug(Class clase, String message) {
		logger = LoggerFactory.getLogger(clase);
		logger.debug(message);
	}
}
