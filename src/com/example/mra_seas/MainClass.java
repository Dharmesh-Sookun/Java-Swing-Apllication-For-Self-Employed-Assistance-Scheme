package com.example.mra_seas;

import javax.swing.*;

public class MainClass {

	public static void main(String[] args) {
		
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setResizable(true);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		loginFrame.setVisible(true);

	}

}
