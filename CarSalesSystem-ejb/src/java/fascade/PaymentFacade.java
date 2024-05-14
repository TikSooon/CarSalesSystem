/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fascade;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Customer;
import model.Payment;
import static model.Payment_.salesman;
import model.Salesman;

/**
 *
 * @author wongtiksoon
 */
@Stateless
public class PaymentFacade extends AbstractFacade<Payment> {

    @EJB
    private CustomerFacade customerFacade;

    @EJB
    private SalesmanFacade salesmanFacade;

    @PersistenceContext(unitName = "CarSalesSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaymentFacade() {
        super(Payment.class);
    }
    
    public List<Payment> salesmanSearchPayment(String search, long id){
        Salesman salesman = salesmanFacade.find(id);
        if (search == null){
            search = "";
        }
        Query q = em.createQuery("SELECT a FROM Payment a WHERE a.salesman = :salesman AND "
                    + "(a.date LIKE CONCAT('%',:search,'%') "
                    + "OR a.rating LIKE CONCAT('%',:search,'%') "
                    + "OR a.comment LIKE CONCAT('%',:search,'%') "                
                    + "OR a.feedback LIKE CONCAT('%',:search,'%')) ");
//                + "OR a.customer.name LIKE CONCAT('%',:search,'%'))");
        q.setParameter("search", search);
        q.setParameter("salesman", salesman);
        List<Payment> all = q.getResultList();
        
        return all;
    }
    
    public List<Payment> customerSearchPayment(String search, long id){
        Customer customer = customerFacade.find(id);
        if (search == null){
            search = "";
        }
         Query q = em.createQuery("SELECT a FROM Payment a WHERE a.customer = :customer AND "
                    + "(a.date LIKE CONCAT('%',:search,'%') "
                    + "OR a.rating LIKE CONCAT('%',:search,'%') "
                    + "OR a.comment LIKE CONCAT('%',:search,'%') "                
                    + "OR a.feedback LIKE CONCAT('%',:search,'%')) ");
//                + "OR a.customer.name LIKE CONCAT('%',:search,'%'))");
        q.setParameter("search", search);
        q.setParameter("customer", customer);
        List<Payment> all = q.getResultList();
        
        return all;
    }
    
    public List<Payment> searchPayment(String search){
        if (search == null){
            search = "";
        }
        Query q = em.createQuery("SELECT a FROM Payment a WHERE "
                    + "(a.date LIKE CONCAT('%',:search,'%') "
                    + "OR a.rating LIKE CONCAT('%',:search,'%') "
                    + "OR a.comment LIKE CONCAT('%',:search,'%') "                
                    + "OR a.feedback LIKE CONCAT('%',:search,'%')) ");
        q.setParameter("search", search);
        List<Payment> all = q.getResultList();
        
        return all;
    }
}
