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
public class BasicComplaints {
    private Integer IDBasicComplaints;
    private String StatementOfComplaint;
    private String HistoryOfPreviousTreatment;
    private String PhysicianHospitalTreated;

    public BasicComplaints(Integer IDBasicComplaints, String StatementOfComplaint, String HistoryOfPreviousTreatment, String PhysicianHospitalTreated) {
        this.IDBasicComplaints = IDBasicComplaints;
        this.StatementOfComplaint = StatementOfComplaint;
        this.HistoryOfPreviousTreatment = HistoryOfPreviousTreatment;
        this.PhysicianHospitalTreated = PhysicianHospitalTreated;
    }

    public Integer getIDBasicComplaints() {
        return IDBasicComplaints;
    }

    public void setIDBasicComplaints(Integer IDBasicComplaints) {
        this.IDBasicComplaints = IDBasicComplaints;
    }

    public String getStatementOfComplaint() {
        return StatementOfComplaint;
    }

    public void setStatementOfComplaint(String StatementOfComplaint) {
        this.StatementOfComplaint = StatementOfComplaint;
    }

    public String getHistoryOfPreviousTreatment() {
        return HistoryOfPreviousTreatment;
    }

    public void setHistoryOfPreviousTreatment(String HistoryOfPreviousTreatment) {
        this.HistoryOfPreviousTreatment = HistoryOfPreviousTreatment;
    }

    public String getPhysicianHospitalTreated() {
        return PhysicianHospitalTreated;
    }

    public void setPhysicianHospitalTreated(String PhysicianHospitalTreated) {
        this.PhysicianHospitalTreated = PhysicianHospitalTreated;
    }

    @Override
    public String toString() {
        return "BasicComplaints{" + "IDBasicComplaints=" + IDBasicComplaints + ", StatementOfComplaint=" + StatementOfComplaint + ", HistoryOfPreviousTreatment=" + HistoryOfPreviousTreatment + ", PhysicianHospitalTreated=" + PhysicianHospitalTreated + '}';
    }
    
    
}
