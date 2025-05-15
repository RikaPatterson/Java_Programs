//Rika Patterson
//Travel Expense Calculator Program
//Created May 15th, 2025
//This is the main program file for the travel expense calculator.

//Import Java utilities.
import java.io.*;
import javax.swing.*;
import java.net.*; //This package allows us to access the internet. The splashScreen method references a URL where I have placed the splash screen graphic.

//The Program
public class ExpenseCalculator
{
	//The Program's Main Method
	public static void main(String[] args) throws IOException
	{
		//Display the splash screen.
		splashScreen();
	}

	//Method for displaying the splash screen graphic.
	public static void splashScreen() throws IOException
	{
		//Variables
		int exitProgram;

		//Retrieve the splash screen from GitHub and assign it to the variable "icon".
		final ImageIcon icon = new ImageIcon(new URL("https://github.com/RikaPatterson/Java_Programs/blob/main/splashScreen.png?raw=true"));

		//Change the default window buttons from "Ok" and "Cancel" to "Start Program "and "Exit", respectively.
		UIManager.put("OptionPane.okButtonText", "Start Program");
		UIManager.put("OptionPane.cancelButtonText", "Exit");

		//Create a JOptionPane that displays the image retrieved above.
		exitProgram = JOptionPane.showConfirmDialog(null, "", "Rika Patterson's Travel Expense Calculator", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icon);

		//If the user clicks the "Exit" button or the red "X' in the top right corner, the program will close to terminal.
		if (exitProgram == JOptionPane.CANCEL_OPTION || exitProgram == JOptionPane.CLOSED_OPTION) {
			System.out.println("_____________________________________________________");
			System.out.println("You have exited the program. Thank you, and goodbye.");
			System.out.println("_____________________________________________________");
			System.out.println("");
			System.exit(1);
		}
	}
}
