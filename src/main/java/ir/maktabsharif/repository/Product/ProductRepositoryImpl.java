package ir.maktabsharif.repository.Product;

import ir.maktabsharif.model.Product;
import ir.maktabsharif.repository.Base.BaseRepositoryImpl;

public class ProductRepositoryImpl extends BaseRepositoryImpl<Product, Integer> implements ProductRepository {
    public ProductRepositoryImpl() {
        super(Product.class);
    }

    @Override
    protected void updateEntity(Product newEntity, Product dbEntity) {
        dbEntity.setCategory(newEntity.getCategory());
        dbEntity.setName(newEntity.getName());
        dbEntity.setPrice(newEntity.getPrice());
        dbEntity.setRating(newEntity.getRating());
    }
}
