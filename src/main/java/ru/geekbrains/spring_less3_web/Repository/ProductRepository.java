package ru.geekbrains.spring_less3_web.Repository;


import org.springframework.stereotype.Component;
import ru.geekbrains.spring_less3_web.Model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;


//    @PostConstruct
//    public void init() {
//        productList = new ArrayList<>(Arrays.asList(
//                new Product(1L, "Apple", 25),
//                new Product(2L, "Сoconut", 35),
//                new Product(3L, "Melon", 45),
//                new Product(4L, "Watermelon", 55),
//                new Product(5L, "Orange", 65),
//                new Product(6L, "Tomatoes", 95),
//                new Product(7L, "Bananas", 135),
//                new Product(8L, "Broomstick", 75),
//                new Product(9L, "Mandarins", 85),
//                new Product(10L, "Mango", 125)
//        ));
//    }


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

    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }
}


