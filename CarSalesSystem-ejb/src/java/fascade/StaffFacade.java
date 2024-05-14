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
import model.Staff;

/**
 *
 * @author wongtiksoon
 */
@Stateless
public class StaffFacade extends AbstractFacade<Staff> {

    @PersistenceContext(unitName = "CarSalesSystem-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StaffFacade() {
        super(Staff.class);
    }
    
    public Staff searchByUsername(String search){
        
        Staff found = null;
        Query q = em.createQuery("SELECT a FROM Staff a WHERE a.username = :username");
        q.setParameter("username", search);
        List<Staff> all = q.getResultList();
        if(all.size()>0){
            found = all.get(0);
        }
        return found;
    }
    
    public List<Staff> searchedStaff(String search){
        
        Query q = em.createQuery("SELECT a FROM Staff a WHERE a.username LIKE CONCAT('%',:search,'%') "
                + "OR a.name LIKE CONCAT('%',:search,'%') "
                + "OR a.email LIKE CONCAT('%',:search,'%') "                
                + "OR a.contact LIKE CONCAT('%',:search,'%')");
        q.setParameter("search", search);
        List<Staff> all = q.getResultList();
        
        return all;
    }
    
    
}
