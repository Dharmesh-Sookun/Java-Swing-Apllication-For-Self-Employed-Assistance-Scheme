package com.example.mra_seas;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class ValidateInputs extends InputVerifier {
	
	private ApplicantDetails applicant;
	
	public ValidateInputs() {}
	
	public ValidateInputs(ApplicantDetails applicant)
	{
		this.applicant = applicant;
	}

	@Override
	public boolean verify(JComponent input) {

		String compName = input.getName();
		
		if(compName.equals("surnameTF"))
		{
			String surnameText = ((JTextField) input).getText().trim();
			
			if(!surnameText.isBlank())
			{
				String firstCharInSurname = surnameText.substring(0, 1).toUpperCase();
				String nicNum = this.applicant.getNID();
				String firstcharInNICNum = nicNum.substring(0, 1);
				
				if(!firstcharInNICNum.equals(firstCharInSurname))
				{
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							input.setBorder(new LineBorder(Color.RED));
							JOptionPane.showMessageDialog(null, "Your surname must start with an '" + firstcharInNICNum + "'",
									"Your surname must start with an '" + firstcharInNICNum + "'", JOptionPane.ERROR_MESSAGE);
						}
					});
					return false;
				}
				else 
				{
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							input.setBorder(LineBorder.createBlackLineBorder());
						}
					});
				}
			}

		}

		if (compName.equals("monthlyIncomeTF")) {
			String monthlyIncomeText = ((JTextField) input).getText().trim();
			if(!monthlyIncomeText.isBlank())
			{
				double monthlyIncomeVal = Double.parseDouble(monthlyIncomeText);
				if (monthlyIncomeVal > 50000) {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							input.setBorder(new LineBorder(Color.RED));
							JOptionPane.showMessageDialog(null, "Total monthly income must not exceed Rs 50000",
									"Total monthly income must not exceed Rs 50000", JOptionPane.ERROR_MESSAGE);
						}
					});
					return false;
				} else {
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							input.setBorder(LineBorder.createBlackLineBorder());
						}
					});
				}
			}
		}
		
		if(compName.equals("occupationTF"))
		{
			String occupationText = ((JTextField) input).getText().trim();
			if(occupationText.equalsIgnoreCase("fisherman"))
			{
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						input.setBorder(new LineBorder(Color.RED));
						JOptionPane.showMessageDialog(null, "Fishermen are not eligible for this scheme.",
								"Fishermen are not eligible for this scheme.", JOptionPane.ERROR_MESSAGE);
					}
				});
				return false;
			}
			else {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						input.setBorder(LineBorder.createBlackLineBorder());
					}
				});
			}
		}
		
		if(compName.equals("spouseNICNumTF"))
		{
			String NICNumText = ((JTextField) input).getText().trim();
			if(!NICNumText.isBlank())
			{
				if(NICNumText.length() != 14)
				{
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							input.setBorder(new LineBorder(Color.RED));
							JOptionPane.showMessageDialog(null, "An NIC number must contain 14 characters",
									"Invalid number of characters", JOptionPane.ERROR_MESSAGE);
						}
					});
					return false;
				}
				
				else if((Character.isLowerCase(NICNumText.charAt(0))) || !(Character.isLetter(NICNumText.charAt(0))))
				{
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							input.setBorder(new LineBorder(Color.RED));
							JOptionPane.showMessageDialog(null, "An NIC number must start with an uppercase letter",
									"An NIC number must start with an uppercase letter", JOptionPane.ERROR_MESSAGE);
						}
					});
					return false;
				}
				
				else
				{
					String dateFromNID = NICNumText.substring(1, 3) + "/" + NICNumText.substring(3, 5) + "/"
							+ NICNumText.substring(5, 7);
					
					if(!UtilFunctionsClass.isDateValid(dateFromNID, "dd/MM/yyyy"))
					{
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								input.setBorder(new LineBorder(Color.RED));
								JOptionPane.showMessageDialog(null, "Invalid date of birth in your NIC number",
										"Invalid date of birth in your NIC number", JOptionPane.ERROR_MESSAGE);
							}
						});
						return false;
					}
					
					else
					{
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								input.setBorder(LineBorder.createBlackLineBorder());
							}
						});
					}
				}
			}

		}

		return true;
	}

}
