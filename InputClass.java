//Rika Patterson
//Travel Expense Calculator Program
//Created May 15th, 2025
//This class is used to get input from the user about the employee's name, trip duration, and any applicable travel by the employee within their own vehicle.
//This data will be echo printed to the terminal and sent to an external expense report file.

//Import Java Utilities
import javax.swing.*;
import java.io.*;

//InputClass Class
public class InputClass
{
	//The variable to hold the data for the date string.
	private String stringDate;

	//Assign stringDate to the string that was passed into InputClass.
	public InputClass(String date)
	{
		stringDate = date;
	}

	//Inputs Method
	public void inputs() throws IOException
	{
		//User Inputs
		final JTextField nameField = new JTextField(5);
		JTextField daysField = new JTextField(5);
		JTextField mileageField = new JTextField(5);

		//Define new JPanel "inputPanel".
		JPanel inputPanel = new JPanel();

		//Set inputPanel Layout
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

		//"Employee Name" Input Field
		inputPanel.add(new JLabel("Employee Name:"));
		inputPanel.add(nameField);
		inputPanel.add(Box.createVerticalStrut(15));

		//"Days" Input Field
		inputPanel.add(new JLabel("Number of days spent on trip:"));
		inputPanel.add(daysField);
		inputPanel.add(Box.createVerticalStrut(15));

		//"Mileage" Input Field
		inputPanel.add(new JLabel("Miles driven in a personal/privately owned vehicle:"));
		inputPanel.add(mileageField);

		//Change the default window buttons from "Ok" and "Cancel" to "Okay" and "Exit", respectively.
		UIManager.put("OptionPane.okButtonText", "Okay");
		UIManager.put("OptionPane.cancelButtonText", "Exit");

		//The "result" variable checks whether the user clicked "OK" or "Exit".
		int result = JOptionPane.showConfirmDialog(null, inputPanel, "Travel Expense Calculator", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		//If the user clicks "Okay" on the input window...
		if (result == JOptionPane.OK_OPTION)
		{
			//Assign the user-entered text from the textboxes to their respective variables.
			String empName = nameField.getText();
			String tripTemp = daysField.getText();	 //Assign the user-entered string value to a temporary variable before parsing.
			String povTemp = mileageField.getText(); //Assign the user-entered string value to a temporary variable before parsing.

			//Parse the temporary string variables into their proper types.
			int tripDays = Integer.parseInt(tripTemp);
			double povMileage = Double.parseDouble(povTemp);

			//Calculate the mileage reimbursement based on a pre-determined rate by the employer.
			final double mileageRate = 0.5;
			double mileReimburse = povMileage * mileageRate;

			//Create a text file for generating a travel expense receipt.
			PrintWriter textFileOutput = new PrintWriter(empName + " Invoice.txt");

			//Add data to the travel expense receipt file.
			textFileOutput.println("");
			textFileOutput.println("Travel Expense Calculator");
			textFileOutput.println("");
			textFileOutput.println(empName + "'s Invoice");
			textFileOutput.println(stringDate);
			textFileOutput.println("_________________________");
			textFileOutput.println("");
			textFileOutput.println("Employee Name:\t\t\t" + empName);
			textFileOutput.println("Duration of Trip: \t\t" + tripDays + " Days");
			textFileOutput.print("Miles Driven in POV: \t\t");
			textFileOutput.printf("%,.1f", povMileage);
			textFileOutput.print(" Miles\n");
			textFileOutput.println(" ");
			textFileOutput.printf("Total Mileage Reimbursement:\t$%,.2f \n", mileReimburse);
			textFileOutput.println(" ");
			textFileOutput.close(); //Close textFileOutput.

			//Echo print the travel expense receipt to the terminal.
			System.out.println("");
			System.out.println("Employee Name:\t\t\t" + empName);
			System.out.print("Duration of Trip: \t\t" + tripDays + " Days\n");
			System.out.print("Miles Driven in POV: \t\t");
			System.out.printf("%,.1f", povMileage);
			System.out.print(" Miles\n");
			System.out.printf("Total Mileage Reimbursement:\t$%,.2f", mileReimburse);
			System.out.println("");

		}
		else //Otherwise, if the user exited the program via the "Exit" or "X" button...
		{
			System.out.println("");
			System.out.println("You have exited the program. Thank you, and goodbye.");
			System.out.println("_________________________");
			System.out.println("");
			System.exit(1);
		}
	}
}