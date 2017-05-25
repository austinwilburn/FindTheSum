/*
* [FindTheSum].java
* Author: [Austin Wilburn]
* Submission Date: [12/7/2014]
*
* Purpose: The program is a class that has three methods: a 
* method to put an array into a string, a method to find 
* values that added horizontally to become an entered sum 
* and set the others to 0, and the last method takes an array
* and to find values that added vertically become an entered
* sum and set the others to 0.
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia.
*/
public class FindThesum {
	//method to return a string from the array entered
	public static String arrayToString(int[][] a){
		//declare the string and initialize
		String arrayString = "";
		//for loops, loops through the rows
		for(int row = 0; row < a.length; row++)
			{
			//for loop, loops through the columns
			for(int col = 0; col < a[0].length; col++)
				{
				//if column is not the last
				if(col != a[0].length - 1)
					//concat value and space
					arrayString += a[row][col] + " ";	
				else
					//concat value
					arrayString += a[row][col];
				}
			//if row is not end
			if(row != a.length - 1)
				//concat to the next line
			 arrayString += "\n";
			}
		//return string
		return arrayString;
		}
	//return integer array that adds horizontally to array and value entered and set other to 0
	public static int[][] horizontalSums(int[][] a, int sumToFind){
		//create new array set to all 0s with same size as array entered
		int[][] b = new int[a.length][a[0].length];
		//for loop, loops through all rows in array
		for(int row = 0; row < a.length; row++)
			{
			//set up values for loop
			int sum = 0;
			int count = 0;
			int col = 0;
			//loops through all columns in array
			while(col < a[row].length)
				{
				//add value to sum
				sum += a[row][col];
				//increase count
				count++;
				//if sum is less than the entered sum
				if(sum < sumToFind)
					{
					//next column
					col++;
					}
				//if sum is the sum entered
				if(sum == sumToFind)
					{
					//set sum to 0
					sum = 0;
					//for loop, loops through the length of the summed values
					for(int i = (col + 1 - count); i <= col; i++)
						{
						//set b to those values
						b[row][i] = a[row][i];
						}
					//go to next column from start
					col = col + 2 - count;
					//set count back to 0
					count = 0;
					}
				//if sum is greater than sum entered
				if(sum > sumToFind)
					{
					//go to next column from start
					col = col + 2 - count;
					//set sum and count to 0
					sum = 0;
					count = 0;
					}	
				}
			}
		//return new array
		return b;
	}
	//return integer array that adds vertically to 
	//array and value entered and set other to 0
	public static int[][] verticalSums(int[][] a, int sumToFind){
		//create new array set to all 0s with same size as array entered
		int[][] b = new int[a.length][a[0].length];
		//for loop, loops through all columns in array
		for(int col = 0; col < a[0].length; col++)
			{
			//set up values for loop
			int sum = 0;
			int count = 0;
			int row = 0;
			//loops through all rows in array
			while(row < a.length)
				{
				//add value to sum
				sum += a[row][col];
				//increase count
				count++;
				//if sum is less than the entered sum
				if(sum < sumToFind)
					{
					//next row
					row++;
					}
				//if sum is the sum entered
				if(sum == sumToFind)
					{
					//set sum to 0
					sum = 0;
					//for loop, loops through the length of the summed values
					for(int i = (row + 1 - count); i <= row; i++)
						{
						//set b to those values
						b[i][col] = a[i][col];
						}
					//go to next row from start
					row = row + 2 - count;
					//set count back to 0
					count = 0;
					}
				//if sum is greater than sum entered
				if(sum > sumToFind)
					{
					//go to next row from start
					row = row + 2 - count;
					//set sum and count to 0
					sum = 0;
					count = 0;
					}
				}
			}
		//return new array
		return b;
		}
}
