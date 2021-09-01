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
	private double[] results;
	
	
	public Test(double[][] arr, double[] answers, double[] results, int h)
	{
		this.arr = arr;
		this.answers = answers;
		this.h = h;
		this.results = results;
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
					arr[j][k] = arr[j][k] - m * arr[i][k];
				}
				
			}
		}
		return arr;
	}
	
	public double[] backSub()
	{
		int a = h;
		a--;
		results[a] = answers[a] / arr[a][a];
		a--;
		results[a] = (answers[a] - results[a+1] * arr[a][a+1]) / arr[a][a];
		a--;
		results[a] = (answers[a] - results[a+1] * arr[a][a+1] - results[a+2] * arr[a][a+2]) / arr[a][a];
		a--;
		results[a] = (answers[a] - results[a+1] * arr[a][a+1] - results[a+2] * arr[a][a+2] - results[a+3] * arr[a][a+3]) / arr[a][a];
		
		return results;
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
	
	public void printResults()
	{
		int z = 1;
		for(int j = 0; j<h; j++)
		{
			System.out.println("x" + z + " = " + results[j]);
		}
	}
	
	

}
