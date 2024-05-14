package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Car;
import model.Customer;
import model.Salesman;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-08T16:17:54")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, String> date;
    public static volatile SingularAttribute<Payment, String> feedback;
    public static volatile SingularAttribute<Payment, Car> car;
    public static volatile SingularAttribute<Payment, Long> paymentid;
    public static volatile SingularAttribute<Payment, String> rating;
    public static volatile SingularAttribute<Payment, Salesman> salesman;
    public static volatile SingularAttribute<Payment, String> comment;
    public static volatile SingularAttribute<Payment, Customer> customer;

}