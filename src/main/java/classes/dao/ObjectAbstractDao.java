package classes.dao;

import classes.manager.DaoManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;

public abstract class ObjectAbstractDao<T extends Serializable> {
    EntityManager entityManager = DaoManager.getEntityManager();

    public void create( T entity){
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist( entity );
        tx.commit();
    }
    public T findOne(int id,Class<T> tClass){
        return entityManager.find(tClass,id);
    }
    public List<T> findAll(Class<T> tClass){
        return entityManager.createQuery( "from " + tClass.getName() )
                .getResultList();
    }
    public T update(T object){
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        T entityMerged = entityManager.merge(object);
        tx.commit();
        return entityMerged;
    }
    public void delete(T object){
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(object);
        tx.commit();
    }

}
