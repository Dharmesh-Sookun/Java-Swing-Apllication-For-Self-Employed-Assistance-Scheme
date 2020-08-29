package com.example.mra_seas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class EnterBusinessAndBankDetails extends CustomFrame {

	private ApplicantDetails applicant = null;

	private JLabel titlelbl, steplbl, occupationlbl, placeOfBusinesslbl, startDateOfbusinesslbl, bankNamelbl,
			accountHolderNamelbl, accountNumlbl, step1lbl, step2lbl, step3lbl, step4lbl, logoutlbl;

	private JTextField occupationTF, placeOfBusinessTF, accountHolderNameTF, bankAccNumTF;

	private JComboBox<String> bankNamesCB, businessStartYearCB, businessStartMonthCB, businessStartDayCB;

	private JButton prevBtn, saveBtn, nextBtn;

	private DisplayDates displayDates;

	public EnterBusinessAndBankDetails(ApplicantDetails applicant) {
		super("Enter business and bank details");
		this.applicant = applicant;
		createGUI();
	}

	@Override
	public void createGUI() {
		setLayout(new GridLayout(1, 1));

		titlelbl = new JLabel("Application form for self-employed assistance scheme in the context of covid-19");
		steplbl = new JLabel("Step 3 of 4 - Business and Bank Details");

		occupationlbl = new JLabel("Enter your occupation: *");
		placeOfBusinesslbl = new JLabel("Enter your place of business: *");
		startDateOfbusinesslbl = new JLabel("Start date of your business: *");
		bankNamelbl = new JLabel("Select the bank name: *");
		accountHolderNamelbl = new JLabel("<html><p>Enter the name of the account</p><p>holder: *</p></html>");
		accountNumlbl = new JLabel("<html><p>Enter the bank account</p><p>number: *</p></html>");
		step1lbl = new JLabel("Step 1: Personal Details");
		step2lbl = new JLabel("Step 2: Address Details");
		step3lbl = new JLabel("Step 3: Business and Bank details");
		step4lbl = new JLabel("Step 4: Contact details");
		logoutlbl = new JLabel("Logout");
		
		titlelbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		steplbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		occupationlbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		placeOfBusinesslbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		startDateOfbusinesslbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		bankNamelbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		accountHolderNamelbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		accountNumlbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		step1lbl.setForeground(Color.decode(Colours.SIDE_NAVIGATION_PRIMARY_TEXT_COLOUR));
		step2lbl.setForeground(Color.decode(Colours.SIDE_NAVIGATION_PRIMARY_TEXT_COLOUR));
		step3lbl.setForeground(Color.decode(Colours.SIDE_NAVIGATION_PRIMARY_TEXT_COLOUR));
		step4lbl.setForeground(Color.decode(Colours.SIDE_NAVIGATION_PRIMARY_TEXT_COLOUR));
		logoutlbl.setForeground(Color.decode(Colours.SIDE_NAVIGATION_PRIMARY_TEXT_COLOUR));
		
		titlelbl.setFont(Fonts.TITLE_FONT);
		steplbl.setFont(Fonts.MAIN_HEADING_FONT);
		occupationlbl.setFont(Fonts.NORMAL_TEXT_FONT);
		placeOfBusinesslbl.setFont(Fonts.NORMAL_TEXT_FONT);
		startDateOfbusinesslbl.setFont(Fonts.NORMAL_TEXT_FONT);
		bankNamelbl.setFont(Fonts.NORMAL_TEXT_FONT);
		accountHolderNamelbl.setFont(Fonts.NORMAL_TEXT_FONT);
		accountNumlbl.setFont(Fonts.NORMAL_TEXT_FONT);
		step1lbl.setFont(Fonts.NORMAL_TEXT_FONT);
		step2lbl.setFont(Fonts.NORMAL_TEXT_FONT);
		step3lbl.setFont(Fonts.NORMAL_TEXT_FONT);
		step4lbl.setFont(Fonts.NORMAL_TEXT_FONT);
		logoutlbl.setFont(Fonts.NORMAL_TEXT_FONT);
		

		occupationTF = new JTextField();
		placeOfBusinessTF = new JTextField();
		accountHolderNameTF = new JTextField();
		bankAccNumTF = new JTextField();
		
		occupationTF.setName("occupationTF");
		occupationTF.setInputVerifier(new ValidateInputs());

		bankNamesCB = new JComboBox<String>();

		final String BANK_NAMES[] = { "Please select", "ABC Banking Corporation Ltd", "Absa Bank (Mauritius) Limited",
				"AfrAsia Bank Limited", "Bank of Baroda", "Bank One Limited", "BCP Bank (Mauritius)",
				"Habib Bank Limited", "HSBC Mauritius", "MauBank Ltd", "SBI (Mauritius) Limited", "State Bank of Mauritius Ltd",
				 "The Mauritius Commercial Bank Ltd" };
		
		for(int index = 0; index < BANK_NAMES.length; index++)
		{
			bankNamesCB.addItem(BANK_NAMES[index]);
		}
		
		prevBtn = new JButton("Previous");
		saveBtn = new JButton("Save form");
		nextBtn = new JButton("Next");
		
		prevBtn.setBackground(Color.decode(Colours.PREV_BUTTON_BACKGROUND));
		prevBtn.setForeground(Color.decode(Colours.PRIMARY_BUTTON_TEXT));
		prevBtn.setFont(Fonts.BUTTON_TEXT_FONT);
		
		saveBtn.setBackground(Color.decode(Colours.SAVE_BUTTON_BACKGROUND));
		saveBtn.setForeground(Color.decode(Colours.PRIMARY_BUTTON_TEXT));
		saveBtn.setFont(Fonts.BUTTON_TEXT_FONT);
		
		nextBtn.setBackground(Color.decode(Colours.NEXT_BUTTON_BACKGROUND));
		nextBtn.setForeground(Color.decode(Colours.PRIMARY_BUTTON_TEXT));
		nextBtn.setFont(Fonts.BUTTON_TEXT_FONT);
		
		JPanel panelTitle = new JPanel();
		panelTitle.add(titlelbl, JLabel.CENTER);
		panelTitle.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));

		JPanel panelStep = new JPanel();
		panelStep.add(steplbl, JLabel.CENTER);
		panelStep.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));

		JPanel panelHeadings = new JPanel(new GridLayout(2, 1, 10, 30));
		panelHeadings.add(panelTitle);
		panelHeadings.add(panelStep);
		panelHeadings.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		JPanel panelBtns = new JPanel();
		panelBtns.add(nextBtn, JButton.CENTER);
		panelBtns.add(saveBtn, JButton.CENTER);
		panelBtns.add(prevBtn, JButton.CENTER);
		panelBtns.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		displayDates = new DisplayDates();
		
		businessStartYearCB = displayDates.getYearDisplayComboBox();
		businessStartMonthCB = displayDates.getMonthDisplayComboBox();
		businessStartDayCB = displayDates.getDayDisplayComboBox();
		
		JPanel panelBusinessStartDate = displayDates.getDatePanel();
		panelBusinessStartDate.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		JPanel panelBusinessDetails = new JPanel(new GridLayout(2, 5, 2, 50));
		panelBusinessDetails.add(occupationlbl);
		panelBusinessDetails.add(occupationTF);
		panelBusinessDetails.add(new Container());
		panelBusinessDetails.add(placeOfBusinesslbl);
		panelBusinessDetails.add(placeOfBusinessTF);
		
		panelBusinessDetails.add(startDateOfbusinesslbl);
		panelBusinessDetails.add(panelBusinessStartDate);
		panelBusinessDetails.add(new Container());
		panelBusinessDetails.add(new Container());
		panelBusinessDetails.add(new Container());
		
		panelBusinessDetails.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		TitledBorder panelBusinessDetailsBorder = BorderFactory.createTitledBorder("Business Details");
		panelBusinessDetailsBorder.setBorder(new LineBorder(Color.decode(Colours.PRIMARY_BORDER_COLOUR), 3, true));
		panelBusinessDetailsBorder.setTitleJustification(TitledBorder.CENTER);
		panelBusinessDetailsBorder.setTitleFont(Fonts.NORMAL_TEXT_FONT);
		panelBusinessDetailsBorder.setTitleColor(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		
		panelBusinessDetails.setBorder(panelBusinessDetailsBorder);
		
		JPanel panelBusinessDetailsContainer = new JPanel(new BorderLayout(1, 55));
		panelBusinessDetailsContainer.add(new Container(), BorderLayout.NORTH);
		panelBusinessDetailsContainer.add(panelBusinessDetails, BorderLayout.CENTER);
		panelBusinessDetailsContainer.add(new Container(), BorderLayout.WEST);
		panelBusinessDetailsContainer.add(new Container(), BorderLayout.EAST);
		panelBusinessDetailsContainer.add(new Container(), BorderLayout.SOUTH);
		
		panelBusinessDetailsContainer.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		JPanel panelBankDetails = new JPanel(new GridLayout(2, 5, 0, 40));
		panelBankDetails.add(bankNamelbl);
		panelBankDetails.add(bankNamesCB);
		panelBankDetails.add(new Container());
		panelBankDetails.add(accountHolderNamelbl);
		panelBankDetails.add(accountHolderNameTF);
		
		panelBankDetails.add(accountNumlbl);
		panelBankDetails.add(bankAccNumTF);
		panelBankDetails.add(new Container());
		panelBankDetails.add(new Container());
		panelBankDetails.add(new Container());
		
		panelBankDetails.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		TitledBorder panelBankDetailsBorder = BorderFactory.createTitledBorder("Bank Details");
		panelBankDetailsBorder.setBorder(new LineBorder(Color.decode(Colours.PRIMARY_BORDER_COLOUR), 3, true));
		panelBankDetailsBorder.setTitleJustification(TitledBorder.CENTER);
		panelBankDetailsBorder.setTitleFont(Fonts.NORMAL_TEXT_FONT);
		panelBankDetailsBorder.setTitleColor(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		
		panelBankDetails.setBorder(panelBankDetailsBorder);
		
		JPanel panelBankDetailsContainer = new JPanel(new BorderLayout(0, 55));
		panelBankDetailsContainer.add(new Container(), BorderLayout.NORTH);
		panelBankDetailsContainer.add(panelBankDetails, BorderLayout.CENTER);
		panelBankDetailsContainer.add(new Container(), BorderLayout.WEST);
		panelBankDetailsContainer.add(new Container(), BorderLayout.EAST);
		panelBankDetailsContainer.add(new Container(), BorderLayout.SOUTH);
		
		panelBankDetailsContainer.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		JPanel panelMainContent = new JPanel(new GridLayout(2, 1, 1, 10));
		panelMainContent.add(panelBusinessDetailsContainer);
		panelMainContent.add(panelBankDetailsContainer);
		
		panelMainContent.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		JPanel panelMain = new JPanel(new BorderLayout(15, 20));
		panelMain.add(panelHeadings, BorderLayout.NORTH);
		panelMain.add(new Container(), BorderLayout.WEST);
		panelMain.add(panelMainContent, BorderLayout.CENTER);
		panelMain.add(new Container(), BorderLayout.EAST);
		panelMain.add(panelBtns, BorderLayout.SOUTH);
		
		panelMain.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		ButtonHandler buttonHandler = new ButtonHandler(this);
		nextBtn.addActionListener(buttonHandler);
		prevBtn.addActionListener(buttonHandler);
		saveBtn.addActionListener(buttonHandler);
		
		JPanel panelStep1 = new JPanel(new GridBagLayout());
		panelStep1.setName("panelStep1");
		panelStep1.add(step1lbl);
		panelStep1.setBackground(Color.decode(Colours.SIDE_NAVIGATION_BACKGROUND_COLOUR));
		panelStep1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JPanel panelStep2 = new JPanel(new GridBagLayout());
		panelStep2.setName("panelStep2");
		panelStep2.add(step2lbl);
		panelStep2.setBackground(Color.decode(Colours.SIDE_NAVIGATION_BACKGROUND_COLOUR));
		panelStep2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JPanel panelStep3 = new JPanel(new GridBagLayout());
		panelStep3 = new JPanel(new GridBagLayout());
		panelStep3.setName("panelStep3");
		panelStep3.add(step3lbl);
		panelStep3.setBackground(Colours.SIDE_NAVIGATION_SELECTED_COLOUR);
		panelStep3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JPanel panelStep4 = new JPanel(new GridBagLayout());
		panelStep4 = new JPanel(new GridBagLayout());
		panelStep4.setName("panelStep4");
		panelStep4.add(step4lbl);
		panelStep4.setBackground(Color.decode(Colours.SIDE_NAVIGATION_BACKGROUND_COLOUR));
		panelStep4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JPanel panelLogout = new JPanel(new GridBagLayout());
		panelLogout = new JPanel(new GridBagLayout());
		panelLogout.setName("panelLogout");
		panelLogout.add(logoutlbl);
		panelLogout.setBackground(Color.decode(Colours.SIDE_NAVIGATION_BACKGROUND_COLOUR));
		panelLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JPanel panelSideNavigation = new JPanel(new GridLayout(7, 1, 1, 10));
		JSplitPane splitPane = new JSplitPane();
		
		panelSideNavigation.setSize(340, 768);
		panelSideNavigation.setBackground(Color.decode(Colours.SIDE_NAVIGATION_BACKGROUND_COLOUR));
		panelSideNavigation.add(new Container());
		panelSideNavigation.add(panelStep1);
		panelSideNavigation.add(panelStep2);
		panelSideNavigation.add(panelStep3);
		panelSideNavigation.add(panelStep4);
		panelSideNavigation.add(panelLogout);
		panelSideNavigation.add(new Container());
		
		splitPane.setDividerSize(0);
		splitPane.setDividerLocation(240);
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(panelSideNavigation);
		splitPane.setRightComponent(panelMain);
		
		PanelMouseListener panelMouseListener = new PanelMouseListener(this);
		panelStep1.addMouseListener(panelMouseListener);
		panelStep2.addMouseListener(panelMouseListener);
		panelStep4.addMouseListener(panelMouseListener);
		panelLogout.addMouseListener(panelMouseListener);
		
		setApplicantValues();
		
		add(splitPane);
	}
	
	private void setApplicantValues()
	{
		String occupation = this.applicant.getOccupation();
		if(occupation == null)
		{
			occupation = "";
		}
		occupationTF.setText(occupation);
		
		occupation = null;
		
		String businessPlace = this.applicant.getPlace_of_business();
		if(businessPlace == null)
		{
			businessPlace = "";
		}
		
		placeOfBusinessTF.setText(businessPlace);
		businessPlace = null;
		
		java.sql.Date businessStartDate = this.applicant.getStart_date_of_business();
		
		if(businessStartDate != null)
		{
			String businessStartDateAsString = UtilFunctionsClass.convertDateToString(businessStartDate);
			
			if(businessStartDateAsString.equals("1360-10-10"))
			{
				displayDates.setYearDisplayIndex(0);
				displayDates.setMonthDisplayIndex(0);
				displayDates.setDayDisplayIndex(0);
			}
			else
			{
				displayDates.setDate(businessStartDateAsString);
				businessStartDateAsString = null;
			}

		}
		else
		{
			displayDates.setYearDisplayIndex(0);
			displayDates.setMonthDisplayIndex(0);
			displayDates.setDayDisplayIndex(0);
		}
		
		businessStartDate = null;
		
		if(applicant.getBankDetails() != null)
		{
			String bankName = this.applicant.getBankDetails().getBankName();
			if(bankName == null)
			{
				bankName = "";
			}
			else
			{
				for(int index = 0; index < bankNamesCB.getItemCount(); index++)
				{
					String currentItem = bankNamesCB.getItemAt(index);
					
					if(bankName.equals(currentItem))
					{
						bankNamesCB.setSelectedIndex(index);
						currentItem = null;
						break;
					}
				}
			}
			
			bankName = null;
			
			String accountHolderName = this.applicant.getBankDetails().getAccount_holder_name();
			if(accountHolderName == null)
			{
				accountHolderName = "";
			}
			
			accountHolderNameTF.setText(accountHolderName);
			accountHolderName = null;
			
			String accountNumber = this.applicant.getBankDetails().getBank_account_num();
			if(accountNumber == null)
			{
				accountNumber = "";
			}
			
			bankAccNumTF.setText(accountNumber);
			accountNumber = null;
		}
		
	}
	
	private void getApplicantValues()
	{
		String occupation = occupationTF.getText().trim();
		if(occupation == null)
		{
			occupation = "";
		}
		
		applicant.setOccupation(occupation);
		occupation = null;
		
		String businessPlace = placeOfBusinessTF.getText().trim();
		if(businessPlace == null)
		{
			businessPlace = "";
		}
		
		applicant.setPlace_of_business(businessPlace);
		businessPlace = null;
		
		String businessStartDateStr = "";
		
		if(businessStartYearCB.getSelectedIndex() == 0)
		{
			businessStartDateStr += "1360";
		}
		else
		{
			businessStartDateStr = businessStartDateStr + businessStartYearCB.getSelectedItem();
		}
		
		if(businessStartMonthCB.getSelectedIndex() == 0)
		{
			businessStartDateStr += "-10";
		}
		else
		{
			if(businessStartMonthCB.getSelectedIndex() < 10)
			{
				businessStartDateStr = businessStartDateStr + "-0" + businessStartMonthCB.getSelectedIndex();
			}
			
			else
			{
				businessStartDateStr = businessStartDateStr + "-" + businessStartMonthCB.getSelectedIndex();
			}
		}
		
		if(businessStartDayCB.getSelectedIndex() == 0)
		{
			businessStartDateStr += "-10";
		}
		else
		{
			businessStartDateStr = businessStartDateStr + "-" + businessStartDayCB.getSelectedItem();
		}
		
		java.sql.Date businessStartDate = null;
		
		if(businessStartDateStr != "")
		{
			businessStartDate = java.sql.Date.valueOf(businessStartDateStr);
		}
		
		applicant.setStart_date_of_business(businessStartDate);
		businessStartDate = null;
		businessStartDateStr = null;
		
		int bankNameSelectedIndex = bankNamesCB.getSelectedIndex();
		
		if(bankNameSelectedIndex == 0)
		{
			applicant.setBankDetails(new BankAccountDetails("", "", ""));
		}
		else
		{
			String bankName = (String) bankNamesCB.getSelectedItem();
			if(bankName == null)
			{
				bankName = "";
			}
			
			String accountHolderName = accountHolderNameTF.getText().trim();
			if(accountHolderName == null)
			{
				accountHolderName = "";
			}
			
			String bankAccountNum = bankAccNumTF.getText().trim();
			if(bankAccountNum == null)
			{
				bankAccountNum = "";
			}
			
			applicant.setBankDetails(new BankAccountDetails(bankName, accountHolderName, bankAccountNum));
			
			bankName = null;
			accountHolderName = null;
			bankAccountNum = null;
			
		}
	}
	
	private class ButtonHandler implements ActionListener
	{
		
		EnterBusinessAndBankDetails enterBusinessAndBankDetails;
		
		public ButtonHandler(EnterBusinessAndBankDetails enterBusinessAndBankDetails)
		{
			this.enterBusinessAndBankDetails = enterBusinessAndBankDetails;
		}

		@Override
		public void actionPerformed(ActionEvent event) 
		{	
			getApplicantValues();
			
			if(event.getSource() == nextBtn)
			{
				UtilFunctionsClass.loadEnterContactDetailsScreen(applicant, this.enterBusinessAndBankDetails);
			}
			
			if(event.getSource() == prevBtn)
			{
				UtilFunctionsClass.loadEnterAddressDetailsScreen(applicant, this.enterBusinessAndBankDetails);
			}
			
			if(event.getSource() == saveBtn)
			{
				ApplicantDaoImplementation applicantDao = new ApplicantDaoImplementation();
				try 
				{
					int saveStatus = applicantDao.saveApplicantDetails(applicant);
					if(saveStatus > 0)
					{
						JOptionPane.showMessageDialog(getParent(), "Information saved successfully", "Save Successfull",  JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(getParent(), "Information was not saved successfully", "Save Unsuccessfull",  JOptionPane.WARNING_MESSAGE);
					}
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private class PanelMouseListener implements MouseListener{
		
		EnterBusinessAndBankDetails enterBusinessAndBankDetailsFrame;
		
		public PanelMouseListener(EnterBusinessAndBankDetails enterBusinessAndBankDetailsFrame)
		{
			this.enterBusinessAndBankDetailsFrame = enterBusinessAndBankDetailsFrame;
		}

		@Override
		public void mouseClicked(MouseEvent event) 
		{
			getApplicantValues();
			
			String panelName = ((JPanel) event.getSource()).getName();
			
			if(panelName.equals("panelStep1"))
			{
				UtilFunctionsClass.loadEnterPersonalDetailsScreen(applicant, this.enterBusinessAndBankDetailsFrame);
			}
			
			else if(panelName.equals("panelStep2"))
			{
				UtilFunctionsClass.loadEnterAddressDetailsScreen(applicant, this.enterBusinessAndBankDetailsFrame);
			}
			
			else if(panelName.equals("panelStep4"))
			{
				UtilFunctionsClass.loadEnterContactDetailsScreen(applicant, this.enterBusinessAndBankDetailsFrame);
			}
			
			else if(panelName.equals("panelLogout"))
			{
				int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout? Be sure to save the information provided before logging out. Else all information provided will be lost", "Are you sure you want to logout?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(response == JOptionPane.YES_OPTION)
				{
					applicant = null;
					UtilFunctionsClass.loadLoginScreen(this.enterBusinessAndBankDetailsFrame);
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent event) {}

		@Override
		public void mouseReleased(MouseEvent event) {}

		@Override
		public void mouseEntered(MouseEvent event) 
		{
			String panelName = ((JPanel) event.getSource()).getName();
			JPanel targetPanel = ((JPanel) event.getSource());
			
			if(panelName.equals("panelStep1"))
			{
				targetPanel.setBackground(Colours.SIDE_NAVIGATION_HOVER_COLOUR);
			}
			
			else if(panelName.equals("panelStep2"))
			{
				targetPanel.setBackground(Colours.SIDE_NAVIGATION_HOVER_COLOUR);
			}
			
			else if(panelName.equals("panelStep4"))
			{
				targetPanel.setBackground(Colours.SIDE_NAVIGATION_HOVER_COLOUR);
			}
			
			else if(panelName.equals("panelLogout"))
			{
				targetPanel.setBackground(Colours.SIDE_NAVIGATION_HOVER_COLOUR);
			}
			
		}

		@Override
		public void mouseExited(MouseEvent event) 
		{
			String panelName = ((JPanel) event.getSource()).getName();
			JPanel targetPanel = ((JPanel) event.getSource());
			
			if(panelName.equals("panelStep1"))
			{
				targetPanel.setBackground(Color.decode(Colours.SIDE_NAVIGATION_BACKGROUND_COLOUR));
			}
			
			else if(panelName.equals("panelStep2"))
			{
				targetPanel.setBackground(Color.decode(Colours.SIDE_NAVIGATION_BACKGROUND_COLOUR));
			}
			
			else if(panelName.equals("panelStep4"))
			{
				targetPanel.setBackground(Color.decode(Colours.SIDE_NAVIGATION_BACKGROUND_COLOUR));
			}
			
			else if(panelName.equals("panelLogout"))
			{
				targetPanel.setBackground(Color.decode(Colours.SIDE_NAVIGATION_BACKGROUND_COLOUR));
			}
		}
		
	}

}
