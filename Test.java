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
	private double[] answers;
	
	public Test(double[][] arr, double[] answers, int h)
	{
		this.arr = arr;
		this.answers = answers;
		this.h = h;
	}

	public void setArr() 
	{
		for(int i = 0; i <h; i++)
		{
			for(int j = 0; j<h; j++)
			{
				this.arr[i][j] = i + j;
			}
		}
	}
	
	public void inputAnswers(int i, double value)
	{
		this.answers[i] = value;
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
			for(int j=i+1; j<h; j++) // iterate through rows to be modified
			{
				double m = (arr[j][i] / arr[i][i]);
				
				for(int k=i; k<h; k++) // iterate through columns to modify elements
				{
					this.arr[j][k] = this.arr[j][k] - m * this.arr[i][k];
				}
				
			}
		}
		return this.arr;
	}
	
	public double[] backSub()
	{
		return null;
	}
	
	public void printArr()
	{
		for(int i = 0; i <h; i++)
		{
			for(int j = 0; j<h; j++)
			{
				System.out.print(arr[i][j] + " ");
			}
			
			System.out.println(" = " + answers[i]);
			
			System.out.println();
		}
	}
	
	

}
