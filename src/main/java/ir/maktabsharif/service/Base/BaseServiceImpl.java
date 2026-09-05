package ir.maktabsharif.service.Base;

import ir.maktabsharif.exception.BusinesException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.exception.Validation;
import ir.maktabsharif.model.BaseModel;
import ir.maktabsharif.repository.Base.BaseRepository;

import java.io.Serializable;
import java.util.List;

public abstract class BaseServiceImpl <T extends BaseModel<ID>
        ,ID extends Serializable
        ,R extends BaseRepository<T,ID>>
        implements BaseService<T,ID>{

    private R repository;

    public BaseServiceImpl(R repository){
        this.repository = repository;
    }


    @Override
    public ID save(T t) {
        try {
            validation(t);
            return repository.save(t);
        } catch (Validation | RepositoryException e) {
            throw new BusinesException("operation save is failed => "+e.getMessage());
        }
    }

    @Override
    public T update(T t) {
        try {
            validation(t);
            return repository.update(t);
        } catch (Validation | RepositoryException e) {
            throw new BusinesException("operation update is failed => "+e.getMessage());
        }
    }

    @Override
    public ID delete(ID id) {
        try {
            return repository.delete(id);
        }catch (RepositoryException e) {
            throw new BusinesException("operation delete is failed => "+e.getMessage());
        }
    }

    @Override
    public T findByID(ID id) {
        try {
            return repository.read(id);
        }catch (RepositoryException e) {
            throw new BusinesException("operation find By id is failed => "+e.getMessage());
        }
    }

    @Override
    public List<T> findAll() {
        try {
            return repository.findAll();
        }catch (RepositoryException e) {
            throw new BusinesException("operation find All is failed => "+e.getMessage());
        }
    }

    protected abstract void validation(T entity) throws Validation;
}
