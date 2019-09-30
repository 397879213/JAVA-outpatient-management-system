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
public class PhoneFaxEmailContacts {
    private Integer IDPhoneFaxEmailContacts;
    private String TelephoneWork;
    private String TelephoneHome;
    private String Mobile;
    private String Pager;
    private String Fax;
    private String Email;

    public PhoneFaxEmailContacts(Integer IDPhoneFaxEmailContacts, String TelephoneWork, String TelephoneHome, String Mobile, String Pager, String Fax, String Email) {
        this.IDPhoneFaxEmailContacts = IDPhoneFaxEmailContacts;
        this.TelephoneWork = TelephoneWork;
        this.TelephoneHome = TelephoneHome;
        this.Mobile = Mobile;
        this.Pager = Pager;
        this.Fax = Fax;
        this.Email = Email;
    }

    public Integer getIDPhoneFaxEmailContacts() {
        return IDPhoneFaxEmailContacts;
    }

    public void setIDPhoneFaxEmailContacts(Integer IDPhoneFaxEmailContacts) {
        this.IDPhoneFaxEmailContacts = IDPhoneFaxEmailContacts;
    }

    public String getTelephoneWork() {
        return TelephoneWork;
    }

    public void setTelephoneWork(String TelephoneWork) {
        this.TelephoneWork = TelephoneWork;
    }

    public String getTelephoneHome() {
        return TelephoneHome;
    }

    public void setTelephoneHome(String TelephoneHome) {
        this.TelephoneHome = TelephoneHome;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getPager() {
        return Pager;
    }

    public void setPager(String Pager) {
        this.Pager = Pager;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "PhoneFaxEmailContacts{" + "IDPhoneFaxEmailContacts=" + IDPhoneFaxEmailContacts + ", TelephoneWork=" + TelephoneWork + ", TelephoneHome=" + TelephoneHome + ", Mobile=" + Mobile + ", Pager=" + Pager + ", Fax=" + Fax + ", Email=" + Email + '}';
    }
    
    
}
