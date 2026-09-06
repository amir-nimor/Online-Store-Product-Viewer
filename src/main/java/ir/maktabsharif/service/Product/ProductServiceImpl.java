package ir.maktabsharif.service.Product;

import ir.maktabsharif.exception.BusinesException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.exception.Validation;
import ir.maktabsharif.model.Product;
import ir.maktabsharif.repository.Product.ProductRepositoryImpl;
import ir.maktabsharif.service.Base.BaseServiceImpl;
import ir.maktabsharif.util.Ruls;

import java.math.BigDecimal;
import java.util.List;

public class ProductServiceImpl extends BaseServiceImpl<Product, Integer, ProductRepositoryImpl> implements ProductService {

    private ProductRepositoryImpl productRepository;

    public ProductServiceImpl() {
        super(new ProductRepositoryImpl());
        this.productRepository = new ProductRepositoryImpl();
    }

    @Override
    protected void validation(Product entity) throws Validation {
        Ruls.Check(entity.getCategory() == null, "your category is null");
        Ruls.Check(entity.getName().isBlank(), "your name is empty");
        Ruls.Check(entity.getPrice().compareTo(BigDecimal.ZERO) < 0, "your price is negative");
        Ruls.Check(entity.getRating() < 0, "your rating is negative");
    }

    @Override
    public List<Product> productElectric() {
        try {
            return productRepository.productInElicteric();
        } catch (RepositoryException e) {
            throw new BusinesException("operation product electric is failed => " + e.getMessage());
        }
    }

    @Override
    public List<Product> SortedByPrice() {
        try {
            return productRepository.SortedByPrice();
        } catch (RepositoryException e) {
            throw new BusinesException("operation product sort is failed => " + e.getMessage());
        }
    }

    @Override
    public List<Product> AffordableProducts() {
        try {
            return productRepository.AffordableProducts();
        } catch (RepositoryException e) {
            throw new BusinesException("operation product Affordable is failed => " + e.getMessage());
        }
    }


}
