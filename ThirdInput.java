//Rika Patterson
//Travel Expense Calculator Program
//Created May 26, 2025
//This class is used for the input of non-meal, one-time expenses such as air-fare, rental fees, and any applicable seminar fees.

//Import Java utilities
import java.util.Scanner;
import javax.swing.*;
import java.io.*;

//ThirdInput Subclass
public class ThirdInput
{
	//Variable for storing the file name of the invoice text file.
	private String invoiceFileName = "";

	public void thirdInputs() throws IOException
	{
		//User Input Fields
		JTextField airField = new JTextField(5);
		JTextField rentalField = new JTextField(5);
		JTextField registField = new JTextField(5);

		//Define new JPanel "inputPanel".
		JPanel inputPanel = new JPanel();

		//Set inputPanel Layout
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

		//"Airfare" Input Field
		inputPanel.add(new JLabel("Total Trip Airfare Charge:"));
		inputPanel.add(airField);
		inputPanel.add(Box.createVerticalStrut(15));

		//"Rental" Input Field
		inputPanel.add(new JLabel("Total Trip Car Rental Fees:"));
		inputPanel.add(rentalField);
		inputPanel.add(Box.createVerticalStrut(15));

		//"Hotel" Input Field
		inputPanel.add(new JLabel("Total Trip Conference/Seminar Registration Fees:"));
		inputPanel.add(registField);

		//Change the default window buttons from "Ok" and "Cancel" to "Okay" and "Exit", respectively.
		UIManager.put("OptionPane.okButtonText", "Okay");
		UIManager.put("OptionPane.cancelButtonText", "Exit");
		

		//The "result" variable checks whether the user clicked "OK" or "Exit".
		int result = JOptionPane.showConfirmDialog(null, inputPanel, "Travel Expense Calculator", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		//If the user clicks "Okay" on the input window...
		if (result == JOptionPane.OK_OPTION)
		{
			//Assign the user-entered text from the textboxes to their respective variables.
			String airTemp = airField.getText();		//Assign the user-entered string value to a temporary variable before parsing.
			String rentalTemp = rentalField.getText();	//Assign the user-entered string value to a temporary variable before parsing.
			String registTemp = registField.getText();	//Assign the user-entered string value to a temporary variable before parsing.

			//Parse the respective string values to their double-type variables.
			double airFare = Double.parseDouble(airTemp);
			double rentalFees = Double.parseDouble(rentalTemp);
			double registFees = Double.parseDouble(registTemp);

			//Open FilenameStorage.txt
			File readFile = new File("FilenameStorage.txt");

			//Read the contents of "FilenameStorage.txt" to retrieve the name of this employee's invoice receipt (invoiceFileName).
			Scanner inputFile = new Scanner(readFile);
			invoiceFileName = inputFile.nextLine();
			inputFile.close(); //Close "FilenameStorage.txt"

			//Append the employee invoice text file using "textFileOutput".
			FileWriter empInvoice = new FileWriter(invoiceFileName, true);
			PrintWriter textFileOutput = new PrintWriter(empInvoice);

			//Echo print to the terminal.
			System.out.print("\nTrip Airfare Charge:\t\t$");
			System.out.printf("%,.2f\t", airFare);
			System.out.print("\nTrip Car Rental Fees:\t\t$");
			System.out.printf("%,.2f\t", rentalFees);
			System.out.print("\nTrip Registration Fees:\t\t$");
			System.out.printf("%,.2f", registFees);
			System.out.println("");

			//Add data to the travel expense receipt file.
			textFileOutput.print("\nTrip Airfare Charge:\t\t$");
			textFileOutput.printf("%,.2f\t", airFare);
			textFileOutput.print("\nTrip Car Rental Fees:\t\t$");
			textFileOutput.printf("%,.2f\t", rentalFees);
			textFileOutput.print("\nTrip Registration Fees:\t\t$");
			textFileOutput.printf("%,.2f\n", registFees);
			textFileOutput.close(); //Close the invoice text file.
		}
		else //Otherwise, if the user exited the program via the "Exit" or "X" button...
		{
			System.out.println("\nYou have exited the program. Thank you, and goodbye.");
			System.out.println("_________________________\n");
			System.exit(1); //Exit Program
		}
	}
}