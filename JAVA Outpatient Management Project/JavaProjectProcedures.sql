use ProjectJava
go

--------------------------------
-----------PROCEDURES-----------
--------------------------------

--------------------------------
--Procedures for Basic Details--
--------------------------------

--create basic details for patient
create proc CreateBasicDetails
	@PatientName nvarchar(100),
	@Sex nvarchar(1),
	@DateOfBirth date,
	@IDBasicDetails int output
as 
begin 
	insert into BasicDetails 
	values(@PatientName, @Sex, @DateOfBirth)
	set @IDBasicDetails = SCOPE_IDENTITY()
end
go

--get basic details for patient
create proc GetBasicDetails
	@IDBasicDetails int
as 
begin 
	select * from BasicDetails
	where IDBasicDetails = @IDBasicDetails
end
go

--update basic details for patient
create proc UpdateBasicDetails
	@PatientName nvarchar(100),
	@Sex nvarchar(1),
	@DateOfBirth date,
	@IDBasicDetails int
as
begin
	update BasicDetails 
	set PatientName = @PatientName, Sex = @Sex, DateOfBirth = @DateOfBirth
	where IDBasicDetails = @IDBasicDetails
end
go

--delete basic details for patient
create proc DeleteBasicDetails
	@IDBasicDetails int	 
as
begin 
	delete from BasicDetails
	where IDBasicDetails = @IDBasicDetails
end
go

------------------------------------
--Procedures for Residence Address--
------------------------------------

--create present or permanent address for patient
create proc CreateResidenceAddress
	@DoorNo nvarchar(50),
	@Street nvarchar(50),
	@Area nvarchar(50),
	@City nvarchar(50),
	@StateName nvarchar(50),
	@Pincode nvarchar(50),
	@IDResidenceAddress int output
as 
begin 
	insert into ResidenceAddress 
	values(@DoorNo, @Street, @Area, @City, @StateName, @Pincode)
	set @IDResidenceAddress = SCOPE_IDENTITY()
end
go

--get patient address
create proc GetResidenceAddress
	@IDResidenceAddress int
as 
begin 
	select * from ResidenceAddress
	where IDResidenceAddress = @IDResidenceAddress
end
go

--update present or permanent address of patient
create proc UpdateResidenceAddress
	@DoorNo nvarchar(50),
	@Street nvarchar(50),
	@Area nvarchar(50),
	@City nvarchar(50),
	@StateName nvarchar(50),
	@Pincode nvarchar(50),
	@IDResidenceAddress int 	 
as 
begin 
	update ResidenceAddress
	set DoorNo = @DoorNo, Street = @Street, Area = @Area, City = @City, StateName = @StateName, Pincode = @Pincode
	where IDResidenceAddress = @IDResidenceAddress
end
go

--delete present or permanent address of patient
create proc DeleteResidenceAddress
	@IDResidenceAddress int
as
begin
	delete from ResidenceAddress
	where IDResidenceAddress = @IDResidenceAddress
end
go

-------------------------------------------
--Procedures for Phone/Fax/Email Contacts--
-------------------------------------------

--create phone/fax/email contacts
create proc CreatePhoneFaxEmailContacts
	@TelephoneWork nvarchar(20),
	@TelephoneHome nvarchar(20),
	@Mobile nvarchar(20),
	@Pager nvarchar(20),
	@Fax nvarchar(20),
	@Email nvarchar(100),
	@IDPhoneFaxEmailContact int output	
as 
begin 
	insert into PhoneFaxEmailContacts 
	values(@TelephoneWork, @TelephoneHome, @Mobile, @Pager, @Fax, @Email)
	set @IDPhoneFaxEmailContact = SCOPE_IDENTITY()
end
go

--get phone/fax/email contacts
create proc GetPhoneFaxEmailContacts
	@IDPhoneFaxEmailContact int
as 
begin 
	select * from PhoneFaxEmailContacts
	where IDPhoneFaxEmailContact = @IDPhoneFaxEmailContact
end
go

--update phone/fax/email contacts
create proc UpdatePhoneFaxEmailContacts
	@TelephoneWork nvarchar(20),
	@TelephoneHome nvarchar(20),
	@Mobile nvarchar(20),
	@Pager nvarchar(20),
	@Fax nvarchar(20),
	@Email nvarchar(100),
	@IDPhoneFaxEmailContact int	 
