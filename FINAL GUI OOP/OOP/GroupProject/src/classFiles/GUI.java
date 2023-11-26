package classFiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class GUI extends DepartmentRates{
	
	
	private JFrame frame;
	private JLabel welcomeUserLabel;
	private JLabel test;
	private final String departmentOptions[] = {"Options","Add","Update","View Specific","View All"};
	private JComboBox<String> optionsCombo;
	
	private final String PayrollOptions[] = {"Options","Department Rates","Employee Payroll","Processed Payroll","Exit"};
	private JComboBox<String> payrollOptionsCombo;
	
	public GUI() throws IOException {
	    new ProcessedPayroll().getAllFileRecords();

		frame = new JFrame("Company Payroll");
		
	    frame.setBounds(30,30,900,900);
	    frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    
	    try {
			new DepartmentRates().getAllFileRecords();
			new EmployeePayroll().getAllFileRecords();
			new ProcessedPayroll().getAllFileRecords();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    welcomeUserLabel= new JLabel("Hello user, what would you like to do today");
	    optionsCombo = new JComboBox<String>(departmentOptions);
	    
	    frame.add(welcomeUserLabel);
	    frame.add(optionsCombo);

	    welcomeUserLabel.setBounds(50,50,260,20);
	    optionsCombo.setBounds(310, 50, 200, 20);	
	    
	    optionsCombo.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    	    int comboselectedindex = optionsCombo.getSelectedIndex();

	    	    if(comboselectedindex == 1) {
	    	    	String[] options = {"Add", "Update", "View Specific", "View All", "Cancel"};
	    	    	        int n = JOptionPane.showOptionDialog(null, "What would you like to do?", "Select an option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, departmentOptions, null);

	    	    	        switch (n) {
	    	    	            case 0:
	    	    	    	    	new DepartmentRates().Add();
	    	    	                break;
	    	    	                
	    	    	            case 1:
								try {
									new DepartmentRates().UpdateSpecificRecord();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
	    	    	                break;
	    	    	                
	    	    	            case 2:
								try {
									new DepartmentRates().getSpecificRecord();
								} catch (IOException e1) {
									e1.printStackTrace();
								}
	    	    	                break;
	    	    	                
	    	    	            case 3:
	    	    	                System.out.println("You selected View All");
	    	    	                break;
	    	    	                
	    	    	            case 4:
	    	    	                System.out.println("You selected Cancel");
	    	    	                break;
	    	    	                
	    	    	            default:
	    	    	                System.out.println("Invalid selection");
	    	    	        }
	    	    	    }    	
	    	    
	    	    else if(comboselectedindex == 2) {
	    	    	String[] PayrollOptions = {"Add", "Update", "View Specific", "View Department", "Delete","Cancel"};
	    	        int n = JOptionPane.showOptionDialog(null, "What would you like to do?", "Select an option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, PayrollOptions, null);

	    	        switch (n) {
	    	            case 0:
	    	    	    	new EmployeePayroll().Add();
	    	                break;
	    	                
	    	            case 1:
						try {
							new EmployeePayroll().UpdateSpecificRecord();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
	    	                break;
	    	                
	    	            case 2:
						try {
							new DepartmentRates().getSpecificRecord();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
	    	                break;
	    	                
	    	            case 3:
	    	                System.out.println("You selected View All");
	    	                break;
	    	                
	    	            case 4:
	    	                System.out.println("You selected Cancel");
	    	                break;
	    	                
	    	            default:
	    	                System.out.println("Invalid selection");
	    	        }
	    	    }
		    	
	    	    else if(comboselectedindex == 3) {
                    try {
						new DepartmentRates().getSpecificRecord();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

		    	}
	    	    else if(comboselectedindex == 4) {
                    try {
						new DepartmentRates().ViewAllRecord();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		    	}
	    	    
	    	}
	    });
	    
        JButton gettext = new JButton("TEXT");
	    gettext.setBounds(150,150,260,20);

        frame.add(gettext);
        gettext.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
	    
	    	

	}
	
}
