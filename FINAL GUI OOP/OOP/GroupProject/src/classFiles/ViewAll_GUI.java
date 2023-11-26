package classFiles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewAll_GUI extends DepartmentRates  {
	

	private JLabel veiwAlMessage;
	private JFrame frame;
	private JButton button;
	private int labelCount = 0;
	private int y = 80; 

		
	public ViewAll_GUI() {
		frame = new JFrame("Get All Records");
		
		int x = 50;
		
		
		frame.setSize(800,800);
		frame.setPreferredSize(new Dimension(800, 800));		 
		frame.setVisible(true);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
		frame.getContentPane().setLayout(null); // Set the layout of the content pane
		
		button = new JButton("add label");
		button.setBounds(50,50,190,20);
		frame.getContentPane().add(button);
		
        JPanel panel = new JPanel();
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Scanner scannerRead = null;
				try {
					scannerRead = new Scanner(file);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        String fileLine = "";
		        
		        JLabel label = new JLabel(scannerRead.nextLine());
				label.setBounds(100,y,400,20);
				panel.add(label);	
				 y += 30;
				 
	            frame.getContentPane().add(label);
	            
	         // Refresh the frame to reflect changes
               frame.revalidate();
               frame.repaint();

		        while (scannerRead.hasNextLine()) {
		            fileLine = scannerRead.nextLine();
		            
		            JLabel recordlabel = new JLabel(scannerRead.nextLine());
		            recordlabel.setBounds(100,y,400,20);
					panel.add(recordlabel);
					
					 y += 30;
					 labelCount += 1;			
					 
		            frame.getContentPane().add(recordlabel);
		            
		         // Refresh the frame to reflect changes
	                frame.revalidate();
	                frame.repaint();   
		        }

		        scannerRead.close();
				/*JLabel label = new JLabel("Label"+ labelCount);
				label.setBounds(100,y,190,20);
				panel.add(label);
				
				 y += 30;
				 labelCount += 1;			
				 
	            frame.getContentPane().add(label);
	            
	         // Refresh the frame to reflect changes
                frame.revalidate();
                frame.repaint();*/

			}
				
		});

		
		/*
		veiwAlMessage = new JLabel("Below are all the records currently on file");
		 veiwAlMessage.setBounds(50,50,190,20);
		frame.getContentPane().add(veiwAlMessage);
		*/
	
	}
}

