/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Clases;

import com.mycompany.proyecto.Clases.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author pedro
 */
public class DevolucionesJpaController implements Serializable {

    public DevolucionesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Devoluciones devoluciones) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Detallecompras detallecomprasId = devoluciones.getDetallecomprasId();
            if (detallecomprasId != null) {
                detallecomprasId = em.getReference(detallecomprasId.getClass(), detallecomprasId.getId());
                devoluciones.setDetallecomprasId(detallecomprasId);
            }
            em.persist(devoluciones);
            if (detallecomprasId != null) {
                detallecomprasId.getDevolucionesCollection().add(devoluciones);
                detallecomprasId = em.merge(detallecomprasId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Devoluciones devoluciones) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Devoluciones persistentDevoluciones = em.find(Devoluciones.class, devoluciones.getIddevoluciones());
            Detallecompras detallecomprasIdOld = persistentDevoluciones.getDetallecomprasId();
            Detallecompras detallecomprasIdNew = devoluciones.getDetallecomprasId();
            if (detallecomprasIdNew != null) {
                detallecomprasIdNew = em.getReference(detallecomprasIdNew.getClass(), detallecomprasIdNew.getId());
                devoluciones.setDetallecomprasId(detallecomprasIdNew);
            }
            devoluciones = em.merge(devoluciones);
            if (detallecomprasIdOld != null && !detallecomprasIdOld.equals(detallecomprasIdNew)) {
                detallecomprasIdOld.getDevolucionesCollection().remove(devoluciones);
                detallecomprasIdOld = em.merge(detallecomprasIdOld);
            }
            if (detallecomprasIdNew != null && !detallecomprasIdNew.equals(detallecomprasIdOld)) {
                detallecomprasIdNew.getDevolucionesCollection().add(devoluciones);
                detallecomprasIdNew = em.merge(detallecomprasIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = devoluciones.getIddevoluciones();
                if (findDevoluciones(id) == null) {
                    throw new NonexistentEntityException("The devoluciones with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Devoluciones devoluciones;
            try {
                devoluciones = em.getReference(Devoluciones.class, id);
                devoluciones.getIddevoluciones();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The devoluciones with id " + id + " no longer exists.", enfe);
            }
            Detallecompras detallecomprasId = devoluciones.getDetallecomprasId();
            if (detallecomprasId != null) {
                detallecomprasId.getDevolucionesCollection().remove(devoluciones);
                detallecomprasId = em.merge(detallecomprasId);
            }
            em.remove(devoluciones);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Devoluciones> findDevolucionesEntities() {
        return findDevolucionesEntities(true, -1, -1);
    }

    public List<Devoluciones> findDevolucionesEntities(int maxResults, int firstResult) {
        return findDevolucionesEntities(false, maxResults, firstResult);
    }

    private List<Devoluciones> findDevolucionesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Devoluciones.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Devoluciones findDevoluciones(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Devoluciones.class, id);
        } finally {
            em.close();
        }
    }

    public int getDevolucionesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Devoluciones> rt = cq.from(Devoluciones.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
