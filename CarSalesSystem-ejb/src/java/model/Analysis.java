/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author wongtiksoon
 */
public class Analysis {
    
    private Salesman sales;
    private String price;
    private String carsold;
    private String rating;

    public Analysis(Salesman sales, String price, String carsold, String averagerating) {
        this.sales = sales;
        this.price = price;
        this.carsold = carsold;
        this.rating = averagerating;
    }

    public Salesman getSales() {
        return sales;
    }

    public void setSales(Salesman sales) {
        this.sales = sales;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCarsold() {
        return carsold;
    }

    public void setCarsold(String carsold) {
        this.carsold = carsold;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    
    
    Analysis(){}
}
