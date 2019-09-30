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
public class ResidenceAddress {
    private Integer IDResidenceAddress;
    private String DoorNumber;
    private String Street;
    private String Area;
    private String City;
    private String StateName;
    private String Pincode;

    public ResidenceAddress(Integer IDResidenceAddress, String DoorNumber, String Street, String Area, String City, String StateName, String Pincode) {
        this.IDResidenceAddress = IDResidenceAddress;
        this.DoorNumber = DoorNumber;
        this.Street = Street;
        this.Area = Area;
        this.City = City;
        this.StateName = StateName;
        this.Pincode = Pincode;
    }

    public Integer getIDResidenceAddress() {
        return IDResidenceAddress;
    }

    public void setIDResidenceAddress(Integer IDResidenceAddress) {
        this.IDResidenceAddress = IDResidenceAddress;
    }

    public String getDoorNumber() {
        return DoorNumber;
    }

    public void setDoorNumber(String DoorNumber) {
        this.DoorNumber = DoorNumber;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String StateName) {
        this.StateName = StateName;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String Pincode) {
        this.Pincode = Pincode;
    }

    @Override
    public String toString() {
        return "ResidenceAddress{" + "IDResidenceAddress=" + IDResidenceAddress + ", DoorNumber=" + DoorNumber + ", Street=" + Street + ", Area=" + Area + ", City=" + City + ", StateName=" + StateName + ", Pincode=" + Pincode + '}';
    }    
}