as 
begin 
	update PhoneFaxEmailContacts
	set TelephoneWork = @TelephoneWork, TelephoneHome = @TelephoneHome, Mobile = @Mobile, Pager = @Pager, Fax = @Fax, Email = @Email
	where IDPhoneFaxEmailContact = @IDPhoneFaxEmailContact
end
go

--delete phone/fax/email contacts
create proc DeletePhoneFaxEmailContacts
	@IDPhoneFaxEmailContact int	 
as 
begin 
	delete from PhoneFaxEmailContacts
	where IDPhoneFaxEmailContact = @IDPhoneFaxEmailContact
end
go

----------------------------------
--Procedures for Contact Details--
----------------------------------

--create full contact details
create proc CreateContactDetails
	@PresentAddress int,
	@PermanentAddress int,
	@TelephoneFaxEmail int,
	@IDContactDetails int output
as 
begin 
	insert into ContactDetails 
	values(@PresentAddress, @PermanentAddress, @TelephoneFaxEmail)
	set @IDContactDetails = SCOPE_IDENTITY()
end
go

--get full contact details
create proc GetContactDetails
	@IDContactDetails int
as
begin
	select * from ContactDetails
	where IDContactDetails = @IDContactDetails
end
go

--update full contact details
create proc UpdateContactDetails
	@PresentAddress int,
	@PermanentAddress int,
	@TelephoneFaxEmail int,
	@IDContactDetails int
as
begin
	update ContactDetails 
	set	PresentAddress = @PresentAddress, PermanentAddress = @PermanentAddress, TelephoneFaxEmail = @TelephoneFaxEmail			
	where IDContactDetails = @IDContactDetails
end
go

--delete contact details
create proc DeleteContactDetails
	@IDContactDetails int	 
as
begin
	delete from ContactDetails
	where IDContactDetails = @IDContactDetails
end
go

--------------------------------------
--Procedures for Contact Next-Of-Kin--
--------------------------------------

--create contact of next-of-kin
create proc CreateContactNextOfKin
	@NextOfKinName nvarchar(100),
	@RelationshipWithPatient nvarchar(20),
	@ContactDetail int,
	@IDNextOfKin int output
as 
begin 
	insert into ContactNextOfKin 
	values(@NextOfKinName, @RelationshipWithPatient, @ContactDetail)
	set @IDNextOfKin = SCOPE_IDENTITY()
end
go

--get contact of next-of-kin
create proc GetContactNextOfKin
	@IDNextOfKin int
as 
begin 
	select * from ContactNextOfKin
	where IDNextOfKin = @IDNextOfKin
end
go

--update contact of next-of-kin
create proc UpdateContactNextOfKin
	@NextOfKinName nvarchar(100),
	@RelationshipWithPatient nvarchar(20),
	@ContactDetail int,
	@IDNextOfKin int 
as 
begin 
	update ContactNextOfKin 
	set	NextOfKinName = @NextOfKinName, RelationshipWithPatient = @RelationshipWithPatient, ContactDetail = @ContactDetail			
	where IDNextOfKin = @IDNextOfKin
end
go

--delete contact of next-of-kin
create proc DeleteContactNextOfKin
	@IDNextOfKin int	 
as 
begin 
	delete from ContactNextOfKin
	where IDNextOfKin = @IDNextOfKin
end
go

-----------------------------------
--Procedures for Personal Details--
-----------------------------------

--create personal details for patient
create proc CreatePersonalDetails
	@MaritalStatus nvarchar(20),
	@NoOfDependents int,
	@PatientHeight int,
	@PatientWeight int,
	@BloodTypeRH nvarchar(10),
	@IDPersonalDetails int output
as 
begin 
	insert into PersonalDetails 
	values(@MaritalStatus, @NoOfDependents, @PatientHeight, @PatientWeight, @BloodTypeRH)
	set @IDPersonalDetails = SCOPE_IDENTITY()
end
go

--get personal details of patient
create proc GetPersonalDetails
	@IDPersonalDetails int
as 
begin 
	select * from PersonalDetails
	where IDPersonalDetails = @IDPersonalDetails
end
go

--update personal details of patient
CREATE PROCEDURE updatePersonalDetails
	@MaritalStatus nvarchar(20),
	@NoOfDependents int,
	@PatientHeight int,
	@PatientWeight int,
	@BloodTypeRH nvarchar(10),
	@IDPersonalDetails int
