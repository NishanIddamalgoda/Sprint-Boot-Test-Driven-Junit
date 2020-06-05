package com.service.price.models;

public class ItemPrice {
    public int units;
    public int cartons;
    public double unit_price;
    public double carton_price;
    public double carton_discounted_price;
    public double tot_price_unit;
    public double tot_price_carton;
    public double total_price;

    // calculate full total considering units
    public void calculateTotalByUnits(Item itm) {
        setUnits(itm);
        setCartons(itm);
        setUnitPrice(itm);
        setCartonPrice(itm);
        setCartonDiscount(itm);
        setTotalpriceUnits();
        setTotalpriceCartons();
        this.total_price = this.tot_price_unit + this.tot_price_carton;
    }

    // calculate full total considering cartons
    public void calculateTotalByCarton(Item itm) {
        this.units = 0;
        this.cartons = itm.getCurrent_selected_units();
        setUnitPrice(itm);
        setCartonPrice(itm);
        setCartonDiscount(itm);
        setTotalpriceUnits();
        setTotalpriceCartons();
        this.total_price = this.tot_price_unit + this.tot_price_carton;
    }

    // set number of units
    private void setUnits(Item itm) {
        this.units = itm.getCurrent_selected_units() % itm.getUnits_p_carton();
    }

    // set number of cartons
    private void setCartons(Item itm) {
        this.cartons = itm.getCurrent_selected_units() / itm.getUnits_p_carton();
    }

    // set unit price
    private void setUnitPrice(Item itm) {
        this.unit_price = (itm.getCarton_price() * itm.getSingle_unit_increment()) / itm.getUnits_p_carton();
    }

    // set carton price
    private void setCartonPrice(Item itm) {
        this.carton_price = itm.getCarton_price();
    }

    // set carton discount if carton qty is eligible for dicount
    private void setCartonDiscount(Item itm) {
        if (this.cartons >= itm.getCarton_dicnt_qty()) {
            this.carton_discounted_price = this.carton_price * (itm.getCarton_dicnt_percnt() / 100);
        } else {
            this.carton_discounted_price = 0;
        }
    }

    // set total price for units
    private void setTotalpriceUnits() {
        this.tot_price_unit = this.unit_price * this.units;
    }

    // set total price for cartons
    private void setTotalpriceCartons() {
        this.tot_price_carton = this.cartons * (this.carton_price - this.carton_discounted_price);
    }
}