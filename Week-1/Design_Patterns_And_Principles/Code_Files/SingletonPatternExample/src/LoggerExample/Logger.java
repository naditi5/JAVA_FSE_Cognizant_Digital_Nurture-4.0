package LoggerExample;
public class Logger {
	
	private static Logger instance;

	private Logger() {
		System.out.println("Logger Initialised in constructor");
	}
	
	public static Logger getInstance() {
		if(instance == null) {
			instance = new Logger();
		}
		return instance;
	}
	
	public void logMessage(String msg) {
		System.out.println("[LOG] : " + msg);
	}
}