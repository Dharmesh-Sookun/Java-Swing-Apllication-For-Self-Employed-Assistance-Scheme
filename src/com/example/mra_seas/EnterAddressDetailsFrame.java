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
public class EnterAddressDetailsFrame extends CustomFrame {

	private ApplicantDetails applicant = null;

	private JLabel titlelbl, steplbl, houseNumlbl, streetlbl, localitylbl, mauritiusPostalRegionlbl, villageTownlbl,
			postalCodelbl, step1lbl, step2lbl, step3lbl, step4lbl, logoutlbl;

	private JTextField houseNumTF, streetTF, localityTF, villageTownTF, postalCodeTF;

	private JComboBox<String> mauritiusPostalRegionCB;

	private JButton prevBtn, saveFormBtn, nextBtn;

	public EnterAddressDetailsFrame(ApplicantDetails applicant) {
		super("Enter address details");
		this.applicant = applicant;
		createGUI();
	}

	@Override
	public void createGUI() {
		
		titlelbl = new JLabel("Application form for self-employed assistance scheme in the context of covid-19");
		steplbl = new JLabel("Step 2 of 4 - Address Details");
		houseNumlbl = new JLabel("Enter your house number: *");
		streetlbl = new JLabel("Enter your street: *");
		localitylbl = new JLabel("Enter your locality: *");
		mauritiusPostalRegionlbl = new JLabel("Select your postal region: *");
		villageTownlbl = new JLabel("Enter your village or town: *");
		postalCodelbl = new JLabel("Enter your postal code: *");
		step1lbl = new JLabel("Step 1: Personal Details");
		step2lbl = new JLabel("Step 2: Address Details");
		step3lbl = new JLabel("Step 3: Business and Bank details");
		step4lbl = new JLabel("Step 4: Contact details");
		logoutlbl = new JLabel("Logout");
		
		titlelbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		steplbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		houseNumlbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		streetlbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		localitylbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		mauritiusPostalRegionlbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		villageTownlbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		postalCodelbl.setForeground(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		
		titlelbl.setFont(Fonts.TITLE_FONT);
		steplbl.setFont(Fonts.MAIN_HEADING_FONT);
		houseNumlbl.setFont(Fonts.NORMAL_TEXT_FONT);
		streetlbl.setFont(Fonts.NORMAL_TEXT_FONT);
		localitylbl.setFont(Fonts.NORMAL_TEXT_FONT);
		mauritiusPostalRegionlbl.setFont(Fonts.NORMAL_TEXT_FONT);
		villageTownlbl.setFont(Fonts.NORMAL_TEXT_FONT);
		postalCodelbl.setFont(Fonts.NORMAL_TEXT_FONT);
		
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

		houseNumTF = new JTextField();
		streetTF = new JTextField();
		localityTF = new JTextField();
		villageTownTF = new JTextField();
		postalCodeTF = new JTextField();

		mauritiusPostalRegionCB = new JComboBox<String>();

		prevBtn = new JButton("Previous");
		saveFormBtn = new JButton("Save form");
		nextBtn = new JButton("Next");
		
		prevBtn.setBackground(Color.decode(Colours.PREV_BUTTON_BACKGROUND));
		prevBtn.setForeground(Color.decode(Colours.PRIMARY_BUTTON_TEXT));
		prevBtn.setFont(Fonts.BUTTON_TEXT_FONT);
		
		saveFormBtn.setBackground(Color.decode(Colours.SAVE_BUTTON_BACKGROUND));
		saveFormBtn.setForeground(Color.decode(Colours.PRIMARY_BUTTON_TEXT));
		saveFormBtn.setFont(Fonts.BUTTON_TEXT_FONT);
		
		nextBtn.setBackground(Color.decode(Colours.NEXT_BUTTON_BACKGROUND));
		nextBtn.setForeground(Color.decode(Colours.PRIMARY_BUTTON_TEXT));
		nextBtn.setFont(Fonts.BUTTON_TEXT_FONT);

		final String POSTAL_REGIONS[] = { "Please select", "Agalega", "Albion", "Amaury", "Amitie Gokhoola", "Arsenal",
				"Baie Du Cap", "Baie Du Tombeau", "Bambous", "Bambous Virieux", "Bananes", "Beau Bassin", "Beau Vallon",
				"Bel Air", "Bel Ombre", "Belle Vue Maurel", "Benares", "Bois Cheri", "Bois Des Amourettes",
				"Bon Accueil", "Bramsthan", "Brisee Verdire", "Britannia", "Calebasses", "Camp Carol", "Camp De Masque",
				"Camp De Masque Pave", "Camp Diable", "Camp Ithier", "Camp Thorel", "Cap Malheureux", "Cascavelle",
				"Case Noyale", "Centre De Flacq", "Chamarel", "Chamouny", "Chemin Grenier", "Clemencia", "Cluny",
				"Congomah", "Cottage", "Creve Coeur", "Curepipe", "Dagotiere", "D'epinay", "Dubreuil", "Eau Coullee",
				"Ebene", "Escroignard", "Esperance", "Esperance Trebuchet", "Flic En Flac", "Forest Side",
				"Fond Du Sac", "Goodlands", "Grand Baie", "Grand Bel Air", "Grand Bois", "Grand Gaubre",
				"Grande Retraitre", "Grand River South East", "Grand Sable", "Grand River North West", "Gros Cailloux",
				"La Flora", "La Gaulette", "La Laura", "Lallmatie", "L'avenir", "Laventure", "Le Hochet", "Le Morne",
				"L'escalier", "Long Mountain", "Mahebourg", "Mapou", "Mare Chicose", "Mare D'albert", "Mare La Chaux",
				"Mare Tabac", "Medine Camp de Masque", "Melrose", "Midlands", "Moka", "Montagne Blanche",
				"Morcellement St Andre", "New Grove", "Notre Dame", "Nouvelle France", "Old Grand Port", "Olivia",
				"Overseas", "Pailles", "Pamplemousses", "Petit Bel Air", "Petit Raffray", "Petite Riviere", "Phoenix",
				"Piton", "Plaine Des Papayes", "Plaine Magnien", "PLaine Des Roches", "Pointe Aux Piments",
				"Port Louis", "Point Aux Sables", "Poste De Flacq", "Poudre D'Or Village", "Poudre D'Or Hamlet",
				"Providence", "Quartier Millitaire", "Quatres Bornes", "Quatre Cocos", "Quatre Soeurs",
				"Queen Victoria", "Richelieu", "Ripailles", "Riviere Des Anguille", "Riviere Des Creoles",
				"Riviere Du Poste", "Riviere Du Rempart", "Roche Terre", "Roches Noires", "Rodrigues", "Rose Belle",
				"Rose Hill", "Sebastopol", "Souillac", "Union Ducray / St Aubin", "St Hubert", "Saint Julien Village",
				"St Julien D'hotman", "St Pierre", "Surinam", "Tamarin", "Terre Rouge", "Tyack", "The Vale", "Triolet",
				"Trois Boutiques", "Trou Aux Biches", "Trou D'eau Douce", "Union Park", "Vacoas / Floreal", "Verdun",
				"Ville Bague", "16eme Mille" };
		
		for(int index = 0; index < POSTAL_REGIONS.length; index++)
		{
			mauritiusPostalRegionCB.addItem(POSTAL_REGIONS[index]);
		}
		
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
		panelBtns.add(saveFormBtn, JButton.CENTER);
		panelBtns.add(prevBtn, JButton.CENTER);
		panelBtns.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		JPanel panelAddressDetails = new JPanel(new GridLayout(3, 5, 2, 70));
		panelAddressDetails.add(houseNumlbl);
		panelAddressDetails.add(houseNumTF);
		panelAddressDetails.add(new Container());
		panelAddressDetails.add(streetlbl);
		panelAddressDetails.add(streetTF);
		
		panelAddressDetails.add(localitylbl);
		panelAddressDetails.add(localityTF);
		panelAddressDetails.add(new Container());
		panelAddressDetails.add(mauritiusPostalRegionlbl);
		panelAddressDetails.add(mauritiusPostalRegionCB);
		
		panelAddressDetails.add(villageTownlbl);
		panelAddressDetails.add(villageTownTF);
		panelAddressDetails.add(new Container());
		panelAddressDetails.add(postalCodelbl);
		panelAddressDetails.add(postalCodeTF);
		
		panelAddressDetails.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		TitledBorder panelAddressDetailsBorder = BorderFactory.createTitledBorder("Address Details");
		panelAddressDetailsBorder.setBorder(new LineBorder(Color.decode(Colours.PRIMARY_BORDER_COLOUR), 3, true));
		panelAddressDetailsBorder.setTitleJustification(TitledBorder.CENTER);
		panelAddressDetailsBorder.setTitleFont(Fonts.NORMAL_TEXT_FONT);
		panelAddressDetailsBorder.setTitleColor(Color.decode(Colours.PRIMARY_TEXT_COLOUR));
		
		panelAddressDetails.setBorder(panelAddressDetailsBorder);
		
		JPanel panelEmpty = new JPanel(new GridLayout(2, 5, 2, 50));
		panelEmpty.add(new Container());
		panelEmpty.add(new Container());
		panelEmpty.add(new Container());
		panelEmpty.add(new Container());
		panelEmpty.add(new Container());
		
		panelEmpty.add(new Container());
		panelEmpty.add(new Container());
		panelEmpty.add(new Container());
		panelEmpty.add(new Container());
		panelEmpty.add(new Container());
		
		panelEmpty.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		JPanel panelEmptyContainer = new JPanel(new BorderLayout(10, 10));
		panelEmptyContainer.add(new Container(), BorderLayout.NORTH);
		panelEmptyContainer.add(new Container(), BorderLayout.WEST);
		panelEmptyContainer.add(panelEmpty, BorderLayout.CENTER);
		panelEmptyContainer.add(new Container(), BorderLayout.EAST);
		panelEmptyContainer.add(new Container(), BorderLayout.SOUTH);
		
		panelEmptyContainer.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		JPanel panelMainContent = new JPanel(new GridLayout(2, 1, 10, 10));
		panelMainContent.add(panelAddressDetails);
		panelMainContent.add(panelEmptyContainer);
		
		panelMainContent.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		JPanel panelMain = new JPanel(new BorderLayout(100, 25));
		panelMain.add(panelHeadings, BorderLayout.NORTH);
		panelMain.add(new Container(), BorderLayout.WEST);
		panelMain.add(panelMainContent, BorderLayout.CENTER);
		panelMain.add(new Container(), BorderLayout.EAST);
		panelMain.add(panelBtns, BorderLayout.SOUTH);
		
		panelMain.setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
		
		ButtonHandler buttonHandler = new ButtonHandler(this);
		nextBtn.addActionListener(buttonHandler);
		prevBtn.addActionListener(buttonHandler);
		saveFormBtn.addActionListener(buttonHandler);
		
		JPanel panelStep1 = new JPanel(new GridBagLayout());
		panelStep1.setName("panelStep1");
		panelStep1.add(step1lbl);
		panelStep1.setBackground(Color.decode(Colours.SIDE_NAVIGATION_BACKGROUND_COLOUR));
		panelStep1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JPanel panelStep2 = new JPanel(new GridBagLayout());
		panelStep2.setName("panelStep2");
		panelStep2.add(step2lbl);
		panelStep2.setBackground(Colours.SIDE_NAVIGATION_SELECTED_COLOUR);
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
		panelStep3.addMouseListener(panelMouseListener);
		panelStep4.addMouseListener(panelMouseListener);
		panelLogout.addMouseListener(panelMouseListener);
		
		setApplicantValues();
		
		add(splitPane);
	}
	
	private void setApplicantValues()
	{
		String houseNum = this.applicant.getHouseNum();
		if(houseNum == null)
		{
			houseNum = "";
		}
		
		houseNumTF.setText(houseNum);
		houseNum = null;
		
		String street = this.applicant.getStreet();
		if(street == null)
		{
			street = "";
		}
		
		streetTF.setText(street);
		street = null;
		
		String locality = this.applicant.getLocality();
		if(locality == null)
		{
			locality = "";
		}
		
		localityTF.setText(locality);
		locality = null;
		
		String mauritiusPostalRegion = this.applicant.getMauritusPostalRegion();
		if(mauritiusPostalRegion == null)
		{
			mauritiusPostalRegionCB.setSelectedIndex(0);
			mauritiusPostalRegion = null;
		}
		else
		{
			for(int index = 0; index < mauritiusPostalRegionCB.getItemCount(); index++)
			{
				String selectedItem = mauritiusPostalRegionCB.getItemAt(index);
				
				if(selectedItem.equals(mauritiusPostalRegion))
				{
					mauritiusPostalRegionCB.setSelectedIndex(index);
					selectedItem = null;
					mauritiusPostalRegion = null;
					break;
				}
			}
		}
		
		String villageTown = this.applicant.getVillage_town();
		if(villageTown == null)
		{
			villageTown = "";
		}
		
		villageTownTF.setText(villageTown);
		villageTown = null;
		
		String postalCode = this.applicant.getPostalCode();
		if(postalCode == null)
		{
			postalCode = "";
		}
		
		postalCodeTF.setText(postalCode);
		postalCode = null;
	}
	
	private void getApplicantValues()
	{
		String houseNum = houseNumTF.getText().trim();
		if(houseNum == null)
		{
			houseNum = "";
		}
		
		String street = streetTF.getText().trim();
		if(street == null)
		{
			street = "";
		}
		
		String locality = localityTF.getText().trim();
		if(locality == null)
		{
			locality = "";
		}
		
		String mauritiusPostalRegion = null;
		
		if(mauritiusPostalRegionCB.getSelectedIndex() == 0)
		{
			mauritiusPostalRegion = "";
		}
		else
		{
			mauritiusPostalRegion = (String) mauritiusPostalRegionCB.getSelectedItem();
		}
		
		String villageTown = villageTownTF.getText().trim();
		if(villageTown == null)
		{
			villageTown = "";
		}
		
		String postalCode = postalCodeTF.getText().trim();
		if(postalCode == null)
		{
			postalCode = "";
		}
		
		applicant.setHouseNum(houseNum);
		applicant.setStreet(street);
		applicant.setLocality(locality);
		applicant.setMauritusPostalRegion(mauritiusPostalRegion);
		applicant.setVillage_town(villageTown);
		applicant.setPostalCode(postalCode);
		
		houseNum = null;
		street = null;
		locality = null;
		mauritiusPostalRegion = null;
		villageTown = null;
		postalCode = null;
	}
	
	private class ButtonHandler implements ActionListener
	{
		EnterAddressDetailsFrame enterAddressFrame;
		
		public ButtonHandler(EnterAddressDetailsFrame enterAddressFrame)
		{
			this.enterAddressFrame = enterAddressFrame;
		}

		@Override
		public void actionPerformed(ActionEvent event) 
		{
			getApplicantValues();
			
			if(event.getSource() == nextBtn)
			{
				UtilFunctionsClass.loadEnterBusinessDetailsScreen(applicant, this.enterAddressFrame);
			}
			
			if(event.getSource() == prevBtn)
			{
				UtilFunctionsClass.loadEnterPersonalDetailsScreen(applicant, this.enterAddressFrame);
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
		
		EnterAddressDetailsFrame enterAddressDetailsFrame;
		
		public PanelMouseListener(EnterAddressDetailsFrame enterAddressDetailsFrame)
		{
			this.enterAddressDetailsFrame = enterAddressDetailsFrame;
		}

		@Override
		public void mouseClicked(MouseEvent event) 
		{
			getApplicantValues();
			
			String panelName = ((JPanel) event.getSource()).getName();
			
			if(panelName.equals("panelStep1"))
			{
				UtilFunctionsClass.loadEnterPersonalDetailsScreen(applicant, this.enterAddressDetailsFrame);
			}
			
			else if(panelName.equals("panelStep3"))
			{
				UtilFunctionsClass.loadEnterBusinessDetailsScreen(applicant, this.enterAddressDetailsFrame);
			}
			
			else if(panelName.equals("panelStep4"))
			{
				UtilFunctionsClass.loadEnterContactDetailsScreen(applicant, this.enterAddressDetailsFrame);
			}
			
			else if(panelName.equals("panelLogout"))
			{
				int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout? Be sure to save the information provided before logging out. Else all information provided will be lost", "Are you sure you want to logout?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(response == JOptionPane.YES_OPTION)
				{
					applicant = null;
					UtilFunctionsClass.loadLoginScreen(this.enterAddressDetailsFrame);
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
			JPanel targetPanel = ((JPanel) event.getSource());
			
			if(panelName.equals("panelStep1"))
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
