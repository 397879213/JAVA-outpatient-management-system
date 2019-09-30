/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sepl.dal.model;

import java.math.BigDecimal;

/**
 *
 * @author Vilcha
 */
public class Bill {
    private Integer IDBill;
    private Patient Patient;
    private String BillItem;
    private BigDecimal BillPrice;

    public Bill(Integer IDBill, Patient Patient, String BillItem, BigDecimal BillPrice) {
        this.IDBill = IDBill;
        this.Patient = Patient;
        this.BillItem = BillItem;
        this.BillPrice = BillPrice;
    }

    public Integer getIDBill() {
        return IDBill;
    }

    public void setIDBill(Integer IDBill) {
        this.IDBill = IDBill;
    }

    public Patient getPatient() {
        return Patient;
    }

    public void setPatient(Patient Patient) {
        this.Patient = Patient;
    }

    public String getBillItem() {
        return BillItem;
    }

    public void setBillItem(String BillItem) {
        this.BillItem = BillItem;
    }

    public BigDecimal getBillPrice() {
        return BillPrice;
    }

    public void setBillPrice(BigDecimal BillPrice) {
        this.BillPrice = BillPrice;
    }

    @Override
    public String toString() {
        return "Bill ID [" + IDBill + "] ----- item to pay - " + BillItem + ", price to pay - " + BillPrice;
    }
    
    
}
