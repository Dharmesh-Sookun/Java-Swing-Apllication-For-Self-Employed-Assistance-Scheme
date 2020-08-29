package com.example.mra_seas;

import java.sql.SQLException;

public interface ApplicantDao {
	
	public int addApplicantDetails(ApplicantDetails applicant) throws SQLException;
	
	public ApplicantDetails getApplicantDetails(String applicant_nid) throws SQLException;
	
	public int updateApplicantDetails(ApplicantDetails applicant) throws SQLException;
			
	public boolean doesApplicantExist(String applicant_nid) throws SQLException;
	
	public int saveApplicantDetails(ApplicantDetails applicant) throws SQLException;
	
	public String getAppliedStatus(String applicant_nid) throws SQLException;
	
	public int updateAppliedStatus(String applicant_nid) throws SQLException;

}
