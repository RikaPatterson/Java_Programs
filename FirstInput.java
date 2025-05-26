//Rika Patterson
//Travel Expense Calculator Program
//Created May 15th, 2025
//This class is used to get input from the user about the employee's name, trip duration, and any applicable travel by the employee within their own vehicle.
//This data will be echo printed to the terminal and sent to an external expense report file.

//Import Java Utilities
import javax.swing.*;
import java.io.*;

//FirstInput Subclass
public class FirstInput
{
	//Variable to hold the data for the date string.
	private String stringDate;

	//Assign stringDate to the string that was passed into FirstInput.
	public FirstInput(String date)
	{
		stringDate = date;
	}

	//firstInputs Method
	public int firstInputs() throws IOException
	{
		//Initialize "tripDays". This value is returned to ExpenseCalculator after FirstInput has completed.
		int tripDays = 0;

		//User Input Fields
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
			String tripTemp = daysField.getText();		//Assign the user-entered string value to a temporary variable before parsing.
			String povTemp = mileageField.getText();	//Assign the user-entered string value to a temporary variable before parsing.

			//Parse the temporary string variables into their proper types.
			tripDays = Integer.parseInt(tripTemp);
			double povMileage = Double.parseDouble(povTemp);

			//Calculate the mileage reimbursement based on a pre-determined rate by the employer.
			final double mileageRate = 0.5;
			double mileReimburse = povMileage * mileageRate;

			//Create a text file for generating a travel expense receipt.
			PrintWriter textFileOutput = new PrintWriter(empName + " Invoice.txt");

			//Add data to the travel expense receipt file.
			textFileOutput.println("\nTravel Expense Calculator\n");
			textFileOutput.println(empName + "'s Invoice");
			textFileOutput.println(stringDate);
			textFileOutput.println("_________________________\n");
			textFileOutput.println("Employee Name:\t\t\t" + empName);
			textFileOutput.println("Duration of Trip:\t\t" + tripDays + " Days");
			textFileOutput.printf("Miles Driven in POV:\t\t%,.1f Miles\n", povMileage);
			textFileOutput.printf("Total Mileage Reimbursement:\t$%,.2f\n\n", mileReimburse);
			textFileOutput.close(); //Close the invoice text file.

			//Echo print to the terminal.
			System.out.println("\nEmployee Name:\t\t\t" + empName);
			System.out.print("Duration of Trip:\t\t" + tripDays + " Days\n");
			System.out.printf("Miles Driven in POV:\t\t%,.1f Miles\n", povMileage);
			System.out.printf("Total Mileage Reimbursement:\t$%,.2f\n", mileReimburse);

			//Create a text file to store the name of the employee invoice text file.
			//Only a single value may be returned from this subclass (we are returning "tripDays").
			//This value is needed elsewhere in the program moving forward to append the invoice receipt.
			PrintWriter storeFilename = new PrintWriter("FilenameStorage.txt");
			storeFilename.println(empName + " Invoice.txt");
			storeFilename.close(); //Close "FilenameStorage.txt"

		}
		else //Otherwise, if the user exited the program via the "Exit" or "X" button...
		{
			System.out.println("\nYou have exited the program. Thank you, and goodbye.");
			System.out.println("_________________________\n");
			System.exit(1); //Exit Program
		}

		//Return tripDays to ExpenseCalculator
		return tripDays;
	}
}