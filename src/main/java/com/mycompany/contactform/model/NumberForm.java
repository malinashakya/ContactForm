/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactform.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author malina
 */
@Entity
@Table(name = "number_data")
public class NumberForm implements Serializable {

    public NumberForm() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "intnum")
    private int intnum;

    @Column(name = "doublenum")
    private double doublenum;

    @Column(name = "horizontal_with_step")
    private double horizontal_with_step;

    @Column(name = "vertical_with_step")
    private double vertical_with_step;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getIntnum() {
        return intnum;
    }

    public double getDoublenum() {
        return doublenum;
    }

    public double getHorizontal_with_step() {
        return horizontal_with_step;
    }

    public double getVertical_with_step() {
        return vertical_with_step;
    }

    public void setIntnum(int intnum) {
        this.intnum = intnum;
    }

    public void setDoublenum(double doublenum) {
        this.doublenum = doublenum;
    }

    public void setHorizontal_with_step(double horizontal_with_step) {
        this.horizontal_with_step = horizontal_with_step;
    }

    public void setVertical_with_step(double vertical_with_step) {
        this.vertical_with_step = vertical_with_step;
    }

    public NumberForm(int intnum, double doublenum, double horizontal_with_step, double vertical_with_step) {
        this.intnum = intnum;
        this.doublenum = doublenum;
        this.horizontal_with_step = horizontal_with_step;
        this.vertical_with_step = vertical_with_step;
    }

    @Override
    public String toString() {
        return "NumberForm{"
                + "id=" + id
                + "intnum" + intnum
                + "doublenum" + doublenum
                + "horizontal_with_step" + horizontal_with_step
                + "vertical_with_step" + vertical_with_step
                + '}';

    }
}
