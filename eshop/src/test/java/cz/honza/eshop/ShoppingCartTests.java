package cz.honza.eshop;

import cz.honza.eshop.entyty.Order;
import cz.honza.eshop.entyty.OrderHasProduct;
import cz.honza.eshop.entyty.Product;
import cz.honza.eshop.entyty.StateEnum;
import cz.honza.eshop.repository.OrderHasProductRepository;
import cz.honza.eshop.repository.OrderRepository;
import cz.honza.eshop.repository.ProductRepository;
import cz.honza.eshop.service.ShoppingCartService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@RunWith(SpringRunner.class)
//@DataJdbcTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
class ShoppingCartTests {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Test
	void addOneToShoppingCart() {

		Product product = new Product();
		product.setName("Lada");
		productRepository.save(product);
		List<Product> all = productRepository.findAll();

		//Assertions.assertThat(all.size()).isEqualTo(1);

		Long productId =all.get(0).getId();
		shoppingCartService.add(productId);

		// počet pvků v košíku = 1
		Assertions.assertThat(shoppingCartService.getCart().size()).isEqualTo(1);

		// obsahuje právě vložený produkt
		Assertions.assertThat(shoppingCartService.getCart().containsKey(all.get(0))).isTrue();

		// obsahuje vložený produkt v počtu = 1
		Assertions.assertThat(shoppingCartService.getCart().get(all.get(0))).isEqualTo(1);


		}

}
