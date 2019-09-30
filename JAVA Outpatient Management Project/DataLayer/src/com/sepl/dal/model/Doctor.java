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
public class Doctor {
    private Integer IDDoctor;
    private DoctorType DoctorType;
    private BasicDetails BasicDetails;
    private ContactDetails ContactDetails;

    public Doctor(Integer IDDoctor, DoctorType DoctorType, BasicDetails BasicDetails, ContactDetails ContactDetails) {
        this.IDDoctor = IDDoctor;
        this.DoctorType = DoctorType;
        this.BasicDetails = BasicDetails;
        this.ContactDetails = ContactDetails;
    }

    public Integer getIDDoctor() {
        return IDDoctor;
    }

    public void setIDDoctor(Integer IDDoctor) {
        this.IDDoctor = IDDoctor;
    }

    public DoctorType getDoctorType() {
        return DoctorType;
    }

    public void setDoctorType(DoctorType DoctorType) {
        this.DoctorType = DoctorType;
    }

    public BasicDetails getBasicDetails() {
        return BasicDetails;
    }

    public void setBasicDetails(BasicDetails BasicDetails) {
        this.BasicDetails = BasicDetails;
    }

    public ContactDetails getContactDetails() {
        return ContactDetails;
    }

    public void setContactDetails(ContactDetails ContactDetails) {
        this.ContactDetails = ContactDetails;
    }

    @Override
    public String toString() {
        return "Doctor{" + "IDDoctor=" + IDDoctor + ", DoctorType=" + DoctorType + ", BasicDetails=" + BasicDetails + ", ContactDetails=" + ContactDetails + '}';
    }

    
    
    
}
