package com.startup.beans;

public class Product {

    private int id;
    private String name;
    private String desc;
    private double price;
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId( int id ) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName( String name ) {
        this.name = name;
    }
    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }
    /**
     * @param desc the desc to set
     */
    public void setDesc( String desc ) {
        this.desc = desc;
    }
   
    /**
     * @return the priceValue
     */
    public double getPrice() {
        return price;
    }
    /**
     * @param priceValue the priceValue to set
     */
    public void setPrice( double price ) {
        this.price = price;
    }
    
    
    
}
