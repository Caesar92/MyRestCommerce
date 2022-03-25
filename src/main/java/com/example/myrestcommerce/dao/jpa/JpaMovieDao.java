package com.example.myrestcommerce.dao.jpa;

import com.example.myrestcommerce.dao.base.MovieDao;
import com.example.myrestcommerce.dao.entity.Movie;
import com.example.myrestcommerce.dao.util.PersistenceManager;

import jakarta.persistence.*;

import java.util.List;


public class JpaMovieDao implements MovieDao {

    @Override
    public Long add(Movie movie) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        System.out.println(movie);
        try {
            em.persist(movie);
            em.flush();
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
            return movie.getId();
        }
    }

    @Override
    public void update(Movie movie) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = PersistenceManager.getEntityManagerFactory().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(movie);

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
    public Movie findById(Long id) {
        Movie m = null;
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("FROM Movie WHERE id = :id");
        query.setParameter("id", id);
        m = (Movie) query.getSingleResult();
        em.close();
        return m;
    }

    @Override
    public List<Movie> getAll() {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        Query query = em.createQuery("FROM Movie");
        List<Movie> movies = query.getResultList();
        em.close();
        return movies;

    }

    @Override
    public void remove(Movie movie) {
        EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            if (em.contains(movie)) {
                em.remove(movie);
            } else {
                movie = em.merge(movie);
                em.remove(movie);
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
            Movie p = em.find(Movie.class, id);
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
}
