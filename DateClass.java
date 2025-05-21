//Rika Patterson
//Travel Expense Calculator Program
//Created May 15th, 2025
//This external class is used to get the current date.

//Import Java Utilities
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

//DateClass Class
public class DateClass
{
	
	//Create a Calendar object with the computer's current date and timezone.
	Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
	
	//Get the current time.
	Date currentTime = localCalendar.getTime();

	//getYear Method
	public int getYear()
	{
		//Grab the year value from the Calendar object and return it.
		int calendarYear = localCalendar.get(Calendar.YEAR);
		return(calendarYear);
	}

	//getMonth method.
	public String getMonth()
	{
		//String variable for month value.
		String calendarMonth;

		//Grab the month value from the Calendar object.
		int currentMonth = localCalendar.get(Calendar.MONTH) + 1;

		//Convert the numerical month value to a month name.
		switch(currentMonth)
		{
			case 1:
				calendarMonth = ("January");
				break;

			case 2:
				calendarMonth = ("February");
				break;

			case 3:
				calendarMonth = ("March");
				break;

			case 4:
				calendarMonth = ("April");
				break;

			case 5:
				calendarMonth = ("May");
				break;

			case 6:
				calendarMonth = ("June");
				break;

			case 7:
				calendarMonth = ("July");
				break;

			case 8:
				calendarMonth = ("August");
				break;

			case 9:
				calendarMonth = ("September");
				break;

			case 10:
				calendarMonth = ("October");
				break;

			case 11:
				calendarMonth = ("November");
				break;

			case 12:
				calendarMonth = ("December");
				break;

			default:
				calendarMonth = ("Month");
				break;
		}

		//Return the month name.
		return(calendarMonth);
	}

	//getDay method.
	public int getDay()
	{
		//Grab the day value from the Calendar object and return it.
		int calendarDay = localCalendar.get(Calendar.DATE);
		return(calendarDay);
	}

}