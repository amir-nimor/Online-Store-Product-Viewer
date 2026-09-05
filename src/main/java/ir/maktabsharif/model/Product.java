package ir.maktabsharif.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;

@Entity
@Table(name = "Products")
public class Product extends BaseModel<Integer>{

    @Column(nullable = false)
    private String name;

    @Enumerated
    private Category category;

    @Check(constraints = "price >= 0")
    private BigDecimal price;

    @Check(constraints = "rating >= 0")
    private Integer rating;

    public Product(String name, Category category, BigDecimal price, Integer rating) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
