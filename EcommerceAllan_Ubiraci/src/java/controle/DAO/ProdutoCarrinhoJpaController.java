/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle.DAO;

import Dominio.ProdutoCarrinho;
import controle.DAO.exceptions.NonexistentEntityException;
import controle.DAO.exceptions.PreexistingEntityException;
import controle.DAO.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author allan
 */
public class ProdutoCarrinhoJpaController implements Serializable {

    public ProdutoCarrinhoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    public void create(ProdutoCarrinho produtoCarrinho) throws RollbackFailureException, PreexistingEntityException{
        EntityManager em = null;
        EntityTransaction utx = null;
        try {
            em = getEntityManager();
            utx = em.getTransaction();
            utx.begin();
            em.persist(produtoCarrinho);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findProdutoCarrinho(produtoCarrinho.getId()) != null) {
                throw new PreexistingEntityException("ProdutoCarrinho " + produtoCarrinho + " already exists.", ex);
            }
            //throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }        

    
    public void edit(ProdutoCarrinho produtoCarrinho) throws RollbackFailureException{
        
        EntityManager em = null;
        EntityTransaction utx = null;
        try {
            em = getEntityManager();
            utx = em.getTransaction();
            utx.begin();
            produtoCarrinho = em.merge(produtoCarrinho);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            //throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }    


    public void destroy(Long id) throws RollbackFailureException{
        EntityManager em = null;
        EntityTransaction utx = null;
        try {
            em = getEntityManager();
            utx = em.getTransaction();
            utx.begin();
            ProdutoCarrinho produtoCarrinho = em.getReference(ProdutoCarrinho.class, id);
            em.remove(produtoCarrinho);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            //throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }      

    public List<ProdutoCarrinho> findProdutoCarrinhoEntities() {
        return findProdutoCarrinhoEntities(true, -1, -1);
    }

    public List<ProdutoCarrinho> findProdutoCarrinhoEntities(int maxResults, int firstResult) {
        return findProdutoCarrinhoEntities(false, maxResults, firstResult);
    }

    private List<ProdutoCarrinho> findProdutoCarrinhoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProdutoCarrinho.class));
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

    public ProdutoCarrinho findProdutoCarrinho(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProdutoCarrinho.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutoCarrinhoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProdutoCarrinho> rt = cq.from(ProdutoCarrinho.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
