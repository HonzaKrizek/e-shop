package cz.honza.eshop;

import cz.honza.eshop.entyty.Order;
import cz.honza.eshop.entyty.OrderHasProduct;
import cz.honza.eshop.entyty.Product;
import cz.honza.eshop.entyty.StateEnum;
import cz.honza.eshop.repository.OrderHasProductRepository;
import cz.honza.eshop.repository.OrderRepository;
import cz.honza.eshop.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@SpringBootTest
class ProductRepositoryTests {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderHasProductRepository orderHasProductRepository;

	@Test
	void productTest() {

		Product product = new Product();
		product.setName("Auto Lada");
		productRepository.save(product);

		Order order = new Order();
		order.setState(StateEnum.NEW);
		//orderRepository.save(order);

		OrderHasProduct orderHasProduct1 = new OrderHasProduct();
		orderHasProduct1.setProduct(product);
		orderHasProduct1.setAmount(2);
		orderHasProduct1.setOrder(order);
		//orderHasProductRepository.save(orderHasProduct1);

		OrderHasProduct orderHasProduct2 = new OrderHasProduct();
		orderHasProduct2.setProduct(product);
		orderHasProduct2.setAmount(6);
		orderHasProduct2.setOrder(order);
		//orderHasProductRepository.save(orderHasProduct2);


		List<Product> all = productRepository.findAll();

		Assertions.assertThat(all.size()).isEqualTo(1);


		//productRepository.deleteAll();
		//orderRepository.deleteAll();
		//orderHasProductRepository.deleteAll();

		//productRepository.save(product);

		//all.stream().forEach(System.out::println);
		//System.out.println(all);

		//Product containsDacia = productRepository.findProductByNameContains("Dacia");
		//List<Product> betweenId = productRepository.findProductByIdBetween(4L,6L);

		//List<Product> sortDescending = productRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));

		//Page<Product> allPage = productRepository.findAll(PageRequest.of(0,5,Sort.by("id").ascending().and(Sort.by("name").descending())));
	}

}