as 
begin 
	update PersonalDetails 
	set	MaritalStatus = @MaritalStatus, NoOfDependents = @NoOfDependents, PatientHeight = @PatientHeight, PatientWeight = @PatientWeight, BloodTypeRH = @BloodTypeRH		
	where IDPersonalDetails = @IDPersonalDetails
end
go

--delete personal details of patient
create proc DeletePersonalDetails
	@IDPersonalDetails int	 
as 
begin 
	delete from PersonalDetails
	where IDPersonalDetails = @IDPersonalDetails
end
go

-------------------------------------
--Procedures for Profession Details--
-------------------------------------

--create profession details for patient
create proc CreateProfessionDetails
	@Occupation nvarchar(20),
	@GrossAnualIncome money,
	@IDProfessionDetails int output
as 
begin
	insert into ProfessionDetails 
	values(@Occupation, @GrossAnualIncome)
	set @IDProfessionDetails = SCOPE_IDENTITY()
end
go

--get profession details of patient
create proc GetProfessionDetails
	@IDProfessionDetails int
as 
begin 
	select * from ProfessionDetails
	where IDProfessionDetails = @IDProfessionDetails
end
go

--update profession details of patient
create proc UpdateProfessionDetails
	@Occupation nvarchar(20),
	@GrossAnualIncome money,
	@IDProfessionDetails int 
as 
begin 
	update ProfessionDetails
	set Occupation = @Occupation, GrossAnnualIncome = @GrossAnualIncome
	where IDProfessionDetails = @IDProfessionDetails
end
go

--delete profession details of patient
create proc DeleteProfessionDetails
	@IDProfessionDetails int	 
as 
begin 
	delete from ProfessionDetails
	where IDProfessionDetails = @IDProfessionDetails
end
go

----------------------------
--Procedures for Lifestyle--
----------------------------

--create lifestyle for patient
create proc CreateLifestyle
	@Vegetarian bit,
	@Smoker bit,
	@AverageNoOfCigarettesPerDay int,
	@ConsumeAlcoholicBeverage bit,
	@AverageNoOfDrinksPerDay int,
	@UseStimulants nvarchar(max),
	@ConsumptionOfCoffeeTeaPerDay int,
	@ConsumptionOfSoftDrinksPerDay int,
	@HaveRegularMeals nvarchar(max),
	@EatHomeFoodOrOutsidePredominantly nvarchar(max),
	@IDLifestyle int output
as 
begin 
	insert into Lifestyle 
	values(@Vegetarian, @Smoker, @AverageNoOfCigarettesPerDay, @ConsumeAlcoholicBeverage, @AverageNoOfDrinksPerDay, @UseStimulants,
		@ConsumptionOfCoffeeTeaPerDay, @ConsumptionOfSoftDrinksPerDay, @HaveRegularMeals, @EatHomeFoodOrOutsidePredominantly)
	set @IDLifestyle = SCOPE_IDENTITY()
end
go

--get lifestyle of patient
create proc GetLifestyle
	@IDLifestyle int
as 
begin 
	select * from Lifestyle
	where IDLifestyle = @IDLifestyle
end
go

--update lifestyle of patient
create proc UpdateLifestyle
	@Vegetarian bit,
	@Smoker bit,
	@AverageNoOfCigarettesPerDay int,
	@ConsumeAlcoholicBeverage bit,
	@AverageNoOfDrinksPerDay int,
	@UseStimulants nvarchar(max),
	@ConsumptionOfCoffeeTeaPerDay int,
	@ConsumptionOfSoftDrinksPerDay int,
	@HaveRegularMeals nvarchar(max),
	@EatHomeFoodOrOutsidePredominantly nvarchar(max),
	@IDLifestyle int	 
as 
begin 
	update Lifestyle 
	set	Vegetarian = @Vegetarian, Smoker = @Smoker, AverageNoOfCigarettesPerDay = @AverageNoOfCigarettesPerDay, ConsumeAlcoholicBeverage = @ConsumeAlcoholicBeverage,
		AverageNoOfDrinksPerDay = @AverageNoOfDrinksPerDay,	UseStimulants = @UseStimulants, ConsumptionOfCoffeeTeaPerDay = @ConsumptionOfCoffeeTeaPerDay, 
		ConsumptionOfSoftDrinksPerDay = @ConsumptionOfSoftDrinksPerDay, HaveRegularMeals = @HaveRegularMeals, EatHomeFoodOrOutsidePredominantly = @EatHomeFoodOrOutsidePredominantly
	where IDLifestyle = @IDLifestyle
