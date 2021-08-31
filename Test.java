import java.util.Scanner;

public class Test {
	private double[][] arr; 	// array to be modified
	private double[][] arrCopy; // utility array
	private double[] c;			// "answers" array
	
	private final int a = arr.length;
	
	public Test()
	{
		
	}

	public double[][] getArr() {
		arr = loopin();
		return arr;
	}

	public void setArr(double[][] arr) {
		this.arr = arr;
		this.arrCopy = arr;
		
	}
	
	private double[][] loopin()
	{
		/*
		 * i = modifying row
		 * j = row to be modified
		 * k = element in row
		 * a = length of array
		 */
		for(int i=0; i<a; i++) // iterate through modifier rows
		{
			for(int j=1; j<a; j++) // iterate through rows to be modified
			{
				double m = (arr[j][i] / arr[i][i]);
				
				for(int k=i; k<a; k++) // iterate through columns to modify elements
				{
					arrCopy[i][k] = m * arr[i][k]; // multiply modifying row by m
				}
				
				for(int k = i; k<a; k++) // subtract modified term from row to be modified
				{
					arr[j][k] = arr[j][k] - arrCopy[j][k];
				}
				
				for(int k = i; k<a; k++) // return modifying row to original state
				{
					arr[i][k] = arrCopy[i][k];
				}
			}
		}
		return arr;
	}
	
	public void printArr()
	{
		for(int i = 0; i <a; i++)
		{
			for(int j = 0; j<a; j++)
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Input the size of the array");
		
		
		int arrLength = in.nextInt();
		double[][] arr = new double[arrLength][arrLength];
		
		for(int i = 0; i <arrLength; i++)
		{
			for(int j = 0; j<arrLength; j++)
			{
				arr[i][j] = i + j;
			}
		}
		
		Test test = new Test();
		
		test.setArr(arr);
		test.getArr();
		test.printArr();
		
		
		
	}

}
