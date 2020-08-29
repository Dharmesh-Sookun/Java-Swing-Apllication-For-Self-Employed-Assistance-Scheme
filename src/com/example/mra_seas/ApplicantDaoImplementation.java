package com.example.mra_seas;

import java.sql.SQLException;
import java.sql.*;

public class ApplicantDaoImplementation implements ApplicantDao {

	private static Connection conn = DatabaseConnection.getConnection();

	@Override
	public int addApplicantDetails(ApplicantDetails applicant) throws SQLException {

		String spouse_nid = applicant.getSpouseDetails().getSpouse_nid();
		if (spouse_nid == null) {
			spouse_nid = "";
		}

		String spouse_name = applicant.getSpouseDetails().getSpouse_name();
		if (spouse_name == null) {
			spouse_name = "";
		}

		String spouse_passport_num = applicant.getSpouseDetails().getSpouse_passport_num();
		if (spouse_passport_num == null) {
			spouse_passport_num = "";
		}

		String spouse_occupation = applicant.getSpouseDetails().getSpouse_occupation();
		if (spouse_occupation == null) {
			spouse_occupation = "";
		}

		String bank_acc_num = "";
		String bank_name = "";
		String account_holder_name = "";

		if (applicant.getBankDetails() != null) {
			bank_acc_num = applicant.getBankDetails().getBank_account_num();
			if (bank_acc_num == null) {
				bank_acc_num = "";
			}

			bank_name = applicant.getBankDetails().getBankName();
			if (bank_name == null) {
				bank_name = "";
			}

			account_holder_name = applicant.getBankDetails().getAccount_holder_name();
			if (account_holder_name == null) {
				account_holder_name = "";
			}
		}

		String defaultDate = "1360-10-10";

		java.sql.Date applicant_dob = applicant.getDateOfBirth();
		if (applicant_dob == null) {
			applicant_dob = java.sql.Date.valueOf(defaultDate);
		}

		java.sql.Date applicant_business_start_date = applicant.getStart_date_of_business();
		if (applicant_business_start_date == null) {
			applicant_business_start_date = java.sql.Date.valueOf(defaultDate);
		}

		String sqlInsertQuery = "INSERT INTO applicant_details(applicant_nid, surname, other_names, monthly_income, married, date_of_birth, "
				+ "house_num, street, locality, mauritius_postal_region, village_town, postal_code, occupation, business_place, "
				+ "business_start_date, telephone_num, mobile_num, email, spouse_nid, spouse_name, spouse_passport_num, "
				+ "spouse_occupation, bank_acc_num, bank_name, account_holder_name) VALUES"
				+ "('" + applicant.getNID() + "', '" + applicant.getSurname() + "', '" + applicant.getOtherNames()
				+ "', " + applicant.getMonthlyIncome() + ", '" + applicant.getMarried() + "', '" + applicant_dob
				+ "', '" + applicant.getHouseNum() + "', '" + applicant.getStreet() + "', '" + applicant.getLocality()
				+ "', '" + applicant.getMauritusPostalRegion() + "', '" + applicant.getVillage_town() + "', '"
				+ applicant.getPostalCode() + "', '" + applicant.getOccupation() + "', '"
				+ applicant.getPlace_of_business() + "', '" + applicant_business_start_date + "', '"
				+ applicant.getTelephone_num() + "', '" + applicant.getMobile_num() + "', '"
				+ applicant.getEmail_address() + "', '" + spouse_nid + "', '" + spouse_name + "', '"
				+ spouse_passport_num + "', '" + spouse_occupation + "', '" + bank_acc_num + "', '" + bank_name + "', '"
				+ account_holder_name + "');";

		// int oldCount = this.countNumOfRowsInTable("applicant_details");

		Statement stmt = conn.createStatement();

		int status = stmt.executeUpdate(sqlInsertQuery);
		
		stmt.close();

		// int newCount = this.countNumOfRowsInTable("applicant_details");

		return status;

	}

