package ir.demo;

import ir.maktabsharif.repository.Product.ProductRepositoryImpl;
import ir.maktabsharif.service.Product.ProductServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class service {

    @Test
    public void productTest(){
        ProductServiceImpl productService = new ProductServiceImpl();

        assertEquals(0,productService.findAll().size());
    }


    @Test
    public void productElectric(){
        ProductServiceImpl productService = new ProductServiceImpl();

        assertEquals(0,productService.productElectric().size());
    }


    @Test
    public void productstatics(){
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

    }
}
