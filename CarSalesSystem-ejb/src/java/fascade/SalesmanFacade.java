/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fascade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Salesman;

/**
 *
 * @author wongtiksoon
 */
@Stateless
public class SalesmanFacade extends AbstractFacade<Salesman> {

    @PersistenceContext(unitName = "CarSalesSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SalesmanFacade() {
        super(Salesman.class);
    }
    
    public Salesman searchByUsername(String search){
        
        Salesman found = null;
        Query q = em.createQuery("SELECT a FROM Salesman a WHERE a.username = :username");
        q.setParameter("username", search);
        List<Salesman> all = q.getResultList();
        if(all.size()>0){
            found = all.get(0);
        }
        return found;
    }
    
    public List<Salesman> searchByName(String search){
        
        Query q = em.createQuery("SELECT a FROM Salesman a WHERE a.name LIKE CONCAT('%',:search,'%')");
        q.setParameter("search", search);
        List<Salesman> all = q.getResultList();
        
        return all;
    }
    
    public boolean checkStatus(String search){
       
        Query q = em.createQuery("SELECT a FROM Salesman a WHERE a.username = :username AND a.approved = 1");
        q.setParameter("username", search);
        List<Salesman> all = q.getResultList();
        
        return all.size()>0;
    }
    
    public List<Salesman> validSalesman(){
        
        Query q = em.createQuery("SELECT a FROM Salesman a WHERE a.approved = 1");
        List<Salesman> all = q.getResultList();
        
        return all;
    }
    
    public List<Salesman> searchedSalesman(String search, String filter){
        
        List<Salesman> all = null;
        if (filter.equals("approved")){
            Query q = em.createQuery("SELECT a FROM Salesman a WHERE a.approved = 1 AND "
                    + "(a.username LIKE CONCAT('%',:search,'%') "
                    + "OR a.name LIKE CONCAT('%',:search,'%') "
                    + "OR a.email LIKE CONCAT('%',:search,'%') "                
                    + "OR a.contact LIKE CONCAT('%',:search,'%')) ");
            q.setParameter("search", search);
            all = q.getResultList();
        } else if (filter.equals("notapproved")){
            Query q = em.createQuery("SELECT a FROM Salesman a WHERE a.approved = 0 AND "
                    + "(a.username LIKE CONCAT('%',:search,'%') "
                    + "OR a.name LIKE CONCAT('%',:search,'%') "
                    + "OR a.email LIKE CONCAT('%',:search,'%') "                
                    + "OR a.contact LIKE CONCAT('%',:search,'%')) ");
            q.setParameter("search", search);
            all = q.getResultList();
        } else {
            Query q = em.createQuery("SELECT a FROM Salesman a WHERE a.username LIKE CONCAT('%',:search,'%') "
                    + "OR a.name LIKE CONCAT('%',:search,'%') "
                    + "OR a.email LIKE CONCAT('%',:search,'%') "                
                    + "OR a.contact LIKE CONCAT('%',:search,'%')");
            q.setParameter("search", search);
            all = q.getResultList();
        }
        return all;
    }
    
    
    
}
