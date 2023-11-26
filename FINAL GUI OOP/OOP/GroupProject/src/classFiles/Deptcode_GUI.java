package classFiles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.*;

public class Deptcode_GUI extends DepartmentRates implements ActionListener{
	
	private JTextField deptCodeIn;
	private JLabel deptCodeframe;
	private JTextField deptNameIn;
	private JLabel deptNameframe;
	private JTextField regularRateIn;
	private JLabel regularRateframe;
	private JTextField overtimeRateIn;
	private JLabel overtimeRateframe;
	
	public JButton submitButton;
	
	private int intsetdeptcode;
	private int intdeptcode;
	private String deptNameIninput;
	private double dubRegularRateIn;
	private double dubOvertimeIn;
	
	
	public Deptcode_GUI(int deptCode, String deptName, double regularRate, double overtimeRate) {
		
		super(deptCode, deptName, regularRate, overtimeRate);
		
		JFrame frame = new JFrame("Department Rates");
		
		deptCodeIn = new JTextField();
		deptCodeframe = new JLabel("Enter the department code: ");
		
		deptNameIn = new JTextField();
		deptNameframe = new JLabel("Enter the department name: ");
		
		regularRateIn = new JTextField();
		regularRateframe = new JLabel("Enter the regular rate: ");

		overtimeRateIn = new JTextField();
		overtimeRateframe = new JLabel("Enter the overtime rate: ");

		submitButton = new JButton("Submit");
		
	    frame.setBounds(30,30,900,900);
	    frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // This method will be called when the window is closing
                try {
					performActionBeforeExit();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
		
		deptCodeframe.setBounds(50,50,190,20);
		deptCodeIn.setBounds(230,50,150,20);
		
		deptNameframe.setBounds(50,80,190,20);
		deptNameIn.setBounds(230,80,150,20);
		
		regularRateframe.setBounds(50,110,190,20);
		regularRateIn.setBounds(230,110,150,20);
		
		overtimeRateframe.setBounds(50,140,190,20);
		overtimeRateIn.setBounds(230,140,150,20);
		
		submitButton.setBounds(120, 200, 90, 20);
		
		frame.getContentPane().add(deptCodeIn);
		frame.getContentPane().add(deptCodeframe);
		frame.getContentPane().add(deptNameIn);
		frame.getContentPane().add(deptNameframe);
		frame.getContentPane().add(regularRateframe);
		frame.getContentPane().add(regularRateIn);
		frame.getContentPane().add(overtimeRateframe);
		frame.getContentPane().add(overtimeRateIn);
		
		frame.getContentPane().add(submitButton);

		frame.getContentPane().setLayout(null); // Set the layout of the content pane
		
		submitButton.addActionListener(this);
		
		//deptCode = 2;


	}
	
	private void addWindowListener(WindowAdapter windowAdapter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==submitButton) {
			String deptCodeIninput = deptCodeIn.getText();
			intdeptcode = Integer.parseInt(deptCodeIninput);
			deptCode = intdeptcode;	
						
			deptNameIninput = deptNameIn.getText();
			deptName = deptNameIninput;
			
			String getratein = regularRateIn.getText();
			dubRegularRateIn = Double.parseDouble(getratein);
			regularRate = dubRegularRateIn;
			
			String getovertime = overtimeRateIn.getText();
			dubOvertimeIn = Double.parseDouble(getovertime);
			overtimeRate = dubOvertimeIn;
			
			DepartmentRates department = new DepartmentRates(deptCode, deptName, regularRate, overtimeRate);
			System.out.println("======================");
			System.out.println(DepartmentRateStore);
			System.out.println("\n++++++++++++++++++++++");

	        DepartmentRateStore.put(department.deptCode, department);
			System.out.println("\n"+DepartmentRateStore);

		}
    	
	}
	
	private void performActionBeforeExit() throws IOException {
        // Perform actions before exiting the application
        System.out.println("Performing action before exit...");
        // Add your custom actions here
        new DepartmentRates().SaveDataToFile();

        // For example, simulating some cleanup or saving operation
        // File operations, database closing, etc.
    }

}
