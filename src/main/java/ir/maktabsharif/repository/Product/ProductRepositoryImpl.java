package ir.maktabsharif.repository.Product;

import ir.maktabsharif.exception.HibernateException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.model.Category;
import ir.maktabsharif.model.Product;
import ir.maktabsharif.repository.Base.BaseRepositoryImpl;
import ir.maktabsharif.util.HibernateUtil;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Product> productInElicteric() {
        try {
            return HibernateUtil.read(em -> {
                return em.createNamedQuery("Electronics Products", Product.class)
                        .setParameter("enumType", Category.Electronics)
                        .getResultList();
            });
        } catch (HibernateException e) {
            throw new RepositoryException("electric operation is failed => " + e.getMessage());
        }
    }

    @Override
    public List<Product> SortedByPrice() {
        try {
            return HibernateUtil.read(em -> {
                return em.createNamedQuery("Sorted by Price", Product.class)
                        .getResultList();
            });
        }catch (HibernateException e) {
            throw new RepositoryException("sort operation is failed => " + e.getMessage());
        }
    }

    @Override
    public List<Product> AffordableProducts() {
        try {
            return HibernateUtil.read(em -> {
                return em.createNamedQuery("Affordable Products", Product.class)
                        .getResultList();
            });
        }catch (HibernateException e) {
            throw new RepositoryException("Affordable operation is failed => " + e.getMessage());
        }
    }


}
