package com.example.myrestcommerce.dao.jpa;

import com.example.myrestcommerce.dao.base.DirectorDao;
import com.example.myrestcommerce.dao.base.MovieDao;
import com.example.myrestcommerce.dao.entity.Director;
import com.example.myrestcommerce.dao.entity.Movie;
import com.example.myrestcommerce.dao.util.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;


public class JpaDirectorDao implements DirectorDao {

    @Override
    public Long add(Director director) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(director);
            em.flush();
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
            return director.getId();
        }
    }

    @Override
    public void update(Director director) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = PersistenceManager.getEntityManagerFactory().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(director);

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if(transaction != null)
                transaction.rollback();
        } finally {
            if(em != null)
                em.close();
        }
    }

    @Override
    public Director findById(Long id) {
        Director d = null;
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("FROM Director WHERE id = :id");
        query.setParameter("id", id);
        d = (Director) query.getSingleResult();
        em.close();
        return d;
    }

    @Override
    public List<Director> getAll() {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("FROM Director");
        List<Director> directors = query.getResultList();
        em.close();
        return directors;

    }

    @Override
    public void remove(Director director) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            if (em.contains(director)) {
                em.remove(director);
            } else {
                director = em.merge(director);
                em.remove(director);
            }
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public void remove(Long id) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Director p = em.find(Director.class, id);
            em.remove(p);
            et.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public Long realizeMovie(Movie movie) {
        return null;
    }
}
