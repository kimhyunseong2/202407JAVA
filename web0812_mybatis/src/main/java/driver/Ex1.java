package driver;

import shop.Product;
import shop.ProductDAO;

public class Ex1 {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		Product product = new Product(3, "샤프", "샤프", 1000,2 );
		dao.updateProduct(product);
		System.out.println("수정 완료");

	}

}
