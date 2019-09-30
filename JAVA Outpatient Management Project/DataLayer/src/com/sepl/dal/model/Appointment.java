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
public class Appointment {
    private Integer IDAppointment;
    private Doctor Doctor;
    private Patient Patient;
    private Date AppointmentDate;

    public Appointment(Integer IDAppointment, Doctor Doctor, Patient Patient, Date AppointmentDate) {
        this.IDAppointment = IDAppointment;
        this.Doctor = Doctor;
        this.Patient = Patient;
        this.AppointmentDate = AppointmentDate;
    }

    public Integer getIDAppointment() {
        return IDAppointment;
    }

    public void setIDAppointment(Integer IDAppointment) {
        this.IDAppointment = IDAppointment;
    }

    public Doctor getDoctor() {
        return Doctor;
    }

    public void setDoctor(Doctor Doctor) {
        this.Doctor = Doctor;
    }

    public Patient getPatient() {
        return Patient;
    }

    public void setPatient(Patient Patient) {
        this.Patient = Patient;
    }

    public Date getAppointmentDate() {
        return AppointmentDate;
    }

    public void setAppointmentDate(Date AppointmentDate) {
        this.AppointmentDate = AppointmentDate;
    }

    @Override
    public String toString() {
        return "Appointment ID [" + IDAppointment + "] with Doctor " + Doctor.getBasicDetails().getPatientName() + ", on " + AppointmentDate;
    }
    
    
}
