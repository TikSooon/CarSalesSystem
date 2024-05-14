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
import model.Customer;
import model.Salesman;

/**
 *
 * @author wongtiksoon
 */
@Stateless
public class CustomerFacade extends AbstractFacade<Customer> {

    @PersistenceContext(unitName = "CarSalesSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }
    
    public Customer searchByUsername(String search){
        
        Customer found = null;
        Query q = em.createQuery("SELECT a FROM Customer a WHERE a.username = :username");
        q.setParameter("username", search);
        List<Customer> all = q.getResultList();
        if(all.size()>0){
            found = all.get(0);
        }
        return found;
    }
    
    public boolean checkStatus(String search){
       
        Query q = em.createQuery("SELECT a FROM Customer a WHERE a.username = :username AND a.approved = 1");
        q.setParameter("username", search);
        List<Customer> all = q.getResultList();
        
        return all.size()>0;
    }
    
    public List<Customer> validCustomer(){
        
        Query q = em.createQuery("SELECT a FROM Customer a WHERE a.approved = 1");
        List<Customer> all = q.getResultList();
        
        return all;
    }
    
    public List<Customer> searchedCustomer(String search, String filter){
        
        List<Customer> all = null;
        if (filter.equals("approved")){
            Query q = em.createQuery("SELECT a FROM Customer a WHERE a.approved = 1 AND "
                    + "(a.username LIKE CONCAT('%',:search,'%') "
                    + "OR a.name LIKE CONCAT('%',:search,'%') "
                    + "OR a.email LIKE CONCAT('%',:search,'%') "                
                    + "OR a.contact LIKE CONCAT('%',:search,'%')) ");
            q.setParameter("search", search);
            all = q.getResultList();
        } else if (filter.equals("notapproved")){
            Query q = em.createQuery("SELECT a FROM Customer a WHERE a.approved = 0 AND "
                    + "(a.username LIKE CONCAT('%',:search,'%') "
                    + "OR a.name LIKE CONCAT('%',:search,'%') "
                    + "OR a.email LIKE CONCAT('%',:search,'%') "                
                    + "OR a.contact LIKE CONCAT('%',:search,'%')) ");
            q.setParameter("search", search);
            all = q.getResultList();
        } else if (filter.equals("all")){
            Query q = em.createQuery("SELECT a FROM Customer a WHERE a.username LIKE CONCAT('%',:search,'%') "
                    + "OR a.name LIKE CONCAT('%',:search,'%') "
                    + "OR a.email LIKE CONCAT('%',:search,'%') "                
                    + "OR a.contact LIKE CONCAT('%',:search,'%')");
            q.setParameter("search", search);
            all = q.getResultList();
        }
        return all;
    }
}
