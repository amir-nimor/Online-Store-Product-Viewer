package ir.maktabsharif.repository.Product;

import ir.maktabsharif.model.Product;
import ir.maktabsharif.repository.Base.BaseRepository;

import java.util.List;

public interface ProductRepository extends BaseRepository<Product,Integer> {


    List<Product> productInElicteric();


    List<Product> SortedByPrice();

    List<Product> AffordableProducts();


}
