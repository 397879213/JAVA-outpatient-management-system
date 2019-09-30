/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sepl.dal.repo;

import com.sepl.dal.database.DataSourceSingleton;
import com.sepl.dal.model.Appointment;
import com.sepl.dal.model.BasicComplaints;
import com.sepl.dal.model.BasicDetails;
import com.sepl.dal.model.Bill;
import com.sepl.dal.model.ComprehensiveRegistrationForm;
import com.sepl.dal.model.ContactDetails;
import com.sepl.dal.model.ContactNextOfKin;
import com.sepl.dal.model.Doctor;
import com.sepl.dal.model.DoctorType;
import com.sepl.dal.model.ImportantMedicalComplaints;
import com.sepl.dal.model.Lifestyle;
import com.sepl.dal.model.MiniRegistrationForm;
import com.sepl.dal.model.Patient;
import com.sepl.dal.model.PersonalDetails;
import com.sepl.dal.model.PhoneFaxEmailContacts;
import com.sepl.dal.model.ProfessionDetails;
import com.sepl.dal.model.ResidenceAddress;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import jdk.nashorn.internal.objects.Global;

/**
 *
 * @author Vilcha
 */
public class SQLRepo implements IRepo{

    private DataSource ds = DataSourceSingleton.getInstance();
    
