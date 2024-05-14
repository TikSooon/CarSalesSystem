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
import model.Car;
import model.Customer;
import model.Salesman;

/**
 *
 * @author wongtiksoon
 */
@Stateless
public class CarFacade extends AbstractFacade<Car> {

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

    public CarFacade() {
        super(Car.class);
    }
    
    public List<Car> searchedCar(String search){
        Query q = em.createQuery("SELECT a FROM Car a WHERE a.brand LIKE CONCAT('%',:search,'%') "
                + "OR a.model LIKE CONCAT('%',:search,'%') "
                + "OR a.caryear LIKE CONCAT('%',:search,'%') "                
                + "OR a.price LIKE CONCAT('%',:search,'%')");
        q.setParameter("search", search);
        List<Car> all = q.getResultList();
        
        return all;
    }
    
    public List<Car> salesmanSearchCar(String search, long id){
        Salesman salesman = salesmanFacade.find(id);
        if (search == null){
            search = "";
        }
        Query q = em.createQuery("SELECT a FROM Car a WHERE a.salesman = :salesman AND "
                + "(a.brand LIKE CONCAT('%',:search,'%') "
                + "OR a.model LIKE CONCAT('%',:search,'%') "
                + "OR a.caryear LIKE CONCAT('%',:search,'%') "                
                + "OR a.price LIKE CONCAT('%',:search,'%'))");
        q.setParameter("search", search);
        q.setParameter("salesman", salesman);
        List<Car> all = q.getResultList();
        
        return all;
    }
    
    public List<Car> customerSearchCar(String search, long id){
        Customer customer = customerFacade.find(id);
        if (search == null){
            search = "";
        }
        Query q = em.createQuery("SELECT a FROM Car a WHERE a.bookedcustomer = :customer AND "
                + "(a.brand LIKE CONCAT('%',:search,'%') "
                + "OR a.model LIKE CONCAT('%',:search,'%') "
                + "OR a.caryear LIKE CONCAT('%',:search,'%') "                
                + "OR a.price LIKE CONCAT('%',:search,'%'))");
        q.setParameter("search", search);
        q.setParameter("customer", customer);
        List<Car> all = q.getResultList();
        
        return all;
    }
    
}
