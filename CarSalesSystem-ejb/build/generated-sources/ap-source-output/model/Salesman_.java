package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Car;
import model.Payment;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-03-08T16:17:54")
@StaticMetamodel(Salesman.class)
public class Salesman_ { 

    public static volatile SingularAttribute<Salesman, Long> salesmanid;
    public static volatile SingularAttribute<Salesman, String> password;
    public static volatile SingularAttribute<Salesman, Boolean> approved;
    public static volatile CollectionAttribute<Salesman, Car> car;
    public static volatile SingularAttribute<Salesman, String> contact;
    public static volatile SingularAttribute<Salesman, String> name;
    public static volatile CollectionAttribute<Salesman, Payment> payment;
    public static volatile SingularAttribute<Salesman, String> email;
    public static volatile SingularAttribute<Salesman, String> username;

}