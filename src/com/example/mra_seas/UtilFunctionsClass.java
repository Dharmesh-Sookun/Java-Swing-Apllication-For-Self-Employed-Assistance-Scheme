package com.example.mra_seas;

import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class UtilFunctionsClass {
	
	public static void loadEnterPersonalDetailsScreen(ApplicantDetails applicant, JFrame currentFrame)
	{
		EnterPersonalDetailsFrame enterPersonalDetailsFrame = new EnterPersonalDetailsFrame(applicant);
		enterPersonalDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		enterPersonalDetailsFrame.setResizable(true);
		enterPersonalDetailsFrame.setLocationRelativeTo(null);
		enterPersonalDetailsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		enterPersonalDetailsFrame.setVisible(true);
		currentFrame.setVisible(false); 
	}
	
	public static void loadEnterAddressDetailsScreen(ApplicantDetails applicant, JFrame currentFrame)
	{
		EnterAddressDetailsFrame enterAddressDetails = new EnterAddressDetailsFrame(applicant);
		enterAddressDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		enterAddressDetails.setResizable(true);
		enterAddressDetails.setLocationRelativeTo(null);
		enterAddressDetails.setExtendedState(JFrame.MAXIMIZED_BOTH);
		enterAddressDetails.setVisible(true);
		currentFrame.setVisible(false);
	}
	
	public static void loadEnterBusinessDetailsScreen(ApplicantDetails applicant, JFrame currentFrame)
	{
		EnterBusinessAndBankDetails enterBusinessAndBankDetails = new EnterBusinessAndBankDetails(applicant);
		enterBusinessAndBankDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		enterBusinessAndBankDetails.setResizable(true);
		enterBusinessAndBankDetails.setLocationRelativeTo(null);
		enterBusinessAndBankDetails.setExtendedState(JFrame.MAXIMIZED_BOTH);
		enterBusinessAndBankDetails.setVisible(true);
		currentFrame.setVisible(false);
	}
	
	public static void loadEnterContactDetailsScreen(ApplicantDetails applicant, JFrame currentFrame)
	{
		EnterContactDetails enterContactDetails = new EnterContactDetails(applicant);
		enterContactDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		enterContactDetails.setResizable(true);
		enterContactDetails.setLocationRelativeTo(null);
		enterContactDetails.setExtendedState(JFrame.MAXIMIZED_BOTH);
		enterContactDetails.setVisible(true);
		currentFrame.setVisible(false);
	}
	
	public static void loadLoginScreen(JFrame currentFrame)
	{
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setResizable(true);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		loginFrame.setVisible(true);
		currentFrame.setVisible(false);
	}
	
	public static boolean isDateValid(String dateToValidate, String dateFormat)
	{
		if(dateToValidate == null)
		{
			return false;
		}
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		simpleDateFormat.setLenient(false);
		
		try
		{
			simpleDateFormat.parse(dateToValidate);
		}
		
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	public static boolean isNICValid(String nic)
	{		
		if (nic.isBlank()) {
			JOptionPane.showMessageDialog(null, "Please enter your NIC number", "Empty field",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		else if (nic.length() != 14) {
			JOptionPane.showMessageDialog(null, "An NIC number must contain 14 characters",
					"Invalid number of characters", JOptionPane.ERROR_MESSAGE);
			
			return false;
		}

		else if (Character.isLowerCase(nic.charAt(0)) || !Character.isLetter(nic.charAt(0))) {
			JOptionPane.showMessageDialog(null, "An NIC number must start with an uppercase letter",
					"Invalid start character", JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		String dateFromNID = nic.substring(1, 3) + "/" + nic.substring(3, 5) + "/"
				+ nic.substring(5, 7);

		if (!UtilFunctionsClass.isDateValid(dateFromNID, "dd/MM/yyyy")) {
			JOptionPane.showMessageDialog(null, "Invalid date of birth in your NIC number", "Invalid date of birth in your NIC number",
					JOptionPane.ERROR_MESSAGE);
			
			return false;
		}
		
		return true;

	}
	
	public static String convertDateToString(java.sql.Date sqlDate)
	{
		String stringDate = "";
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try
		{
			stringDate = simpleDateFormat.format(sqlDate);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return stringDate;
	}

}
