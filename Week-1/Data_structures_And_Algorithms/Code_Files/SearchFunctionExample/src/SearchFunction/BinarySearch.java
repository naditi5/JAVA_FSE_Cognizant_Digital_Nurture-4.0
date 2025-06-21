package SearchFunction;
import java.util.*;
public class BinarySearch {

	public static Product searchForProduct(Product[] products, String targetProduct) {
		// Sorting the Products based in the name of products
		Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
		
		int left = 0, right = products.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			int compare = products[mid].productName.compareToIgnoreCase(targetProduct);
			
			if(compare == 0) {
				return products[mid];
			} else if(compare < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return null;
	}

}