end
go

--delete lifestyle of patient
create proc DeleteLifestyle
	@IDLifestyle int	 
as 
begin 
	delete from Lifestyle
	where IDLifestyle = @IDLifestyle
end
go

-----------------------------------
--Procedures for Basic Complaints--
-----------------------------------

--create a basic complaint
create proc CreateBasicComplaints
	@StatementOfComplaint nvarchar(max),
	@HistoryOfPreviousTreatment nvarchar(max),
	@PhysicianHospitalTreated nvarchar(max),
	@IDBasicComplaints int output
as 
begin 
	insert into BasicComplaints VALUES(@StatementOfComplaint, @HistoryOfPreviousTreatment, @PhysicianHospitalTreated)
	set @IDBasicComplaints = SCOPE_IDENTITY()
end
go

--get a basic complaint
create proc GetBasicComplaints
	@IDBasicComplaints INT
as 
begin 
	select * from BasicComplaints
	where IDBasicComplaints = @IDBasicComplaints
end
go

--update a basic complaint
create proc UpdateBasicComplaints
	@StatementOfComplaint nvarchar(max),
	@HistoryOfPreviousTreatment nvarchar(max),
	@PhysicianHospitalTreated nvarchar(max),
	@IDBasicComplaints int	 
as 
begin 
	update BasicComplaints 
	set StatementOfComplaint = @StatementOfComplaint, HistoryOfPreviousTreatment = @HistoryofPreviousTreatment,	PhysicianHospitalTreated = @PhysicianHospitalTreated
	where IDBasicComplaints = @IDBasicComplaints
end
go

--delete a basic complaint
create proc DeleteBasicComplaints
	@IDBasicComplaints int	 
as 
begin 
	delete from BasicComplaints
	where IDBasicComplaints = @IDBasicComplaints
end
go

-----------------------------------------------
--Procedures for Important Medical Complaints--
-----------------------------------------------

--create an important medical complaint
create proc CreateImportantMedicalComplaints
	@Diabetic nvarchar(max),
	@Hypertensive nvarchar(max),
	@CardiacCondition nvarchar(max),
	@OrthopedicCondition nvarchar(max),
	@MuscularCondition nvarchar(max),
	@NeurologicalCondition nvarchar(max),
	@DigestiveCondition nvarchar(max),
	@KnownAllergies nvarchar(max),
	@KnownAdverseReactionToSpecificDrugs nvarchar(max),
	@MajorSurgeries nvarchar(max),
	@IDImportantMedicalComplaints int output
as 
begin 
	insert into ImportantMedicalComplaints 
	values(@Diabetic, @Hypertensive, @CardiacCondition, @OrthopedicCondition, @MuscularCondition, @NeurologicalCondition, @DigestiveCondition,
	 @KnownAllergies, @KnownAdverseReactionToSpecificDrugs, @MajorSurgeries)
	set @IDImportantMedicalComplaints = SCOPE_IDENTITY()
end
go

--get an important medical complaint
create proc GetImportantMedicalComplaints
	@IDImportantMedicalComplaints int
as 
begin 
	select * from ImportantMedicalComplaints
	where IDImportantMedicalComplaints = @IDImportantMedicalComplaints
end
go

--update an important medical complaint
create proc UpdateImportantMedicalComplaints
	@Diabetic nvarchar(max),
	@Hypertensive nvarchar(max),
	@CardiacCondition nvarchar(max),
	@OrthopedicCondition nvarchar(max),
	@MuscularCondition nvarchar(max),
	@NeurologicalCondition nvarchar(max),
	@DigestiveCondition nvarchar(max),
	@KnownAllergies nvarchar(max),
	@KnownAdverseReactionToSpecificDrugs nvarchar(max),
	@MajorSurgeries nvarchar(max),
	@IDImportantMedicalComplaints int	 