    @Override
    public int insertBasicDetails(BasicDetails basicDetails) {
        final String InsertBasicDetails = "{ CALL InsertBasicDetails (?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(InsertBasicDetails)) {
            stm.setString("PatientName", basicDetails.getPatientName());
            stm.setString("Sex", basicDetails.getSex());
            stm.setDate("DateOfBirth", basicDetails.getDateOfBirth());
            stm.registerOutParameter("IDBasicDetails", Types.INTEGER);
            stm.executeUpdate();
            return stm.getInt("IDBasicDetails");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateBasicDetails(BasicDetails basicDetails, int basicDetailsID) {
        final String UpdateBasicDetails = "{ CALL UpdateBasicDetails (?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(UpdateBasicDetails)) {
            stm.setString("PatientName", basicDetails.getPatientName());
            stm.setString("Sex", basicDetails.getSex());
            stm.setDate("DateOfBirth", basicDetails.getDateOfBirth());
            stm.setInt("IDBasicDetails", basicDetailsID);
            stm.executeUpdate();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBasicDetails(int basicDetailsID) {
        final String DeleteBasicDetails = "{ CALL DeleteBasicDetails (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(DeleteBasicDetails)) {
            stm.setInt("IDBasicDetails", basicDetailsID);
            stm.executeUpdate();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BasicDetails getBasicDetails(int basicDetailsID) {
       final String GetBasicDetails = "{ CALL GetBasicDetails (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetBasicDetails)) {
            stm.setInt("IDBasicDetails", basicDetailsID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new BasicDetails(
                        rs.getInt("IDBasicDetails"),
                        rs.getString("PatientName"),
                        rs.getString("Sex"),
                        rs.getDate("DateOfBirth")
                    );
                }
            }            
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        return null;
    }

    @Override
    public int insertResidenceAddress(ResidenceAddress address) {
        final String InsertResidenceAddress = "{ CALL InsertResidenceAddress (?,?,?,?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(InsertResidenceAddress)) {
            stm.setString("DoorNo", address.getDoorNumber());
            stm.setString("Street", address.getStreet());
            stm.setString("Area", address.getArea());
            stm.setString("City", address.getCity());
            stm.setString("StateName", address.getStateName());
            stm.setString("Pincode", address.getPincode());
            stm.registerOutParameter("IDResidenceAddress", Types.INTEGER);
            stm.executeUpdate();
            return stm.getInt("IDResidenceAddress");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateResidenceAddress(ResidenceAddress address, int addressID) {
        final String UpdateResidenceAddress = "{ CALL UpdateResidenceAddress (?,?,?,?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(UpdateResidenceAddress)) {
            stm.setString("DoorNo", address.getDoorNumber());
            stm.setString("Street", address.getStreet());
            stm.setString("Area", address.getArea());
            stm.setString("City", address.getCity());
            stm.setString("StateName", address.getStateName());
            stm.setString("Pincode", address.getPincode());
            stm.setInt("IDResidenceAddress", addressID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }

    @Override
    public void deleteResidenceAddress(int addressID) {
        final String DeleteResidenceAddress = "{ CALL DeleteResidenceAddress (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(DeleteResidenceAddress)) {
            stm.setInt("IDResidenceAddress", addressID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }   
    }

    @Override
    public ResidenceAddress getResidenceAddress(int addressID) {
        final String GetResidenceAddress = "{ CALL GetResidenceAddress (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetResidenceAddress)) {
            stm.setInt("IDResidenceAddress", addressID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new ResidenceAddress(
                            rs.getInt("IDResidenceAddress"),
                            rs.getString("DoorNo"),
                            rs.getString("Street"),
                            rs.getString("Area"),
                            rs.getString("City"),
                            rs.getString("StateName"),
                            rs.getString("Pincode")
                    );
                }
            }
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }    

    @Override
    public int insertPhoneFaxEmailContacts(PhoneFaxEmailContacts pfeContacts) {
        final String InsertPhoneFaxEmailContacts = "{ CALL InsertPhoneFaxEmailContacts (?,?,?,?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(InsertPhoneFaxEmailContacts)) {
            stm.setString("TelephoneWork", pfeContacts.getTelephoneWork());
            stm.setString("TelephoneHome", pfeContacts.getTelephoneHome());
            stm.setString("Mobile", pfeContacts.getMobile());
            stm.setString("Pager", pfeContacts.getPager());
            stm.setString("Fax", pfeContacts.getFax());
            stm.setString("Email", pfeContacts.getEmail());
            stm.registerOutParameter("IDPhoneFaxEmailContacts", Types.INTEGER);
            stm.executeUpdate();
            return stm.getInt("IDPhoneFaxEmailContacts");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updatePhoneFaxEmailContacts(PhoneFaxEmailContacts pfeContacts, int pfeContactsID) {
        final String UpdatePhoneFaxEmailContacts = "{ CALL UpdatePhoneFaxEmailContacts (?,?,?,?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(UpdatePhoneFaxEmailContacts)) {
            stm.setString("TelephoneWork", pfeContacts.getTelephoneWork());
            stm.setString("TelephoneHome", pfeContacts.getTelephoneHome());
            stm.setString("Mobile", pfeContacts.getMobile());
            stm.setString("Pager", pfeContacts.getPager());
            stm.setString("Fax", pfeContacts.getFax());
            stm.setString("Email", pfeContacts.getEmail());
            stm.setInt("IDPhoneFaxEmailContacts", pfeContactsID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePhoneFaxEmailContacts(int pfeContactsID) {
        final String DeletePhoneFaxEmailContacts = "{ CALL DeletePhoneFaxEmailContacts (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(DeletePhoneFaxEmailContacts)) {
            stm.setInt("IDPhoneFaxEmailContacts", pfeContactsID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PhoneFaxEmailContacts getPhoneFaxEmailContacts(int pfeContactsID) {
        final String GetPhoneFaxEmailContacts = "{ CALL GetPhoneFaxEmailContacts (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetPhoneFaxEmailContacts)) {
            stm.setInt("IDPhoneFaxEmailContacts", pfeContactsID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new PhoneFaxEmailContacts(
                            rs.getInt("IDPhoneFaxEmailContacts"),
                            rs.getString("TelephoneWork"),
                            rs.getString("TelephoneHome"),
                            rs.getString("Mobile"),
                            rs.getString("Pager"),
                            rs.getString("Fax"),
                            rs.getString("Email")
                    );
                }
            }
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }

    @Override
    public int insertContactDetails(ContactDetails contactDetails) {
        final String InsertContactDetails = "{ CALL InsertContactDetails (?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(InsertContactDetails)) {
            if (contactDetails.getPresentAddress() == null) {
                stm.setNull("PresentAddressID", java.sql.Types.NULL);
            }else{
                stm.setInt("PresentAddressID", contactDetails.getPresentAddress().getIDResidenceAddress());                
            }
            
            if (contactDetails.getPermanentAddress()== null) {
                stm.setNull("PermanentAddressID", java.sql.Types.NULL);
            }else{
                stm.setInt("PermanentAddressID", contactDetails.getPermanentAddress().getIDResidenceAddress());         
            }
            
            if (contactDetails.getTelephoneFaxEmail() == null) {
                stm.setNull("TelephoneFaxEmailID", java.sql.Types.NULL);
            }else{
                stm.setInt("TelephoneFaxEmailID", contactDetails.getTelephoneFaxEmail().getIDPhoneFaxEmailContacts());
            }
            
            stm.registerOutParameter("IDContactDetails", Types.INTEGER);
            stm.executeUpdate();
            return stm.getInt("IDContactDetails");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateContactDetails(ContactDetails contactDetails, int contactDetailsID) {
        final String UpdateContactDetails = "{ CALL UpdateContactDetails (?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(UpdateContactDetails)) {
            if (contactDetails.getPresentAddress() == null) {
                stm.setNull("PresentAddressID", java.sql.Types.NULL);
            }else{
                stm.setInt("PresentAddressID", contactDetails.getPresentAddress().getIDResidenceAddress());                
            }
            
            if (contactDetails.getPermanentAddress()== null) {
                stm.setNull("PermanentAddressID", java.sql.Types.NULL);
            }else{
                stm.setInt("PermanentAddressID", contactDetails.getPermanentAddress().getIDResidenceAddress());         
            }
            
            if (contactDetails.getTelephoneFaxEmail() == null) {
                stm.setNull("TelephoneFaxEmailID", java.sql.Types.NULL);
            }else{
                stm.setInt("TelephoneFaxEmailID", contactDetails.getTelephoneFaxEmail().getIDPhoneFaxEmailContacts());
            }
            
            stm.setInt("IDContactDetails", contactDetailsID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteContactDetails(int contactDetailsID) {
        final String DeleteContactDetails = "{ CALL DeleteContactDetails (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(DeleteContactDetails)) {           
            stm.setInt("IDContactDetails", contactDetailsID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ContactDetails getContactDetails(int contactDetailsID) {
        final String GetContactDetails = "{ CALL GetContactDetails (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetContactDetails)) {
            stm.setInt("IDContactDetails", contactDetailsID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new ContactDetails(
                            rs.getInt("IDContactDetails"),
                            getResidenceAddress(rs.getInt("PresentAddressID")),
                            getResidenceAddress(rs.getInt("PermanentAddressID")),
                            getPhoneFaxEmailContacts(rs.getInt("TelephoneFaxEmailID"))
                    );
                }
            }
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }

    @Override
    public int insertContactNextOfKin(ContactNextOfKin contactNextOfKin) {
        final String InsertContactNextOfKin = "{ CALL InsertContactNextOfKin (?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(InsertContactNextOfKin)) {
            stm.setString("NextOfKinName", contactNextOfKin.getNextOfKinName());
            stm.setString("RelationshipWithPatient", contactNextOfKin.getRelationshipWithPatient());
            
            if (contactNextOfKin.getNextOfKinContactDetails() == null) {
                stm.setNull("ContactDetailsID", java.sql.Types.NULL);
            }else{
                stm.setInt("ContactDetailsID", contactNextOfKin.getNextOfKinContactDetails().getIDContactDetails());
            }
            
            stm.registerOutParameter("IDNextOfKin", Types.INTEGER);
            stm.executeUpdate();
            return stm.getInt("IDNextOfKin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateContactNextOfKin(ContactNextOfKin contactNextOfKin, int contactNextOfKinID) {
        final String UpdateContactNextOfKin = "{ CALL UpdateContactNextOfKin (?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(UpdateContactNextOfKin)) {
            stm.setString("NextOfKinName", contactNextOfKin.getNextOfKinName());
            stm.setString("RelationshipWithPatient", contactNextOfKin.getRelationshipWithPatient());
            
            if (contactNextOfKin.getNextOfKinContactDetails() == null) {
                stm.setNull("ContactDetailsID", java.sql.Types.NULL);
            }else{
                stm.setInt("ContactDetailsID", contactNextOfKin.getNextOfKinContactDetails().getIDContactDetails());
            }
            
            stm.setInt("IDNextOfKin", contactNextOfKinID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteContactNextOfKin(int contactNextOfKinID) {
        final String DeleteContactNextOfKin = "{ CALL DeleteContactNextOfKin (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(DeleteContactNextOfKin)) {
            stm.setInt("IDNextOfKin", contactNextOfKinID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ContactNextOfKin getContactNextOfKin(int contactNextOfKinID) {
        final String GetContactNextOfKin = "{ CALL GetContactNextOfKin (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetContactNextOfKin)) {
            stm.setInt("IDNextOfKin", contactNextOfKinID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new ContactNextOfKin(
                            rs.getInt("IDNextOfKin"),
                            rs.getString("NextOfKinName"),
                            rs.getString("RelationshipWithPatient"),
                            getContactDetails(rs.getInt("ContactDetailsID"))
                    );
                }
            }
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }

    @Override
    public int insertPersonalDetails(PersonalDetails personalDetails) {
        final String InsertPersonalDetails = "{ CALL InsertPersonalDetails (?,?,?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(InsertPersonalDetails)) {
            stm.setString("MaritalStatus", personalDetails.getMaritalStatus());
            stm.setInt("NoOfDependents", personalDetails.getNoOfDependents());                       
            stm.setInt("PatientHeight", personalDetails.getPatientHeight());                       
            stm.setInt("PatientWeight", personalDetails.getPatientWeight());                       
            stm.setString("BloodTypeRH", personalDetails.getBloodTypeRH());                       
            stm.registerOutParameter("IDPersonalDetails", Types.INTEGER);
            stm.executeUpdate();
            return stm.getInt("IDPersonalDetails");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updatePersonalDetails(PersonalDetails personalDetails, int personalDetailsID) {
        final String UpdatePersonalDetails = "{ CALL UpdatePersonalDetails (?,?,?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(UpdatePersonalDetails)) {
            stm.setString("MaritalStatus", personalDetails.getMaritalStatus());
            stm.setInt("NoOfDependents", personalDetails.getNoOfDependents());                       
            stm.setInt("PatientHeight", personalDetails.getPatientHeight());                       
            stm.setInt("PatientWeight", personalDetails.getPatientWeight());                       
            stm.setString("BloodTypeRH", personalDetails.getBloodTypeRH());                       
            stm.setInt("IDPersonalDetails", personalDetailsID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePersonalDetails(int personalDetailsID) {
        final String DeletePersonalDetails = "{ CALL DeletePersonalDetails (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(DeletePersonalDetails)) {                    
            stm.setInt("IDPersonalDetails", personalDetailsID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PersonalDetails getPersonalDetails(int personalDetailsID) {
        final String GetPersonalDetails = "{ CALL GetPersonalDetails (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetPersonalDetails)) {
            stm.setInt("IDPersonalDetails", personalDetailsID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new PersonalDetails(
                            rs.getInt("IDPersonalDetails"),
                            rs.getString("MaritalStatus"),
                            rs.getInt("NoOfDependents"),
                            rs.getInt("PatientHeight"),
                            rs.getInt("PatientWeight"),
                            rs.getString("BloodTypeRH")
                    );
                }
            }
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }

    @Override
    public int insertProfessionDetails(ProfessionDetails professionDetails) {
        final String InsertProfessionDetails = "{ CALL InsertProfessionDetails (?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(InsertProfessionDetails)) {
            stm.setString("Occupation", professionDetails.getOccupation());
            stm.setBigDecimal("GrossAnnualIncome", professionDetails.getGrossAnnualIncome());                       
            stm.registerOutParameter("IDProfessionDetails", Types.INTEGER);
            stm.executeUpdate();
            return stm.getInt("IDProfessionDetails");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateProfessionDetails(ProfessionDetails professionDetails, int professionDetailsID) {
        final String UpdateProfessionDetails = "{ CALL UpdateProfessionDetails (?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(UpdateProfessionDetails)) {
            stm.setString("Occupation", professionDetails.getOccupation());
            stm.setBigDecimal("GrossAnnualIncome", professionDetails.getGrossAnnualIncome());                       
            stm.setInt("IDProfessionDetails", professionDetailsID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProfessionDetails(int professionDetailsID) {
        final String DeleteProfessionDetails = "{ CALL DeleteProfessionDetails (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(DeleteProfessionDetails)) {                     
            stm.setInt("IDProfessionDetails", professionDetailsID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProfessionDetails getProfessionDetails(int professionDetailsID) {
        final String GetProfessionDetails = "{ CALL GetProfessionDetails (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetProfessionDetails)) {
            stm.setInt("IDProfessionDetails", professionDetailsID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new ProfessionDetails(
                            rs.getInt("IDProfessionDetails"),
                            rs.getString("Occupation"),
                            rs.getBigDecimal("GrossAnnualIncome")
                    );
                }
            }
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }
    
    @Override
    public int insertLifestyle(Lifestyle lifestyle) {
        final String InsertLifestyle = "{ CALL InsertLifestyle (?,?,?,?,?,?,?,?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(InsertLifestyle)) {
            stm.setBoolean("Vegetarian", lifestyle.getVegetarian());
            stm.setBoolean("Smoker", lifestyle.getSmoker());                       
            stm.setInt("AverageNoOfCigarettesPerDay", lifestyle.getAverageNoOfCigarettesPerDay());                       
            stm.setBoolean("AlcoholConsumer", lifestyle.getAlcoholConsumer());                       
            stm.setInt("AverageNoOfDrinksPerDay", lifestyle.getAveragenoOfDrinksPerDay());                       
            stm.setString("UseStimulants", lifestyle.getUseStimulants());
            stm.setInt("ConsumptionOfCoffeeTeaPerDay", lifestyle.getConsumptionOfCoffeeTeaPerDay());                       
            stm.setInt("ConsumptionOfSoftDrinksPerDay", lifestyle.getConsumptionOfSoftDrinksPerDay());                       
            stm.setString("HaveRegularMeals", lifestyle.getHaveRegularMeals());                       
            stm.setString("EatHomeFoodOrOutsidePredominantly", lifestyle.getEatHomeFoodOrOutsidePredominantly());                       
            stm.registerOutParameter("IDLifestyle", Types.INTEGER);
            stm.executeUpdate();
            return stm.getInt("IDLifestyle");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateLifestyle(Lifestyle lifestyle, int lifestyleID) {
        final String UpdateLifestyle = "{ CALL UpdateLifestyle (?,?,?,?,?,?,?,?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(UpdateLifestyle)) {
            stm.setBoolean("Vegetarian", lifestyle.getVegetarian());
            stm.setBoolean("Smoker", lifestyle.getSmoker());                       
            stm.setInt("AverageNoOfCigarettesPerDay", lifestyle.getAverageNoOfCigarettesPerDay());                       
            stm.setBoolean("AlcoholConsumer", lifestyle.getAlcoholConsumer());                       
            stm.setInt("AverageNoOfDrinksPerDay", lifestyle.getAveragenoOfDrinksPerDay());                       
            stm.setString("UseStimulants", lifestyle.getUseStimulants());
            stm.setInt("ConsumptionOfCoffeeTeaPerDay", lifestyle.getConsumptionOfCoffeeTeaPerDay());                       
            stm.setInt("ConsumptionOfSoftDrinksPerDay", lifestyle.getConsumptionOfSoftDrinksPerDay());                       
            stm.setString("HaveRegularMeals", lifestyle.getHaveRegularMeals());                       
            stm.setString("EatHomeFoodOrOutsidePredominantly", lifestyle.getEatHomeFoodOrOutsidePredominantly());                       
            stm.setInt("IDLifestyle", lifestyleID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteLifestyle(int lifestyleID) {
        final String DeleteLifestyle = "{ CALL DeleteLifestyle (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(DeleteLifestyle)) {                 
            stm.setInt("IDLifestyle", lifestyleID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Lifestyle getLifestyle(int lifestyleID) {
        final String GetLifestyle = "{ CALL GetLifestyle (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetLifestyle)) {
            stm.setInt("IDLifestyle", lifestyleID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new Lifestyle(
                            rs.getInt("IDLifestyle"),
                            rs.getBoolean("Vegetarian"),
                            rs.getBoolean("Smoker"),
                            rs.getInt("AverageNoOfCigarettesPerDay"),
                            rs.getBoolean("AlcoholConsumer"),
                            rs.getInt("AverageNoOfDrinksPerDay"),
                            rs.getString("UseStimulants"),
                            rs.getInt("ConsumptionOfCoffeeTeaPerDay"),
                            rs.getInt("ConsumptionOfSoftDrinksPerDay"),
                            rs.getString("HaveRegularMeals"),
                            rs.getString("EatHomeFoodOrOutsidePredominantly")
                    );
                }
            }
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }

    @Override
    public int insertBasicComplaints(BasicComplaints basicComplaints) {
        final String InsertBasicComplaints = "{ CALL InsertBasicComplaints (?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(InsertBasicComplaints)) {
            stm.setString("StatementOfComplaint", basicComplaints.getStatementOfComplaint());
            stm.setString("HistoryOfPreviousTreatment", basicComplaints.getHistoryOfPreviousTreatment());                       
            stm.setString("PhysicianHospitalTreated", basicComplaints.getPhysicianHospitalTreated());                                         
            stm.registerOutParameter("IDBasicComplaints", Types.INTEGER);
            stm.executeUpdate();
            return stm.getInt("IDBasicComplaints");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateBasicComplaints(BasicComplaints basicComplaints, int basicComplaintsID) {
        final String UpdateLifestyle = "{ CALL UpdateLifestyle (?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(UpdateLifestyle)) {
            stm.setString("StatementOfComplaint", basicComplaints.getStatementOfComplaint());
            stm.setString("HistoryOfPreviousTreatment", basicComplaints.getHistoryOfPreviousTreatment());                       
            stm.setString("PhysicianHospitalTreated", basicComplaints.getPhysicianHospitalTreated());                                         
            stm.setInt("IDBasicComplaints", basicComplaintsID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBasicComplaints(int basicComplaintsID) {
        final String DeleteLifestyle = "{ CALL DeleteLifestyle (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(DeleteLifestyle)) {                   
            stm.setInt("IDBasicComplaints", basicComplaintsID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BasicComplaints getBasicComplaints(int basicComplaintsID) {
        final String GetBasicComplaints = "{ CALL GetBasicComplaints (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetBasicComplaints)) {
            stm.setInt("IDBasicComplaints", basicComplaintsID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new BasicComplaints(
                            rs.getInt("IDBasicComplaints"),
                            rs.getString("StatementOfComplaint"),
                            rs.getString("HistoryOfPreviousTreatment"),
                            rs.getString("PhysicianHospitalTreated")
                    );
                }
            }
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }

    @Override
    public int insertImportantMedicalComplaints(ImportantMedicalComplaints importantMedicalComplaints) {
        final String InsertImportantMedicalComplaints = "{ CALL InsertImportantMedicalComplaints (?,?,?,?,?,?,?,?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(InsertImportantMedicalComplaints)) {
            stm.setBoolean("Diabetic", importantMedicalComplaints.getDiabetic());
            stm.setBoolean("Hypertensive", importantMedicalComplaints.getHypertensive());                       
            stm.setString("CardiacCondition", importantMedicalComplaints.getCardiacCondition());                                         
            stm.setString("OrthopedicCondition", importantMedicalComplaints.getOrthopedicCondition());
            stm.setString("MuscularCondition", importantMedicalComplaints.getMuscularCondition());                       
            stm.setString("NeurologicalCondition", importantMedicalComplaints.getNeurologicalCondition());                                         
            stm.setString("DigestiveCondition", importantMedicalComplaints.getDigestiveCondition());
            stm.setString("KnownAllergies", importantMedicalComplaints.getKnownAllergies());                       
            stm.setString("KnownAdverseReactionToSpecificDrugs", importantMedicalComplaints.getKnownAdverseReactionToSpecificDrugs());                                         
            stm.setString("MajorSurgeries", importantMedicalComplaints.getMajorSurgeries());                                         
            stm.registerOutParameter("IDImportantMedicalComplaints", Types.INTEGER);
            stm.executeUpdate();
            return stm.getInt("IDImportantMedicalComplaints");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateImportantMedicalComplaints(ImportantMedicalComplaints importantMedicalComplaints, int importantMedicalComplaintsID) {
        final String UpdateImportantMedicalComplaints = "{ CALL UpdateImportantMedicalComplaints (?,?,?,?,?,?,?,?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(UpdateImportantMedicalComplaints)) {
            stm.setBoolean("Diabetic", importantMedicalComplaints.getDiabetic());
            stm.setBoolean("Hypertensive", importantMedicalComplaints.getHypertensive());                       
            stm.setString("CardiacCondition", importantMedicalComplaints.getCardiacCondition());                                         
            stm.setString("OrthopedicCondition", importantMedicalComplaints.getOrthopedicCondition());
            stm.setString("MuscularCondition", importantMedicalComplaints.getMuscularCondition());                       
            stm.setString("NeurologicalCondition", importantMedicalComplaints.getNeurologicalCondition());                                         
            stm.setString("DigestiveCondition", importantMedicalComplaints.getDigestiveCondition());
            stm.setString("KnownAllergies", importantMedicalComplaints.getKnownAllergies());                       
            stm.setString("KnownAdverseReactionToSpecificDrugs", importantMedicalComplaints.getKnownAdverseReactionToSpecificDrugs());                                         
            stm.setString("MajorSurgeries", importantMedicalComplaints.getMajorSurgeries());                                         
            stm.setInt("IDImportantMedicalComplaints", importantMedicalComplaintsID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteImportantMedicalComplaints(int importantMedicalComplaintsID) {
        final String DeleteImportantMedicalComplaints = "{ CALL DeleteImportantMedicalComplaints (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(DeleteImportantMedicalComplaints)) {                                      
            stm.setInt("IDImportantMedicalComplaints", importantMedicalComplaintsID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ImportantMedicalComplaints getImportantMedicalComplaints(int importantMedicalComplaintsID) {
        final String GetImportantMedicalComplaints = "{ CALL GetImportantMedicalComplaints (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetImportantMedicalComplaints)) {
            stm.setInt("IDImportantMedicalComplaints", importantMedicalComplaintsID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new ImportantMedicalComplaints(
                            rs.getInt("IDImportantMedicalComplaints"),
                            rs.getBoolean("Diabetic"),
                            rs.getBoolean("Hypertensive"),
                            rs.getString("CardiacCondition"),
                            rs.getString("OrthopedicCondition"),
                            rs.getString("MuscularCondition"),
                            rs.getString("NeurologicalCondition"),
                            rs.getString("DigestiveCondition"),
                            rs.getString("KnownAllergies"),
                            rs.getString("KnownAdverseReactionToSpecificDrugs"),
                            rs.getString("MajorSurgeries")
                    );
                }
            }
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }

    @Override
    public int insertMiniRegistrationForm(MiniRegistrationForm miniRegForm){
        final String InsertMiniRegistrationForm = "{ CALL InsertMiniRegistrationForm (?,?,?,?,?,?,?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(InsertMiniRegistrationForm)) {
            stm.setDate("DateOfRegistration", miniRegForm.getRegistrationDate());
            stm.setString("PatientName", miniRegForm.getPatientName());                       
            stm.setString("Sex", miniRegForm.getSex());                                         
            stm.setDate("DateOfBirth", miniRegForm.getDateOfBirth());
            stm.setString("BriefStatementOfComplaint", miniRegForm.getBreifStatementOfComplaint());                       
            stm.setString("ContactTelNumber1", miniRegForm.getPhoneNumber1());                                         
            stm.setString("ContactTelNumber2", miniRegForm.getPhoneNumber2());
            stm.setString("NextOfKinName", miniRegForm.getNextOfKinName());                       
            stm.setString("RelationshipToPatitent", miniRegForm.getRelationshipToPatitent());                                         
            stm.registerOutParameter("IDMiniRegForm", Types.INTEGER);
            stm.executeUpdate();
            return stm.getInt("IDMiniRegForm");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateMiniRegistrationForm(MiniRegistrationForm miniRegForm, int miniRegFormID) {
        final String UpdateMiniRegistrationForm = "{ CALL UpdateMiniRegistrationForm (?,?,?,?,?,?,?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(UpdateMiniRegistrationForm)) {
            stm.setDate("DateOfRegistration", miniRegForm.getRegistrationDate());
            stm.setString("PatientName", miniRegForm.getPatientName());                       
            stm.setString("Sex", miniRegForm.getSex());                                         
            stm.setDate("DateOfBirth", miniRegForm.getDateOfBirth());
            stm.setString("BriefStatementOfComplaint", miniRegForm.getBreifStatementOfComplaint());                       
            stm.setString("ContactTelNumber1", miniRegForm.getPhoneNumber1());                                         
            stm.setString("ContactTelNumber2", miniRegForm.getPhoneNumber2());
            stm.setString("NextOfKinName", miniRegForm.getNextOfKinName());                       
            stm.setString("RelationshipToPatitent", miniRegForm.getRelationshipToPatitent());                                         
            stm.setInt("IDMiniRegForm", miniRegFormID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMiniRegistrationForm(int miniRegFormID) {
        final String DeleteMiniRegistrationForm = "{ CALL DeleteMiniRegistrationForm (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(DeleteMiniRegistrationForm)) {                                 
            stm.setInt("IDMiniRegForm", miniRegFormID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MiniRegistrationForm getMiniRegistrationForm(int miniRegFormID) {
        final String GetMiniRegistrationForm = "{ CALL GetMiniRegistrationForm (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetMiniRegistrationForm)) {
            stm.setInt("IDMiniRegForm", miniRegFormID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new MiniRegistrationForm(
                            rs.getInt("IDMiniRegForm"),
                            rs.getDate("DateOfRegistration"),
                            rs.getString("PatientName"),
                            rs.getString("Sex"),
                            rs.getDate("DateOfBirth"),
                            rs.getString("BriefStatementOfComplaint"),
                            rs.getString("ContactTelNumber1"),
                            rs.getString("ContactTelNumber2"),
                            rs.getString("NextOfKinName"),
                            rs.getString("RelationshipToPatient")
                    );
                }
            }
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }

    @Override
    public int insertComprehensiveRegistrationForm(ComprehensiveRegistrationForm compRegForm) {
        final String InsertComprehensiveRegistrationForm = "{ CALL InsertComprehensiveRegistrationForm (?,?,?,?,?,?,?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(InsertComprehensiveRegistrationForm)) {
            stm.setDate("DateOfRegistration", compRegForm.getRegistrationDate());
            
            if (compRegForm.getBasicDetails() == null) {
                stm.setNull("BasicDetailsID", java.sql.Types.NULL);
            }else{
                stm.setInt("BasicDetailsID", compRegForm.getBasicDetails().getIDBasicDetails());         
            }
            
            if (compRegForm.getContactDetails() == null) {
                stm.setNull("ContactDetailsID", java.sql.Types.NULL);
            }else{
                stm.setInt("ContactDetailsID", compRegForm.getContactDetails().getIDContactDetails());
            }
            
            if (compRegForm.getContactNextOfKin() == null) {
                stm.setNull("ContactNextOfKinID", java.sql.Types.NULL);
            }else{
                stm.setInt("ContactNextOfKinID", compRegForm.getContactNextOfKin().getIDNextOfKin());                
            }
            
            if (compRegForm.getPersonalDetails() == null) {
                stm.setNull("PersonalDetailsID", java.sql.Types.NULL);
            }else{
                stm.setInt("PersonalDetailsID", compRegForm.getPersonalDetails().getIDPersonalDetails());         
            }
            
            if (compRegForm.getProfessionDetails()== null) {
                stm.setNull("ProfessionDetailsID", java.sql.Types.NULL);
            }else{
                stm.setInt("ProfessionDetailsID", compRegForm.getProfessionDetails().getIDProfessionDetails());
            }
            
            if (compRegForm.getLifestyle()== null) {
                stm.setNull("LifestyleID", java.sql.Types.NULL);
            }else{
                stm.setInt("LifestyleID", compRegForm.getLifestyle().getIDLifeStyle());                
            }
            
            if (compRegForm.getBasicComplaints()== null) {
                stm.setNull("BasicComplaintsID", java.sql.Types.NULL);
            }else{
                stm.setInt("BasicComplaintsID", compRegForm.getBasicComplaints().getIDBasicComplaints());         
            }
            
            if (compRegForm.getImportantMedicalComplaints()== null) {
                stm.setNull("ImportantMedicalComplaintsID", java.sql.Types.NULL);
            }else{
                stm.setInt("ImportantMedicalComplaintsID", compRegForm.getImportantMedicalComplaints().getIDImportantMedicalComplaints());
            }
            stm.registerOutParameter("IDCompRegForm", Types.INTEGER);
            stm.executeUpdate();
            return stm.getInt("IDCompRegForm");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateComprehensiveRegistrationForm(ComprehensiveRegistrationForm compRegForm, int compRegFormID) {
        final String UpdateComprehensiveRegistrationForm = "{ CALL UpdateComprehensiveRegistrationForm (?,?,?,?,?,?,?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(UpdateComprehensiveRegistrationForm)) {
            stm.setDate("DateOfRegistration", compRegForm.getRegistrationDate());
            
            if (compRegForm.getBasicDetails() == null) {
                stm.setNull("BasicDetailsID", java.sql.Types.NULL);
            }else{
                stm.setInt("BasicDetailsID", compRegForm.getBasicDetails().getIDBasicDetails());         
            }
            
            if (compRegForm.getContactDetails() == null) {
                stm.setNull("ContactDetailsID", java.sql.Types.NULL);
            }else{
                stm.setInt("ContactDetailsID", compRegForm.getContactDetails().getIDContactDetails());
            }
            
            if (compRegForm.getContactNextOfKin() == null) {
                stm.setNull("ContactNextOfKinID", java.sql.Types.NULL);
            }else{
                stm.setInt("ContactNextOfKinID", compRegForm.getContactNextOfKin().getIDNextOfKin());                
            }
            
            if (compRegForm.getPersonalDetails() == null) {
                stm.setNull("PersonalDetailsID", java.sql.Types.NULL);
            }else{
                stm.setInt("PersonalDetailsID", compRegForm.getPersonalDetails().getIDPersonalDetails());         
            }
            
            if (compRegForm.getProfessionDetails()== null) {
                stm.setNull("ProfessionDetailsID", java.sql.Types.NULL);
            }else{
                stm.setInt("ProfessionDetailsID", compRegForm.getProfessionDetails().getIDProfessionDetails());
            }
            
            if (compRegForm.getLifestyle()== null) {
                stm.setNull("LifestyleID", java.sql.Types.NULL);
            }else{
                stm.setInt("LifestyleID", compRegForm.getLifestyle().getIDLifeStyle());                
            }
            
            if (compRegForm.getBasicComplaints()== null) {
                stm.setNull("BasicComplaintsID", java.sql.Types.NULL);
            }else{
                stm.setInt("BasicComplaintsID", compRegForm.getBasicComplaints().getIDBasicComplaints());         
            }
            
            if (compRegForm.getImportantMedicalComplaints()== null) {
                stm.setNull("ImportantMedicalComplaintsID", java.sql.Types.NULL);
            }else{
                stm.setInt("ImportantMedicalComplaintsID", compRegForm.getImportantMedicalComplaints().getIDImportantMedicalComplaints());
            }
            stm.setInt("IDCompRegForm", compRegFormID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteComprehensiveRegistrationForm(int compRegFormID) {
        final String DeleteComprehensiveRegistrationForm = "{ CALL DeleteComprehensiveRegistrationForm (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(DeleteComprehensiveRegistrationForm)) {                                 
            stm.setInt("IDCompRegForm", compRegFormID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ComprehensiveRegistrationForm getComprehensiveRegistrationForm(int compRegFormID) {
        if (compRegFormID == 0) {
            return null;
        }
        final String GetComprehensiveRegistrationForm = "{ CALL GetComprehensiveRegistrationForm (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetComprehensiveRegistrationForm)) {
            stm.setInt("IDCompRegForm", compRegFormID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new ComprehensiveRegistrationForm(
                            rs.getInt("IDCompRegForm"),
                            rs.getDate("DateOfRegistration"),
                            getBasicDetails(rs.getInt("BasicDetailsID")),
                            getContactDetails(rs.getInt("ContactDetailsID")),
                            getContactNextOfKin(rs.getInt("ContactNextOfKinID")),
                            getPersonalDetails(rs.getInt("PersonalDetailsID")),
                            getProfessionDetails(rs.getInt("ProfessionDetailsID")),
                            getLifestyle(rs.getInt("LifestyleID")),
                            getBasicComplaints(rs.getInt("BasicComplaintsID")),
                            getImportantMedicalComplaints(rs.getInt("ImportantMedicalComplaintsID"))
                    );
                }
            }
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }
    

    @Override
    public int insertDoctor(Doctor doctor) {
        final String InsertDoctor = "{ CALL InsertDoctor (?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(InsertDoctor)) {
            if (doctor.getDoctorType() == null) {
                stm.setNull("DoctorTypeID", java.sql.Types.NULL);
            }else{
                stm.setInt("DoctorTypeID", doctor.getDoctorType().getIDDoctorType());                
            }
            
            if (doctor.getBasicDetails() == null) {
                stm.setNull("BasicDetailsID", java.sql.Types.NULL);
            }else{
                stm.setInt("BasicDetailsID", doctor.getBasicDetails().getIDBasicDetails());         
            }
            
            if (doctor.getContactDetails() == null) {
                stm.setNull("ContactDetailsID", java.sql.Types.NULL);
            }else{
                stm.setInt("ContactDetailsID", doctor.getContactDetails().getIDContactDetails());
            }                                    
            stm.registerOutParameter("IDDoctor", Types.INTEGER);
            stm.executeUpdate();
            return stm.getInt("IDDoctor");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateDoctor(Doctor doctor, int doctorID) {
        final String UpdateDoctor = "{ CALL UpdateDoctor (?,?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(UpdateDoctor)) {
            if (doctor.getDoctorType() == null) {
                stm.setNull("DoctorTypeID", java.sql.Types.NULL);
            }else{
                stm.setInt("DoctorTypeID", doctor.getDoctorType().getIDDoctorType());                
            }
            
            if (doctor.getBasicDetails() == null) {
                stm.setNull("BasicDetailsID", java.sql.Types.NULL);
            }else{
                stm.setInt("BasicDetailsID", doctor.getBasicDetails().getIDBasicDetails());         
            }
            
            if (doctor.getContactDetails() == null) {
                stm.setNull("ContactDetailsID", java.sql.Types.NULL);
            }else{
                stm.setInt("ContactDetailsID", doctor.getContactDetails().getIDContactDetails());
            }                                    
            stm.setInt("IDDoctor", doctorID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDoctor(int doctorID) {
        final String DeleteDoctor = "{ CALL DeleteDoctor (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(DeleteDoctor)) {                                           
            stm.setInt("IDDoctor", doctorID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Doctor getDoctor(int doctorID) {
        if (doctorID == 0) {
            return null;
        }
        final String GetDoctor = "{ CALL GetDoctor (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetDoctor)) {
            stm.setInt("IDDoctor", doctorID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new Doctor(
                            rs.getInt("IDDoctor"),
                            getDoctorType(rs.getInt("DoctorTypeID")),
                            getBasicDetails(rs.getInt("BasicDetailsID")),
                            getContactDetails(rs.getInt("ContactDetailsID"))
                    );
                }
            }
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }
    
    @Override
    public int insertPatient(Patient patient) {
        final String InsertPatient = "{ CALL InsertPatient (?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(InsertPatient)) {
            if (patient.getDoctor() == null) {
                stm.setNull("DoctorID", java.sql.Types.NULL);
            }else{
                stm.setInt("DoctorID", patient.getDoctor().getIDDoctor());
            }
            
            if (patient.getMiniRegForm()== null) {
                stm.setNull("MiniRegFormID", java.sql.Types.NULL);
            }else{
                stm.setInt("MiniRegFormID", patient.getMiniRegForm().getIDMiniRegForm());  
            }
            
            if (patient.getCompRegForm() == null) {
                stm.setNull("CompRegFormID", java.sql.Types.NULL);
            }else{
                stm.setInt("CompRegFormID", patient.getCompRegForm().getIDCompRegForm());                                                                                                 
            }
            stm.registerOutParameter("IDPatient", Types.INTEGER);
            stm.executeUpdate();
            return stm.getInt("IDPatient");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }   

    @Override
    public Patient getPatient(int patientID) {
        final String GetPatient = "{ CALL GetPatient (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetPatient)) {
            stm.setInt("IDPatient", patientID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new Patient(
                            rs.getInt("IDPatient"),
                            getDoctor(rs.getInt("DoctorID")),
                            getMiniRegistrationForm(rs.getInt("MiniRegFormID")),
                            getComprehensiveRegistrationForm(rs.getInt("CompRegFormID"))
                    );
                }
            }
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }

    @Override
    public boolean checkPatientForID(int patientID) {
        final String GetPatient = "{ CALL GetPatient (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetPatient)) {
            stm.setInt("IDPatient", patientID);
            try (ResultSet rs = stm.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return false;
    }
    
    @Override
    public boolean checkDoctorForID(int doctorID) {
        final String GetDoctor = "{ CALL GetDoctor (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetDoctor)) {
            stm.setInt("IDDoctor", doctorID);
            try (ResultSet rs = stm.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return false;
    }

    @Override
    public DoctorType getDoctorType(int doctorTypeID) {
        final String GetDoctorType = "{ CALL GetDoctorType (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetDoctorType)) {
            stm.setInt("IDDoctorType", doctorTypeID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new DoctorType(
                            rs.getInt("IDDoctorType"),
                            rs.getString("TypeName")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }

    @Override
    public int insertAppointment(Appointment appointment) {
        final String InsertAppointment = "{ CALL InsertAppointment (?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(InsertAppointment)) {
            stm.setInt("PatientID", appointment.getPatient().getIDPatient());     
            stm.setInt("DoctorID", appointment.getDoctor().getIDDoctor());     
            stm.setDate("AppointmentDate", appointment.getAppointmentDate());     
            stm.registerOutParameter("IDAppointment", Types.INTEGER);
            stm.executeUpdate();
            return stm.getInt("IDAppointment");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateAppointment(Appointment appointment, int appointmentID) {
        final String UpdateAppointment = "{ CALL UpdateAppointment (?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(UpdateAppointment)) {
            stm.setInt("PatientID", appointment.getPatient().getIDPatient());     
            stm.setInt("DoctorID", appointment.getDoctor().getIDDoctor());     
            stm.setDate("AppointmentDate", appointment.getAppointmentDate());     
            stm.setInt("IDAppointment", appointmentID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAppointment(int appointmentID) {
        final String DeleteAppointment = "{ CALL DeleteAppointment (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(DeleteAppointment)) {   
            stm.setInt("IDAppointment", appointmentID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Appointment getAppointment(int appointmentID) {
        final String GetAppointment = "{ CALL GetAppointment (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetAppointment)) {
            stm.setInt("IDAppointment", appointmentID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new Appointment(
                            rs.getInt("IDAppointment"),
                            getDoctor(rs.getInt("DoctorID")),
                            getPatient(rs.getInt("PatientID")),
                            rs.getDate("AppointmentDate")
                    );
                }
            }
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }

    @Override
    public int insertBill(Bill bill) {
        final String InsertBill = "{ CALL InsertBill (?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(InsertBill)) {
            stm.setInt("PatientID", bill.getPatient().getIDPatient());     
            stm.setString("BillItem", bill.getBillItem());     
            stm.setBigDecimal("BillPrice", bill.getBillPrice());     
            stm.registerOutParameter("IDBill", Types.INTEGER);
            stm.executeUpdate();
            return stm.getInt("IDBill");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateBill(Bill bill, int billID) {
        final String UpdateBill = "{ CALL UpdateBill (?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(UpdateBill)) {
            stm.setInt("PatientID", bill.getPatient().getIDPatient());     
            stm.setString("BillItem", bill.getBillItem());     
            stm.setBigDecimal("BillPrice", bill.getBillPrice());     
            stm.setInt("IDBill", billID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBill(int billID) {
        final String DeleteBill = "{ CALL DeleteBill (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(DeleteBill)) {
            stm.setInt("IDBill", billID);
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Bill getBill(int billID) {
        final String GetBill = "{ CALL GetBill (?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetBill)) {
            stm.setInt("IDBill", billID);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return new Bill(
                            rs.getInt("IDAppointment"),
                            getPatient(rs.getInt("PatientID")),
                            rs.getString("BillItem"),
                            rs.getBigDecimal("BillPrice")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }

    @Override
    public List<Appointment> getAppointmentForPatient(Integer idPatient) {
        final String GetAppointmentForPatient = "{ CALL GetAppointmentForPatient (?) }";
        List<Appointment> appointments = new ArrayList<>();
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetAppointmentForPatient)) {
            stm.setInt("PatientID", idPatient);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    appointments.add(new Appointment(rs.getInt("IDAppointment"), getDoctor(rs.getInt("DoctorID")), getPatient(rs.getInt("PatientID")), rs.getDate("AppointmentDate")));
                }
            }
            return appointments;
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }
    
    @Override
    public List<Bill> getBillForPatient(Integer idPatient) {
        final String GetBillForPatient = "{ CALL GetBillForPatient (?) }";
        List<Bill> bills = new ArrayList<>();
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetBillForPatient)) {
            stm.setInt("PatientID", idPatient);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    bills.add(new Bill(rs.getInt("IDBill"), getPatient(rs.getInt("PatientID")), rs.getString("BillItem"), rs.getBigDecimal("BillPrice")));
                }
            }
            return bills;
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }

    @Override
    public void updatePatient(Patient patient) {
        final String UpdatePatient = "{ CALL UpdatePatient (?,?,?,?) }";
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(UpdatePatient)) {
            if (patient.getDoctor() == null) {
                stm.setNull("DoctorID", java.sql.Types.NULL);
            }else{
                stm.setInt("DoctorID", patient.getDoctor().getIDDoctor());
            }
            stm.setInt("MiniRegFormID", patient.getMiniRegForm().getIDMiniRegForm());  
            if (patient.getCompRegForm() == null) {
                stm.setNull("CompRegFormID", java.sql.Types.NULL);
            }else{
                stm.setInt("CompRegFormID", patient.getCompRegForm().getIDCompRegForm());                                                                                                 
            }
            stm.setInt("IDPatient", patient.getIDPatient());
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ComprehensiveRegistrationForm> getAllComprehensiveRegistrationForms() {
        final String GetAllComprehensiveRegistrationForms = "{ CALL GetAllComprehensiveRegistrationForms }";
        List<ComprehensiveRegistrationForm> compRegForms = new ArrayList<>();
        try (Connection con = ds.getConnection(); CallableStatement stm = con.prepareCall(GetAllComprehensiveRegistrationForms)) {
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    compRegForms.add(new ComprehensiveRegistrationForm(
                            rs.getInt("IDCompRegForm"), 
                            rs.getDate("DateOfRegistration"), 
                            getBasicDetails(rs.getInt("BasicDetailsID")), 
                            getContactDetails(rs.getInt("ContactDetailsID")), 
                            getContactNextOfKin(rs.getInt("ContactNextOfKinID")), 
                            getPersonalDetails(rs.getInt("PersonalDetailsID")),
                            getProfessionDetails(rs.getInt("ProfessionDetailsID")), 
                            getLifestyle(rs.getInt("LifestyleID")), 
                            getBasicComplaints(rs.getInt("BasicComplaintsID")), 
                            getImportantMedicalComplaints(rs.getInt("ImportantMedicalComplaintsID"))));
                }
            }
            return compRegForms;
        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return null;
    }
}
