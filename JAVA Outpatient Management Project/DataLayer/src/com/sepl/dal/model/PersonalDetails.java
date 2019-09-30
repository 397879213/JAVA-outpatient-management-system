/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sepl.dal.model;

/**
 *
 * @author Vilcha
 */
public class PersonalDetails {
    private Integer IDPersonalDetails;
    private String MaritalStatus;
    private Integer NoOfDependents;
    private Integer PatientHeight;
    private Integer PatientWeight;
    private String BloodTypeRH;

    public PersonalDetails(Integer IDPersonalDetails, String MaritalStatus, Integer NoOfDependents, Integer PatientHeight, Integer PatientWeight, String BloodTypeRH) {
        this.IDPersonalDetails = IDPersonalDetails;
        this.MaritalStatus = MaritalStatus;
        this.NoOfDependents = NoOfDependents;
        this.PatientHeight = PatientHeight;
        this.PatientWeight = PatientWeight;
        this.BloodTypeRH = BloodTypeRH;
    }

    public Integer getIDPersonalDetails() {
        return IDPersonalDetails;
    }

    public void setIDPersonalDetails(Integer IDPersonalDetails) {
        this.IDPersonalDetails = IDPersonalDetails;
    }

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String MaritalStatus) {
        this.MaritalStatus = MaritalStatus;
    }

    public Integer getNoOfDependents() {
        return NoOfDependents;
    }

    public void setNoOfDependents(Integer NoOfDependents) {
        this.NoOfDependents = NoOfDependents;
    }

    public Integer getPatientHeight() {
        return PatientHeight;
    }

    public void setPatientHeight(Integer PatientHeight) {
        this.PatientHeight = PatientHeight;
    }

    public Integer getPatientWeight() {
        return PatientWeight;
    }

    public void setPatientWeight(Integer PatientWeight) {
        this.PatientWeight = PatientWeight;
    }

    public String getBloodTypeRH() {
        return BloodTypeRH;
    }

    public void setBloodTypeRH(String BloodTypeRH) {
        this.BloodTypeRH = BloodTypeRH;
    }

    @Override
    public String toString() {
        return "PersonalDetails{" + "IDPersonalDetails=" + IDPersonalDetails + ", MaritalStatus=" + MaritalStatus + ", NoOfDependents=" + NoOfDependents + ", PatientHeight=" + PatientHeight + ", PatientWeight=" + PatientWeight + ", BloodTypeRH=" + BloodTypeRH + '}';
    }
    
    
}
