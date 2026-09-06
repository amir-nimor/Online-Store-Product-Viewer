package ir.maktabsharif.onlinestoreproductviewer;

import ir.maktabsharif.model.Category;
import ir.maktabsharif.model.Product;
import ir.maktabsharif.service.Product.ProductServiceImpl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.math.BigDecimal;
@WebListener
public class AddObject implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductServiceImpl productService = new ProductServiceImpl();


        Product product1 = new Product(
                "TV",
                Category.Electronics,
                BigDecimal.valueOf(120),
                10
        );

        Product product2 = new Product(
                "Laptop",
                Category.Electronics,
                BigDecimal.valueOf(1500),
                5
        );

        Product product3 = new Product(
                "Smartphone",
                Category.Electronics,
                BigDecimal.valueOf(800),
                15
        );

        Product product4 = new Product(
                "Headphones",
                Category.Programing,
                BigDecimal.valueOf(100),
                25
        );

        Product product5 = new Product(
                "Keyboard",
                Category.Programing,
                BigDecimal.valueOf(60),
                30
        );

        Product product6 = new Product(
                "Mouse",
                Category.English,
                BigDecimal.valueOf(40),
                40
        );

        Product product7 = new Product(
                "Tablet",
                Category.Electronics,
                BigDecimal.valueOf(500),
                12
        );

        Product product8 = new Product(
                "Smart Watch",
                Category.Math,
                BigDecimal.valueOf(250),
                20
        );

        Product product9 = new Product(
                "Camera",
                Category.Electronics,
                BigDecimal.valueOf(900),
                8
        );

        Product product10 = new Product(
                "Speaker",
                Category.English,
                BigDecimal.valueOf(150),
                18
        );

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
        productService.save(product5);
        productService.save(product6);
        productService.save(product7);
        productService.save(product8);
        productService.save(product9);
        productService.save(product10);


    }


}
