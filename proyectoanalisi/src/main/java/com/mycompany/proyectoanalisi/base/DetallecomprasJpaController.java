/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoanalisi.base;

import com.mycompany.proyectoanalisi.base.exceptions.IllegalOrphanException;
import com.mycompany.proyectoanalisi.base.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author EQUIPO
 */
public class DetallecomprasJpaController implements Serializable {

    public DetallecomprasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Detallecompras detallecompras) {
        if (detallecompras.getDevolucionesCollection() == null) {
            detallecompras.setDevolucionesCollection(new ArrayList<Devoluciones>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compras comprasIdcompras = detallecompras.getComprasIdcompras();
            if (comprasIdcompras != null) {
                comprasIdcompras = em.getReference(comprasIdcompras.getClass(), comprasIdcompras.getIdcompras());
                detallecompras.setComprasIdcompras(comprasIdcompras);
            }
            Producto productoIdproducto = detallecompras.getProductoIdproducto();
            if (productoIdproducto != null) {
                productoIdproducto = em.getReference(productoIdproducto.getClass(), productoIdproducto.getIdproducto());
                detallecompras.setProductoIdproducto(productoIdproducto);
            }
            Collection<Devoluciones> attachedDevolucionesCollection = new ArrayList<Devoluciones>();
            for (Devoluciones devolucionesCollectionDevolucionesToAttach : detallecompras.getDevolucionesCollection()) {
                devolucionesCollectionDevolucionesToAttach = em.getReference(devolucionesCollectionDevolucionesToAttach.getClass(), devolucionesCollectionDevolucionesToAttach.getIddevoluciones());
                attachedDevolucionesCollection.add(devolucionesCollectionDevolucionesToAttach);
            }
            detallecompras.setDevolucionesCollection(attachedDevolucionesCollection);
            em.persist(detallecompras);
            if (comprasIdcompras != null) {
                comprasIdcompras.getDetallecomprasCollection().add(detallecompras);
                comprasIdcompras = em.merge(comprasIdcompras);
            }
            if (productoIdproducto != null) {
                productoIdproducto.getDetallecomprasCollection().add(detallecompras);
                productoIdproducto = em.merge(productoIdproducto);
            }
            for (Devoluciones devolucionesCollectionDevoluciones : detallecompras.getDevolucionesCollection()) {
                Detallecompras oldDetallecomprasIdOfDevolucionesCollectionDevoluciones = devolucionesCollectionDevoluciones.getDetallecomprasId();
                devolucionesCollectionDevoluciones.setDetallecomprasId(detallecompras);
                devolucionesCollectionDevoluciones = em.merge(devolucionesCollectionDevoluciones);
                if (oldDetallecomprasIdOfDevolucionesCollectionDevoluciones != null) {
                    oldDetallecomprasIdOfDevolucionesCollectionDevoluciones.getDevolucionesCollection().remove(devolucionesCollectionDevoluciones);
                    oldDetallecomprasIdOfDevolucionesCollectionDevoluciones = em.merge(oldDetallecomprasIdOfDevolucionesCollectionDevoluciones);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Detallecompras detallecompras) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Detallecompras persistentDetallecompras = em.find(Detallecompras.class, detallecompras.getId());
            Compras comprasIdcomprasOld = persistentDetallecompras.getComprasIdcompras();
            Compras comprasIdcomprasNew = detallecompras.getComprasIdcompras();
            Producto productoIdproductoOld = persistentDetallecompras.getProductoIdproducto();
            Producto productoIdproductoNew = detallecompras.getProductoIdproducto();
            Collection<Devoluciones> devolucionesCollectionOld = persistentDetallecompras.getDevolucionesCollection();
            Collection<Devoluciones> devolucionesCollectionNew = detallecompras.getDevolucionesCollection();
            List<String> illegalOrphanMessages = null;
            for (Devoluciones devolucionesCollectionOldDevoluciones : devolucionesCollectionOld) {
                if (!devolucionesCollectionNew.contains(devolucionesCollectionOldDevoluciones)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Devoluciones " + devolucionesCollectionOldDevoluciones + " since its detallecomprasId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (comprasIdcomprasNew != null) {
                comprasIdcomprasNew = em.getReference(comprasIdcomprasNew.getClass(), comprasIdcomprasNew.getIdcompras());
                detallecompras.setComprasIdcompras(comprasIdcomprasNew);
            }
            if (productoIdproductoNew != null) {
                productoIdproductoNew = em.getReference(productoIdproductoNew.getClass(), productoIdproductoNew.getIdproducto());
                detallecompras.setProductoIdproducto(productoIdproductoNew);
            }
            Collection<Devoluciones> attachedDevolucionesCollectionNew = new ArrayList<Devoluciones>();
            for (Devoluciones devolucionesCollectionNewDevolucionesToAttach : devolucionesCollectionNew) {
                devolucionesCollectionNewDevolucionesToAttach = em.getReference(devolucionesCollectionNewDevolucionesToAttach.getClass(), devolucionesCollectionNewDevolucionesToAttach.getIddevoluciones());
                attachedDevolucionesCollectionNew.add(devolucionesCollectionNewDevolucionesToAttach);
            }
            devolucionesCollectionNew = attachedDevolucionesCollectionNew;
            detallecompras.setDevolucionesCollection(devolucionesCollectionNew);
            detallecompras = em.merge(detallecompras);
            if (comprasIdcomprasOld != null && !comprasIdcomprasOld.equals(comprasIdcomprasNew)) {
                comprasIdcomprasOld.getDetallecomprasCollection().remove(detallecompras);
                comprasIdcomprasOld = em.merge(comprasIdcomprasOld);
            }
            if (comprasIdcomprasNew != null && !comprasIdcomprasNew.equals(comprasIdcomprasOld)) {
                comprasIdcomprasNew.getDetallecomprasCollection().add(detallecompras);
                comprasIdcomprasNew = em.merge(comprasIdcomprasNew);
            }
            if (productoIdproductoOld != null && !productoIdproductoOld.equals(productoIdproductoNew)) {
                productoIdproductoOld.getDetallecomprasCollection().remove(detallecompras);
                productoIdproductoOld = em.merge(productoIdproductoOld);
            }
            if (productoIdproductoNew != null && !productoIdproductoNew.equals(productoIdproductoOld)) {
                productoIdproductoNew.getDetallecomprasCollection().add(detallecompras);
                productoIdproductoNew = em.merge(productoIdproductoNew);
            }
            for (Devoluciones devolucionesCollectionNewDevoluciones : devolucionesCollectionNew) {
                if (!devolucionesCollectionOld.contains(devolucionesCollectionNewDevoluciones)) {
                    Detallecompras oldDetallecomprasIdOfDevolucionesCollectionNewDevoluciones = devolucionesCollectionNewDevoluciones.getDetallecomprasId();
                    devolucionesCollectionNewDevoluciones.setDetallecomprasId(detallecompras);
                    devolucionesCollectionNewDevoluciones = em.merge(devolucionesCollectionNewDevoluciones);
                    if (oldDetallecomprasIdOfDevolucionesCollectionNewDevoluciones != null && !oldDetallecomprasIdOfDevolucionesCollectionNewDevoluciones.equals(detallecompras)) {
                        oldDetallecomprasIdOfDevolucionesCollectionNewDevoluciones.getDevolucionesCollection().remove(devolucionesCollectionNewDevoluciones);
                        oldDetallecomprasIdOfDevolucionesCollectionNewDevoluciones = em.merge(oldDetallecomprasIdOfDevolucionesCollectionNewDevoluciones);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = detallecompras.getId();
                if (findDetallecompras(id) == null) {
                    throw new NonexistentEntityException("The detallecompras with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Detallecompras detallecompras;
            try {
                detallecompras = em.getReference(Detallecompras.class, id);
                detallecompras.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detallecompras with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Devoluciones> devolucionesCollectionOrphanCheck = detallecompras.getDevolucionesCollection();
            for (Devoluciones devolucionesCollectionOrphanCheckDevoluciones : devolucionesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Detallecompras (" + detallecompras + ") cannot be destroyed since the Devoluciones " + devolucionesCollectionOrphanCheckDevoluciones + " in its devolucionesCollection field has a non-nullable detallecomprasId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Compras comprasIdcompras = detallecompras.getComprasIdcompras();
            if (comprasIdcompras != null) {
                comprasIdcompras.getDetallecomprasCollection().remove(detallecompras);
                comprasIdcompras = em.merge(comprasIdcompras);
            }
            Producto productoIdproducto = detallecompras.getProductoIdproducto();
            if (productoIdproducto != null) {
                productoIdproducto.getDetallecomprasCollection().remove(detallecompras);
                productoIdproducto = em.merge(productoIdproducto);
            }
            em.remove(detallecompras);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Detallecompras> findDetallecomprasEntities() {
        return findDetallecomprasEntities(true, -1, -1);
    }

    public List<Detallecompras> findDetallecomprasEntities(int maxResults, int firstResult) {
        return findDetallecomprasEntities(false, maxResults, firstResult);
    }

    private List<Detallecompras> findDetallecomprasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Detallecompras.class));
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

    public Detallecompras findDetallecompras(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Detallecompras.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetallecomprasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Detallecompras> rt = cq.from(Detallecompras.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
