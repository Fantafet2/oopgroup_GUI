package classFiles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.*;


public class UpdateSpecific_GUI {

	private JFrame frame;
	private JTextField searchCodeIn;
	private JLabel searchCodeLabel;
	
	private JButton submit;
	
	public UpdateSpecific_GUI() {
		
		JFrame frame = new JFrame("Update Specific");
		frame.setBounds(30,30,900,900);
	    frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		searchCodeIn = new JTextField();
		searchCodeLabel = new JLabel("Enter the code for the record you want to update");
		submit = new JButton("Submit");
		
		searchCodeIn.setBounds(370,50,80,20);
		searchCodeLabel.setBounds(50,50,290,20);
		submit.setBounds(50,80,80,20);
		
		frame.getContentPane().add(searchCodeIn);
		frame.getContentPane().add(searchCodeLabel);
		frame.getContentPane().add(submit);
		
		frame.getContentPane().setLayout(null); // Set the layout of the content pane
		
	}
}
