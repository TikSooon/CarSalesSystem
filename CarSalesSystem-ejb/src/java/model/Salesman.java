/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author wongtiksoon
 */
@Entity
public class Salesman implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long salesmanid;
    private String username;
    private String name;
    private String password;
    private String email;

    public Long getSalesmanid() {
        return salesmanid;
    }

    public void setSalesmanid(Long salesmanid) {
        this.salesmanid = salesmanid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Car> getCar() {
        return car;
    }

    public void setCar(Collection<Car> car) {
        this.car = car;
    }

    public Collection<Payment> getPayment() {
        return payment;
    }

    public void setPayment(Collection<Payment> payment) {
        this.payment = payment;
    }
    private String contact;
    private boolean approved;
    
    @OneToMany(mappedBy = "salesman")
    private Collection<Car> car;
    
    @OneToMany(mappedBy = "salesman")
    private Collection<Payment> payment;

    public Salesman( String username, String name, String password, String email, String contact, boolean approved) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.contact = contact;
        this.approved = approved;
    }

    public Salesman(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    
    public Long getId() {
        return salesmanid;
    }

    public void setId(Long id) {
        this.salesmanid = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesmanid != null ? salesmanid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salesman)) {
            return false;
        }
        Salesman other = (Salesman) object;
        if ((this.salesmanid == null && other.salesmanid != null) || (this.salesmanid != null && !this.salesmanid.equals(other.salesmanid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Salesman[ id=" + salesmanid + " ]";
    }
    
}
