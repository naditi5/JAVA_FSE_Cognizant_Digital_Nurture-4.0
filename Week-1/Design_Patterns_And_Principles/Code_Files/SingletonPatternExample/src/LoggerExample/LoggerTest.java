package LoggerExample;

public class LoggerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger log1 = Logger.getInstance();
		Logger log2 = Logger.getInstance();
		
		log1.logMessage("First Message");
		log2.logMessage("Second Message");
		
		if(log1 == log2) {
			System.out.println("Both logger instances are the same. Hence, singleton works!!");
		} else {
			System.out.println("Logger instaces are diffrent. Hence, singleton failed!!");
		}

	}

}
