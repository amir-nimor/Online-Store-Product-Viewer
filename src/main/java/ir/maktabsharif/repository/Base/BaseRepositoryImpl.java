package ir.maktabsharif.repository.Base;

import ir.maktabsharif.exception.HibernateException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.model.BaseModel;
import ir.maktabsharif.util.HibernateUtil;

import java.io.Serializable;
import java.util.List;

public abstract class BaseRepositoryImpl<T extends BaseModel<ID>, ID extends Serializable> implements BaseRepository<T, ID> {


    private Class<T> entityType;


    public BaseRepositoryImpl(Class<T> entityType) {
        this.entityType = entityType;
    }


    @Override
    public ID save(T t) {
        try {
            return HibernateUtil.inTxReturn(em -> {
                em.persist(t);
                return t.getId();
            });
        } catch (HibernateException e) {
            throw new RepositoryException("save operation is failed => " + e.getMessage());
        }
    }

    @Override
    public T update(T t) {
        try {
            return HibernateUtil.inTxReturn(em -> {
                T entity = em.find(entityType, t.getId());
                updateEntity(t, entity);
                return entity;
            });
        } catch (HibernateException e) {
            throw new RepositoryException("update operation is failed => " + e.getMessage());
        }
    }

    @Override
    public ID delete(ID id) {
        try {
            return HibernateUtil.inTxReturn(em -> {
                em.remove(em.find(entityType,id));
                return id;
            });
        }catch (HibernateException e){
            throw new RepositoryException("delete operation is failed => "+e.getMessage());
        }
    }

    @Override
    public T read(ID id) {
        try {
            return HibernateUtil.read(em -> {
                return em.find(entityType,id);
            });
        }catch (HibernateException e){
            throw new RepositoryException("read operation is failed => "+e.getMessage());
        }
    }

    @Override
    public List<T> findAll() {
        try {
            return HibernateUtil.read(em -> {
                return em.createQuery("from Product ",entityType)
                        .getResultList();
            });
        }catch (HibernateException e){
            throw new RepositoryException("find All operation is failed => "+e.getMessage());
        }
    }

    protected abstract void updateEntity(T newEntity, T dbEntity);
}
