//Rika Patterson
//Travel Expense Calculator Program
//Created May 26, 2025
//This class is used for the input of the departure and arrival times during the first and final days of the trip by the employee.
//This data will then be used to determine the applicable meals that will be covered by the employer for expense report purposes.

//Import Java utilities
import java.util.Scanner;
import javax.swing.*;
import java.io.*;

//SecondInput Subclass
public class SecondInput
{
	//Variable for storing the file name of the invoice text file.
	private String invoiceFileName = "";

	//secondInputs Method
	public void secondInputs(CalculationClass calculate) throws IOException
	{
		//User Input Fields
		JTextField leaveField = new JTextField(5);
		JTextField arriveField = new JTextField(5);

		//Define new JPanel "inputPanel".
		JPanel inputPanel = new JPanel();

		//Set inputPanel Layout
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

		//"Left home" Input Field
		inputPanel.add(new JLabel("Time you left home when you began your trip:"));
		inputPanel.add(leaveField);
		inputPanel.add(Box.createVerticalStrut(15));

		//"Arrive home" Input Field
		inputPanel.add(new JLabel("Time you arrived home at the end of your trip:"));
		inputPanel.add(arriveField);

		//Change the default window buttons from "Ok" and "Cancel" to "Okay" and "Exit", respectively.
		UIManager.put("OptionPane.okButtonText", "Okay");
		UIManager.put("OptionPane.cancelButtonText", "Exit");

		//The "result" variable checks whether the user clicked "OK" or "Exit".
		int result = JOptionPane.showConfirmDialog(null, inputPanel, "Travel Expense Calculator", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		//If the user clicks "Okay" on the input window...
		if (result == JOptionPane.OK_OPTION)
		{
			//Assign the user-entered text from the textboxes to their respective String variables before parsing to integers.
			String departTemp = leaveField.getText();
			String arriveTemp = arriveField.getText();

			//Parse the string values to their respective integer-type variables.
			int departForTrip = Integer.parseInt(departTemp);
			int arriveAtHome = Integer.parseInt(arriveTemp);

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
			System.out.println("\nTime Left Home:\t\t\t" + departTemp);
			System.out.println("Time Arrived at Home:\t\t" + arriveTemp);

			//Add data to the travel expense receipt file.
			textFileOutput.println("Time Left Home:\t\t\t" + departTemp);
			textFileOutput.println("Time Arrived at Home:\t\t" + arriveTemp);
			textFileOutput.close(); //Close the invoice text file.

			//Send the three times to the CalcClass external class for storage.
			//These values will be used during the FourthInput external class.
			calculate.setTime(departForTrip, arriveAtHome);
		}
		else //Otherwise, if the user exited the program via the "Exit" or "X" button...
		{
			System.out.println("\nYou have exited the program. Thank you, and goodbye.");
			System.out.println("_________________________\n");
			System.exit(1); //Exit Program
		}
	}
}