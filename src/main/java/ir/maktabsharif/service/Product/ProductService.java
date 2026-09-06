package ir.maktabsharif.service.Product;

import ir.maktabsharif.model.Product;
import ir.maktabsharif.service.Base.BaseService;

import java.util.List;

public interface ProductService extends BaseService<Product, Integer> {

    List<Product> productElectric();



    List<Product> SortedByPrice();

    List<Product> AffordableProducts();



}