as 
begin 
	update ImportantMedicalComplaints 
	set	Diabetic = @Diabetic, Hypertensive = @Hypertensive, CardiacCondition = @CardiacCondition, OrthopedicCondition = @OrthopedicCondition, MuscularCondition = @MuscularCondition,
		NeurologicalCondition = @NeurologicalCondition,	DigestiveCondition = @DigestiveCondition, KnownAllergies = @KnownAllergies, KnownAdverseReactionToSpecificDrugs = @KnownAdverseReactionToSpecificDrugs,
		MajorSurgeries = @MajorSurgeries
	where IDImportantMedicalComplaints = @IDImportantMedicalComplaints
end
go

--delete an important medical complaint
create proc DeleteImportantMedicalComplaints
	@IDImportantMedicalComplaints int	 
as 
begin 
	delete from ImportantMedicalComplaints
	where IDImportantMedicalComplaints = @IDImportantMedicalComplaints
end
go

---------------------------
--Procedures for Employee--
---------------------------

--create an employee
create proc CreateEmployee
	@DateOfBirth date, 
	@IDEmployee int output
as 
begin
	insert into Employee 
	values(@DateOfBirth)
	set @IDEmployee = SCOPE_IDENTITY()
end
go

--get an employee
create proc GetEmployee
	@IDEmployee int
as
begin
	select * from Employee
	where IDEmployee = @IDEmployee
end
go

--update an employee
create proc UpdateEmployee
	@DateOfBirth date, 
	@IDEmployee int
as 
begin 
	update Employee 
	set	DateOfBirth = @DateOfBirth
	where IDEmployee = @IDEmployee
end
go

--delete an employee
create proc DeleteEmployee
	@IDEmployee int	 
as 
begin 
	delete from Employee
	where IDEmployee = @IDEmployee
end
go

-------------------------
--Procedures for Doctor--
-------------------------

--create a doctor
create proc CreateDoctor
    @EmployeeID int, 
	@PersonalDetailsID int,  
	@BasicDetailsID int, 
	@ContactDetailsID int, 
	@IDDoctor int output
as 
begin 
	insert into Doctor 
	values(@EmployeeID, @PersonalDetailsID, @BasicDetailsID, @ContactDetailsID)
	set @IDDoctor = SCOPE_IDENTITY()
end
go

--get a doctor
create proc GetDoctor
	@IDDoctor int
as 
begin 
	select * from Doctor
	where IDDoctor = @IDDoctor
end
go

--update a doctor
create proc UpdateDoctor
	@EmployeeID int, 
	@PersonalDetailsID int, 
	@BasicDetailsID int,
	@ContactDetailsID int,
	@IDDoctor int	 
as 
begin 
	update Doctor 
	set	EmployeeID = @EmployeeID, PersonalDetailsID = @PersonalDetailsID, BasicDetailsID = @BasicDetailsID, ContactDetailsID = @ContactDetailsID
	where IDDoctor = @IDDoctor
end
go

--delete a doctor
create proc DeleteDoctor
	@IDDoctor int	 
as 
begin 
	delete from Doctor
	where IDDoctor = @IDDoctor
end
go

--------------------------
--Procedures for Patient--
--------------------------

--create a patient
create proc CreatePatient
	@DoctorID int,
	@MiniFormID int,
	@ComprehensiveFormID int,
	@IDOutPatient int output
as 
begin 
	insert into Patient 
	values(@DoctorID, @MiniFormID, @ComprehensiveFormID)
	set @IDOutPatient = SCOPE_IDENTITY()
end
go

--get a patient
create proc GetPatient
	@IDOutPatient int
as
begin
	select * from Patient
	where IDOutPatient = @IDOutPatient
end
go

--update a patient
create proc UpdatePatient
	@DoctorID int,
	@MiniFormID int,
	@ComprehensiveFormID int,
	@IDOutPatient int	 
as 
begin 
	update Patient 
	set	DoctorID = @DoctorID, MiniRegistrationFormID = @MiniFormID, CompRegistrationFormID = @ComprehensiveFormID
	where IDOutPatient = @IDOutPatient
end
go

--delete a patient
create proc DeletePatient
	@IDOutPatient int
as
begin
	delete from Patient
	where IDOutPatient = @IDOutPatient
end
go

--get a patient of a specific doctor
create proc GetPatientForDoctor
	@DoctorID int
as 
begin 
	select * from Patient
	where DoctorID = @DoctorID
