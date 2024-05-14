package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Customer;
import model.Salesman;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-08T16:17:54")
@StaticMetamodel(Car.class)
public class Car_ { 

    public static volatile SingularAttribute<Car, String> price;
    public static volatile SingularAttribute<Car, String> model;
    public static volatile SingularAttribute<Car, Salesman> salesman;
    public static volatile SingularAttribute<Car, String> caryear;
    public static volatile SingularAttribute<Car, Customer> bookedcustomer;
    public static volatile SingularAttribute<Car, String> brand;
    public static volatile SingularAttribute<Car, Long> carid;
    public static volatile SingularAttribute<Car, String> status;

}