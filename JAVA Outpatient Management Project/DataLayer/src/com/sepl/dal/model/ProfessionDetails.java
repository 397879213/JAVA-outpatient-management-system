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
public class ProfessionDetails {
    private Integer IDProfessionDetails;
    private String Occupation;
    private BigDecimal GrossAnnualIncome;

    public ProfessionDetails(Integer IDProfessionDetails, String Occupation, BigDecimal GrossAnnualIncome) {
        this.IDProfessionDetails = IDProfessionDetails;
        this.Occupation = Occupation;
        this.GrossAnnualIncome = GrossAnnualIncome;
    }

    public Integer getIDProfessionDetails() {
        return IDProfessionDetails;
    }

    public void setIDProfessionDetails(Integer IDProfessionDetails) {
        this.IDProfessionDetails = IDProfessionDetails;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String Occupation) {
        this.Occupation = Occupation;
    }

    public BigDecimal getGrossAnnualIncome() {
        return GrossAnnualIncome;
    }

    public void setGrossAnnualIncome(BigDecimal GrossAnnualIncome) {
        this.GrossAnnualIncome = GrossAnnualIncome;
    }

    @Override
    public String toString() {
        return "ProfessionDetails{" + "IDProfessionDetails=" + IDProfessionDetails + ", Occupation=" + Occupation + ", GrossAnnualIncome=" + GrossAnnualIncome + '}';
    }
    
    
}
