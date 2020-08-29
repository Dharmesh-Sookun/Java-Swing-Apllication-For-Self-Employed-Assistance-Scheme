package com.example.mra_seas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class EnterPersonalDetailsFrame extends CustomFrame {

	ApplicantDetails applicant = null;

	private JLabel titlelbl, steplbl, applicantNICCardNolbl, surnamelbl, otherNameslbl, monthlyIncomelbl, marriedlbl,
			doblbl, spouseNICCardNolbl, spouseNamelbl, spousePassportNumlbl, spouseOccupationlbl, step1lbl, step2lbl, step3lbl, step4lbl, logoutlbl;

	private JTextField applicantNICCardNoTF, surnameTF, otherNamesTF, monthlyIncomeTF, spouseNICCardNoTF, spouseNameTF,
			spousePassportNumTF, spouseOccupationTF;

	private JComboBox<String> marriedCB, dobYearCB, dobMonthCB, dobDayCB;

	private JButton saveFormBtn, nextBtn;

	private JPanel panelSpouseDetails;

	private DisplayDates displayDates;

	public EnterPersonalDetailsFrame(ApplicantDetails applicant) {
		super("Enter personal details");
		this.applicant = applicant;
		createGUI();
	}

	@Override
	public void createGUI() {

		setLayout(new GridLayout(1, 1));

		titlelbl = new JLabel("Application form for self-employed assistance scheme in the context of covid-19");
		steplbl = new JLabel("Step 1 of 4 - Personal Details");
		applicantNICCardNolbl = new JLabel("NIC Card Number: *");
		surnamelbl = new JLabel("Enter your surname: *");
		otherNameslbl = new JLabel("Enter your other names: *");
		doblbl = new JLabel("Select your date of birth: *");
		marriedlbl = new JLabel("Are you married? *");
		monthlyIncomelbl = new JLabel("<html><p>Enter your monthly income</p><p>(Rs): *</p></html>");
		spouseNICCardNolbl = new JLabel("Enter your spouse NIC number: *");
		spouseNamelbl = new JLabel("Enter your spouse name: *");
		spousePassportNumlbl = new JLabel("<html><p>Enter your spouse passport</p><p>number: *</p></html>");
		spouseOccupationlbl = new JLabel("Enter your spouse occupation: *");
		step1lbl = new JLabel("Step 1: Personal Details");
		step2lbl = new JLabel("Step 2: Address Details");
		step3lbl = new JLabel("Step 3: Business and Bank details");
		step4lbl = new JLabel("Step 4: Contact details");
		logoutlbl = new JLabel("Logout");
		
		titlelbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		steplbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		applicantNICCardNolbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		surnamelbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		otherNameslbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		doblbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		marriedlbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		monthlyIncomelbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		spouseNICCardNolbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		spouseNamelbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		spousePassportNumlbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		spouseOccupationlbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		
		titlelbl.setFont(Fonts.TITLE_FONT);
		steplbl.setFont(Fonts.MAIN_HEADING_FONT);
		applicantNICCardNolbl.setFont(Fonts.NORMAL_TEXT_FONT);
		surnamelbl.setFont(Fonts.NORMAL_TEXT_FONT);
		otherNameslbl.setFont(Fonts.NORMAL_TEXT_FONT);
		doblbl.setFont(Fonts.NORMAL_TEXT_FONT);
		marriedlbl.setFont(Fonts.NORMAL_TEXT_FONT);
		monthlyIncomelbl.setFont(Fonts.NORMAL_TEXT_FONT);
		spouseNICCardNolbl.setFont(Fonts.NORMAL_TEXT_FONT);
		spouseNamelbl.setFont(Fonts.NORMAL_TEXT_FONT);
		spousePassportNumlbl.setFont(Fonts.NORMAL_TEXT_FONT);
		spouseOccupationlbl.setFont(Fonts.NORMAL_TEXT_FONT);
		
		step1lbl.setForeground(Color.decode(Colours.SIDE_NAVIGATION_PRIMARY_TEXT_COLOUR));
		step2lbl.setForeground(Color.decode(Colours.SIDE_NAVIGATION_PRIMARY_TEXT_COLOUR));
		step3lbl.setForeground(Color.decode(Colours.SIDE_NAVIGATION_PRIMARY_TEXT_COLOUR));
		step4lbl.setForeground(Color.decode(Colours.SIDE_NAVIGATION_PRIMARY_TEXT_COLOUR));
		logoutlbl.setForeground(Color.decode(Colours.SIDE_NAVIGATION_PRIMARY_TEXT_COLOUR));
		step1lbl.setFont(Fonts.NORMAL_TEXT_FONT);
		step2lbl.setFont(Fonts.NORMAL_TEXT_FONT);
		step3lbl.setFont(Fonts.NORMAL_TEXT_FONT);
		step4lbl.setFont(Fonts.NORMAL_TEXT_FONT);
		logoutlbl.setFont(Fonts.NORMAL_TEXT_FONT);
		
		applicantNICCardNoTF = new JTextField();
		surnameTF = new JTextField();
		otherNamesTF = new JTextField();
		monthlyIncomeTF = new JTextField();
		spouseNICCardNoTF = new JTextField();
		spouseNameTF = new JTextField();
		spousePassportNumTF = new JTextField();
		spouseOccupationTF = new JTextField();
		
		surnameTF.setName("surnameTF");
		surnameTF.setInputVerifier(new ValidateInputs(this.applicant));
		
		monthlyIncomeTF.setName("monthlyIncomeTF");
		monthlyIncomeTF.setInputVerifier(new ValidateInputs());

		applicantNICCardNoTF.setEditable(false);
		applicantNICCardNoTF.setText(this.applicant.getNID());
		
		spouseNICCardNoTF.setName("spouseNICNumTF");
		spouseNICCardNoTF.setInputVerifier(new ValidateInputs());

		marriedCB = new JComboBox<String>();

		final String MARRIED_OPTIONS[] = { "Please select", "Yes", "No" };

		for (int index = 0; index < MARRIED_OPTIONS.length; index++) {
			marriedCB.addItem(MARRIED_OPTIONS[index]);
		}

		saveFormBtn = new JButton("Save form");
		nextBtn = new JButton("Next");
		
		saveFormBtn.setBackground(Color.decode(Colours.SAVE_BUTTON_BACKGROUND));
		saveFormBtn.setForeground(Color.decode(Colours.PRIMARY_BUTTON_TEXT));
		saveFormBtn.setFont(Fonts.BUTTON_TEXT_FONT);
		
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

		displayDates = new DisplayDates();

		JPanel panelDOB = displayDates.getDatePanel();
		panelDOB.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));

		JPanel panelBtns = new JPanel();
		panelBtns.add(nextBtn, JButton.CENTER);
		panelBtns.add(saveFormBtn, JButton.CENTER);
		panelBtns.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));

		JPanel panelPersonalDetailsContainer = new JPanel(new GridLayout(3, 5, 0, 55));
		panelPersonalDetailsContainer.add(applicantNICCardNolbl);
		panelPersonalDetailsContainer.add(applicantNICCardNoTF);
		panelPersonalDetailsContainer.add(new Container());
		panelPersonalDetailsContainer.add(surnamelbl);
		panelPersonalDetailsContainer.add(surnameTF);

		panelPersonalDetailsContainer.add(otherNameslbl);
		panelPersonalDetailsContainer.add(otherNamesTF);
		panelPersonalDetailsContainer.add(new Container());
		panelPersonalDetailsContainer.add(doblbl);
		panelPersonalDetailsContainer.add(panelDOB);

		panelPersonalDetailsContainer.add(marriedlbl);
		panelPersonalDetailsContainer.add(marriedCB);
		panelPersonalDetailsContainer.add(new Container());
		panelPersonalDetailsContainer.add(monthlyIncomelbl);
		panelPersonalDetailsContainer.add(monthlyIncomeTF);
		
		panelPersonalDetailsContainer.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		TitledBorder panelPersonalDetailsContainerBorder = BorderFactory.createTitledBorder("Basic Details");
		panelPersonalDetailsContainerBorder.setBorder(new LineBorder(Color.decode(Colours.PRIMARY_BORDER_COLOUR), 3, true));
		panelPersonalDetailsContainerBorder.setTitleJustification(TitledBorder.CENTER);
		panelPersonalDetailsContainerBorder.setTitleFont(Fonts.NORMAL_TEXT_FONT);
		panelPersonalDetailsContainerBorder.setTitleColor(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		
		panelPersonalDetailsContainer.setBorder(panelPersonalDetailsContainerBorder);

		JPanel panelSpouseDetailsContainer = new JPanel(new GridLayout(2, 5, 0, 40));
		panelSpouseDetailsContainer.add(spouseNICCardNolbl);
		panelSpouseDetailsContainer.add(spouseNICCardNoTF);
		panelSpouseDetailsContainer.add(new Container());
		panelSpouseDetailsContainer.add(spouseNamelbl);
		panelSpouseDetailsContainer.add(spouseNameTF);

		panelSpouseDetailsContainer.add(spousePassportNumlbl);
		panelSpouseDetailsContainer.add(spousePassportNumTF);
		panelSpouseDetailsContainer.add(new Container());
		panelSpouseDetailsContainer.add(spouseOccupationlbl);
		panelSpouseDetailsContainer.add(spouseOccupationTF);
		
		panelSpouseDetailsContainer.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		TitledBorder panelSpouseDetailsContainerBorder = BorderFactory.createTitledBorder("Spouse Details");
		panelSpouseDetailsContainerBorder.setBorder(new LineBorder(Color.decode(Colours.PRIMARY_BORDER_COLOUR), 3, true));
		panelSpouseDetailsContainerBorder.setTitleJustification(TitledBorder.CENTER);
		panelSpouseDetailsContainerBorder.setTitleColor(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		panelSpouseDetailsContainerBorder.setTitleFont(Fonts.NORMAL_TEXT_FONT);
		panelSpouseDetailsContainer.setBorder(panelSpouseDetailsContainerBorder);

		panelSpouseDetails = new JPanel(new BorderLayout(0, 55));
		panelSpouseDetails.add(new Container(), BorderLayout.NORTH);
		panelSpouseDetails.add(panelSpouseDetailsContainer, BorderLayout.CENTER);
		panelSpouseDetails.add(new Container(), BorderLayout.WEST);
		panelSpouseDetails.add(new Container(), BorderLayout.EAST);
		panelSpouseDetails.add(new Container(), BorderLayout.SOUTH);
		
		panelSpouseDetails.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));

		JPanel panelPersonalDetails = new JPanel(new GridLayout(2, 1, 0, 10));
		panelPersonalDetails.add(panelPersonalDetailsContainer);
		panelPersonalDetails.add(panelSpouseDetails);
		
		panelPersonalDetails.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));

		JPanel panelMain = new JPanel(new BorderLayout(15, 30));
		panelMain.add(panelHeadings, BorderLayout.NORTH);
		panelMain.add(new Container(), BorderLayout.WEST);
		panelMain.add(panelPersonalDetails, BorderLayout.CENTER);
		panelMain.add(new Container(), BorderLayout.EAST);
		panelMain.add(panelBtns, BorderLayout.SOUTH);
		//panelMain.setSize(1100, 768);
		
		panelMain.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));

		panelSpouseDetails.setVisible(false);

		ComboBoxHandler comboBoxHandler = new ComboBoxHandler();
		marriedCB.addItemListener(comboBoxHandler);
		
		dobYearCB = displayDates.getYearDisplayComboBox();
		dobMonthCB = displayDates.getMonthDisplayComboBox();
		dobDayCB = displayDates.getDayDisplayComboBox();
		
		dobYearCB.addItemListener(comboBoxHandler);

		CustomKeyListener keyListener = new CustomKeyListener();
		monthlyIncomeTF.addKeyListener(keyListener);

		ButtonHandler buttonHandler = new ButtonHandler(this);
		saveFormBtn.addActionListener(buttonHandler);
		nextBtn.addActionListener(buttonHandler);
		
		JPanel panelStep1 = new JPanel(new GridBagLayout());
		panelStep1.setName("panelStep1");
		panelStep1.add(step1lbl);
		panelStep1.setBackground(Colours.SIDE_NAVIGATION_SELECTED_COLOUR);
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
		panelStep4.setBackground(Color.decode(Colours.SIDE_NAVIGATION_BACKGROUND_COLOUR));
		panelStep4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JPanel panelLogout = new JPanel(new GridBagLayout());
		panelLogout = new JPanel(new GridBagLayout());
		panelLogout.setName("panelLogout");
		panelLogout.add(logoutlbl);
		panelLogout.setBackground(Color.decode(Colours.SIDE_NAVIGATION_BACKGROUND_COLOUR));
		panelLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JPanel panelSideNavigation = new JPanel(new GridLayout(7, 1, 1, 20));
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
		panelStep2.addMouseListener(panelMouseListener);
		panelStep3.addMouseListener(panelMouseListener);
		panelStep4.addMouseListener(panelMouseListener);
		panelLogout.addMouseListener(panelMouseListener);
		
		setApplicantValues();

		add(splitPane);
	}

	private void setApplicantValues() {
		String surname = this.applicant.getSurname();
		if (surname == null) {
			surname = "";
		}

		surnameTF.setText(surname);

		surname = null;

		String otherNames = this.applicant.getOtherNames();
		if (otherNames == null) {
			otherNames = "";
		}

		otherNamesTF.setText(otherNames);

		otherNames = null;

		java.sql.Date dob = this.applicant.getDateOfBirth();

		if (dob != null) 
		{
			String dobAsString = UtilFunctionsClass.convertDateToString(dob);
			
			if(dobAsString.equals("1360-10-10"))
			{
				displayDates.setYearDisplayIndex(0);
				displayDates.setMonthDisplayIndex(0);
				displayDates.setDayDisplayIndex(0);
			}
			
			else
			{
				displayDates.setDate(dobAsString);

				dobAsString = null;
			}
		}
		else
		{
			displayDates.setYearDisplayIndex(0);
			displayDates.setMonthDisplayIndex(0);
			displayDates.setDayDisplayIndex(0);
		}

		dob = null;

		String married = this.applicant.getMarried();
		if (married != null) {
			if (married.equals("Y")) {
				marriedCB.setSelectedIndex(1);
				String spouse_nid = this.applicant.getSpouseDetails().getSpouse_nid();
				if (spouse_nid == null) {
					spouse_nid = "";
				}
				spouseNICCardNoTF.setText(spouse_nid);

				String spouse_name = this.applicant.getSpouseDetails().getSpouse_name();
				if (spouse_name == null) {
					spouse_name = "";
				}
				spouseNameTF.setText(spouse_name);

				String passport_num = this.applicant.getSpouseDetails().getSpouse_passport_num();
				if (passport_num == null) {
					passport_num = "";
				}
				spousePassportNumTF.setText(passport_num);

				String spouse_occupation = this.applicant.getSpouseDetails().getSpouse_occupation();
				if (spouse_occupation == null) {
					spouse_occupation = "";
				}

				spouseOccupationTF.setText(spouse_occupation);
			}

			else if (married.equals("N")) {
				marriedCB.setSelectedIndex(2);
			}
		}

		married = null;

		double monthlyIncome = this.applicant.getMonthlyIncome();

		if (monthlyIncome == 0) {
			monthlyIncomeTF.setText("");
		} else {
			monthlyIncomeTF.setText(monthlyIncome + "");
		}

	}

	private class CustomKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {}

		@Override
		public void keyPressed(KeyEvent e) {

			JTextField targetTextField = (JTextField) e.getSource();

			if (e.getSource() == monthlyIncomeTF) {

				if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || (e.getKeyCode() == 8)
						|| (e.getKeyChar() == '.')) {
					targetTextField.setEditable(true);
				}

				else {
					targetTextField.setEditable(false);
					JOptionPane.showMessageDialog(getParent(), "This field requires numeric input only",
							"Numeric input only", JOptionPane.ERROR_MESSAGE);
					targetTextField.setEditable(true);
				}

			}

		}

		@Override
		public void keyReleased(KeyEvent e) {}

	}

	private class ComboBoxHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent event) {
			if (event.getSource() == marriedCB && event.getStateChange() == ItemEvent.SELECTED) {
				if (marriedCB.getSelectedIndex() == 1) {
					panelSpouseDetails.setVisible(true);
				}

				else {
					panelSpouseDetails.setVisible(false);
					spouseNICCardNoTF.setText("");
					spouseNameTF.setText("");
					spousePassportNumTF.setText("");
					spouseOccupationTF.setText("");
				}
			}
			
			if(event.getSource() == dobYearCB && event.getStateChange() == ItemEvent.SELECTED)
			{
				if(dobYearCB.getSelectedIndex() != 0)
				{
					int yearSelected = Integer.parseInt((String) dobYearCB.getSelectedItem());
					int currentYear = Calendar.getInstance().get(Calendar.YEAR);
					int age = currentYear - yearSelected;
					
					if(age <= 18)
					{
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								dobYearCB.setBorder(new LineBorder(Color.RED));
								JOptionPane.showMessageDialog(null, "You must be above 18 years to be eligible",
										"You must be above 18 years to be eligible", JOptionPane.ERROR_MESSAGE);
								dobYearCB.setSelectedIndex(0);
							}
						});
					}
					
					else if(age == 60)
					{
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								dobYearCB.setBorder(new LineBorder(Color.RED));
								JOptionPane.showMessageDialog(null, "You are 60 years old and eligible for basic retirement pension.\nThis scheme is not applicable for you.",
										"This scheme is not applicable for you.", JOptionPane.ERROR_MESSAGE);
								dobYearCB.setSelectedIndex(0);
							}
						});
					}
					
					else if(age > 60)
					{
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								dobYearCB.setBorder(new LineBorder(Color.RED));
								JOptionPane.showMessageDialog(null, "You are above 60 years old and eligible for basic retirement pension.\nThis scheme is not applicable for you.",
										"This scheme is not applicable for you.", JOptionPane.ERROR_MESSAGE);
								dobYearCB.setSelectedIndex(0);
							}
						});
					}
					
					else
					{
						displayDates.setCalendarYear(yearSelected);
						dobMonthCB.setSelectedIndex(0);
						displayDates.generateDays();
					}
				}
			}
			
		}

	}
	
	private void getApplicantValues()
	{
		String surname = surnameTF.getText().trim();

		if (surname.isBlank()) {
			surname = "";
		}

		String otherNames = otherNamesTF.getText().trim();

		if (otherNames.isBlank()) {
			otherNames = "";
		}
		
		String dobText = "";
		if(dobYearCB.getSelectedIndex() == 0)
		{
			dobText += "1360";
		}
		else
		{
			dobText += dobYearCB.getSelectedItem();
		}
		
		if(dobMonthCB.getSelectedIndex() == 0)
		{
			dobText = dobText + "-10";
		}
		else
		{
			if(dobMonthCB.getSelectedIndex() < 10)
			{
				dobText = dobText + "-0" + dobMonthCB.getSelectedIndex();
			}
			
			else
			{
				dobText = dobText + "-" + dobMonthCB.getSelectedIndex();
			}
		}
		
		if(dobDayCB.getSelectedIndex() == 0)
		{
			dobText = dobText + "-10";
		}
		else
		{
			dobText = dobText + "-" + dobDayCB.getSelectedItem();
		}
		
		java.sql.Date dobDate = null;
		if(dobText != "")
		{
			dobDate = java.sql.Date.valueOf(dobText);
		}
		
		double monthlyIncome = 0.00;

		if (!monthlyIncomeTF.getText().trim().isBlank()) {
			monthlyIncome = Double.parseDouble((String) monthlyIncomeTF.getText());
		}

		applicant.setSurname(surname);
		applicant.setOtherNames(otherNames);
		applicant.setDateOfBirth(dobDate);
		applicant.setMonthlyIncome(monthlyIncome);

		surname = null;
		otherNames = null;
		dobDate = null;
		dobText = null;

		int marriedIndex = marriedCB.getSelectedIndex();

		if (marriedIndex == 0) {

			applicant.setMarried("");
			applicant.setSpouseDetails(new SpouseDetails("", "", "", ""));

		}

		else if (marriedIndex == 1) {

			String spouseNIC = spouseNICCardNoTF.getText().trim();

			if (spouseNIC.isBlank()) {
				spouseNIC = "";
			}

			String spouseName = spouseNameTF.getText().trim();

			if (spouseName.isBlank()) {
				spouseName = "";
			}

			String spousePassportNum = spousePassportNumTF.getText().trim();

			if (spousePassportNum.isBlank()) {
				spousePassportNum = "";
			}

			String spouseOccupation = spouseOccupationTF.getText().trim();

			if (spouseOccupation.isBlank()) {
				spouseOccupation = "";
			}

			applicant.setMarried("Y");
			applicant.setSpouseDetails(
					new SpouseDetails(spouseNIC, spouseName, spousePassportNum, spouseOccupation));

			spouseNIC = null;
			spouseName = null;
			spousePassportNum = null;
			spouseOccupation = null;

		}

		else if (marriedIndex == 2) {
			applicant.setMarried("N");
			applicant.setSpouseDetails(new SpouseDetails("", "", "", ""));

		}
	}

	private class ButtonHandler implements ActionListener {

		EnterPersonalDetailsFrame enterPersonalDetailsFrame;

		public ButtonHandler(EnterPersonalDetailsFrame enterPersonalDetailsFrame) {
			this.enterPersonalDetailsFrame = enterPersonalDetailsFrame;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			
			getApplicantValues();

			if (event.getSource() == nextBtn) 
			{
				UtilFunctionsClass.loadEnterAddressDetailsScreen(applicant, this.enterPersonalDetailsFrame);
			}
			
			if(event.getSource() == saveFormBtn)
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
		
		EnterPersonalDetailsFrame enterPersonalDetailsFrame;
		
		public PanelMouseListener(EnterPersonalDetailsFrame enterPersonalDetailsFrame)
		{
			this.enterPersonalDetailsFrame = enterPersonalDetailsFrame;
		}

		@Override
		public void mouseClicked(MouseEvent event) 
		{
			getApplicantValues();
			
			String panelName = ((JPanel) event.getSource()).getName();
			
			if(panelName.equals("panelStep2"))
			{
				UtilFunctionsClass.loadEnterAddressDetailsScreen(applicant, this.enterPersonalDetailsFrame);
			}
			
			else if(panelName.equals("panelStep3"))
			{
				UtilFunctionsClass.loadEnterBusinessDetailsScreen(applicant, this.enterPersonalDetailsFrame);
			}
			
			else if(panelName.equals("panelStep4"))
			{
				UtilFunctionsClass.loadEnterContactDetailsScreen(applicant, this.enterPersonalDetailsFrame);
			}
			
			else if(panelName.equals("panelLogout"))
			{
				int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout? Be sure to save the information provided before logging out. Else all information provided will be lost", "Are you sure you want to logout?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(response == JOptionPane.YES_OPTION)
				{
					applicant = null;
					UtilFunctionsClass.loadLoginScreen(this.enterPersonalDetailsFrame);
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
			
			JPanel targetPanel = (JPanel) event.getSource();
			
			if(panelName.equals("panelStep2"))
			{
				targetPanel.setBackground(Colours.SIDE_NAVIGATION_HOVER_COLOUR);
			}
			
			else if(panelName.equals("panelStep3"))
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
			
			JPanel targetPanel = (JPanel) event.getSource();
			
			if(panelName.equals("panelStep2"))
			{
				targetPanel.setBackground(Color.decode(Colours.SIDE_NAVIGATION_BACKGROUND_COLOUR));
			}
			
			else if(panelName.equals("panelStep3"))
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
