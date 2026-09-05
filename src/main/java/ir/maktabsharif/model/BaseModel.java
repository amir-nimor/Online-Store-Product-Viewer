package ir.maktabsharif.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDate;


@MappedSuperclass
public class BaseModel <ID extends Serializable>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private ID id;

    @CreationTimestamp
    private LocalDate createAt;


    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }


}
