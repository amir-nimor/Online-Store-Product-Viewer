package ir.maktabsharif.repository.Base;

import ir.maktabsharif.model.BaseModel;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository <T extends BaseModel<ID>,ID extends Serializable>{

    ID save(T t);

    T update(T t);

    ID delete(ID id);

    T read(ID id);

    List<T> findAll();


}
