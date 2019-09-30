/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sepl.dal.repo;

import com.sepl.dal.model.*;
import java.util.List;

/**
 *
 * @author Vilcha
 */
public interface IRepo {
    
    public int insertBasicDetails(BasicDetails basicDetails);
    public void updateBasicDetails(BasicDetails basicDetails, int basicDetailsID);
    public void deleteBasicDetails(int basicDetailsID);
    public BasicDetails getBasicDetails(int basicDetailsID);
    
    public int insertResidenceAddress(ResidenceAddress address);
    public void updateResidenceAddress(ResidenceAddress address, int addressID);
    public void deleteResidenceAddress(int addressID);
    public ResidenceAddress getResidenceAddress(int addressID);
    
    public int insertPhoneFaxEmailContacts(PhoneFaxEmailContacts pfeContacts);
    public void updatePhoneFaxEmailContacts(PhoneFaxEmailContacts pfeContacts, int pfeContactsID);
    public void deletePhoneFaxEmailContacts(int pfeContactsID);
    public PhoneFaxEmailContacts getPhoneFaxEmailContacts(int pfeContactsID);
    
    public int insertContactDetails(ContactDetails contactDetails);
    public void updateContactDetails(ContactDetails contactDetails, int contactDetailsID);
    public void deleteContactDetails(int contactDetailsID);
    public ContactDetails getContactDetails(int contactDetailsID);
    
    public int insertContactNextOfKin(ContactNextOfKin contactNextOfKin);
    public void updateContactNextOfKin(ContactNextOfKin contactNextOfKin, int contactNextOfKinID);
    public void deleteContactNextOfKin(int contactNextOfKinID);
    public ContactNextOfKin getContactNextOfKin(int contactNextOfKinID);
    
    public int insertPersonalDetails(PersonalDetails personalDetails);
    public void updatePersonalDetails(PersonalDetails personalDetails, int personalDetailsID);
    public void deletePersonalDetails(int personalDetailsID);
    public PersonalDetails getPersonalDetails(int personalDetailsID);
    
    public int insertProfessionDetails(ProfessionDetails professionDetails);
    public void updateProfessionDetails(ProfessionDetails professionDetails, int professionDetailsID);
    public void deleteProfessionDetails(int professionDetailsID);
    public ProfessionDetails getProfessionDetails(int professionDetailsID);
    
    public int insertLifestyle(Lifestyle lifestyle);
    public void updateLifestyle(Lifestyle lifestyle, int lifestyleID);
    public void deleteLifestyle(int lifestyleID);
    public Lifestyle getLifestyle(int lifestyleID);
    
    public int insertBasicComplaints(BasicComplaints basicComplaints);
    public void updateBasicComplaints(BasicComplaints basicComplaints, int basicComplaintsID);
    public void deleteBasicComplaints(int basicComplaintsID);
    public BasicComplaints getBasicComplaints(int basicComplaintsID);
    
    public int insertImportantMedicalComplaints(ImportantMedicalComplaints importantMedicalComplaints);
    public void updateImportantMedicalComplaints(ImportantMedicalComplaints importantMedicalComplaints, int importantMedicalComplaintsID);
    public void deleteImportantMedicalComplaints(int importantMedicalComplaintsID);
    public ImportantMedicalComplaints getImportantMedicalComplaints(int importantMedicalComplaintsID);
    
    public int insertMiniRegistrationForm(MiniRegistrationForm miniRegForm);
    public void updateMiniRegistrationForm(MiniRegistrationForm miniRegForm, int miniRegFormID);
    public void deleteMiniRegistrationForm(int miniRegFormID);
    public MiniRegistrationForm getMiniRegistrationForm(int miniRegFormID);
    
    public int insertComprehensiveRegistrationForm(ComprehensiveRegistrationForm compRegForm);
    public void updateComprehensiveRegistrationForm(ComprehensiveRegistrationForm compRegForm, int compRegFormID);
    public void deleteComprehensiveRegistrationForm(int compRegFormID);
    public ComprehensiveRegistrationForm getComprehensiveRegistrationForm(int compRegFormID);
    
    public int insertDoctor(Doctor doctor);
    public void updateDoctor(Doctor doctor, int doctorID);
    public void deleteDoctor(int doctorID);
    public Doctor getDoctor(int doctorID);
    
    public int insertAppointment(Appointment appointment);
    public void updateAppointment(Appointment appointment, int appointmentID);
    public void deleteAppointment(int appointmentID);
    public Appointment getAppointment(int appointmentID);
    
    public int insertBill(Bill bill);
    public void updateBill(Bill bill, int billID);
    public void deleteBill(int billID);
    public Bill getBill(int billID);
    
    public DoctorType getDoctorType(int doctorTypeID);
    
    public int insertPatient(Patient patient);
    public void updatePatient(Patient patient);

    public boolean checkPatientForID(int patientID);
    public boolean checkDoctorForID(int doctorID);
    
    public Patient getPatient(int patientID);

    public List<Appointment> getAppointmentForPatient(Integer idPatient);
    public List<Bill> getBillForPatient(Integer idPatient);

    public List<ComprehensiveRegistrationForm> getAllComprehensiveRegistrationForms();
}