	@Override
	public ApplicantDetails getApplicantDetails(String applicant_nid) throws SQLException {

		String sqlSelectFromApplicantTable = "SELECT * FROM applicant_details WHERE applicant_nid='" + applicant_nid
				+ "';";

		ApplicantDetails applicant = null;

		Statement stmtSelectFromApplicantTable = conn.createStatement();

		ResultSet rsSelectFromApplicantTable = stmtSelectFromApplicantTable.executeQuery(sqlSelectFromApplicantTable);

		while (rsSelectFromApplicantTable.next()) {

			applicant = new ApplicantDetails(rsSelectFromApplicantTable.getString("applicant_nid"),
					rsSelectFromApplicantTable.getString("surname"),
					rsSelectFromApplicantTable.getString("other_names"),
					rsSelectFromApplicantTable.getDate("date_of_birth"),
					rsSelectFromApplicantTable.getDouble("monthly_income"),
					rsSelectFromApplicantTable.getString("married"), rsSelectFromApplicantTable.getString("house_num"),
					rsSelectFromApplicantTable.getString("street"), rsSelectFromApplicantTable.getString("locality"),
					rsSelectFromApplicantTable.getString("mauritius_postal_region"),
					rsSelectFromApplicantTable.getString("village_town"),
					rsSelectFromApplicantTable.getString("postal_code"),
					rsSelectFromApplicantTable.getString("occupation"),
					rsSelectFromApplicantTable.getString("business_place"),
					rsSelectFromApplicantTable.getDate("business_start_date"),
					rsSelectFromApplicantTable.getString("telephone_num"),
					rsSelectFromApplicantTable.getString("mobile_num"), rsSelectFromApplicantTable.getString("email"));

			applicant.setSpouseDetails(new SpouseDetails(rsSelectFromApplicantTable.getString("spouse_nid"),
					rsSelectFromApplicantTable.getString("spouse_name"),
					rsSelectFromApplicantTable.getString("spouse_passport_num"),
					rsSelectFromApplicantTable.getString("spouse_occupation")));

			applicant.setBankDetails(new BankAccountDetails(rsSelectFromApplicantTable.getString("bank_name"),
					rsSelectFromApplicantTable.getString("account_holder_name"),
					rsSelectFromApplicantTable.getString("bank_acc_num")));
		}

		rsSelectFromApplicantTable.close();
		stmtSelectFromApplicantTable.close();

		return applicant;

	}

	/*
	 * private int countNumOfRowsInTable(String tableName) { int count = 0;
	 * 
	 * String sqlCount = "SELECT COUNT(*) FROM " + tableName + ";";
	 * 
	 * try { Statement stmt = conn.createStatement(); ResultSet rs =
	 * stmt.executeQuery(sqlCount); while (rs.next()) { count = rs.getInt(1); }
	 * 
	 * rs.close(); stmt.close(); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * return count;
	 * 
	 * }
	 */

	@Override
	public boolean doesApplicantExist(String applicant_nid) throws SQLException {

		int count = 0;

		String sql = "SELECT COUNT(applicant_nid) FROM applicant_details WHERE applicant_nid = '" + applicant_nid
				+ "';";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			count = rs.getInt(1);
		}
		
		rs.close();
		stmt.close();

		if (count == 0) {
			return false;
		}

