package ir.maktabsharif.util;

import ir.maktabsharif.exception.HibernateException;
import jakarta.persistence.*;

import java.util.function.Function;

public class HibernateUtil {

    private static final String PERSISTENCE_UNIT = "";


    private static EntityManagerFactory emf;


    private synchronized static EntityManagerFactory getEmf() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf;
    }


    public static EntityManager getEm() {
        return getEmf().createEntityManager();
    }


    public static <T> T inTxReturn(Function<EntityManager, T> operation) {
        EntityManager em = getEm();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            T result = operation.apply(em);
            tx.commit();
            return result;
        } catch (PersistenceException e) {
            throw new HibernateException("hibernate connection is failed ! => " + e.getMessage());
        }
    }

    public static <T> T read(Function<EntityManager, T> operation) {
        EntityManager em = getEm();
        try {
            return operation.apply(em);
        } catch (PersistenceException e) {
            throw new HibernateException("hibernate connection is failed read ! => " + e.getMessage());
        }
    }


}
