use ProjectJava
go
 
-----------------------------------
--------------TABLES---------------
-----------------------------------

-----------------------------------
--Comprehensive Registration Form--
-----------------------------------

create table BasicDetails
(
	IDBasicDetails int primary key identity,
	PatientName nvarchar(100),
	Sex nvarchar(1),
	DateOfBirth date,
)
go

create table ResidenceAddress
(
	IDResidenceAddress int primary key identity,
	DoorNo nvarchar(50),
	Street nvarchar(50),
	Area nvarchar(50),
	City nvarchar(50),
	StateName nvarchar(50),
	Pincode nvarchar(50)
)
go

create table PhoneFaxEmailContacts
(
	IDPhoneFaxEmailContact int primary key identity,
	TelephoneWork nvarchar(20),
	TelephoneHome nvarchar(20),
	Mobile nvarchar(20),
	Pager nvarchar(20),
	Fax nvarchar(20),
	Email nvarchar(100)
)
go

create table ContactDetails
(
	IDContactDetails int primary key identity,
	PresentAddress  int foreign key references ResidenceAddress(IDResidenceAddress),
	PermanentAddress int foreign key references ResidenceAddress(IDResidenceAddress),
	TelephoneFaxEmail int foreign key references PhoneFaxEmailContacts(IDPhoneFaxEmailContact)
)
go

create table ContactNextOfKin
(
	IDNextOfKin int primary key identity,
	NextOfKinName nvarchar(100),
	RelationshipWithPatient nvarchar(20),
	ContactDetail int foreign key references ContactDetails(IDContactDetails)
)
go

create table PersonalDetails
(
	IDPersonalDetails int primary key identity,
	MaritalStatus nvarchar(20),
	NoOfDependents int,
	PatientHeight int,
	PatientWeight int,
	BloodTypeRH nvarchar(10)
)
go

create table ProfessionDetails
(
	IDProfessionDetails int primary key identity,
	Occupation nvarchar(20),
	GrossAnnualIncome money
)
go

create table Lifestyle
(
	IDLifestyle int primary key identity,
	Vegetarian bit,
	Smoker bit,
	AverageNoOfCigarettesPerDay int,
	ConsumeAlcoholicBeverage bit,
	AverageNoOfDrinksPerDay int,
	UseStimulants nvarchar(max),
	ConsumptionOfCoffeeTeaPerDay int,
	ConsumptionOfSoftDrinksPerDay int,
	HaveRegularMeals nvarchar(max),
	EatHomeFoodOrOutsidePredominantly nvarchar(max),
)
go

create table BasicComplaints
(
	IDBasicComplaints int primary key identity,
	StatementOfComplaint nvarchar(max),
	HistoryOfPreviousTreatment nvarchar(max),
	PhysicianHospitalTreated nvarchar(max),
)
go

create table ImportantMedicalComplaints
(
	IDImportantMedicalComplaints int primary key identity,
	Diabetic nvarchar(max),
	Hypertensive nvarchar(max),
	CardiacCondition nvarchar(max),
	OrthopedicCondition nvarchar(max),
	MuscularCondition nvarchar(max),
	NeurologicalCondition nvarchar(max),
	DigestiveCondition nvarchar(max),
	KnownAllergies nvarchar(max),
	KnownAdverseReactionToSpecificDrugs nvarchar(max),
	MajorSurgeries nvarchar(max),
)
go

--------------------------
--Mini Registration Form--
--------------------------
drop table MiniRegistrationForm
create table MiniRegistrationForm
(
	IDMiniRegForm int Primary key identity,
	DateOfRegistration date,
	PatientName nvarchar(100),
	Sex nvarchar(1),
	DateOfBirth nvarchar(max),
	BriefStatementOfComplain nvarchar(max),
	ContactTelNumber1 nvarchar(20),
	ContactTelNumber2 nvarchar(20),
	NextOfKinName nvarchar(80),
	RelationshipToPatitent nvarchar(10),
	OutPatientID int foreign key references Patient(IDOutPatient)
)
go

-----------------------------------
--Comprehensive Registration Form--
-----------------------------------
drop table ComprehensiveRegistrationForm
create table ComprehensiveRegistrationForm
(
	IDCompRegForm int Primary key identity,
	DateOfRegistration date,
	BasicDetailsID int foreign key references BasicDetails(IDBasicDetails),
	ContactDetailsID int foreign key references ContactDetails(IDContactDetails),
	ContactNextOfKinID int foreign key references ContactNextOfKin(IDNextOfKin),
	PersonalDetailsID int foreign key references PersonalDetails(IDPersonalDetails),
	ProfessionDetailsID int foreign key references ProfessionDetails(IDProfessionDetails),
	LifestyleID int foreign key references Lifestyle(IDLifestyle),
	BasicComplaintsID int foreign key references BasicComplaints(IDBasicComplaints),
	ImportantMedicalComplaintsID int foreign key references ImportantMedicalComplaints(IDImportantMedicalComplaints),
	OutPatientID int foreign key references Patient(IDOutPatient),
)
go

---------------------
--Hospital Entities--
---------------------

create table Employee
(
	IDEmployee int primary key identity,
	DateOfBirth date
)
go

create table Doctor
(
	IDDoctor int primary key identity,
	EmployeeID int foreign key references Employee(IDEmployee),
	PersonalDetailsID int foreign key references PersonalDetails(IDPersonalDetails),
	BasicDetailsID int foreign key references BasicDetails(IDBasicDetails),  
	ContactDetailsID int foreign key references ContactDetails(IDContactDetails)
)
go
drop table Patient
create table Patient
(
	IDOutPatient int primary key identity,
	DoctorID int foreign key references Doctor(IDDoctor),
	BasicDetailsID int foreign key references BasicDetails(IDBasicDetails),
	ContactDetailsID int foreign key references ContactDetails(IDContactDetails),
	ContactNextOfKinID int foreign key references ContactNextOfKin(IDNextOfKin),
	PersonalDetailsID int foreign key references PersonalDetails(IDPersonalDetails),
	ProfessionDetailsID int foreign key references ProfessionDetails(IDProfessionDetails),
	LifestyleID int foreign key references Lifestyle(IDLifestyle),
	BasicComplaintsID int foreign key references BasicComplaints(IDBasicComplaints),
	ImportantMedicalComplaintsID int foreign key references ImportantMedicalComplaints(IDImportantMedicalComplaints)
)
go
drop table Appointment
create table Appointment
(
	IDAppointment int primary key identity,
	PatientID int foreign key references Patient(IDOutPatient),
	DoctorID int foreign key references Doctor(IDDoctor),
	AppointmentDate date
)
go
drop table Bill
create table Bill
(
	IDBill int primary key identity,
	PatientID int foreign key references Patient(IDOutPatient),
	BillItem nvarchar(max),
	BillPrice money
)
go

select * from Patient
select * from Doctor
select * from BasicDetails
select * from PersonalDetails
select * from ContactDetails
select * from ContactNextOfKin
select * from Lifestyle
select * from BasicComplaints
select * from ImportantMedicalComplaints

select * from ComprehensiveRegistrationForm
select * from MiniRegistrationForm



