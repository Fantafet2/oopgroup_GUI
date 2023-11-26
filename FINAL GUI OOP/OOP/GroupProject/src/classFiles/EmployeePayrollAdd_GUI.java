package classFiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EmployeePayrollAdd_GUI extends EmployeePayroll implements ActionListener{
	private JFrame frame;
	
	private JLabel idInLabel;
	private JTextField idInput;
	
	private JLabel firstInLabel;
	private JTextField firstInput;
	
	private JLabel lastInLabel;
	private JTextField lastInput;

	private JLabel deptcodeInLabel;
	private JTextField deptcodeInput;
	
	private JLabel positionInLabel;
	private JTextField positionInput;
	
	private JLabel trnInLabel;
	private JTextField trnInput;
	
	private JLabel nisInLabel;
	private JTextField nisInput;
	
	private JLabel dobInLabel;
	private JTextField dobInput;
	
	private JLabel hireDateInLabel;
	private JTextField hireDateInput;
	
	private JLabel hoursWorkedInLabel;
	private JTextField hoursWorkedInput;
	
	private JButton submit;
	
	public EmployeePayrollAdd_GUI() {
		frame = new JFrame("Add Employee to Payroll");
		frame.setBounds(30,30,900,900);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // Set the layout of the content pane
		
		idInLabel = new JLabel("Enter ID#: ");
		idInput = new JTextField();
		idInLabel.setBounds(50,50,240,20);
		idInput.setBounds(250,50,90,20);
		
		firstInLabel = new JLabel("Enter First Name: ");
		firstInput = new JTextField();
		firstInLabel.setBounds(50,80,240,20);
		firstInput.setBounds(250,80,90,20);
		
		lastInLabel = new JLabel("Enter Last Name: ");
		lastInput = new JTextField();
		lastInLabel.setBounds(50,110,240,20);
		lastInput.setBounds(250,110,90,20);
		
		deptcodeInLabel = new JLabel("Enter Department Code: ");
		deptcodeInput = new JTextField();
		deptcodeInLabel.setBounds(50,140,240,20);
		deptcodeInput.setBounds(250,140,90,20);
		
		positionInLabel = new JLabel("Enter Positon held: ");
		positionInput = new JTextField();
		positionInLabel.setBounds(50,170,240,20);
		positionInput.setBounds(250,170,90,20);
		
		trnInLabel = new JLabel("Enter TRN#: ");
		trnInput = new JTextField();
		trnInLabel.setBounds(50,200,240,20);
		trnInput.setBounds(250,200,90,20);
		
		nisInLabel = new JLabel("Enter NIS#: ");
		nisInput = new JTextField();
		nisInLabel.setBounds(50,230,240,20);
		nisInput.setBounds(250,230,90,20);
		
		dobInLabel = new JLabel("Enter Date of Birth: ");
		dobInput = new JTextField();
		dobInLabel.setBounds(50,260,240,20);
		dobInput.setBounds(250,260,90,20);
		
		hireDateInLabel = new JLabel("Enter Date of Hire: ");
		hireDateInput = new JTextField();
		hireDateInLabel.setBounds(50,90,240,20);
		hireDateInput.setBounds(250,90,90,20);
		
		hoursWorkedInLabel = new JLabel("Enter Amount of hours worked: ");
		hoursWorkedInput = new JTextField();		
		hoursWorkedInLabel.setBounds(50,320,240,20);
		hoursWorkedInput.setBounds(250,320,90,20);
		
		submit = new JButton("submit");
		submit.setBounds(80,350,60,20);
		
		frame.getContentPane().add(idInLabel);
		frame.getContentPane().add(idInput);
		frame.getContentPane().add(firstInLabel);
		frame.getContentPane().add(firstInput);
		frame.getContentPane().add(lastInLabel);
		frame.getContentPane().add(lastInput);
		frame.getContentPane().add(deptcodeInLabel);
		frame.getContentPane().add(deptcodeInput);
		frame.getContentPane().add(positionInLabel);
		frame.getContentPane().add(positionInput);
		frame.getContentPane().add(trnInLabel);
		frame.getContentPane().add(trnInput);
		frame.getContentPane().add(nisInLabel);
		frame.getContentPane().add(nisInput);
		frame.getContentPane().add(dobInLabel);
		frame.getContentPane().add(dobInput);
		frame.getContentPane().add(hireDateInput);
		frame.getContentPane().add(hireDateInLabel);
		frame.getContentPane().add(hoursWorkedInLabel);
		frame.getContentPane().add(hoursWorkedInput);
		frame.getContentPane().add(submit);
		
		submit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==submit) {
			String getId = idInput.getText();
			IdNo = Integer.parseInt(getId);
			
			firstName = firstInput.getText();
			lastName = lastInput.getText();
			position = positionInput.getText();
			TRN = trnInput.getText();
			NIS = nisInput.getText();
			DOB = dobInput.getText();
			employeeHiredDate = hireDateInput.getText();
			
			String getHours = hoursWorkedInput.getText();
			hoursWorked = Double.parseDouble(getHours);
					
			EmployeePayroll employeePayroll = new EmployeePayroll(IdNo, firstName, lastName, deptCode, position, TRN, NIS, DOB, employeeHiredDate, hoursWorked);
	        EmployeePayrollStore.put(employeePayroll.IdNo, employeePayroll);


		}
	}
}
