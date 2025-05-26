//Rika Patterson
//Travel Expense Calculator Program
//Created May 26, 2025
//This class is used for the input of all applicable daily expenses.

//Import Java utilities
import java.util.Scanner;
import javax.swing.*;
import java.io.*;

//FourthInput Subclass
public class FourthInput
{
	//Variable for storing the file name of the invoice text file.
	private String invoiceFileName = "";

	//tripDuration is passed into this method (used to know the length of the trip in number of days).
	public void fourthInputs(int tripDuration) throws IOException
	{
		//User Input Variables (Defined Outside Loop)
		double[] breakfastCharge;
		double[] lunchCharge;
		double[] dinnerCharge;
		double[] miscCharge;

		//Print Header To Terminal
		System.out.println("\n_________________________\nDaily Expenses:");

		//This loop will run once per number of trip days, allowing for daily expenses to be added.
		for (int runCount = 0; runCount<tripDuration; runCount++) 
		{
			//User Input Variables (Defined Inside Loop)
			breakfastCharge = new double[100];
			lunchCharge = new double[100];
			dinnerCharge = new double[100];
			miscCharge = new double[100];

			//User Input Fields
			JTextField breakfastField = new JTextField(5);
			JTextField lunchField = new JTextField(5);
			JTextField dinnerField = new JTextField(5);
			JTextField miscField = new JTextField(5);

			//Define new JPanel "inputPanel".
			JPanel inputPanel = new JPanel();
			
			//Set inputPanel Layout
			inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

			//inputPanel Header
			inputPanel.add(new JLabel("Daily Expenses:"));
			inputPanel.add(new JLabel("Day " + (runCount + 1)));
			inputPanel.add(Box.createVerticalStrut(15));

			//"Breakfast" Input Field
			inputPanel.add(new JLabel("Breakfast:"));
			inputPanel.add(breakfastField);
			inputPanel.add(Box.createVerticalStrut(15));

			//"Lunch" Input Field
			inputPanel.add(new JLabel("Lunch:"));
			inputPanel.add(lunchField);
			inputPanel.add(Box.createVerticalStrut(15));

			//"Dinner" Input Field
			inputPanel.add(new JLabel("Dinner:"));
			inputPanel.add(dinnerField);
			inputPanel.add(Box.createVerticalStrut(15));

			//"Miscellaneous" text field.
			inputPanel.add(new JLabel("Miscellaneous Fees:"));
			inputPanel.add(miscField);
			inputPanel.add(Box.createVerticalStrut(15));

			//Change the default window buttons from "Ok" and "Cancel" to "Okay" and "Exit", respectively.
			UIManager.put("OptionPane.okButtonText", "Okay");
			UIManager.put("OptionPane.cancelButtonText", "Exit");

			//The "result" variable checks whether the user clicked "OK" or "Exit".
			int result = JOptionPane.showConfirmDialog(null, inputPanel, "Travel Expense Calculator", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

			//If the user clicks "Okay" on the input window...
			if (result == JOptionPane.OK_OPTION)
			{
				//Assign the user-entered text from the textboxes to their respective String variables.
				String breakfastTemp = breakfastField.getText();
				String lunchTemp = lunchField.getText();
				String dinnerTemp = dinnerField.getText();
				String miscTemp = miscField.getText();

				//Parse the string values to their double-type variables (in array positions according to the current runCount).
				breakfastCharge[runCount] = Double.parseDouble(breakfastTemp);
				lunchCharge[runCount] = Double.parseDouble(lunchTemp);
				dinnerCharge[runCount] = Double.parseDouble(dinnerTemp);
				miscCharge[runCount] = Double.parseDouble(miscTemp);

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
				System.out.println("\nDay " + (runCount + 1));
				System.out.print("Breakfast Charge:\t\t$");
				System.out.printf("%,.2f", breakfastCharge[runCount]);
				System.out.print("\nLunch Charge:\t\t\t$");
				System.out.printf("%,.2f", lunchCharge[runCount]);
				System.out.print("\nDinner Charge:\t\t\t$");
				System.out.printf("%,.2f", dinnerCharge[runCount]);
				System.out.print("\nMiscellaneous Fees:\t\t$");
				System.out.printf("%,.2f\n", miscCharge[runCount]);

				//Add data to the travel expense receipt file.
				textFileOutput.println("\nDay " + (runCount + 1));
				textFileOutput.print("Breakfast Charge:\t\t$");
				textFileOutput.printf("%,.2f", breakfastCharge[runCount]);
				textFileOutput.print("\nLunch Charge:\t\t\t$");
				textFileOutput.printf("%,.2f", lunchCharge[runCount]);
				textFileOutput.print("\nDinner Charge:\t\t\t$");
				textFileOutput.printf("%,.2f", dinnerCharge[runCount]);
				textFileOutput.print("\nMiscellaneous Fees:\t\t$");
				textFileOutput.printf("%,.2f\n", miscCharge[runCount]);
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
}