package RecursionExample;
import java.util.*;
public class FinancialForecast {

	public static double findFutureValue(double resultValue, double growthRate, int years) {
		if(years == 0)
			return resultValue;
		return (1 + growthRate) * findFutureValue(resultValue, growthRate, years - 1);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		double givenValue, growthRate;
		int years;
		System.out.print("Enter the actual amount: ");
		givenValue = scan.nextDouble();
		System.out.print("Enter growth rate: ");
		growthRate = scan.nextDouble();
		System.out.print("Enter number of years: ");
		years = scan.nextInt();
		
		double futureVal = findFutureValue(givenValue, growthRate, years);
		System.out.printf("The future values of $%f after %d years is: $%.2f", givenValue, years, futureVal);
		
		scan.close();
	}

}
