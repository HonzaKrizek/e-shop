package cz.honza.eshop.service;

import cz.honza.eshop.entyty.Order;
import cz.honza.eshop.entyty.OrderHasProduct;
import cz.honza.eshop.entyty.Product;
import cz.honza.eshop.entyty.StateEnum;
import cz.honza.eshop.repository.OrderHasProductRepository;
import cz.honza.eshop.repository.OrderRepository;
import cz.honza.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private Map<Product, Integer> cart = new HashMap<>();

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderHasProductRepository orderHasProductRepository;

    /*
    public ShoppingCartServiceImpl(ProductRepository productRepository, OrderRepository orderRepository, OrderHasProductRepository orderHasProductRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderHasProductRepository = orderHasProductRepository;
        cart = new HashMap<>();
    }

     */

    @Override
    public void add(Long id) {
        Product product = productRepository.findById(id).orElseThrow(NoSuchElementException::new);
        
        //Když má Product lombok jenom anotaci @Data, tak vyskakuje StuckOverFlowError exception

        if (cart.containsKey(product)) {
            cart.replace(product, cart.get(product)+1);
        } else {
            cart.put(product,1);
        }
    }

    @Override
    public void remove(Long id) {
        Product product = productRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (cart.containsKey(product)) {
            if (cart.get(product) > 1) {
                cart.replace(product, cart.get(product)-1);
            } else {
                cart.remove(product);
            }
        }
    }

    @Override
    public Map<Product, Integer> getCart() {
        return cart;
    }

    @Override
    public void checkout() {
        Order order = new Order();
        order.setState(StateEnum.NEW);
        orderRepository.save(order);
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            OrderHasProduct orderHasProduct = new OrderHasProduct();
            orderHasProduct.setOrder(order);
            orderHasProduct.setProduct(entry.getKey());
            orderHasProduct.setAmount(entry.getValue());
            orderHasProductRepository.save(orderHasProduct);
        }
        cart.clear();
    }

    @Override
    public Integer totalPrice() {
        Integer price = null;
        if (!cart.isEmpty()){
            price = cart.entrySet().stream().mapToInt(a->a.getKey().getPrice()*a.getValue()).sum();
        }
        return price;
    }
}
