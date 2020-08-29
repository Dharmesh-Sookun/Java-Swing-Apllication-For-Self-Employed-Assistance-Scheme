package com.example.mra_seas;

import java.sql.Date;

public class ApplicantDetails {

	private String NID;
	private String surname = "";
	private String otherNames = "";
	private Date dateOfBirth;
	private double monthlyIncome;
	private String married = "";
	private String houseNum = "";
	private String street = "";
	private String locality = "";
	private String mauritusPostalRegion = "";
	private String village_town = "";
	private String postalCode = "";
	private String occupation = "";
	private String place_of_business = "";
	private Date start_date_of_business;
	private BankAccountDetails bankDetails;
	private String telephone_num = "";
	private String mobile_num = "";
	private String email_address = "";
	private SpouseDetails spouseDetails;

	public ApplicantDetails(String nid) {
		this.NID = nid;
	} 
	
	public ApplicantDetails(String nid, String surname, String otherNames, Date dateOfBirth, double monthlyIncome,
			String married, String houseNum, String street, String locality, String mauritiusPostalRegion,
			String village_town, String postalCode, String occupation, String placeOfBusiness,
			Date start_date_of_business, String telephoneNum, String mobileNum,
			String email) {
		this.NID = nid;
		this.surname = surname;
		this.otherNames = otherNames;
		this.dateOfBirth = dateOfBirth;
		this.monthlyIncome = monthlyIncome;
		this.married = married;
		this.houseNum = houseNum;
		this.street = street;
		this.locality = locality;
		this.mauritusPostalRegion = mauritiusPostalRegion;
		this.village_town = village_town;
		this.postalCode = postalCode;
		this.occupation = occupation;
		this.place_of_business = placeOfBusiness;
		this.start_date_of_business = start_date_of_business;
		this.telephone_num = telephoneNum;
		this.mobile_num = mobileNum;
		this.email_address = email;
	} 

	public String getNID() {
		return this.NID;
	}

	public void setNID(String nID) {
		this.NID = nID;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getOtherNames() {
		return this.otherNames;
	}

	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public double getMonthlyIncome() {
		return this.monthlyIncome;
	}

	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public String getMarried() {
		return this.married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public String getHouseNum() {
		return this.houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocality() {
		return this.locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getMauritusPostalRegion() {
		return this.mauritusPostalRegion;
	}

	public void setMauritusPostalRegion(String mauritusPostalRegion) {
		this.mauritusPostalRegion = mauritusPostalRegion;
	}

	public String getVillage_town() {
		return this.village_town;
	}

	public void setVillage_town(String village_town) {
		this.village_town = village_town;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPlace_of_business() {
		return this.place_of_business;
	}

	public void setPlace_of_business(String place_of_business) {
		this.place_of_business = place_of_business;
	}

	public Date getStart_date_of_business() {
		return this.start_date_of_business;
	}

	public void setStart_date_of_business(Date start_date_of_business) {
		this.start_date_of_business = start_date_of_business;
	}

	public BankAccountDetails getBankDetails() {
		return this.bankDetails;
	}

	public void setBankDetails(BankAccountDetails bankDetails) {
		this.bankDetails = bankDetails;
	}

	public String getTelephone_num() {
		return this.telephone_num;
	}

	public void setTelephone_num(String telephone_num) {
		this.telephone_num = telephone_num;
	}

	public String getMobile_num() {
		return this.mobile_num;
	}

	public void setMobile_num(String mobile_num) {
		this.mobile_num = mobile_num;
	}

	public String getEmail_address() {
		return this.email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public SpouseDetails getSpouseDetails() {
		return this.spouseDetails;
	}

	public void setSpouseDetails(SpouseDetails spouseDetails) {
		this.spouseDetails = spouseDetails;
	}

	
	public String toString()
	{
		return ("Applicant nid: " + this.getNID() + "\n" +
				"Applicant surname: " + this.getSurname() + "\n" +
				"Applicant other names: " + this.getOtherNames() + "\n" +
				"Applicant DOB: " + this.getDateOfBirth() + "\n" +
				"Applicant Married: " + this.getMarried() + "\n" +
				"Applicant monthly income: " + this.getMonthlyIncome() + "\n" +
				"Spouse NIC No: " + this.getSpouseDetails().getSpouse_nid() + "\n" +
				"Spouse Name: " + this.getSpouseDetails().getSpouse_name() + "\n" +
				"Spouse passport Num: " + this.getSpouseDetails().getSpouse_passport_num() + "\n" +
				"Spouse occupation: " + this.getSpouseDetails().getSpouse_occupation() + "\n" + 
				"Applicant house num: " + this.getHouseNum() + "\n" +
				"Applicant street: " + this.getStreet() + "\n" +
				"Applicant locality: " + this.getLocality() + "\n" +
				"Applicant postal region: " + this.getMauritusPostalRegion() + "\n" +
				"Applicant village/town: " + this.getVillage_town() + "\n" +
				"Applicant postal code: " + this.getPostalCode() + "\n" +
				"Applicant occupation: " + this.getOccupation() + "\n" +
				"Applicant place of business: " + this.getPlace_of_business() + "\n" +
				"Applicant business start date: " + this.getStart_date_of_business() + "\n" +
				"Applicant bank name: " + this.getBankDetails().getBankName() + "\n" +
				"Applicant bank account holder name: " + this.getBankDetails().getAccount_holder_name() + "\n" +
				"Applicant bank acc num: " + this.getBankDetails().getBank_account_num() + "\n" + 
				"Applicant telephone num: " + this.getTelephone_num() + "\n" +
				"Applicant mobile num: " + this.getMobile_num() + "\n" +
				"Applicant email: " + this.getEmail_address() + "\n");
	}

}