		return true;
	}

	@Override
	public int saveApplicantDetails(ApplicantDetails applicant) throws SQLException {

		if (!doesApplicantExist(applicant.getNID())) {
			return addApplicantDetails(applicant);
		}

		else {
			return updateApplicantDetails(applicant);
		}
	}

	@Override
	public int updateApplicantDetails(ApplicantDetails applicant) throws SQLException {
		String spouse_nid = applicant.getSpouseDetails().getSpouse_nid();
		if (spouse_nid == null) {
			spouse_nid = "";
		}

		String spouse_name = applicant.getSpouseDetails().getSpouse_name();
		if (spouse_name == null) {
			spouse_name = "";
		}

		String spouse_passport_num = applicant.getSpouseDetails().getSpouse_passport_num();
		if (spouse_passport_num == null) {
			spouse_passport_num = "";
		}

		String spouse_occupation = applicant.getSpouseDetails().getSpouse_occupation();
		if (spouse_occupation == null) {
			spouse_occupation = "";
		}

		String bank_acc_num = "";
		String bank_name = "";
		String account_holder_name = "";

		if (applicant.getBankDetails() != null) {
			bank_acc_num = applicant.getBankDetails().getBank_account_num();
			if (bank_acc_num == null) {
				bank_acc_num = "";
			}

			bank_name = applicant.getBankDetails().getBankName();
			if (bank_name == null) {
				bank_name = "";
			}

			account_holder_name = applicant.getBankDetails().getAccount_holder_name();
			if (account_holder_name == null) {
				account_holder_name = "";
			}
		}

		String defaultDate = "1360-10-10";

		java.sql.Date applicant_dob = applicant.getDateOfBirth();
		if (applicant_dob == null) {
			applicant_dob = java.sql.Date.valueOf(defaultDate);
		}

		java.sql.Date applicant_business_start_date = applicant.getStart_date_of_business();
		if (applicant_business_start_date == null) {
			applicant_business_start_date = java.sql.Date.valueOf(defaultDate);
		}

		String sqlUpdateQuery = "UPDATE applicant_details " + "SET surname = '" + applicant.getSurname() + "', "
				+ "other_names = '" + applicant.getOtherNames() + "', " + "monthly_income = "
				+ applicant.getMonthlyIncome() + ", " + "married = '" + applicant.getMarried() + "', "
				+ "date_of_birth = '" + applicant_dob + "', " + "house_num = '" + applicant.getHouseNum() + "', "
				+ "street = '" + applicant.getStreet() + "', " + "locality = '" + applicant.getLocality() + "', "
				+ "mauritius_postal_region = '" + applicant.getMauritusPostalRegion() + "', " + "village_town = '"
				+ applicant.getVillage_town() + "', " + "postal_code = '" + applicant.getPostalCode() + "', "
				+ "occupation = '" + applicant.getOccupation() + "', " + "business_place = '"
				+ applicant.getPlace_of_business() + "', " + "business_start_date = '" + applicant_business_start_date
				+ "', " + "telephone_num = '" + applicant.getTelephone_num() + "', " + "mobile_num = '"
				+ applicant.getMobile_num() + "', " + "email = '" + applicant.getEmail_address() + "', "
				+ "spouse_nid = '" + spouse_nid + "', " + "spouse_name = '" + spouse_name + "', "
				+ "spouse_passport_num = '" + spouse_passport_num + "', " + "spouse_occupation = '" + spouse_occupation
				+ "'," + "bank_acc_num = '" + bank_acc_num + "', " + "bank_name = '" + bank_name + "', "
				+ "account_holder_name = '" + account_holder_name + "' " + "WHERE applicant_nid = '"
				+ applicant.getNID() + "';";

		Statement stmtUpdate = conn.createStatement();

		int status = stmtUpdate.executeUpdate(sqlUpdateQuery);
		
		stmtUpdate.close();

		return status;
	}

	@Override
	public String getAppliedStatus(String applicant_nid) throws SQLException 
	{
		String sql = "SELECT applied FROM applicant_details WHERE applicant_nid = '" + applicant_nid + "';";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		String appliedStatus = "";
		
		while(rs.next())
		{
			appliedStatus = rs.getString("applied");
		}
		
		rs.close();
		stmt.close();
		
		return appliedStatus;
	}

	@Override
	public int updateAppliedStatus(String applicant_nid) throws SQLException 
	{
		String sql = "UPDATE applicant_details " +
					 "SET applied = 'Y' " +
					 "WHERE applicant_nid = '" + applicant_nid + "';";
		
		Statement stmt = conn.createStatement();
		
		int status = stmt.executeUpdate(sql);
		
		stmt.close();
		
		return status;
	}

}
