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
public class ImportantMedicalComplaints {
    private Integer IDImportantMedicalComplaints;
    private boolean Diabetic;
    private boolean Hypertensive;
    private String CardiacCondition;
    private String OrthopedicCondition;
    private String MuscularCondition;
    private String NeurologicalCondition;
    private String DigestiveCondition;
    private String KnownAllergies;
    private String KnownAdverseReactionToSpecificDrugs;
    private String MajorSurgeries;    

    public ImportantMedicalComplaints(Integer IDImportantMedicalComplaints, boolean Diabetic, boolean Hypertensive, String CardiacCondition, String OrthopedicCondition, String MuscularCondition, String NeurologicalCondition, String DigestiveCondition, String KnownAllergies, String KnownAdverseReactionToSpecificDrugs, String MajorSurgeries) {
        this.IDImportantMedicalComplaints = IDImportantMedicalComplaints;
        this.Diabetic = Diabetic;
        this.Hypertensive = Hypertensive;
        this.CardiacCondition = CardiacCondition;
        this.OrthopedicCondition = OrthopedicCondition;
        this.MuscularCondition = MuscularCondition;
        this.NeurologicalCondition = NeurologicalCondition;
        this.DigestiveCondition = DigestiveCondition;
        this.KnownAllergies = KnownAllergies;
        this.KnownAdverseReactionToSpecificDrugs = KnownAdverseReactionToSpecificDrugs;
        this.MajorSurgeries = MajorSurgeries;
    }

    public Integer getIDImportantMedicalComplaints() {
        return IDImportantMedicalComplaints;
    }

    public void setIDImportantMedicalComplaints(Integer IDImportantMedicalComplaints) {
        this.IDImportantMedicalComplaints = IDImportantMedicalComplaints;
    }

    public boolean getDiabetic() {
        return Diabetic;
    }

    public void setDiabetic(boolean Diabetic) {
        this.Diabetic = Diabetic;
    }

    public boolean getHypertensive() {
        return Hypertensive;
    }

    public void setHypertensive(boolean Hypertensive) {
        this.Hypertensive = Hypertensive;
    }

    public String getCardiacCondition() {
        return CardiacCondition;
    }

    public void setCardiacCondition(String CardiacCondition) {
        this.CardiacCondition = CardiacCondition;
    }

    public String getOrthopedicCondition() {
        return OrthopedicCondition;
    }

    public void setOrthopedicCondition(String OrthopedicCondition) {
        this.OrthopedicCondition = OrthopedicCondition;
    }

    public String getMuscularCondition() {
        return MuscularCondition;
    }

    public void setMuscularCondition(String MuscularCondition) {
        this.MuscularCondition = MuscularCondition;
    }

    public String getNeurologicalCondition() {
        return NeurologicalCondition;
    }

    public void setNeurologicalCondition(String NeurologicalCondition) {
        this.NeurologicalCondition = NeurologicalCondition;
    }

    public String getDigestiveCondition() {
        return DigestiveCondition;
    }

    public void setDigestiveCondition(String DigestiveCondition) {
        this.DigestiveCondition = DigestiveCondition;
    }

    public String getKnownAllergies() {
        return KnownAllergies;
    }

    public void setKnownAllergies(String KnownAllergies) {
        this.KnownAllergies = KnownAllergies;
    }

    public String getKnownAdverseReactionToSpecificDrugs() {
        return KnownAdverseReactionToSpecificDrugs;
    }

    public void setKnownAdverseReactionToSpecificDrugs(String KnownAdverseReactionToSpecificDrugs) {
        this.KnownAdverseReactionToSpecificDrugs = KnownAdverseReactionToSpecificDrugs;
    }

    public String getMajorSurgeries() {
        return MajorSurgeries;
    }

    public void setMajorSurgeries(String MajorSurgeries) {
        this.MajorSurgeries = MajorSurgeries;
    }

    @Override
    public String toString() {
        return "ImportantMedicalComplaints{" + "IDImportantMedicalComplaints=" + IDImportantMedicalComplaints + ", Diabetic=" + Diabetic + ", Hypertensive=" + Hypertensive + ", CardiacCondition=" + CardiacCondition + ", OrthopedicCondition=" + OrthopedicCondition + ", MuscularCondition=" + MuscularCondition + ", NeurologicalCondition=" + NeurologicalCondition + ", DigestiveCondition=" + DigestiveCondition + ", KnownAllergies=" + KnownAllergies + ", KnownAdverseReactionToSpecificDrugs=" + KnownAdverseReactionToSpecificDrugs + ", MajorSurgeries=" + MajorSurgeries + '}';
    }
    
    
}
