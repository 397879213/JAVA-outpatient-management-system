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
public class ComprehensiveRegistrationForm {
    private Integer IDCompRegForm;
    private Date RegistrationDate;
    private BasicDetails BasicDetails;
    private ContactDetails ContactDetails;
    private ContactNextOfKin ContactNextOfKin;
    private PersonalDetails PersonalDetails;
    private ProfessionDetails ProfessionDetails;
    private Lifestyle Lifestyle;
    private BasicComplaints BasicComplaints;
    private ImportantMedicalComplaints ImportantMedicalComplaints;

    public ComprehensiveRegistrationForm(Integer IDCompRegForm, Date RegistrationDate, BasicDetails BasicDetails, ContactDetails ContactDetails, ContactNextOfKin ContactNextOfKin, PersonalDetails PersonalDetails, ProfessionDetails ProfessionDetails, Lifestyle Lifestyle, BasicComplaints BasicComplaints, ImportantMedicalComplaints ImportantMedicalComplaints) {
        this.IDCompRegForm = IDCompRegForm;
        this.RegistrationDate = RegistrationDate;
        this.BasicDetails = BasicDetails;
        this.ContactDetails = ContactDetails;
        this.ContactNextOfKin = ContactNextOfKin;
        this.PersonalDetails = PersonalDetails;
        this.ProfessionDetails = ProfessionDetails;
        this.Lifestyle = Lifestyle;
        this.BasicComplaints = BasicComplaints;
        this.ImportantMedicalComplaints = ImportantMedicalComplaints;
    }

    public Integer getIDCompRegForm() {
        return IDCompRegForm;
    }

    public void setIDCompRegForm(Integer IDCompRegForm) {
        this.IDCompRegForm = IDCompRegForm;
    }

    public Date getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(Date RegistrationDate) {
        this.RegistrationDate = RegistrationDate;
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

    public ContactNextOfKin getContactNextOfKin() {
        return ContactNextOfKin;
    }

    public void setContactNextOfKin(ContactNextOfKin ContactNextOfKin) {
        this.ContactNextOfKin = ContactNextOfKin;
    }

    public PersonalDetails getPersonalDetails() {
        return PersonalDetails;
    }

    public void setPersonalDetails(PersonalDetails PersonalDetails) {
        this.PersonalDetails = PersonalDetails;
    }

    public ProfessionDetails getProfessionDetails() {
        return ProfessionDetails;
    }

    public void setProfessionDetails(ProfessionDetails ProfessionDetails) {
        this.ProfessionDetails = ProfessionDetails;
    }

    public Lifestyle getLifestyle() {
        return Lifestyle;
    }

    public void setLifestyle(Lifestyle Lifestyle) {
        this.Lifestyle = Lifestyle;
    }

    public BasicComplaints getBasicComplaints() {
        return BasicComplaints;
    }

    public void setBasicComplaints(BasicComplaints BasicComplaints) {
        this.BasicComplaints = BasicComplaints;
    }

    public ImportantMedicalComplaints getImportantMedicalComplaints() {
        return ImportantMedicalComplaints;
    }

    public void setImportantMedicalComplaints(ImportantMedicalComplaints ImportantMedicalComplaints) {
        this.ImportantMedicalComplaints = ImportantMedicalComplaints;
    }

    @Override
    public String toString() {
        return "ID - " + IDCompRegForm + " / Registration Date - " + RegistrationDate + " / Basic Details - " + BasicDetails + " / Contact Details - " + ContactDetails + " / Contact Next-of-Kin - " + ContactNextOfKin + " / Personal Details - " + PersonalDetails + " / Profession Details - " + ProfessionDetails + " / Lifestyle - " + Lifestyle + " / Basic Complaints - " + BasicComplaints + " / Important Medical Complaints - " + ImportantMedicalComplaints;
    }

}
