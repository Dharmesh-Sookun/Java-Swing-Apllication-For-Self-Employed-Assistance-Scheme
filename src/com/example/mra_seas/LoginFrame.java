package com.example.mra_seas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class LoginFrame extends CustomFrame {

	private JLabel titlelbl, eligibiltyConditionslbl, enterNIDlbl;
	private JTextField enterNIDTextField;
	private JButton loginBtn;

	public LoginFrame() {
		super("Login form");
		createGUI();
	}

	@Override
	public void createGUI() {

		setLayout(new GridLayout(1, 1));
		titlelbl = new JLabel("Application form for self-employed assistance scheme in the context of covid-19");
		titlelbl.setFont(Fonts.TITLE_FONT);
		enterNIDlbl = new JLabel("Enter your national identity card number: *");
		enterNIDlbl.setFont(Fonts.NORMAL_TEXT_FONT);
		
		eligibiltyConditionslbl = new JLabel("<html>"
												+ "<p>You are <b>NOT</b> eligible for this scheme if:</p>"
												 + "<ol>"
												 +    "<li>You are an employee, whether part-time or full-time</li>"
												 +    "<li>You are eligible for basic retirement pension</li>"
												 +    "<li>You receive social monthly benefits</li>"
												 +    "<li>You are pursuing higher studies on a full time basis</li>"
												 +    "<li>You are a dependent spouse</li>"
												 +    "<li>You were unemployed at the beginning of March 2020</li>"
												 +    "<li>You receive a total monthly income exceeding Rs 50, 000</li>"
												 +    "<li>You are in a passive income business</li>"
												 +    "<li>You are a fisherman</li>"
												 + "</ol>"
												 + "<p>Eligible self-employed individuals and tradespersons will receive a financial support of Rs 5,100.</p>"
												 + "<p>All payments will be credited to the applicant’s bank account.</p>"
										   + "</html>");
		
		eligibiltyConditionslbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		eligibiltyConditionslbl.setFont(Fonts.NORMAL_TEXT_FONT);

		titlelbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		enterNIDlbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		
		enterNIDTextField = new JTextField();
		
		loginBtn = new JButton("Login");
		loginBtn.setBackground(Color.decode(Colours.LOGIN_BUTTON_BACKGROUND));
		loginBtn.setForeground(Color.decode(Colours.PRIMARY_BUTTON_TEXT));
		loginBtn.setFont(Fonts.BUTTON_TEXT_FONT);

		JPanel panelTitle = new JPanel();
		panelTitle.add(titlelbl, JLabel.CENTER);
		panelTitle.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));

		JPanel panelBtn = new JPanel();
		panelBtn.add(loginBtn, JButton.CENTER);
		panelBtn.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		JPanel panelEligibiltyConditions = new JPanel();
		panelEligibiltyConditions.add(eligibiltyConditionslbl, JLabel.CENTER);
		
		TitledBorder panelEligibiltyConditionsBorder = BorderFactory.createTitledBorder("Eligibilty Conditions");
		panelEligibiltyConditionsBorder.setBorder(new LineBorder(Color.decode(Colours.PRIMARY_BORDER_COLOUR), 3, true));
		panelEligibiltyConditionsBorder.setTitleJustification(TitledBorder.CENTER);
		panelEligibiltyConditionsBorder.setTitleColor(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		panelEligibiltyConditionsBorder.setTitleFont(Fonts.NORMAL_TEXT_FONT);
		panelEligibiltyConditions.setBorder(panelEligibiltyConditionsBorder);
		
		panelEligibiltyConditions.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));

		JPanel panelInputFields = new JPanel(new GridLayout(1, 4, 10, 15));
		panelInputFields.add(new Container());
		panelInputFields.add(enterNIDlbl);
		panelInputFields.add(enterNIDTextField);
		panelInputFields.add(new Container());
		panelInputFields.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));

		JPanel panelInputFieldsContainer = new JPanel(new BorderLayout(10, 65));
		panelInputFieldsContainer.add(panelEligibiltyConditions, BorderLayout.NORTH);
		panelInputFieldsContainer.add(new Container(), BorderLayout.EAST);
		panelInputFieldsContainer.add(panelInputFields, BorderLayout.CENTER);
		panelInputFieldsContainer.add(new Container(), BorderLayout.WEST);
		panelInputFieldsContainer.add(panelBtn, BorderLayout.SOUTH);
		panelInputFieldsContainer.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));

		JPanel panelMain = new JPanel(new BorderLayout(100, 85));
		panelMain.add(panelTitle, BorderLayout.NORTH);
		panelMain.add(panelInputFieldsContainer, BorderLayout.CENTER);
		panelMain.add(new Container(), BorderLayout.WEST);
		panelMain.add(new Container(), BorderLayout.EAST);
		panelMain.add(new Container(), BorderLayout.SOUTH);
		panelMain.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));

		ButtonHandler buttonHandler = new ButtonHandler(this);

		loginBtn.addActionListener(buttonHandler);

		JScrollPane scrollView = new JScrollPane(panelMain);

		add(scrollView);

	}

	private class ButtonHandler implements ActionListener {

		LoginFrame loginFrame;

		public ButtonHandler(LoginFrame loginFrame) {
			this.loginFrame = loginFrame;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == loginBtn) 
			{
				String nid_entered = enterNIDTextField.getText();
				
				if(UtilFunctionsClass.isNICValid(nid_entered))
				{
					ApplicantDaoImplementation applicantDao = new ApplicantDaoImplementation();
					
					ApplicantDetails applicant = null;
					
					try 
					{
						if(applicantDao.doesApplicantExist(nid_entered))
						{
							String appliedStatus = applicantDao.getAppliedStatus(nid_entered);
							if(appliedStatus.equals("Y"))
							{
								JOptionPane.showMessageDialog(getParent(), "You already have applied for this scheme. You cannot apply twice.",
										"Already applied", JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								applicant = applicantDao.getApplicantDetails(nid_entered);
								EnterPersonalDetailsFrame enterPersonalDetailsFrame = new EnterPersonalDetailsFrame(applicant);
								enterPersonalDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								enterPersonalDetailsFrame.setResizable(true);
								enterPersonalDetailsFrame.setLocationRelativeTo(null);
								enterPersonalDetailsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
								enterPersonalDetailsFrame.setVisible(true);
								this.loginFrame.setVisible(false);
							}
						}
						else
						{
							applicant = new ApplicantDetails(nid_entered);
							EnterPersonalDetailsFrame enterPersonalDetailsFrame = new EnterPersonalDetailsFrame(applicant);
							enterPersonalDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							enterPersonalDetailsFrame.setResizable(true);
							enterPersonalDetailsFrame.setLocationRelativeTo(null);
							enterPersonalDetailsFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
							enterPersonalDetailsFrame.setVisible(true);
							this.loginFrame.setVisible(false);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					//System.out.println(applicant.toString());
					
				/*	try
					{
						applicant = applicantDao.getApplicantDetails(nid_entered);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					if(applicant == null)
					{
						applicant = new ApplicantDetails(nid_entered);
					} */
					 
				}

			}
		}

	}

}
