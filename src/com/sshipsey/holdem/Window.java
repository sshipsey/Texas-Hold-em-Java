package com.sshipsey.holdem;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;

public class Window {

	public Window()
	{
		JFrame frame = new JFrame("Texas Hold 'Em");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	    frame.setResizable(false);
	    frame.setSize(1000,500);
	    frame.getContentPane().setBackground(Color.LIGHT_GRAY);
	    frame.setVisible(true);
	}
}
