package com.example.mra_seas;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.*;


public class DisplayDates implements ItemListener {

	private JComboBox<String> dayDisplay;
	private JComboBox<String> monthDisplay;
	private JComboBox<String> yearDisplay;
	private JPanel datePanel;
	private Calendar date = null;
	private final String[] MONTHS = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
			"Dec" };

	public DisplayDates() {
		datePanel = new JPanel();
		date = Calendar.getInstance();
		yearDisplay = new JComboBox<String>();
		generateYears();
		yearDisplay.setSelectedIndex(0);
		monthDisplay = new JComboBox<String>();
		generateMonths();
		monthDisplay.setSelectedIndex(0);
		dayDisplay = new JComboBox<String>();
		generateDays();
		dayDisplay.setSelectedIndex(0);
		yearDisplay.addItemListener(this);
		monthDisplay.addItemListener(this);
		dayDisplay.addItemListener(this);
		datePanel.add(yearDisplay);
		datePanel.add(monthDisplay);
		datePanel.add(dayDisplay);
	}

	private void generateYears() {
		int currentYear = date.get(Calendar.YEAR);

		this.yearDisplay.addItem("Year");

		for (int counter = currentYear; counter >= currentYear - 70; counter--) 
		{
			this.yearDisplay.addItem(Integer.toString(counter));
		}
	}

	private void generateMonths() {
		this.monthDisplay.removeAllItems();

		this.monthDisplay.addItem("Month");

		for (int counter = 0; counter < 12; counter++) {
			this.monthDisplay.addItem(this.MONTHS[counter]);
		}
	}

	public void generateDays()
	{
		this.dayDisplay.removeAllItems();
		
		this.dayDisplay.addItem("Day");
		
		int lastDay = 31;
		
		if(yearDisplay.getSelectedIndex() != 0)
		{
			int yearSelected = Integer.parseInt((String) yearDisplay.getSelectedItem());
			
			int monthSelectedIndex = monthDisplay.getSelectedIndex();
			
			if(monthSelectedIndex != 0)
			{
				if(monthSelectedIndex == 2)
				{
					if(yearSelected % 4 == 0)
					{
						lastDay = 29;
					}
					
					else
					{
						lastDay = 28;
					}
				}
				
				else
				{
					if(monthSelectedIndex == 1 || monthSelectedIndex == 3 || monthSelectedIndex == 5 || monthSelectedIndex == 7 
					  || monthSelectedIndex == 8 || monthSelectedIndex == 10 || monthSelectedIndex == 12)
					{
						lastDay = 31;
					}
					
					else
					{
						lastDay = 30;
					}
				}
				
			}
		}
		
		for(int counter = 1; counter <= lastDay; counter++)
		{
			String day = "";
			if(counter < 10)
			{
				day = "0" + counter;
			}
			else
			{
				day = Integer.toString(counter);
			}
			
			this.dayDisplay.addItem(day);
		} 
	}

	public JPanel getDatePanel() {
		return this.datePanel;
	}
	
	public void setDate(String newDate)
	{
		String newYear = newDate.substring(0, 4);
		String newMonth = newDate.substring(5, 7);
		String newDay = newDate.substring(8, 10);
		
		for(int index = 0; index < this.yearDisplay.getItemCount(); index++)
		{
			String itemAtIndex = this.yearDisplay.getItemAt(index);
			
			if(itemAtIndex.equals(newYear))
			{
				this.yearDisplay.setSelectedIndex(index);
				int yearSelected = Integer.parseInt((String) yearDisplay.getSelectedItem());
				this.date.set(Calendar.YEAR, yearSelected);
				generateDays();
				break;
			}
		}
		
		switch(newMonth)
		{
		case "01":
			this.monthDisplay.setSelectedIndex(1);
			this.date.set(Calendar.MONTH, monthDisplay.getSelectedIndex() - 1);
			generateDays();
			break;
			
		case "02":
			this.monthDisplay.setSelectedIndex(2);
			this.date.set(Calendar.MONTH, monthDisplay.getSelectedIndex() - 1);
			generateDays();
			break;
			
		case "03":
			this.monthDisplay.setSelectedIndex(3);
			this.date.set(Calendar.MONTH, monthDisplay.getSelectedIndex() - 1);
			generateDays();
			break;
			
		case "04":
			this.monthDisplay.setSelectedIndex(4);
			this.date.set(Calendar.MONTH, monthDisplay.getSelectedIndex() - 1);
			generateDays();
			break;
			
		case "05":
			this.monthDisplay.setSelectedIndex(5);
			this.date.set(Calendar.MONTH, monthDisplay.getSelectedIndex() - 1);
			generateDays();
			break;
			
		case "06":
			this.monthDisplay.setSelectedIndex(6);
			this.date.set(Calendar.MONTH, monthDisplay.getSelectedIndex() - 1);
			generateDays();
			break;
			
		case "07":
			this.monthDisplay.setSelectedIndex(7);
			this.date.set(Calendar.MONTH, monthDisplay.getSelectedIndex() - 1);
			generateDays();
			break;
			
		case "08":
			this.monthDisplay.setSelectedIndex(8);
			this.date.set(Calendar.MONTH, monthDisplay.getSelectedIndex() - 1);
			generateDays();
			break;
			
		case "09":
			this.monthDisplay.setSelectedIndex(9);
			this.date.set(Calendar.MONTH, monthDisplay.getSelectedIndex() - 1);
			generateDays();
			break;
			
		case "10":
			this.monthDisplay.setSelectedIndex(10);
			this.date.set(Calendar.MONTH, monthDisplay.getSelectedIndex() - 1);
			generateDays();
			break;
			
		case "11":
			this.monthDisplay.setSelectedIndex(11);
			this.date.set(Calendar.MONTH, monthDisplay.getSelectedIndex() - 1);
			generateDays();
			break;
			
		case "12":
			this.monthDisplay.setSelectedIndex(12);
			this.date.set(Calendar.MONTH, monthDisplay.getSelectedIndex() - 1);
			generateDays();
			break;
		}
		
		for(int index = 0; index < this.dayDisplay.getItemCount(); index++)
		{
			String itemAtIndex = this.dayDisplay.getItemAt(index);
			if(itemAtIndex.equals(newDay))
			{
				this.dayDisplay.setSelectedIndex(index);
				int day = Integer.parseInt((String) dayDisplay.getSelectedItem());
				this.date.set(Calendar.DATE, day);
			}
		}
	}
	
	
	public void setYearDisplayIndex(int index)
	{
		this.yearDisplay.setSelectedIndex(index);
	}
	
	public int getYearDisplayIndex()
	{
		return this.yearDisplay.getSelectedIndex();
	}
	
	public String getYearValue()
	{
		return (String) this.yearDisplay.getSelectedItem();
	}
	
	public JComboBox<String> getYearDisplayComboBox()
	{
		return this.yearDisplay;
	}
	
	
	public void setMonthDisplayIndex(int index)
	{
		this.monthDisplay.setSelectedIndex(index);
	}
	
	public int getMonthDisplayIndex()
	{
		return this.monthDisplay.getSelectedIndex();
	}
	
	public String getMonthValue()
	{
		return (String) this.monthDisplay.getSelectedItem();
	}
	
	public JComboBox<String> getMonthDisplayComboBox()
	{
		return this.monthDisplay;
	}
	
	public void setDayDisplayIndex(int index)
	{
		this.dayDisplay.setSelectedIndex(index);
	}
	
	public int getDayDisplayIndex()
	{
		return this.dayDisplay.getSelectedIndex();
	}
	
	public String getDayValue()
	{
		return (String) this.dayDisplay.getSelectedItem();
	}
	
	public JComboBox<String> getDayDisplayComboBox()
	{
		return this.dayDisplay;
	}
	
	public void setCalendarYear(int year)
	{
		this.date.set(Calendar.YEAR, year);
	}
	
	public void setCalendarMonth(int monthIndex)
	{
		this.date.set(Calendar.MONTH, monthIndex - 1);
	}
	
	public void setCalendarDay(int day)
	{
		this.date.set(Calendar.DATE, day);
	}

	@Override
	public void itemStateChanged(ItemEvent event) 
	{

		if (event.getSource() == yearDisplay && event.getStateChange() == ItemEvent.SELECTED) 
		{
			if (yearDisplay.getSelectedIndex() != 0) 
			{
				int yearSelected = Integer.parseInt((String) yearDisplay.getSelectedItem());
				this.date.set(Calendar.YEAR, yearSelected);
				monthDisplay.setSelectedIndex(0);
				generateDays();
			}
		}

		else if (event.getSource() == monthDisplay && event.getStateChange() == ItemEvent.SELECTED) 
		{
			if (monthDisplay.getSelectedIndex() != 0) 
			{
				this.date.set(Calendar.MONTH, monthDisplay.getSelectedIndex() - 1);
				generateDays();
			}
		}

		else if (event.getSource() == dayDisplay && event.getStateChange() == ItemEvent.SELECTED) 
		{
			if (dayDisplay.getSelectedIndex() != 0) 
			{
				int day = Integer.parseInt((String) dayDisplay.getSelectedItem());
				this.date.set(Calendar.DATE, day);
			}
		}

	}

}
