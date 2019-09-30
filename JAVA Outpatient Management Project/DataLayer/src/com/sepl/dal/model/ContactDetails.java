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
public class ContactDetails {
    private Integer IDContactDetails;
    private ResidenceAddress PresentAddress;
    private ResidenceAddress PermanentAddress;
    private PhoneFaxEmailContacts TelephoneFaxEmail;

    public ContactDetails(Integer IDContactDetails, ResidenceAddress PresentAddress, ResidenceAddress PermanentAddress, PhoneFaxEmailContacts TelephoneFaxEmail) {
        this.IDContactDetails = IDContactDetails;
        this.PresentAddress = PresentAddress;
        this.PermanentAddress = PermanentAddress;
        this.TelephoneFaxEmail = TelephoneFaxEmail;
    }

    public Integer getIDContactDetails() {
        return IDContactDetails;
    }

    public void setIDContactDetails(Integer IDContactDetails) {
        this.IDContactDetails = IDContactDetails;
    }

    public ResidenceAddress getPresentAddress() {
        return PresentAddress;
    }

    public void setPresentAddress(ResidenceAddress PresentAddress) {
        this.PresentAddress = PresentAddress;
    }

    public ResidenceAddress getPermanentAddress() {
        return PermanentAddress;
    }

    public void setPermanentAddress(ResidenceAddress PermanentAddress) {
        this.PermanentAddress = PermanentAddress;
    }

    public PhoneFaxEmailContacts getTelephoneFaxEmail() {
        return TelephoneFaxEmail;
    }

    public void setTelephoneFaxEmail(PhoneFaxEmailContacts TelephoneFaxEmail) {
        this.TelephoneFaxEmail = TelephoneFaxEmail;
    }

    @Override
    public String toString() {
        return "ContactDetails{" + "IDContactDetails=" + IDContactDetails + ", PresentAddress=" + PresentAddress + ", PermanentAddress=" + PermanentAddress + ", TelephoneFaxEmail=" + TelephoneFaxEmail + '}';
    }
    
    
}
