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
public class ContactNextOfKin {
    private Integer IDNextOfKin;
    private String NextOfKinName;
    private String RelationshipWithPatient;
    private ContactDetails NextOfKinContactDetails;

    public ContactNextOfKin(Integer IDNextOfKin, String NextOfKinName, String RelationshipWithPatient, ContactDetails NextOfKinContactDetails) {
        this.IDNextOfKin = IDNextOfKin;
        this.NextOfKinName = NextOfKinName;
        this.RelationshipWithPatient = RelationshipWithPatient;
        this.NextOfKinContactDetails = NextOfKinContactDetails;
    }

    public Integer getIDNextOfKin() {
        return IDNextOfKin;
    }

    public void setIDNextOfKin(Integer IDNextOfKin) {
        this.IDNextOfKin = IDNextOfKin;
    }

    public String getNextOfKinName() {
        return NextOfKinName;
    }

    public void setNextOfKinName(String NextOfKinName) {
        this.NextOfKinName = NextOfKinName;
    }

    public String getRelationshipWithPatient() {
        return RelationshipWithPatient;
    }

    public void setRelationshipWithPatient(String RelationshipWithPatient) {
        this.RelationshipWithPatient = RelationshipWithPatient;
    }

    public ContactDetails getNextOfKinContactDetails() {
        return NextOfKinContactDetails;
    }

    public void setNextOfKinContactDetails(ContactDetails NextOfKinContactDetails) {
        this.NextOfKinContactDetails = NextOfKinContactDetails;
    }

    @Override
    public String toString() {
        return "ContactNextOfKin{" + "IDNextOfKin=" + IDNextOfKin + ", NextOfKinName=" + NextOfKinName + ", RelationshipWithPatient=" + RelationshipWithPatient + ", NextOfKinContactDetails=" + NextOfKinContactDetails + '}';
    }
    
    
    
}
