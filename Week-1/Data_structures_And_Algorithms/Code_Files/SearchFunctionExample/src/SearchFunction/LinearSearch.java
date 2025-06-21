package SearchFunction;
public class LinearSearch {

	public static Product searchForProduct(Product[] products, String targetProduct) {
		for(Product product : products) {
			if(product.productName.equalsIgnoreCase(targetProduct))
				return product;
		}
		return null;
	}

}
