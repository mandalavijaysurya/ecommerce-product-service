package org.scaler.ecommereceproductservice.service;

import org.scaler.ecommereceproductservice.model.Category;
import org.scaler.ecommereceproductservice.model.Order;
import org.scaler.ecommereceproductservice.model.Price;
import org.scaler.ecommereceproductservice.model.Product;
import org.scaler.ecommereceproductservice.repository.CategoryRepository;
import org.scaler.ecommereceproductservice.repository.OrderRepository;
import org.scaler.ecommereceproductservice.repository.PriceRepository;
import org.scaler.ecommereceproductservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Vijaysurya Mandala
 * @github: github/mandalavijaysurya (<a href="https://www.github.com/mandalavijaysurya"> Github</a>)
 */
@Service
public class InitServiceImpl implements InitService {
    private ProductRepository productRepository;
    private PriceRepository priceRepository;
    private OrderRepository orderRepository;
    private CategoryRepository categoryRepository;

    public InitServiceImpl(ProductRepository productRepository, PriceRepository priceRepository, OrderRepository orderRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public void initData() {
        Category electronics = new Category();
        electronics.setCategoryName("Electronics");
        Category savedCategory = categoryRepository.save(electronics);

        Price priceIphone = new Price();
        priceIphone.setAmount(100000);
        priceIphone.setCurrency("INR");
        priceIphone.setDiscount(0);
        priceRepository.save(priceIphone);

        Price priceMacbook = new Price();
        priceMacbook.setAmount(200000);
        priceMacbook.setCurrency("INR");
        priceMacbook.setDiscount(0);
        priceRepository.save(priceMacbook);

        Price priceWatch = new Price();
        priceWatch.setAmount(50000);
        priceWatch.setCurrency("INR");
        priceWatch.setDiscount(0);
        priceRepository.save(priceWatch);

        Product iphone = new Product();
        iphone.setCategory(savedCategory);
        iphone.setPrice(priceIphone);
        iphone.setTitle("Iphone 15 pro");
        iphone.setImage("https://iphone-15-pro-image");
        iphone.setDescription("Best Iphone ever");
        Product macBook = new Product();
        macBook.setCategory(savedCategory);
        macBook.setPrice(priceMacbook);
        macBook.setTitle("Macbook pro 16");
        macBook.setImage("https://macbook-pro-16-image");
        macBook.setDescription("Best Macbook ever");
        Product watch = new Product();
        watch.setCategory(savedCategory);
        watch.setPrice(priceWatch);
        watch.setTitle("Watch series 10");
        watch.setImage("https://watch-series-10-image");
        watch.setDescription("Best Watch ever");

        productRepository.save(iphone);
        productRepository.save(macBook);
        productRepository.save(watch);

        categoryRepository.save(savedCategory);

        Order order = new Order();
        order.setProducts(List.of(iphone, macBook, watch));
        orderRepository.save(order);
    }
}
