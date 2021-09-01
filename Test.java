/*
 * TODO: create "answer" array
 * 
 * TODO: figure out loops for back substitution
 * 
 * TODO: create array of "variables" that will be solved for
 */

public class Test {
	private int h;
	private double[][] arr;
	private double[][] arrCopy; 
	
	public Test(double[][] arr, double[][] arrCopy, int h)
	{
		this.arr = arr;
		this.arrCopy = arrCopy;
		this.h = h;
	}

	public void setArr() {
		for(int i = 0; i <h; i++)
		{
			for(int j = 0; j<h; j++)
			{
				this.arr[i][j] = i + j;
			}
		}
	}
	
	public void inputArr(int i, int j, double value)
	{
		this.arr[i][j] = value;
	}
	
	public double[][] flipArr()
	{
		/*
		 * i = modifying row
		 * j = row to be modified
		 * k = element in row
		 * h = height/length of array
		 */
		for(int i=0; i<h-1; i++) // iterate through modifier rows
		{
			for(int j=1; j<h-1; j++) // iterate through rows to be modified
			{
				double m = (arr[j][i] / arr[i][i]);
				
				for(int k=i; k<h; k++) // iterate through columns to modify elements
				{
					arrCopy[i][k] = m * arr[i][k]; // multiply modifying row by m
				}
				
				for(int k = i; k<h; k++) // subtract modified term from row to be modified
				{
					arr[j][k] = arr[j][k] - arrCopy[j][k];
				}
				
				for(int k = i; k<h; k++) // return modifying row to original state
				{
					arr[i][k] = arrCopy[i][k];
				}
			}
		}
		return arr;
	}
	
	public void printArr()
	{
		for(int i = 0; i <h; i++)
		{
			for(int j = 0; j<h; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	

}
