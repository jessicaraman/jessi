package fr.digicar.backoffice.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractService<E, I> {

    @PersistenceContext()
    private EntityManager entityManager;

    private Class<E> type;

    protected AbstractService(Class<E> type) {
        this.type = type;
    }

    private EntityManager getEntityManager() {
        return this.entityManager;
    }

    public E findById(I id) {
        if (id == null)
            return null;
        return getEntityManager().find(type, id);
    }

    public void update(E entity) {
        getEntityManager().merge(entity);
    }

    public void create(E entity) {
        getEntityManager().persist(entity);
    }

    public void refresh(E entity) {
        getEntityManager().refresh(entity);
    }

    public void remove(E entity) {
        getEntityManager().remove(entity);
    }

}
