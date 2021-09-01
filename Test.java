import java.util.Scanner;
/*
 * TODO: modify "answer" array
 * 
 * TODO: figure out loops for back substitution
 * 
 * TODO: create array of "variables" that will be solved for
 */

public class Test {
	private double[][] arr; 	// array to be modified
	private double[][] arrCopy; // utility array
	private double[] c;			// "answers" array
	
	private int a;
	
	public Test(int length)
	{
		setLength(length);
	}

	public void setLength(int l)
	{
		a = l;
	}
	public double[][] getArr() {
		return arr;
	}

	public void setArr() {
		for(int i = 0; i <a; i++)
		{
			for(int j = 0; j<a; j++)
			{
				this.arr[i][j] = i + j;
			}
		}
		
	}
	
	private double[][] loopArr()
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
	
	public void printArr(double[][] arr)
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
		int length = in.nextInt();
		
		Test test = new Test(length);
		
		test.setArr();
		test.loopArr();
		test.printArr(test.getArr());
		
		
		
	}

}