end
go

------------------------------
--Procedures for Appointment--
------------------------------

--create an appointment
create proc CreateAppointment
    @PatientID int, 
	@DoctorID int, 
	@AppointmentDate date,  
	@IDAppointment int output
as 
begin 
	insert into Appointment 
	values(@PatientID, @DoctorID, @AppointmentDate)
	set @IDAppointment = SCOPE_IDENTITY()
end
go

--get an appointment
create proc GetAppointment
	@IDAppointment int
as 
begin 
	select * from Appointment
	where IDAppointment = @IDAppointment
end
go

--update an appointment
create proc UpdateAppointment
    @PatientID int, 
	@DoctorID int, 
	@AppointmentDate date,  
	@IDAppointment int	 
as 
begin 
	update Appointment 
	set	PatientID = @PatientID, DoctorID = @DoctorID, @AppointmentDate = @AppointmentDate
	where IDAppointment = @IDAppointment
end
go

--delete an appointment
create proc DeleteAppointment
	@IDAppointment int	 
as 
begin 
	delete from Appointment
	where IDAppointment = @IDAppointment
end
go

--get an appointment for a specific patient
create proc GetAppointmentForPatient
	@PatientID int
as 
begin 
	select * from Appointment
	where PatientID = @PatientID
end
go

--get an appointment for a specific doctor
create proc GetAppointmentForDoctor
	@DoctorID int
as 
begin 
	select * from Appointment
	where DoctorID = @DoctorID
end
go

-----------------------
--Procedures for Bill--
-----------------------

--create a bill
create proc CreateBill
    @PatientID int, 
	@BillItem nvarchar(max), 
	@BillPrice money, 
	@IDBill int output
as 
begin 
	insert into Bill 
	values(@PatientID, @BillItem, @BillPrice)
	set @IDBill = SCOPE_IDENTITY()
end
go

--get a bill
create proc GetBill
	@IDBill int
as 
begin 
	select * from Bill
	where IDBill = @IDBill
end
go

--update a bill
create proc UpdateBill
    @PatientID int, 
	@BillItem nvarchar(max), 
	@BillPrice money, 
	@IDBill int	 
as 
begin 
	update Bill 
	set PatientID = @PatientID, BillItem = @BillItem, BillPrice = @BillPrice		
	where IDBill = @IDBill
end
go

--delete a bill
create proc DeleteBill
	@IDBill int	 
as 
begin 
	delete from Bill
	where IDBill = @IDBill
end
go

--get a bill for a specific patient
create proc GetBillForPatient
	@PatientID int
as 
begin 
	select * from Bill
	where PatientID = @PatientID
end
go

--------------------------------------------------
--Procedures for Comprehensive Registration Form--
--------------------------------------------------

--create a comprehensive registration form
create proc CreateComprehensiveRegistrationForm
	@DateOfRegistration date,
	@BasicDetailsID int, 
	@ContactDetailsID int, 
	@ContactNextOfKinID int, 
	@PersonalDetailsID int, 
	@ProfessionDetailsID int,
	@LifestyleID int, 
	@BasicComplaintsID int, 
	@ImportantMedicalComplaintsID int, 
	@OutPatientID int,
	@IDCompRegForm int output
as 
begin 
	insert into ComprehensiveRegistrationForm 
	values(@DateOfRegistration, @BasicDetailsID, @ContactDetailsID, @ContactNextOfKinID, @PersonalDetailsID, @ProfessionDetailsID, @LifestyleID, @BasicComplaintsID, @ImportantMedicalComplaintsID, @OutPatientID)
	set @IDCompRegForm = SCOPE_IDENTITY()
end
go

--get a comprehensive registration form
create proc GetComprehensiveRegistrationForm
	@IDCompRegForm int
as 
begin 
	select * from ComprehensiveRegistrationForm 
	where @IDCompRegForm = @IDCompRegForm
end
go

--get all comprehensive registration forms
create proc GetAllComprehensiveRegistrationForms
as 
begin 
	select * from ComprehensiveRegistrationForm
end
go

--get a comprehensive registration form for a specific patient
create proc GetComprehensiveRegistrationFormForPatient
	@OutPatientID int
as 
begin 
	select * from ComprehensiveRegistrationForm
	where OutPatientID = @OutPatientID
end
go

