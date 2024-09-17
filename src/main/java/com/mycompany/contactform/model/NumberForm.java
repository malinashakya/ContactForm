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
    
    @Column(name = "nogroupintnum")
    private int nogroupintnum;
    
    @Column(name = "minmaxfractdigit")
    private int minmaxfractdigit;
    
    @Column(name = "minmaxboundary")
    private int minmaxboundary;
    
    @Column(name = "doublenum")
    private double doublenum;
    
    @Column(name = "user_locale")
    private double user_locale;
    
    @Column(name = "us_locale")
    private double us_locale;
    
    @Column(name = "german_locale")
    private double german_locale;
    
    @Column(name = "indian_locale")
    private double indian_locale;
    
    @Column(name = "currency")
    private double currency;
    
    @Column(name = "prefiix")
    private int prefiix;
    
    @Column(name = "suffix")
    private int suffix;
    
    @Column(name = "stacked")
    private double stacked;
    
    @Column(name = "minmax")
    private int minmax;
    
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

    public int getNogroupintnum() {
        return nogroupintnum;
    }

    public int getMinmaxfractdigit() {
        return minmaxfractdigit;
    }

    public int getMinmaxboundary() {
        return minmaxboundary;
    }

    public double getDoublenum() {
        return doublenum;
    }

    public double getUser_locale() {
        return user_locale;
    }

    public double getUs_locale() {
        return us_locale;
    }

    public double getGerman_locale() {
        return german_locale;
    }

    public double getIndian_locale() {
        return indian_locale;
    }

    public double getCurrency() {
        return currency;
    }

    public int getPrefiix() {
        return prefiix;
    }

    public int getSuffix() {
        return suffix;
    }

    public double getStacked() {
        return stacked;
    }

    public int getMinmax() {
        return minmax;
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

    public void setNogroupintnum(int nogroupintnum) {
        this.nogroupintnum = nogroupintnum;
    }

    public void setMinmaxfractdigit(int minmaxfractdigit) {
        this.minmaxfractdigit = minmaxfractdigit;
    }

    public void setMinmaxboundary(int minmaxboundary) {
        this.minmaxboundary = minmaxboundary;
    }

    public void setDoublenum(double doublenum) {
        this.doublenum = doublenum;
    }

    public void setUser_locale(double user_locale) {
        this.user_locale = user_locale;
    }

    public void setUs_locale(double us_locale) {
        this.us_locale = us_locale;
    }

    public void setGerman_locale(double german_locale) {
        this.german_locale = german_locale;
    }

    public void setIndian_locale(double indian_locale) {
        this.indian_locale = indian_locale;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    public void setPrefiix(int prefiix) {
        this.prefiix = prefiix;
    }

    public void setSuffix(int suffix) {
        this.suffix = suffix;
    }

    public void setStacked(double stacked) {
        this.stacked = stacked;
    }

    public void setMinmax(int minmax) {
        this.minmax = minmax;
    }

    public void setHorizontal_with_step(double horizontal_with_step) {
        this.horizontal_with_step = horizontal_with_step;
    }

    public void setVertical_with_step(double vertical_with_step) {
        this.vertical_with_step = vertical_with_step;
    }

    public NumberForm(int intnum, int nogroupintnum, int minmaxfractdigit, int minmaxboundary, double doublenum, double user_locale, double us_locale, double german_locale, double indian_locale, double currency, int prefiix, int suffix, double stacked, int minmax, double horizontal_with_step, double vertical_with_step) {
        this.intnum = intnum;
        this.nogroupintnum = nogroupintnum;
        this.minmaxfractdigit = minmaxfractdigit;
        this.minmaxboundary = minmaxboundary;
        this.doublenum = doublenum;
        this.user_locale = user_locale;
        this.us_locale = us_locale;
        this.german_locale = german_locale;
        this.indian_locale = indian_locale;
        this.currency = currency;
        this.prefiix = prefiix;
        this.suffix = suffix;
        this.stacked = stacked;
        this.minmax = minmax;
        this.horizontal_with_step = horizontal_with_step;
        this.vertical_with_step = vertical_with_step;
    }

    @Override
    public String toString()
    {
        return "NumberForm{"+
                "id="+id
                +"intnum"+intnum
                 +"nogroupintnum"+nogroupintnum
                 +"minmaxfractdigit"+minmaxfractdigit
                 +"minmaxboundary"+minmaxboundary
                 +"doublenum"+doublenum
                 +"user_locale"+user_locale
                 +"us_locale"+us_locale
                 +"german_locale"+german_locale
                 +"indian_locale"+indian_locale
                 +"currency"+currency
                 +"prefiix"+prefiix
                 +"suffix"+suffix
                 +"stacked"+stacked
                 +"minmax"+minmax
                 +"horizontal_with_step"+horizontal_with_step
                 +"vertical_with_step"+vertical_with_step
                +
                '}';
                
    }
}
        