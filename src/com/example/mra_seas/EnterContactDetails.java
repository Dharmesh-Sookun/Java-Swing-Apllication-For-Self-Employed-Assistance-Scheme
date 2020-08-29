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
public class EnterContactDetails extends CustomFrame {

	private ApplicantDetails applicant = null;

	private JLabel titlelbl, steplbl, telephoneNumlbl, mobileNumlbl, emailAddresslbl,
			economicallyActivelbl, notPursuingStudieslbl, notAnEmployeelbl, notReceivingSocialBenefitslbl, 
			notDependentSpouselbl, notInPassiveBusinesslbl, step1lbl, step2lbl, step3lbl, step4lbl, logoutlbl;

	private JTextField telephoneNumTF, mobileNumTF, emailAddressTF;
	
	private JCheckBox economicallyActiveCheck, notPursuingStudiesCheck, notAnEmployeeCheck,
			notReceivingSocialBenefitsCheck, notDependentSpouseCheck, notInPassiveBusinessCheck;
	
	private JButton prevBtn, saveBtn, applyBtn;

	public EnterContactDetails(ApplicantDetails applicant) 
	{
		super("Enter contact details");
		this.applicant = applicant;
		createGUI();
	}

	@Override
	public void createGUI() {
		
		setLayout(new GridLayout(1, 1));

		titlelbl = new JLabel("Application form for self-employed assistance scheme in the context of covid-19");
		steplbl = new JLabel("Step 4 of 4 - Contact Details");
		telephoneNumlbl = new JLabel("Enter your telephone number: *");
		mobileNumlbl = new JLabel("Enter your mobile number: ");
		emailAddresslbl = new JLabel("Enter your email address: ");

		economicallyActivelbl = new JLabel("I confirm that I have been economically active for the last 3 months. *");
		notPursuingStudieslbl = new JLabel("I confirm that I am not pursuing full time higher studies. *");
		notDependentSpouselbl = new JLabel("I certify that I am not a dependent spouse. *");
		notAnEmployeelbl = new JLabel("I certify that I am not a full-time or part-time employee. *");
		notReceivingSocialBenefitslbl = new JLabel("I certify that I do not receive monthly social benefits. *");
		notInPassiveBusinesslbl = new JLabel("I certify that I am not in any passive income businesses. *");
		
		step1lbl = new JLabel("Step 1: Personal Details");
		step2lbl = new JLabel("Step 2: Address Details");
		step3lbl = new JLabel("Step 3: Business and Bank details");
		step4lbl = new JLabel("Step 4: Contact details");
		logoutlbl = new JLabel("Logout");
		
		titlelbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		steplbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		telephoneNumlbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		mobileNumlbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		emailAddresslbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		
		economicallyActivelbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		notPursuingStudieslbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		notDependentSpouselbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		notAnEmployeelbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		notReceivingSocialBenefitslbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		notInPassiveBusinesslbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		
		step1lbl.setForeground(Color.decode(Colours.SIDE_NAVIGATION_PRIMARY_TEXT_COLOUR));
		step2lbl.setForeground(Color.decode(Colours.SIDE_NAVIGATION_PRIMARY_TEXT_COLOUR));
		step3lbl.setForeground(Color.decode(Colours.SIDE_NAVIGATION_PRIMARY_TEXT_COLOUR));
		step4lbl.setForeground(Color.decode(Colours.SIDE_NAVIGATION_PRIMARY_TEXT_COLOUR));
		logoutlbl.setForeground(Color.decode(Colours.SIDE_NAVIGATION_PRIMARY_TEXT_COLOUR));
		
		titlelbl.setFont(Fonts.TITLE_FONT);
		steplbl.setFont(Fonts.MAIN_HEADING_FONT);
		telephoneNumlbl.setFont(Fonts.NORMAL_TEXT_FONT);
		mobileNumlbl.setFont(Fonts.NORMAL_TEXT_FONT);
		emailAddresslbl.setFont(Fonts.NORMAL_TEXT_FONT);
		economicallyActivelbl.setFont(Fonts.NORMAL_TEXT_FONT);
		notPursuingStudieslbl.setFont(Fonts.NORMAL_TEXT_FONT);
		notDependentSpouselbl.setFont(Fonts.NORMAL_TEXT_FONT);
		notAnEmployeelbl.setFont(Fonts.NORMAL_TEXT_FONT);
		notReceivingSocialBenefitslbl.setFont(Fonts.NORMAL_TEXT_FONT);
		notInPassiveBusinesslbl.setFont(Fonts.NORMAL_TEXT_FONT);
		step1lbl.setFont(Fonts.NORMAL_TEXT_FONT);
		step2lbl.setFont(Fonts.NORMAL_TEXT_FONT);
		step3lbl.setFont(Fonts.NORMAL_TEXT_FONT);
		step4lbl.setFont(Fonts.NORMAL_TEXT_FONT);
		logoutlbl.setFont(Fonts.NORMAL_TEXT_FONT);

		telephoneNumTF = new JTextField();
		mobileNumTF = new JTextField();
		emailAddressTF = new JTextField();

		economicallyActiveCheck = new JCheckBox();
		notPursuingStudiesCheck = new JCheckBox();
		notDependentSpouseCheck = new JCheckBox();
		notAnEmployeeCheck = new JCheckBox();
		notReceivingSocialBenefitsCheck = new JCheckBox();
		notInPassiveBusinessCheck = new JCheckBox();
		
		economicallyActiveCheck.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		notPursuingStudiesCheck.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		notDependentSpouseCheck.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		notAnEmployeeCheck.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		notReceivingSocialBenefitsCheck.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		notInPassiveBusinessCheck.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));

		prevBtn = new JButton("Previous");
		applyBtn = new JButton("Apply");
		saveBtn = new JButton("Save form");
		
		prevBtn.setBackground(Color.decode(Colours.PREV_BUTTON_BACKGROUND));
		prevBtn.setForeground(Color.decode(Colours.PRIMARY_BUTTON_TEXT));
		prevBtn.setFont(Fonts.BUTTON_TEXT_FONT);
		
		applyBtn.setBackground(Color.decode(Colours.APPLY_BUTTON_BACKGROUND));
		applyBtn.setForeground(Color.decode(Colours.PRIMARY_BUTTON_TEXT));
		applyBtn.setFont(Fonts.BUTTON_TEXT_FONT);
		
		saveBtn.setBackground(Color.decode(Colours.SAVE_BUTTON_BACKGROUND));
		saveBtn.setForeground(Color.decode(Colours.PRIMARY_BUTTON_TEXT));
		saveBtn.setFont(Fonts.BUTTON_TEXT_FONT);

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
		panelBtns.add(applyBtn, JButton.CENTER);
		panelBtns.add(saveBtn, JButton.CENTER);
		panelBtns.add(prevBtn, JButton.CENTER);
		panelBtns.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));

		JPanel panelContactInfo = new JPanel(new GridLayout(2, 5, 2, 60));
		panelContactInfo.add(telephoneNumlbl);
		panelContactInfo.add(telephoneNumTF);
		panelContactInfo.add(new Container());
		panelContactInfo.add(mobileNumlbl);
		panelContactInfo.add(mobileNumTF);

		panelContactInfo.add(emailAddresslbl);
		panelContactInfo.add(emailAddressTF);
		panelContactInfo.add(new Container());
		panelContactInfo.add(new Container());
		panelContactInfo.add(new Container());
		
		panelContactInfo.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		TitledBorder panelContactInfoBorder = BorderFactory.createTitledBorder("Contact Details");
		panelContactInfoBorder.setBorder(new LineBorder(Color.decode(Colours.PRIMARY_BORDER_COLOUR), 3, true));
		panelContactInfoBorder.setTitleJustification(TitledBorder.CENTER);
		panelContactInfoBorder.setTitleFont(Fonts.NORMAL_TEXT_FONT);
		panelContactInfoBorder.setTitleColor(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		
		panelContactInfo.setBorder(panelContactInfoBorder);

		JPanel panelContactInfoContainer = new JPanel(new BorderLayout(1, 55));
		panelContactInfoContainer.add(new Container(), BorderLayout.NORTH);
		panelContactInfoContainer.add(panelContactInfo, BorderLayout.CENTER);
		panelContactInfoContainer.add(new Container(), BorderLayout.WEST);
		panelContactInfoContainer.add(new Container(), BorderLayout.EAST);
		panelContactInfoContainer.add(new Container(), BorderLayout.SOUTH);
		
		panelContactInfoContainer.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));

		JPanel panelAgreedTerms = new JPanel(new GridLayout(6, 2));
		panelAgreedTerms.add(economicallyActivelbl);
		panelAgreedTerms.add(economicallyActiveCheck);

		panelAgreedTerms.add(notPursuingStudieslbl);
		panelAgreedTerms.add(notPursuingStudiesCheck);
		
		panelAgreedTerms.add(notAnEmployeelbl);
		panelAgreedTerms.add(notAnEmployeeCheck);
		
		panelAgreedTerms.add(notInPassiveBusinesslbl);
		panelAgreedTerms.add(notInPassiveBusinessCheck);
		
		panelAgreedTerms.add(notReceivingSocialBenefitslbl);
		panelAgreedTerms.add(notReceivingSocialBenefitsCheck);
		
		panelAgreedTerms.add(notDependentSpouselbl);
		panelAgreedTerms.add(notDependentSpouseCheck);
		
		panelAgreedTerms.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		TitledBorder panelAgreedTermsBorder = BorderFactory.createTitledBorder("Terms And Conditions");
		panelAgreedTermsBorder.setBorder(new LineBorder(Color.decode(Colours.PRIMARY_BORDER_COLOUR), 3, true));
		panelAgreedTermsBorder.setTitleJustification(TitledBorder.CENTER);
		panelAgreedTermsBorder.setTitleFont(Fonts.NORMAL_TEXT_FONT);
		panelAgreedTermsBorder.setTitleColor(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		
		panelAgreedTerms.setBorder(panelAgreedTermsBorder);

		JPanel panelMainContent = new JPanel(new GridLayout(2, 1));
		panelMainContent.add(panelContactInfoContainer);
		panelMainContent.add(panelAgreedTerms);
		panelMainContent.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));

		JPanel panelMain = new JPanel(new BorderLayout(40, 30));
		panelMain.add(panelHeadings, BorderLayout.NORTH);
		panelMain.add(new Container(), BorderLayout.WEST);
		panelMain.add(panelMainContent, BorderLayout.CENTER);
		panelMain.add(new Container(), BorderLayout.EAST);
		panelMain.add(panelBtns, BorderLayout.SOUTH);
		panelMain.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		if(applicant.getMarried().equals("Y"))
		{
			notDependentSpouselbl.setVisible(true);
			notDependentSpouseCheck.setVisible(true);
		}
		
		else
		{
			notDependentSpouselbl.setVisible(false);
			notDependentSpouseCheck.setVisible(false);
		}
		
		ButtonHandler buttonHandler = new ButtonHandler(this);
		prevBtn.addActionListener(buttonHandler);
		saveBtn.addActionListener(buttonHandler);
		applyBtn.addActionListener(buttonHandler);
		
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
		panelStep3.setBackground(Color.decode(Colours.SIDE_NAVIGATION_BACKGROUND_COLOUR));
		panelStep3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JPanel panelStep4 = new JPanel(new GridBagLayout());
		panelStep4 = new JPanel(new GridBagLayout());
		panelStep4.setName("panelStep4");
		panelStep4.add(step4lbl);
		panelStep4.setBackground(Colours.SIDE_NAVIGATION_SELECTED_COLOUR);
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
		panelStep3.addMouseListener(panelMouseListener);
		panelLogout.addMouseListener(panelMouseListener);
		
		setApplicantValues();

		add(splitPane);
	}
	
	private void setApplicantValues()
	{
		telephoneNumTF.setText(this.applicant.getTelephone_num());
		
		mobileNumTF.setText(this.applicant.getMobile_num());
		
		emailAddressTF.setText(this.applicant.getEmail_address());
	}
	
	private void getApplicantValues()
	{
		String telephoneNum = telephoneNumTF.getText().trim();
		if(telephoneNum == null)
		{
			telephoneNum = "";
		}
		
		applicant.setTelephone_num(telephoneNum);
		telephoneNum = null;
		
		String mobileNum = mobileNumTF.getText().trim();
		if(mobileNum == null)
		{
			mobileNum = "";
		}
		
		applicant.setMobile_num(mobileNum);
		mobileNum = null;
		
		String email = emailAddressTF.getText().trim();
		if(email == null)
		{
			email = "";
		}
		applicant.setEmail_address(email);
		email = null;
	}
	
	private class ButtonHandler implements ActionListener
	{
		EnterContactDetails enterContactDetails;
		
		public ButtonHandler(EnterContactDetails enterContactDetails)
		{
			this.enterContactDetails = enterContactDetails;
		}

		@Override
		public void actionPerformed(ActionEvent event) 
		{
			getApplicantValues();
			
			if(event.getSource() == prevBtn)
			{
				UtilFunctionsClass.loadEnterBusinessDetailsScreen(applicant, this.enterContactDetails);
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
			
			if(event.getSource() == applyBtn)
			{
				String applicant_dob = UtilFunctionsClass.convertDateToString(applicant.getDateOfBirth());
				
				String business_start_date = UtilFunctionsClass.convertDateToString(applicant.getStart_date_of_business());
				
				if(applicant.getSurname().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter your surname", "Empty surname",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(applicant.getOtherNames().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter your other names", "Empty other names",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(applicant_dob.equals("1360-10-10"))
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter your date of birth", "Empty date of birth",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(applicant.getMarried().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter whether you are married or not", "Empty married field",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(applicant.getMarried().equals("Y"))
				{
					if(applicant.getSpouseDetails().getSpouse_nid().equals(""))
					{
						JOptionPane.showMessageDialog(getParent(), "Please enter the NIC number of your spouse", "Empty spouse NIC number",  JOptionPane.ERROR_MESSAGE);

					}
					
					else if(applicant.getSpouseDetails().getSpouse_name().equals(""))
					{
						JOptionPane.showMessageDialog(getParent(), "Please enter the name of your spouse", "Empty spouse name",  JOptionPane.ERROR_MESSAGE);

					}
					
					else if(applicant.getSpouseDetails().getSpouse_passport_num().equals(""))
					{
						JOptionPane.showMessageDialog(getParent(), "Please enter the passport number of your spouse", "Empty spouse passport number",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(applicant.getSpouseDetails().getSpouse_occupation().equals(""))
					{
						JOptionPane.showMessageDialog(getParent(), "Please enter the occupation of your spouse", "Empty spouse occupation",  JOptionPane.ERROR_MESSAGE);

					}
					
					else if(applicant.getHouseNum().equals(""))
					{
						JOptionPane.showMessageDialog(getParent(), "Please enter your house number", "Empty house number",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(applicant.getStreet().equals(""))
					{
						JOptionPane.showMessageDialog(getParent(), "Please enter your street", "Empty street",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(applicant.getLocality().equals(""))
					{
						JOptionPane.showMessageDialog(getParent(), "Please enter your locality", "Empty locality",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(applicant.getMauritusPostalRegion().equals(""))
					{
						JOptionPane.showMessageDialog(getParent(), "Please enter your postal region", "Empty postal region",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(applicant.getVillage_town().equals(""))
					{
						JOptionPane.showMessageDialog(getParent(), "Please enter your village or town", "Empty village or town",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(applicant.getPostalCode().equals(""))
					{
						JOptionPane.showMessageDialog(getParent(), "Please enter your postal code", "Empty postal code",  JOptionPane.ERROR_MESSAGE);

					}
					
					else if(applicant.getOccupation().equals(""))
					{
						JOptionPane.showMessageDialog(getParent(), "Please enter your occupation", "Empty occupation",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(applicant.getPlace_of_business().equals(""))
					{
						JOptionPane.showMessageDialog(getParent(), "Please enter your place of business", "Empty place of business",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(business_start_date.equals("1360-10-10"))
					{
						JOptionPane.showMessageDialog(getParent(), "Please select your business start date", "Empty business start date",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(applicant.getBankDetails().getBankName().equals(""))
					{
						JOptionPane.showMessageDialog(getParent(), "Please select your bank", "Empty bank",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(applicant.getBankDetails().getAccount_holder_name().equals(""))
					{
						JOptionPane.showMessageDialog(getParent(), "Please enter the account holder name", "Empty account holder name",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(applicant.getBankDetails().getBank_account_num().equals(""))
					{
						JOptionPane.showMessageDialog(getParent(), "Please enter your bank account number", "Empty bank account number",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(applicant.getTelephone_num().equals(""))
					{
						JOptionPane.showMessageDialog(getParent(), "Please enter your telephone number", "Empty telephone number",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(!economicallyActiveCheck.isSelected())
					{
						JOptionPane.showMessageDialog(getParent(), "Please confirm that you have been economically active for the last 3 months", "Please confirm that you have been economically active for the last 3 months",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(!notPursuingStudiesCheck.isSelected())
					{
						JOptionPane.showMessageDialog(getParent(), "Please confirm that you are not pursuing full time higher studies", "Please confirm that you are not pursuing full time higher studies",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(!notAnEmployeeCheck.isSelected())
					{
						JOptionPane.showMessageDialog(getParent(), "Please confirm that you are not a full-time or part-time employee", "Please confirm that you are not a full-time or part-time employee",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(!notInPassiveBusinessCheck.isSelected())
					{
						JOptionPane.showMessageDialog(getParent(), "Please confirm that you are not in any passive income businesses", "Please confirm that you are not in any passive income businesses",  JOptionPane.ERROR_MESSAGE);
					}
					
					else if(!notReceivingSocialBenefitsCheck.isSelected())
					{
						JOptionPane.showMessageDialog(getParent(), "Please confirm that you do not receive monthly social benefits", "Please confirm that I do not receive monthly social benefits",  JOptionPane.ERROR_MESSAGE);

					}
					else if(!notDependentSpouseCheck.isSelected())
					{
						JOptionPane.showMessageDialog(getParent(), "Please confirm that you are not a dependent spouse", "Please confirm that you are not a dependent spouse",  JOptionPane.ERROR_MESSAGE);
					}
					
					else
					{
						ApplicantDaoImplementation applicantDao = new ApplicantDaoImplementation();
						
						try 
						{
							int applyStatus = applicantDao.saveApplicantDetails(applicant);
							int appliedStatus = applicantDao.updateAppliedStatus(applicant.getNID());
							
							if(applyStatus > 0 && appliedStatus > 0)
							{
								JOptionPane.showMessageDialog(getParent(), "You have successfully applied for this scheme", "Application Successfull",  JOptionPane.INFORMATION_MESSAGE);
							}
							else
							{
								JOptionPane.showMessageDialog(getParent(), "Your application for this scheme was not successfull", "Application Unsuccessfull",  JOptionPane.ERROR_MESSAGE);
							}
						} 
						catch (SQLException e) 
						{
							e.printStackTrace();
						}
						
					}
				}
				
				else if(applicant.getHouseNum().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter your house number", "Empty house number",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(applicant.getStreet().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter your street", "Empty street",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(applicant.getLocality().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter your locality", "Empty locality",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(applicant.getMauritusPostalRegion().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter your postal region", "Empty postal region",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(applicant.getVillage_town().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter your village or town", "Empty village or town",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(applicant.getPostalCode().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter your postal code", "Empty postal code",  JOptionPane.ERROR_MESSAGE);

				}
				
				else if(applicant.getOccupation().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter your occupation", "Empty occupation",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(applicant.getPlace_of_business().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter your place of business", "Empty place of business",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(business_start_date.equals("1360-10-10"))
				{
					JOptionPane.showMessageDialog(getParent(), "Please select your business start date", "Empty business start date",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(applicant.getBankDetails().getBankName().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Please select your bank", "Empty bank",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(applicant.getBankDetails().getAccount_holder_name().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter the account holder name", "Empty account holder name",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(applicant.getBankDetails().getBank_account_num().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter your bank account number", "Empty bank account number",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(applicant.getTelephone_num().equals(""))
				{
					JOptionPane.showMessageDialog(getParent(), "Please enter your telephone number", "Empty telephone number",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(!economicallyActiveCheck.isSelected())
				{
					JOptionPane.showMessageDialog(getParent(), "Please confirm that you have been economically active for the last 3 months", "Please confirm that you have been economically active for the last 3 months",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(!notPursuingStudiesCheck.isSelected())
				{
					JOptionPane.showMessageDialog(getParent(), "Please confirm that you are not pursuing full time higher studies", "Please confirm that you are not pursuing full time higher studies",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(!notAnEmployeeCheck.isSelected())
				{
					JOptionPane.showMessageDialog(getParent(), "Please confirm that you are not a full-time or part-time employee", "Please confirm that you are not a full-time or part-time employee",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(!notInPassiveBusinessCheck.isSelected())
				{
					JOptionPane.showMessageDialog(getParent(), "Please confirm that you are not in any passive income businesses", "Please confirm that you are not in any passive income businesses",  JOptionPane.ERROR_MESSAGE);
				}
				
				else if(!notReceivingSocialBenefitsCheck.isSelected())
				{
					JOptionPane.showMessageDialog(getParent(), "Please confirm that you do not receive monthly social benefits", "Please confirm that I do not receive monthly social benefits",  JOptionPane.ERROR_MESSAGE);

				}
				
				else
				{
					ApplicantDaoImplementation applicantDao = new ApplicantDaoImplementation();
					
					try 
					{
						int applyStatus = applicantDao.saveApplicantDetails(applicant);
						int appliedStatus = applicantDao.updateAppliedStatus(applicant.getNID());
						
						if(applyStatus > 0 && appliedStatus > 0)
						{
							JOptionPane.showMessageDialog(getParent(), "You have successfully applied for this scheme", "Application Successfull",  JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(getParent(), "Your application for this scheme was not successfull", "Application Unsuccessfull",  JOptionPane.ERROR_MESSAGE);
						}
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					
				}
			}
		}
	}
	
	private class PanelMouseListener implements MouseListener{
		
		EnterContactDetails enterContactDetailsFrame;
		
		public PanelMouseListener(EnterContactDetails enterContactDetailsFrame)
		{
			this.enterContactDetailsFrame = enterContactDetailsFrame;
		}

		@Override
		public void mouseClicked(MouseEvent event) 
		{
			getApplicantValues();
			
			String panelName = ((JPanel) event.getSource()).getName();
			
			if(panelName.equals("panelStep1"))
			{
				UtilFunctionsClass.loadEnterPersonalDetailsScreen(applicant, this.enterContactDetailsFrame);
			}
			
			else if(panelName.equals("panelStep2"))
			{
				UtilFunctionsClass.loadEnterAddressDetailsScreen(applicant, this.enterContactDetailsFrame);
			}
			
			else if(panelName.equals("panelStep3"))
			{
				UtilFunctionsClass.loadEnterBusinessDetailsScreen(applicant, this.enterContactDetailsFrame);
			}
			
			else if(panelName.equals("panelLogout"))
			{
				int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout? Be sure to save the information provided before logging out. Else all information provided will be lost", "Are you sure you want to logout?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(response == JOptionPane.YES_OPTION)
				{
					applicant = null;
					UtilFunctionsClass.loadLoginScreen(this.enterContactDetailsFrame);
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
			
			else if(panelName.equals("panelStep3"))
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
			
			else if(panelName.equals("panelStep3"))
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
