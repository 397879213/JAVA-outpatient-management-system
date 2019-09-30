/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sepl.dal.business;

import com.sepl.dal.model.*;
import com.sepl.dal.repo.IRepo;
import com.sepl.dal.repo.RepoFactory;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Vilcha
 */
public class BusinessLogic {
    private IRepo repo = RepoFactory.getRepo();
    
    public int insertMiniRegistrationForm(Date regDate, String name, String sex, Date dob, String phoneOne, String phoneTwo, String nextOfKinName, String relationshipToPatient, String statementOfComplaint){        
        return repo.insertMiniRegistrationForm(new MiniRegistrationForm(null, regDate, name, sex, regDate, statementOfComplaint, phoneOne, phoneTwo, nextOfKinName, relationshipToPatient));
    }
    
    public int insertPatient(Doctor doctor, MiniRegistrationForm miniRegForm, ComprehensiveRegistrationForm compRegForm){
        return repo.insertPatient(new Patient(null, doctor, miniRegForm, compRegForm));
    }

    public boolean checkPatientForID(int patientID) {
        return repo.checkPatientForID(patientID);
    }

    public Patient getPatient(int patientID) {
        return repo.getPatient(patientID);
    }

    public MiniRegistrationForm getMiniRegistrationForm(int miniRegFormId) {
        return repo.getMiniRegistrationForm(miniRegFormId);
    }

    public List<Appointment> getAppointmentsForPatient(Integer idPatient) {
        return repo.getAppointmentForPatient(idPatient);
    }

    public List<Bill> getBillsForPatient(Integer idPatient) {
        return repo.getBillForPatient(idPatient);
    }
    
    public DoctorType getDoctorType(Integer doctorTypeID) {
        return repo.getDoctorType(doctorTypeID);
    }

    public void insertDoctor(DoctorType doctorType, BasicDetails basicDetails, ContactDetails contactDetails) {
        repo.insertDoctor(new Doctor(null, doctorType, basicDetails, contactDetails));
    }

    public int insertBasicDetails(String fullName, String sex, Date dateOfBirth) {
        return repo.insertBasicDetails(new BasicDetails(null, fullName, sex, dateOfBirth));
    }

    public int insertResidenceAddress(String doorNo, String street, String area, String city, String stateName, String pinCode) {
        return repo.insertResidenceAddress(new ResidenceAddress(null, doorNo, street, area, city, stateName, pinCode));
    }

    public int insertPhoneFaxemail(String telephoneWork, String telephoneHome, String mobile, String pager, String fax, String email) {
        return repo.insertPhoneFaxEmailContacts(new PhoneFaxEmailContacts(null, telephoneWork, telephoneHome, mobile, pager, fax, email));
    }

    public int insertContactDetails(ResidenceAddress presentAddress, ResidenceAddress permanentAddress, PhoneFaxEmailContacts contacts) {
        return repo.insertContactDetails(new ContactDetails(null, presentAddress, permanentAddress, contacts));
    }

    public int insertPersonalDetails(String maritalStatus, Integer noOfDependents, Integer height, Integer weight, String bloodTypeRH) {
        return repo.insertPersonalDetails(new PersonalDetails(null, maritalStatus, noOfDependents, height, weight, bloodTypeRH));
    }

    public int insertProfessionDetails(String occupation, BigDecimal grossAnnualIncome) {
        return repo.insertProfessionDetails(new ProfessionDetails(null, occupation, grossAnnualIncome));
    }

    public int insertLifestyle(boolean vegetarian, boolean smoker, Integer avgNoOfCigs, boolean alcoholConsumer, Integer avgNoOfDrinks, String useStimulants, Integer coffeTeaPerDay, Integer softDrinksPerDay, String haveRegularMeals, String eatHomeEatOutside) {
        return repo.insertLifestyle(new Lifestyle(null, vegetarian, smoker, avgNoOfCigs, alcoholConsumer, avgNoOfDrinks, useStimulants, coffeTeaPerDay, softDrinksPerDay, haveRegularMeals, eatHomeEatOutside));
    }

    public int insertBasicComplaints(String statementOfComplaint, String historyOfPreviousTreatment, String physicianHospitalTreated) {
        return repo.insertBasicComplaints(new BasicComplaints(null, statementOfComplaint, historyOfPreviousTreatment, physicianHospitalTreated));
    }

    public int insertImportanMedicalComplaints(boolean diabetic, boolean hypertensive, String cardiac, String orthopedic, String muscular, String neurological, String digestive, String knownAllergies, String knownAdverseReactions, String majorSurgeries) {
        return repo.insertImportantMedicalComplaints(new ImportantMedicalComplaints(null, diabetic, hypertensive, cardiac, orthopedic, muscular, neurological, digestive, knownAllergies, knownAdverseReactions, majorSurgeries));
    }

    public int insertComprehensiveRegistrationForm(Date registrationDate, BasicDetails basicDetails, ContactDetails contactDetails, ContactNextOfKin nextOfKinContactDetails, PersonalDetails peronalDetails, ProfessionDetails professionDetails, Lifestyle lifestyle, BasicComplaints basicComplaints, ImportantMedicalComplaints importantMedicalComplaints) {
        return repo.insertComprehensiveRegistrationForm(new ComprehensiveRegistrationForm(null, registrationDate, basicDetails, contactDetails, nextOfKinContactDetails, peronalDetails, professionDetails, lifestyle, basicComplaints, importantMedicalComplaints));
    }

    public int insertContactNextOfKin(String nextOfKinName, String nextOfKinRelationship, ContactDetails nextOfKinContactDetails) {
        return repo.insertContactNextOfKin(new ContactNextOfKin(null, nextOfKinName, nextOfKinRelationship, nextOfKinContactDetails));
    }

    public void updatePatient(Patient patient) {
        repo.updatePatient(patient);
    }

    public Doctor getDoctor(int doctorID) {
        return repo.getDoctor(doctorID);
    }

    public boolean checkDoctorForID(int doctorID) {
        return repo.checkDoctorForID(doctorID);
    }

    public void deleteAppointment(Integer appointmentID) {
        repo.deleteAppointment(appointmentID);
    }

    public void deleteBill(Integer billID) {
        repo.deleteBill(billID);
    }

    public List<ComprehensiveRegistrationForm> getComprehensiveRegistrationForms() {
        return repo.getAllComprehensiveRegistrationForms();
    }
}