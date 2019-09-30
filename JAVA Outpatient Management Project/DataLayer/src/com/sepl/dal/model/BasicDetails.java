/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sepl.dal.model;

import java.sql.Date;

/**
 *
 * @author Vilcha
 */
public class BasicDetails {
    private Integer IDBasicDetails;
    private String PatientName;
    private String Sex;
    private Date DateOfBirth;

    public BasicDetails(Integer IDBasicDetails, String PatientName, String Sex, Date DateOfBirth) {
        this.IDBasicDetails = IDBasicDetails;
        this.PatientName = PatientName;
        this.Sex = Sex;
        this.DateOfBirth = DateOfBirth;
    }

    public Integer getIDBasicDetails() {
        return IDBasicDetails;
    }

    public void setIDBasicDetails(Integer IDBasicDetails) {
        this.IDBasicDetails = IDBasicDetails;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String PatientName) {
        this.PatientName = PatientName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    @Override
    public String toString() {
        return "BasicDetails{" + "IDBasicDetails=" + IDBasicDetails + ", PatientName=" + PatientName + ", Sex=" + Sex + ", DateOfBirth=" + DateOfBirth + '}';
    }
}
