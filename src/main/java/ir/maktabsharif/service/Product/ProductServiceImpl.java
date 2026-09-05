package ir.maktabsharif.service.Product;

import ir.maktabsharif.exception.Validation;
import ir.maktabsharif.model.Product;
import ir.maktabsharif.repository.Product.ProductRepositoryImpl;
import ir.maktabsharif.service.Base.BaseServiceImpl;
import ir.maktabsharif.util.Ruls;

import java.math.BigDecimal;

public class ProductServiceImpl extends BaseServiceImpl<Product, Integer, ProductRepositoryImpl> implements ProductService {

    public ProductServiceImpl() {
        super(new ProductRepositoryImpl());
    }

    @Override
    protected void validation(Product entity) throws Validation {
        Ruls.Check(entity.getCategory() == null, "your category is null");
        Ruls.Check(entity.getName().isBlank(), "your name is empty");
        Ruls.Check(entity.getPrice().compareTo(BigDecimal.ZERO) < 0, "your price is negative");
        Ruls.Check(entity.getRating() < 0, "your rating is negative");
    }
}
