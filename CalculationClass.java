//Rika Patterson
//Travel Expense Calculator Program
//Created May 26, 2025
//This class is used for the final financial calculations of the program.

//CalculationClass Subclass
public class CalculationClass
{
	//Variable Declarations
	double employeeSpent = 0.00;	//Total Spent By Employee
	double budgetAllocated = 0.00;	//Budget Allocated By Employer
	double overageAmount = 0.00;	//Budget Remaining or Overspent
	int departTime;
	int arriveTime;

	//Setters - Trip Departure and Home Arrival Times
	public void setTime(int departForTrip, int arriveAtHome)
	{
		departTime = departForTrip;
		arriveTime = arriveAtHome;
	}

	//Getter - Trip Departure Time
	public int getDepartTime()
	{
		return departTime;
	}

	//Getter - Home Arrival Time
	public int getArriveTime()
	{
		return arriveTime;
	}

	//Setter - Expenses Incurred Daily (Adds To Total)
	public void setExpenseTotal(double expenseTotal)
	{
		employeeSpent += expenseTotal;
	}

	//Setter - Allowances Incurred Daily (Adds To Total)
	public void setAllowanceTotal(double allowanceTotal)
	{
		budgetAllocated += allowanceTotal;
	}

	//Setter - Overages Incurred Daily (Adds To Total)
	public void setOverageTotal(double overageTotal)
	{
		overageAmount += overageTotal;
	}
}