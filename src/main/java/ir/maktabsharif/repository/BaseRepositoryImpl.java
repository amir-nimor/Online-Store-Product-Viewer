package ir.maktabsharif.repository;

import ir.maktabsharif.model.BaseModel;

import java.io.Serializable;
import java.util.List;

public class BaseRepositoryImpl <T extends BaseModel<ID>,ID extends Serializable> implements BaseRepository<T,ID>{



    @Override
    public ID save(T t) {
        return null;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public ID delete(ID id) {
        return null;
    }

    @Override
    public T read(ID id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return List.of();
    }
}
