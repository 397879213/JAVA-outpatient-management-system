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
public class MiniRegistrationForm {
    private Integer IDMiniRegForm;
    private Date RegistrationDate;
    private String PatientName;
    private String Sex;
    private Date DateOfBirth;
    private String BreifStatementOfComplaint;
    private String PhoneNumber1;
    private String PhoneNumber2;
    private String NextOfKinName;
    private String RelationshipToPatitent;

    public MiniRegistrationForm(Integer IDMiniRegForm, Date RegistrationDate, String PatientName, String Sex, Date DateOfBirth, String BreifStatementOfComplaint, String PhoneNumber1, String PhoneNumber2, String NextOfKinName, String RelationshipToPatitent) {
        this.IDMiniRegForm = IDMiniRegForm;
        this.RegistrationDate = RegistrationDate;
        this.PatientName = PatientName;
        this.Sex = Sex;
        this.DateOfBirth = DateOfBirth;
        this.BreifStatementOfComplaint = BreifStatementOfComplaint;
        this.PhoneNumber1 = PhoneNumber1;
        this.PhoneNumber2 = PhoneNumber2;
        this.NextOfKinName = NextOfKinName;
        this.RelationshipToPatitent = RelationshipToPatitent;
    }

    public Integer getIDMiniRegForm() {
        return IDMiniRegForm;
    }

    public void setIDMiniRegForm(Integer IDMiniRegForm) {
        this.IDMiniRegForm = IDMiniRegForm;
    }

    public Date getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(Date RegistrationDate) {
        this.RegistrationDate = RegistrationDate;
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

    public String getBreifStatementOfComplaint() {
        return BreifStatementOfComplaint;
    }

    public void setBreifStatementOfComplaint(String BreifStatementOfComplaint) {
        this.BreifStatementOfComplaint = BreifStatementOfComplaint;
    }

    public String getPhoneNumber1() {
        return PhoneNumber1;
    }

    public void setPhoneNumber1(String PhoneNumber1) {
        this.PhoneNumber1 = PhoneNumber1;
    }

    public String getPhoneNumber2() {
        return PhoneNumber2;
    }

    public void setPhoneNumber2(String PhoneNumber2) {
        this.PhoneNumber2 = PhoneNumber2;
    }

    public String getNextOfKinName() {
        return NextOfKinName;
    }

    public void setNextOfKinName(String NextOfKinName) {
        this.NextOfKinName = NextOfKinName;
    }

    public String getRelationshipToPatitent() {
        return RelationshipToPatitent;
    }

    public void setRelationshipToPatitent(String RelationshipToPatitent) {
        this.RelationshipToPatitent = RelationshipToPatitent;
    }

    @Override
    public String toString() {
        return "MiniRegistrationForm{" + "IDMiniRegForm=" + IDMiniRegForm + ", RegistrationDate=" + RegistrationDate + ", PatientName=" + PatientName + ", Sex=" + Sex + ", DateOfBirth=" + DateOfBirth + ", BreifStatementOfComplaint=" + BreifStatementOfComplaint + ", PhoneNumber1=" + PhoneNumber1 + ", PhoneNumber2=" + PhoneNumber2 + ", NextOfKinName=" + NextOfKinName + ", RelationshipToPatitent=" + RelationshipToPatitent + '}';
    }
    
    
}
