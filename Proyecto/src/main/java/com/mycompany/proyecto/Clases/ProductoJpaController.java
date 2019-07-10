/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Clases;

import com.mycompany.proyecto.Clases.exceptions.IllegalOrphanException;
import com.mycompany.proyecto.Clases.exceptions.NonexistentEntityException;
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
 * @author pedro
 */
public class ProductoJpaController implements Serializable {

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) {
        if (producto.getDetallecomprasCollection() == null) {
            producto.setDetallecomprasCollection(new ArrayList<Detallecompras>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Detallecompras> attachedDetallecomprasCollection = new ArrayList<Detallecompras>();
            for (Detallecompras detallecomprasCollectionDetallecomprasToAttach : producto.getDetallecomprasCollection()) {
                detallecomprasCollectionDetallecomprasToAttach = em.getReference(detallecomprasCollectionDetallecomprasToAttach.getClass(), detallecomprasCollectionDetallecomprasToAttach.getId());
                attachedDetallecomprasCollection.add(detallecomprasCollectionDetallecomprasToAttach);
            }
            producto.setDetallecomprasCollection(attachedDetallecomprasCollection);
            em.persist(producto);
            for (Detallecompras detallecomprasCollectionDetallecompras : producto.getDetallecomprasCollection()) {
                Producto oldProductoIdproductoOfDetallecomprasCollectionDetallecompras = detallecomprasCollectionDetallecompras.getProductoIdproducto();
                detallecomprasCollectionDetallecompras.setProductoIdproducto(producto);
                detallecomprasCollectionDetallecompras = em.merge(detallecomprasCollectionDetallecompras);
                if (oldProductoIdproductoOfDetallecomprasCollectionDetallecompras != null) {
                    oldProductoIdproductoOfDetallecomprasCollectionDetallecompras.getDetallecomprasCollection().remove(detallecomprasCollectionDetallecompras);
                    oldProductoIdproductoOfDetallecomprasCollectionDetallecompras = em.merge(oldProductoIdproductoOfDetallecomprasCollectionDetallecompras);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getIdproducto());
            Collection<Detallecompras> detallecomprasCollectionOld = persistentProducto.getDetallecomprasCollection();
            Collection<Detallecompras> detallecomprasCollectionNew = producto.getDetallecomprasCollection();
            List<String> illegalOrphanMessages = null;
            for (Detallecompras detallecomprasCollectionOldDetallecompras : detallecomprasCollectionOld) {
                if (!detallecomprasCollectionNew.contains(detallecomprasCollectionOldDetallecompras)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Detallecompras " + detallecomprasCollectionOldDetallecompras + " since its productoIdproducto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Detallecompras> attachedDetallecomprasCollectionNew = new ArrayList<Detallecompras>();
            for (Detallecompras detallecomprasCollectionNewDetallecomprasToAttach : detallecomprasCollectionNew) {
                detallecomprasCollectionNewDetallecomprasToAttach = em.getReference(detallecomprasCollectionNewDetallecomprasToAttach.getClass(), detallecomprasCollectionNewDetallecomprasToAttach.getId());
                attachedDetallecomprasCollectionNew.add(detallecomprasCollectionNewDetallecomprasToAttach);
            }
            detallecomprasCollectionNew = attachedDetallecomprasCollectionNew;
            producto.setDetallecomprasCollection(detallecomprasCollectionNew);
            producto = em.merge(producto);
            for (Detallecompras detallecomprasCollectionNewDetallecompras : detallecomprasCollectionNew) {
                if (!detallecomprasCollectionOld.contains(detallecomprasCollectionNewDetallecompras)) {
                    Producto oldProductoIdproductoOfDetallecomprasCollectionNewDetallecompras = detallecomprasCollectionNewDetallecompras.getProductoIdproducto();
                    detallecomprasCollectionNewDetallecompras.setProductoIdproducto(producto);
                    detallecomprasCollectionNewDetallecompras = em.merge(detallecomprasCollectionNewDetallecompras);
                    if (oldProductoIdproductoOfDetallecomprasCollectionNewDetallecompras != null && !oldProductoIdproductoOfDetallecomprasCollectionNewDetallecompras.equals(producto)) {
                        oldProductoIdproductoOfDetallecomprasCollectionNewDetallecompras.getDetallecomprasCollection().remove(detallecomprasCollectionNewDetallecompras);
                        oldProductoIdproductoOfDetallecomprasCollectionNewDetallecompras = em.merge(oldProductoIdproductoOfDetallecomprasCollectionNewDetallecompras);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = producto.getIdproducto();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
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
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getIdproducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Detallecompras> detallecomprasCollectionOrphanCheck = producto.getDetallecomprasCollection();
            for (Detallecompras detallecomprasCollectionOrphanCheckDetallecompras : detallecomprasCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the Detallecompras " + detallecomprasCollectionOrphanCheckDetallecompras + " in its detallecomprasCollection field has a non-nullable productoIdproducto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    public Producto findProducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
