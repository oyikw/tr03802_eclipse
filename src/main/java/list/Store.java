package list;

import java.util.ArrayList;
import java.util.List;

public class Store {
	public static List<Product> products;
	
	static {
		products = new ArrayList<Product>();
		products.add(new Product(1, "波司登羽绒服", 2000, 110));
		products.add(new Product(2, "立白洗衣液", 21, 50));
		products.add(new Product(3, "华为mate60 pro", 6999, 10));
		products.add(new Product(4, "iPhone 15 Pro", 2000, 110));
		products.add(new Product(5, "特斯拉Model Y", 300000, 10));
		products.add(new Product(6, "雷鸟电视机", 5999, 110));
	}
}
