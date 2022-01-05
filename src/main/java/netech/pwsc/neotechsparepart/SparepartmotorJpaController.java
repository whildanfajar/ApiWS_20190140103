/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netech.pwsc.neotechsparepart;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import netech.pwsc.neotechsparepart.exceptions.NonexistentEntityException;
import netech.pwsc.neotechsparepart.exceptions.PreexistingEntityException;

/**
 *
 * @author whildan fajar
 */
public class SparepartmotorJpaController implements Serializable {

    public SparepartmotorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sparepartmotor sparepartmotor) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sparepartmotor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSparepartmotor(sparepartmotor.getIdSparepart()) != null) {
                throw new PreexistingEntityException("Sparepartmotor " + sparepartmotor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sparepartmotor sparepartmotor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sparepartmotor = em.merge(sparepartmotor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sparepartmotor.getIdSparepart();
                if (findSparepartmotor(id) == null) {
                    throw new NonexistentEntityException("The sparepartmotor with id " + id + " no longer exists.");
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
            Sparepartmotor sparepartmotor;
            try {
                sparepartmotor = em.getReference(Sparepartmotor.class, id);
                sparepartmotor.getIdSparepart();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sparepartmotor with id " + id + " no longer exists.", enfe);
            }
            em.remove(sparepartmotor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sparepartmotor> findSparepartmotorEntities() {
        return findSparepartmotorEntities(true, -1, -1);
    }

    public List<Sparepartmotor> findSparepartmotorEntities(int maxResults, int firstResult) {
        return findSparepartmotorEntities(false, maxResults, firstResult);
    }

    private List<Sparepartmotor> findSparepartmotorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sparepartmotor.class));
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

    public Sparepartmotor findSparepartmotor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sparepartmotor.class, id);
        } finally {
            em.close();
        }
    }

    public int getSparepartmotorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sparepartmotor> rt = cq.from(Sparepartmotor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
