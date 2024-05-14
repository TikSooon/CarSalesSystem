/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author wongtiksoon
 */
@Entity
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carid;
    private String brand;
    private String model;
    private String caryear;
    private String price;
    private String status;

    public Car(String brand, String model, String caryear, String price, String status, Salesman salesman, Customer bookedcustomer) {
        this.brand = brand;
        this.model = model;
        this.caryear = caryear;
        this.price = price;
        this.status = status;
        this.salesman = salesman;
        this.bookedcustomer = bookedcustomer;
    }
    
    public Car(){}
    
    public Car(String brand, String model, String caryear, String price, String status, Salesman salesman) {
        this.brand = brand;
        this.model = model;
        this.caryear = caryear;
        this.price = price;
        this.status = status;
        this.salesman = salesman;
    }

    public Long getCarid() {
        return carid;
    }

    public void setCarid(Long carid) {
        this.carid = carid;
    }
    
    @ManyToOne
    @JoinColumn(name = "salesmanid")
    private Salesman salesman;
    
    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer bookedcustomer;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCaryear() {
        return caryear;
    }

    public void setCaryear(String caryear) {
        this.caryear = caryear;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public Customer getBookedcustomer() {
        return bookedcustomer;
    }

    public void setBookedcustomer(Customer bookedcustomer) {
        this.bookedcustomer = bookedcustomer;
    }
    

    public Long getId() {
        return carid;
    }

    public void setId(Long id) {
        this.carid = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carid != null ? carid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.carid == null && other.carid != null) || (this.carid != null && !this.carid.equals(other.carid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Car[ id=" + carid + " ]";
    }
    
}
