//Rika Patterson
//Travel Expense Calculator Program
//Created May 15th, 2025
//This is the main program file for the travel expense calculator.

//Import Java Utilities
import java.util.Scanner;	//For keyboard scanner object
import java.io.*;			//For throwing IOException
import javax.swing.*;		//For UI stuff (JPanels, JFrames, etc.)
import java.net.*;			//For accessing the internet. The splashScreen method references a URL where I have placed the splash screen graphic.

//ExpenseCalculator
public class ExpenseCalculator
{
	//main Method
	public static void main(String[] args) throws IOException
	{
		//This program uses keyboard inputs by the user.
		//Therefore, we must establish our scanner object (the keyboard).
		Scanner keyboard = new Scanner(System.in);

		//Display Splash Screen
		welcomeSplashScreen();

		//Print the program header to the terminal.
		System.out.println("\n_________________________\n");
		System.out.println("Travel Expense Calculator");
		System.out.println("Written by Rika Patterson");
		System.out.println("Created May 15, 2025 (Last Updated May 20, 2025)");
		System.out.println("\n_________________________\n");

		//The program will repeat until the user clicks "Exit" or the red "X" in the top right corner.
		do
		{
			//Retrieve today's date (formatted) using the retreiveDate method.
			String dateString = retreiveDate();

			//Send today's date information to the userInputs method, which handles the user inputs and generates travel expense receipts.
			userInputs(dateString);

			//After an expense report has been generated for one employee, we will ask the user if they would like to run the program again for another employee.
			//Define new JPanel "repeatPanel".
			JPanel repeatPanel = new JPanel();

			//Set repeatPanel Layout
			repeatPanel.setLayout(new BoxLayout(repeatPanel, BoxLayout.Y_AXIS));

			//Change the default window buttons from "Ok" and "Cancel" to "Run Again" and "Exit", respectively.
			UIManager.put("OptionPane.okButtonText", "Run Again");
			UIManager.put("OptionPane.cancelButtonText", "Exit");

			///The "exitProgram" variable checks whether the user clicked "OK" or "Exit".
			int exitProgram = JOptionPane.showConfirmDialog(null, "Would you like to run the program again for another employee?", "Travel Expense Calculator", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

			//If the user clicks the "Exit" button or the red "X' in the top right corner, the program will close to terminal.
			if (exitProgram==JOptionPane.NO_OPTION||exitProgram==JOptionPane.CLOSED_OPTION)
			{
				System.out.println("\nYou have exited the program. Thank you, and goodbye.");
				System.out.println("_________________________\n");
				System.exit(1); //Exit Program
			}
		}while(1==1);
	}

	//welcomeSplashScreen Method
	public static void welcomeSplashScreen() throws IOException
	{
		//Retrieve the splash screen image from GitHub and assign it to the variable "icon".
		final ImageIcon icon = new ImageIcon(new URL("https://github.com/RikaPatterson/Java_Programs/blob/main/SplashScreen.png?raw=true"));

		//Change the default window buttons from "Ok" and "Cancel" to "Start Program" and "Exit", respectively.
		UIManager.put("OptionPane.okButtonText", "Start Program");
		UIManager.put("OptionPane.cancelButtonText", "Exit");

		//Create a JOptionPane that displays the image retrieved above.
		int exitProgram = JOptionPane.showConfirmDialog(null, "", "Homestar Corporation Travel Expense Calculator", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icon);

		//If the user clicks the "Exit" button or the red "X' in the top right corner, the program will close to terminal.
		if(exitProgram==JOptionPane.CANCEL_OPTION||exitProgram==JOptionPane.CLOSED_OPTION)
		{
			System.out.println("\nYou have exited the program. Thank you, and goodbye.");
			System.out.println("_____________________________________________________\n");
			System.exit(1); //Exit Program
		}

	}

	//retreiveDate Method
	public static String retreiveDate() throws IOException
	{
		//Reference the DateClass file as "dateSubProgram".
		DateClass dateSubProgram = new DateClass();

		//Call the appropriate methods within dateSubProgram to get our data.
		int currentYear = dateSubProgram.getYear();		 //Retreive the current year.
		String currentMonth = dateSubProgram.getMonth(); //Retreive the current month.
		int currentDay = dateSubProgram.getDay();		 //Retreive the current day.

		//Return today's date (formatted) as a string for use in outputs.
		return(currentMonth + " " + currentDay + ", " + currentYear);
	}

	//userInputs Method
	public static void userInputs(String dateString) throws IOException
	{
		//Reference the input files, where the user inputs will be carried out.
		FirstInput inputSubProgram = new FirstInput(dateString);
		SecondInput inputSubProgram2 = new SecondInput();
		ThirdInput inputSubProgram3 = new ThirdInput();
		FourthInput inputSubProgram4 = new FourthInput();

		//Call the input methods within the program subclasses to process user inputs and generate travel expense receipts.
		int tripDuration = inputSubProgram.firstInputs();
		inputSubProgram2.secondInputs();
		inputSubProgram3.thirdInputs();
		inputSubProgram4.fourthInputs(tripDuration); //Pass tripDuration
	}
}
