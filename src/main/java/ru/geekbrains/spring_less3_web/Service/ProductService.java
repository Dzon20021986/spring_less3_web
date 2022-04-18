package ru.geekbrains.spring_less3_web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_less3_web.Model.Product;
import ru.geekbrains.spring_less3_web.Repository.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product(1L, "Apple", 25),
                new Product(2L, "Сoconut", 35),
                new Product(3L, "Melon", 45),
                new Product(4L, "Watermelon", 55),
                new Product(5L, "Orange", 65),
                new Product(6L, "Tomatoes", 95),
                new Product(7L, "Bananas", 135),
                new Product(8L, "Broomstick", 75),
                new Product(9L, "Mandarins", 85),
                new Product(10L, "Mango", 125)
        ));
    }



    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productList);
    }



    public Product findById(Long id) {
        return productList.stream().filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> findAll() {
        return productList;
    }

    public List<Product> getAllProduct() {  // получить весь продукт
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {  // добавить продукт
        if (product == null){
            return null;
        }
        return productRepository.addProduct(product);
    }
}
