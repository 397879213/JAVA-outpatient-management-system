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
public class Patient {
    private Integer IDPatient;
    private Doctor Doctor;
    private MiniRegistrationForm MiniRegForm;
    private ComprehensiveRegistrationForm CompRegForm;

    public Patient(Integer IDPatient, Doctor Doctor, MiniRegistrationForm MiniRegForm, ComprehensiveRegistrationForm CompRegForm) {
        this.IDPatient = IDPatient;
        this.Doctor = Doctor;
        this.MiniRegForm = MiniRegForm;
        this.CompRegForm = CompRegForm;
    }

    public Integer getIDPatient() {
        return IDPatient;
    }

    public void setIDPatient(Integer IDPatient) {
        this.IDPatient = IDPatient;
    }

    public Doctor getDoctor() {
        return Doctor;
    }

    public void setDoctor(Doctor Doctor) {
        this.Doctor = Doctor;
    }

    public MiniRegistrationForm getMiniRegForm() {
        return MiniRegForm;
    }

    public void setMiniRegForm(MiniRegistrationForm MiniRegForm) {
        this.MiniRegForm = MiniRegForm;
    }

    public ComprehensiveRegistrationForm getCompRegForm() {
        return CompRegForm;
    }

    public void setCompRegForm(ComprehensiveRegistrationForm CompRegForm) {
        this.CompRegForm = CompRegForm;
    }

    @Override
    public String toString() {
        return "Patient{" + "IDPatient=" + IDPatient + ", Doctor=" + Doctor + ", MiniRegForm=" + MiniRegForm + ", CompRegForm=" + CompRegForm + '}';
    }

    
    
    
}
