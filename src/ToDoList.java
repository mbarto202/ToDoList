/**
 * ToDoList

 * This program allows users to add, remove, or change elements in a partial array.
 *
 * @author Michael Barto
 * @version 2/24/2020
 */

import java.util.Scanner;
import java.io.IOException;

public class ToDoList
{
	/** Main method of the program.*/
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);

		System.out.println("Enter the number of tasks you want in your to-do list. ");
		
		String strLength = in.nextLine();
		while (Integer.valueOf(strLength) <= 0 || Integer.valueOf(strLength) > 100)
		{
			System.out.println("Please enter a number greater than 0 and less than 100.");
			strLength = in.nextLine();
		}
		
		int length = Integer.valueOf(strLength);
		

		String[] tasks = new String[length];

		int currentSize = 0;

		System.out.println("Menu");


		// variables

		char choice;        

		do
		{
			System.out.print("\f");  // Clears the console
			// ...
			choice = selectAction(in, tasks, length, currentSize);  //  get the activity to perform
			in.nextLine();  //  Get rid of the extra /n in the buffer
			if (choice == 'Q')
				break;                
			switch(choice)
			{  
			// Adds elements to the array.
			case 'A': System.out.println("Add Task: ");
			add(in, tasks, currentSize, length);
			currentSize++;

			break;
			// Removes elements in the array.
			case 'R': System.out.println("Remove Task: ");
			remove(in, tasks, currentSize, length);
			currentSize--;

			break;
			// Changes elements in the array.
			case 'C': System.out.println("Change Tasks: ");
			change(in, tasks, currentSize);

			break;
			}

			pause();
		}while (true);

		System.out.println("End of program.");
	}          

	/**
	 * This method displays the program menu and returns the user's selection
	 * @param in - the Scanner object to read the user's choice
	 * @param tasks - reference to the string array 
	 * @param length - the length of the array
	 * @param currentSize - the current number of elements in the array
	 * @return the activity selected by the user
	 */
	private static char selectAction(Scanner in, String[] tasks, int length, int currentSize)
	{

		System.out.println("");
		for (int i = 0; i < length; i++)
		{
			if ( tasks[i] == null)
			{
				System.out.println(" ");
			}
			else
			{
				System.out.println((i+1) + ". " + tasks[i]);
			}
		}

		if(currentSize == 0)
		{
			System.out.println("The list is empty");
		}

		String menu = "\nSelect Activity below:\n" +
				"\t[A]dd a Task\n" +
				"\t[R]emove a Task\n" +
				"\t[C]hange a Task\n" +
				"\t[Q]uit\n" +
				"Enter the letter in the \"[ ]\": ";
		System.out.print(menu);
		return in.next().toUpperCase().charAt(0);
	}

	/**
	 * This method pauses processing until the user enters any key
	 * throw IOException - if read error occurs
	 */
	public static void pause() throws IOException
	{
		System.out.print("Press Enter key to continue: ");
		char c = (char) System.in.read();
	}

	/**
	 * This method removes an element from the partial array.
	 * It finds the index of the element to be removed.
	 * @param in - scanner for the user input
	 * @param length - the length of the array
	 * @param tasks - reference to the string array from which the element
	 *  is to be removed
	 * @param currentSize - the current number of elements in the array
	 */
	static void remove(Scanner in, String[] tasks, int currentSize, int length)
	{
		if(currentSize == 0)
		{
			System.out.println("The list is empty. ");
		}

		else if (currentSize == 1)
		{
			System.out.println("There is " + currentSize + " task that can be removed. ");
			int rem = in.nextInt();
			rem--;
			tasks[rem] = null;
			currentSize--;

			for(int i = rem + 1; i < currentSize; i++)
			{

				tasks[i - 1] = tasks[i];
			}

		}

		else
		{
			System.out.println("Which task would you like to delete 1-" + (currentSize)+"? ");
			int rem = in.nextInt();
			rem--;
			tasks[rem] = null;
			currentSize--;

			for(int i = rem + 1; i < currentSize; i++)
			{
				tasks[i - 1] = tasks[i];
			}
		}
	}

	/**
	 * This method adds an element to the partial array.
	 * It finds the index of the element to be added.
	 * @param in - scanner for the user input
	 * @param length - the length of the array
	 * @param tasks - reference to the string array from which the element
	 *  is to be added
	 * @param currentSize - the current number of elements in the array
	 */
	static void add(Scanner in, String[] tasks, int currentSize, int length)
	{
		if(currentSize == length) 
		{
			System.out.print("The task list is full. ");
			System.out.println("");
		}
		else
		{
			System.out.print((currentSize + 1) + ". ");
			tasks[currentSize] = in.nextLine();
		}
	}

	/**
	 * This method changes an element in the partial array.
	 * @param in - scanner for the user input
	 * @param tasks - reference to the string array from which the element
	 *  is to be changed
	 * @param currentSize - the current number of elements in the array
	 */
	static void change(Scanner in, String[] tasks, int currentSize)
	{
		System.out.println("Input the number of the task you would like to change.");
		int n = in.nextInt();
		in.nextLine();

		if (n <= 0 || n > currentSize)
		{
			System.out.println("The number of the task was not found");
		}
		else
		{
			System.out.println("Enter the new task.");
			tasks[n-1] = in.nextLine();
		}
	}
}