package org.scaler.ecommereceproductservice.service;

import org.scaler.ecommereceproductservice.demo.Author;
import org.scaler.ecommereceproductservice.demo.AuthorRepository;
import org.scaler.ecommereceproductservice.demo.Book;
import org.scaler.ecommereceproductservice.model.Category;
import org.scaler.ecommereceproductservice.model.Order;
import org.scaler.ecommereceproductservice.model.Price;
import org.scaler.ecommereceproductservice.model.Product;
import org.scaler.ecommereceproductservice.repository.CategoryRepository;
import org.scaler.ecommereceproductservice.repository.OrderRepository;
import org.scaler.ecommereceproductservice.repository.PriceRepository;
import org.scaler.ecommereceproductservice.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private AuthorRepository authorRepository;

    public InitServiceImpl(ProductRepository productRepository, PriceRepository priceRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }
    @Override
    public void initData() {
        Category electronics = new Category();
        electronics.setCategoryName("Electronics");

        Category furniture = new Category();
        furniture.setCategoryName("Furniture");

        Price sofaSetPrice = new Price();
        sofaSetPrice.setAmount(10000);
        sofaSetPrice.setCurrency("INR");
        sofaSetPrice.setDiscount(0);
        priceRepository.save(sofaSetPrice);

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

        Product sofaSet = new Product();
        sofaSet.setDescription("Very cushion-y sofa set");
        sofaSet.setPrice(sofaSetPrice);
        sofaSet.setImage("https://cushion-y-sofa-set-image");
        sofaSet.setCategory(furniture);
        sofaSet.setTitle("Very cushion-y sofa set");

        Product iphone = new Product();
        iphone.setCategory(electronics);
        iphone.setPrice(priceIphone);
        iphone.setTitle("Iphone 15 pro");
        iphone.setImage("https://iphone-15-pro-image");
        iphone.setDescription("Best Iphone ever");
        Product macBook = new Product();
        macBook.setCategory(electronics);
        macBook.setPrice(priceMacbook);
        macBook.setTitle("Macbook pro 16");
        macBook.setImage("https://macbook-pro-16-image");
        macBook.setDescription("Best Macbook ever");
        Product watch = new Product();
        watch.setCategory(electronics);
        watch.setPrice(priceWatch);
        watch.setTitle("Watch series 10");
        watch.setImage("https://watch-series-10-image");
        watch.setDescription("Best Watch ever");

//        categoryRepository.save(electronics);
//        productRepository.save(iphone);
//        productRepository.save(macBook);
//        productRepository.save(watch);
//

        Order order = new Order();
        order.setProducts(List.of(iphone, macBook, watch, sofaSet));
        orderRepository.save(order);

        System.out.println(orderRepository.findAll());

        /*   ----------- Understanding the fetch types -----------   */

        Author author = new Author();
        author.setAuthorName("John Doe");

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        book1.setAuthor(author);
        book2.setAuthor(author);
        book3.setAuthor(author);
        book1.setName("Book - 1");
        book2.setName("Book - 1");
        book3.setName("Book - 1");

        author.setBooks(List.of(book1, book2, book3));
        authorRepository.save(author);

        Author savedAuthor = authorRepository.findById(1).get();
        System.out.println(savedAuthor.getBooks());
    }
}
