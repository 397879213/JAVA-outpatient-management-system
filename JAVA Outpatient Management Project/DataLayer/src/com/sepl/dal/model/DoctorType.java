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
public class DoctorType {
    private Integer IDDoctorType;
    private String TypeName;

    public DoctorType(Integer IDDoctorType, String TypeName) {
        this.IDDoctorType = IDDoctorType;
        this.TypeName = TypeName;
    }

    public Integer getIDDoctorType() {
        return IDDoctorType;
    }

    public void setIDDoctorType(Integer IDDoctorType) {
        this.IDDoctorType = IDDoctorType;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }

    @Override
    public String toString() {
        return "DoctorType{" + "IDDoctorType=" + IDDoctorType + ", TypeName=" + TypeName + '}';
    }
    
    
}
