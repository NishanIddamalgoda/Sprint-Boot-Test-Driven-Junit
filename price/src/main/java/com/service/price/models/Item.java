package com.service.price.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_code;

    @Column(name = "item_name")
    private String item_name;

    @Column(name = "units_p_carton") // unit per carton
    private int units_p_carton;

    @Column(name = "carton_price")
    private double carton_price;

    @Column(name = "carton_dicnt_qty") // discount eligible carton quantiy
    private int carton_dicnt_qty;

    @Column(name = "carton_dicnt_percnt") // carton discount percentage
    private double carton_dicnt_percnt;

    @Column(name = "single_unit_increment") // single unit value increase percentage from carton price
    private double single_unit_increment;

    @Transient
    private int current_selected_units;

    @Transient
    private double current_selection_total;

    public Long getItem_code() {
        return item_code;
    }

    public void setItem_code(Long item_code) {
        this.item_code = item_code;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getUnits_p_carton() {
        return units_p_carton;
    }

    public void setUnits_p_carton(int units_p_carton) {
        this.units_p_carton = units_p_carton;
    }

    public double getCarton_price() {
        return carton_price;
    }

    public void setCarton_price(double carton_price) {
        this.carton_price = carton_price;
    }

    public int getCarton_dicnt_qty() {
        return carton_dicnt_qty;
    }

    public void setCarton_dicnt_qty(int carton_dicnt_qty) {
        this.carton_dicnt_qty = carton_dicnt_qty;
    }

    public double getCarton_dicnt_percnt() {
        return carton_dicnt_percnt;
    }

    public void setCarton_dicnt_percnt(double carton_dicnt_percnt) {
        this.carton_dicnt_percnt = carton_dicnt_percnt;
    }

    public double getSingle_unit_increment() {
        return single_unit_increment;
    }

    public void setSingle_unit_increment(double single_unit_increment) {
        this.single_unit_increment = single_unit_increment;
    }

    public int getCurrent_selected_units() {
        return current_selected_units;
    }

    public void setCurrent_selected_units(int current_selected_units) {
        this.current_selected_units = current_selected_units;
    }

    public double getCurrent_selection_total() {
        return current_selection_total;
    }

    public void setCurrent_selection_total(double current_selection_total) {
        this.current_selection_total = current_selection_total;
    }

}