/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import Analisis.exceptions.IllegalOrphanException;
import Analisis.exceptions.NonexistentEntityException;
import Bases.Compras;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Bases.Proveedor;
import Bases.Detallecompras;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author pedro
 */
public class ComprasJpaController implements Serializable {

    public ComprasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Compras compras) {
        if (compras.getDetallecomprasCollection() == null) {
            compras.setDetallecomprasCollection(new ArrayList<Detallecompras>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor proveedorIdproveedor = compras.getProveedorIdproveedor();
            if (proveedorIdproveedor != null) {
                proveedorIdproveedor = em.getReference(proveedorIdproveedor.getClass(), proveedorIdproveedor.getIdproveedor());
                compras.setProveedorIdproveedor(proveedorIdproveedor);
            }
            Collection<Detallecompras> attachedDetallecomprasCollection = new ArrayList<Detallecompras>();
            for (Detallecompras detallecomprasCollectionDetallecomprasToAttach : compras.getDetallecomprasCollection()) {
                detallecomprasCollectionDetallecomprasToAttach = em.getReference(detallecomprasCollectionDetallecomprasToAttach.getClass(), detallecomprasCollectionDetallecomprasToAttach.getId());
                attachedDetallecomprasCollection.add(detallecomprasCollectionDetallecomprasToAttach);
            }
            compras.setDetallecomprasCollection(attachedDetallecomprasCollection);
            em.persist(compras);
            if (proveedorIdproveedor != null) {
                proveedorIdproveedor.getComprasCollection().add(compras);
                proveedorIdproveedor = em.merge(proveedorIdproveedor);
            }
            for (Detallecompras detallecomprasCollectionDetallecompras : compras.getDetallecomprasCollection()) {
                Compras oldComprasIdcomprasOfDetallecomprasCollectionDetallecompras = detallecomprasCollectionDetallecompras.getComprasIdcompras();
                detallecomprasCollectionDetallecompras.setComprasIdcompras(compras);
                detallecomprasCollectionDetallecompras = em.merge(detallecomprasCollectionDetallecompras);
                if (oldComprasIdcomprasOfDetallecomprasCollectionDetallecompras != null) {
                    oldComprasIdcomprasOfDetallecomprasCollectionDetallecompras.getDetallecomprasCollection().remove(detallecomprasCollectionDetallecompras);
                    oldComprasIdcomprasOfDetallecomprasCollectionDetallecompras = em.merge(oldComprasIdcomprasOfDetallecomprasCollectionDetallecompras);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Compras compras) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compras persistentCompras = em.find(Compras.class, compras.getIdcompras());
            Proveedor proveedorIdproveedorOld = persistentCompras.getProveedorIdproveedor();
            Proveedor proveedorIdproveedorNew = compras.getProveedorIdproveedor();
            Collection<Detallecompras> detallecomprasCollectionOld = persistentCompras.getDetallecomprasCollection();
            Collection<Detallecompras> detallecomprasCollectionNew = compras.getDetallecomprasCollection();
            List<String> illegalOrphanMessages = null;
            for (Detallecompras detallecomprasCollectionOldDetallecompras : detallecomprasCollectionOld) {
                if (!detallecomprasCollectionNew.contains(detallecomprasCollectionOldDetallecompras)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Detallecompras " + detallecomprasCollectionOldDetallecompras + " since its comprasIdcompras field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (proveedorIdproveedorNew != null) {
                proveedorIdproveedorNew = em.getReference(proveedorIdproveedorNew.getClass(), proveedorIdproveedorNew.getIdproveedor());
                compras.setProveedorIdproveedor(proveedorIdproveedorNew);
            }
            Collection<Detallecompras> attachedDetallecomprasCollectionNew = new ArrayList<Detallecompras>();
            for (Detallecompras detallecomprasCollectionNewDetallecomprasToAttach : detallecomprasCollectionNew) {
                detallecomprasCollectionNewDetallecomprasToAttach = em.getReference(detallecomprasCollectionNewDetallecomprasToAttach.getClass(), detallecomprasCollectionNewDetallecomprasToAttach.getId());
                attachedDetallecomprasCollectionNew.add(detallecomprasCollectionNewDetallecomprasToAttach);
            }
            detallecomprasCollectionNew = attachedDetallecomprasCollectionNew;
            compras.setDetallecomprasCollection(detallecomprasCollectionNew);
            compras = em.merge(compras);
            if (proveedorIdproveedorOld != null && !proveedorIdproveedorOld.equals(proveedorIdproveedorNew)) {
                proveedorIdproveedorOld.getComprasCollection().remove(compras);
                proveedorIdproveedorOld = em.merge(proveedorIdproveedorOld);
            }
            if (proveedorIdproveedorNew != null && !proveedorIdproveedorNew.equals(proveedorIdproveedorOld)) {
                proveedorIdproveedorNew.getComprasCollection().add(compras);
                proveedorIdproveedorNew = em.merge(proveedorIdproveedorNew);
            }
            for (Detallecompras detallecomprasCollectionNewDetallecompras : detallecomprasCollectionNew) {
                if (!detallecomprasCollectionOld.contains(detallecomprasCollectionNewDetallecompras)) {
                    Compras oldComprasIdcomprasOfDetallecomprasCollectionNewDetallecompras = detallecomprasCollectionNewDetallecompras.getComprasIdcompras();
                    detallecomprasCollectionNewDetallecompras.setComprasIdcompras(compras);
                    detallecomprasCollectionNewDetallecompras = em.merge(detallecomprasCollectionNewDetallecompras);
                    if (oldComprasIdcomprasOfDetallecomprasCollectionNewDetallecompras != null && !oldComprasIdcomprasOfDetallecomprasCollectionNewDetallecompras.equals(compras)) {
                        oldComprasIdcomprasOfDetallecomprasCollectionNewDetallecompras.getDetallecomprasCollection().remove(detallecomprasCollectionNewDetallecompras);
                        oldComprasIdcomprasOfDetallecomprasCollectionNewDetallecompras = em.merge(oldComprasIdcomprasOfDetallecomprasCollectionNewDetallecompras);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = compras.getIdcompras();
                if (findCompras(id) == null) {
                    throw new NonexistentEntityException("The compras with id " + id + " no longer exists.");
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
            Compras compras;
            try {
                compras = em.getReference(Compras.class, id);
                compras.getIdcompras();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The compras with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Detallecompras> detallecomprasCollectionOrphanCheck = compras.getDetallecomprasCollection();
            for (Detallecompras detallecomprasCollectionOrphanCheckDetallecompras : detallecomprasCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Compras (" + compras + ") cannot be destroyed since the Detallecompras " + detallecomprasCollectionOrphanCheckDetallecompras + " in its detallecomprasCollection field has a non-nullable comprasIdcompras field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Proveedor proveedorIdproveedor = compras.getProveedorIdproveedor();
            if (proveedorIdproveedor != null) {
                proveedorIdproveedor.getComprasCollection().remove(compras);
                proveedorIdproveedor = em.merge(proveedorIdproveedor);
            }
            em.remove(compras);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Compras> findComprasEntities() {
        return findComprasEntities(true, -1, -1);
    }

    public List<Compras> findComprasEntities(int maxResults, int firstResult) {
        return findComprasEntities(false, maxResults, firstResult);
    }

    private List<Compras> findComprasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Compras.class));
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

    public Compras findCompras(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compras.class, id);
        } finally {
            em.close();
        }
    }

    public int getComprasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Compras> rt = cq.from(Compras.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