--update a comprehensive registration form
create proc UpdateComprehensiveRegistrationForm
	@DateOfRegistration date,
	@BasicDetailsID int, 
	@ContactDetailsID int, 
	@ContactNextOfKinID int, 
	@PersonalDetailsID int, 
	@ProfessionDetailsID int,
	@LifestyleID int, 
	@BasicComplaintsID int, 
	@ImportantMedicalComplaintsID int, 
	@OutPatientID int,
	@IDCompRegForm int 
as 
begin 
	update ComprehensiveRegistrationForm 
	set	DateOfRegistration = @DateOfRegistration, BasicDetailsID = @BasicDetailsID, ContactDetailsID = @ContactDetailsID, ContactNextOfKinID = @ContactNextOfKinID,
		PersonalDetailsID = @PersonalDetailsID, ProfessionDetailsID = @ProfessionDetailsID,	LifestyleID = @LifestyleID, BasicComplaintsID = @BasicComplaintsID,
		ImportantMedicalComplaintsID = @ImportantMedicalComplaintsID, OutPatientID = @OutPatientID
	where IDCompRegForm = @IDCompRegForm
end
go

--delete a comprehensive registration form
create proc DeleteComprehensiveRegistrationForm
	@IDCompRegForm int	 
as 
begin 
	delete from ComprehensiveRegistrationForm
	where IDCompRegForm = @IDCompRegForm
end
go

-----------------------------------------
--Procedures for Mini Registration Form--
-----------------------------------------

--create a mini registration form
create proc CreateMiniRegistrationForm
	@DateOfRegistration date,
	@PatientName nvarchar(100),
	@Sex nvarchar(1),
	@DateOfBirth nvarchar(max),
	@BriefStatementOfComplain nvarchar(max),
	@ContactTelNumber1 nvarchar(20),
	@ContactTelNumber2 nvarchar(20),
	@NextOfKinName nvarchar(80),
	@RelationshipToPatitent nvarchar(10),
	@OutPatientID int, 
	@IDMiniRegForm int output
as 
begin
	insert into MiniRegistrationForm 
	values(@DateOfRegistration, @PatientName, @Sex, @DateOfBirth, @BriefStatementOfComplain, @ContactTelNumber2, @ContactTelNumber1, @NextOfKinName, @RelationshipToPatitent, @OutPatientID)
	set @IDMiniRegForm = SCOPE_IDENTITY()
end
go

--get a mini registration form
create proc GetMiniRegistrationForm
	@IDMiniRegForm INT
as 
begin 
	select * from MiniRegistrationForm
	where IDMiniRegForm = @IDMiniRegForm
end
go

--get all mini registration forms
create proc GetAllMiniRegistrationForms
as 
begin 
	select * from MiniRegistrationForm
end
go

--get a mini registration form for a specific patient
create proc GetMiniRegistrationFormForPatient
	@OutPatientID int
as 
begin 
	select * from MiniRegistrationForm
	where OutPatientID = @OutPatientID
end
go

--update a mini registration form
create proc UpdateMiniRegistrationForm
	@DateOfRegistration date,
	@PatientName nvarchar(100),
	@Sex nvarchar(1),
	@DateOfBirth nvarchar(max),
	@BriefStatementOfComplain nvarchar(max),
	@ContactTelNumber1 nvarchar(20),
	@ContactTelNumber2 nvarchar(20),
	@NextOfKinName nvarchar(80),
	@RelationshipToPatitent nvarchar(10),
	@OutPatientID int, 
	@IDMiniRegForm int
as 
begin 
	update MiniRegistrationForm 
	set	DateOfRegistration = @DateOfRegistration, PatientName = @PatientName, Sex = @Sex, DateOfBirth = @DateOfBirth, BriefStatementOfComplain = @BriefStatementOfComplain,
		ContactTelNumber2 = @ContactTelNumber2, ContactTelNumber1 = @ContactTelNumber1, NextOfKinName=@NextOfKinName, NextOfKinName = @NextOfKinName, OutPatientID = @OutPatientID
	where IDMiniRegForm = @IDMiniRegForm
end
go

--delete a mini registration form
create proc DeleteMiniRegistrationForm
	@IDMiniRegForm int	 
as 
begin 
	delete from MiniRegistrationForm
	where IDMiniRegForm = @IDMiniRegForm
end
go
