package generic;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;



public class Log {
	
	  public static final String START_SEP = "[";
	  public static final String END_SEP = "]";
	  public static final String SEP_SEP = "-";
	  public static final String DEFAULT_CLASSNAME = "Class";
	  public static final String DEFAULT_METHODNAME = "method";
	  private static String CLASS_METHOD_SEP = ".";
	  
	
	private static Logger logger = Logger.getLogger(Log.class);

	public static void fatal(String className, String methodName, String message) {
		logger.fatal(buildMessage(className, methodName, message));
	}
	
	public static void fatal(String className, String methodName, String message,Throwable t) {
		logger.fatal(buildMessage(className, methodName, message),t);
	}
	
	public static void error(String className, String methodName, String message) {
		logger.error(buildMessage(className, methodName, message));
	}
	
	public static void error(String className, String methodName, String message,Throwable t) {
		logger.error(buildMessage(className, methodName, message),t);
	}
	
	public static void warn(String className, String methodName, String message) {
		logger.warn(buildMessage(className, methodName, message));
	}
	
	public static void warn(String className, String methodName, String message,Throwable t) {
		logger.warn(buildMessage(className, methodName, message),t);
	}
	
	public static void info(String className, String methodName, String message) {
		logger.info(buildMessage(className, methodName, message));
	}
	
	public static void info(String className, String methodName, String message,Throwable t) {
		logger.info(buildMessage(className, methodName, message),t);
		
	}
	
	public static void debug(String className, String methodName, String message) {
		logger.debug(buildMessage(className, methodName, message));
	}
	
	public static void debug(String className, String methodName, String message,Throwable t) {
		logger.debug(buildMessage(className, methodName, message),t);
	}

	private static Object buildMessage(String className, String methodName, String message) {
		StringBuilder sb = new StringBuilder();
		sb.append(START_SEP).append(StringUtils.isBlank(className) ? DEFAULT_CLASSNAME : className);
		sb.append(CLASS_METHOD_SEP)
				.append(StringUtils.isBlank(methodName) ? DEFAULT_METHODNAME : methodName);
		sb.append(END_SEP);
		sb.append(SEP_SEP).append(START_SEP).append(message).append(END_SEP);
		return sb.toString();
	}

}