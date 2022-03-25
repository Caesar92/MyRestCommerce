package com.example.myrestcommerce.dao.jpa;

import com.example.myrestcommerce.dao.base.DirectorDao;
import com.example.myrestcommerce.dao.base.UserDao;
import com.example.myrestcommerce.dao.entity.Director;
import com.example.myrestcommerce.dao.entity.Movie;
import com.example.myrestcommerce.dao.entity.User;
import com.example.myrestcommerce.dao.util.PersistenceManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;


public class JpaUserDao implements UserDao {

    @Override
    public Long add(User user) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(user);
            em.flush();
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
            return user.getId();
        }
    }

    @Override
    public void update(User user) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = PersistenceManager.getEntityManagerFactory().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(user);

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
    public User findById(Long id) {
        User u = null;
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("FROM User WHERE id = :id");
        query.setParameter("id", id);
        u = (User) query.getSingleResult();
        em.close();
        return u;
    }

    @Override
    public List<User> getAll() {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("FROM User ");
        List<User> users = query.getResultList();
        em.close();
        return users;

    }

    @Override
    public void remove(User user) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            if (em.contains(user)) {
                em.remove(user);
            } else {
                user = em.merge(user);
                em.remove(user);
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
            User u = em.find(User.class, id);
            em.remove(u);
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
    public void borrowMovie(Movie movie) {

    }

    @Override
    public void returnMovie(Movie movie) {

    }
}
