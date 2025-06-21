package SearchFunction;

public class Test {

	public static void main(String[] args) {
		Product[] products = {
				new Product(101, "Apple", "Fruits"),
				new Product(102, "Laptop", "Electronics"),
				new Product(103, "Mango", "Fruits"),
				new Product(104, "Phone", "Electronics"),
				new Product(105, "Walnut", "Nuts"),
				new Product(106, "Almond", "Nuts"),
				new Product(107, "Guava", "Fruits"),
				new Product(108, "Smartphone", "Electronics")
		};
		
		Product linearSearch = LinearSearch.searchForProduct(products, "Almond");
		System.out.println("Linear Search Result: " + (linearSearch != null ? linearSearch : "Not Found"));

		Product binarySearch = BinarySearch.searchForProduct(products, "Almond");
		System.out.println("Binary Search Result: " + (binarySearch != null ? binarySearch : "Not Found"));
	}

}
