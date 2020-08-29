package com.example.mra_seas;

import java.awt.Color;

import javax.swing.*;

@SuppressWarnings("serial")
public abstract class CustomFrame extends JFrame {
		
	public CustomFrame(String title) 
	{
		super(title);
		setBackground(Color.decode(Colours.PRIMARY_BACKGROUND_COLOUR));
	}
	
	public abstract void createGUI();

}
