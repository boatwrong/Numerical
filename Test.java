
public class Test {
	private int h;
	private double[][] gauss;
	private double[] answers;
	private double[] results;
	
	
	public Test(double[][] gauss, double[] answers, double[] results, int h)
	{
		this.gauss = gauss;
		this.answers = answers;
		this.h = h;
		this.results = results;
		
		for(int i = 0; i<h; i++)
		{
			results[i] = 0;
		}
	}

	public void setGauss() 
	{
		for(int i = 0; i <h; i++)
		{
			for(int j = 0; j<h; j++)
			{
				this.gauss[i][j] = i + j;
			}
		}
	}
	
	public void inputAnswers(int i, double value)
	{
		this.answers[i] = value;
	}
	
	public void inputGauss(int i, int j, double value)
	{
		this.gauss[i][j] = value;
	}
	
	public double[][] flipGauss()
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
				double m = (gauss[j][i] / gauss[i][i]);
				
				for(int k=i; k<h; k++) // iterate through columns to modify elements
				{
					gauss[j][k] = gauss[j][k] - m * gauss[i][k];
				}
				answers[j] = answers[j] -  m * answers[i];	
				
			}
		}
		return gauss;
	}
	
	public double[] backSub()
	{	
		/*
		
		results[h-1] = answers[h-1] / gauss[h-1][h-1];
		
		results[h-2] = (answers[h-2] - results[h-1] * gauss[h-2][h-1]) / gauss[h-2][h-2];
		
		results[h-3] = (answers[h-3] - results[h-2] * gauss[h-3][h-2] - results[h-1] * gauss[h-3][h-1]) / gauss[h-3][h-3];
		
		results[h-4] = (answers[h-4] - results[h-3] * gauss[h-4][h-3] - results[h-2] * gauss[h-4][h-2] - results[h-1] * gauss[h-4][h-1]) / gauss[h-4][h-4];
		
		*/
		
		results[h-1] = answers[h-1] / gauss[h-1][h-1];
		
		for(int g = h-2; g>=0; g--)
		{
			for(int i=g+1; i<h; i++)
			{
				results[g] += (results[i] * gauss[g][i]);
			}
			
			answers[g] -= results[g];
			
			results[g] = answers[g] / gauss[g][g];
		}
		
		return results;
	}
	
	public void printGauss()
	{
		for(int i = 0; i <h; i++)
		{
			for(int j = 0; j<h; j++)
			{
				System.out.print(gauss[i][j] + " ");
			}
			
			System.out.println(" = " + answers[i]);
			
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	
	public void printResults()
	{
		int z = 1;
		for(int j = 0; j<h; j++)
		{
			System.out.println("x" + z + " = " + results[j]);
			z++;
		}
	}
	
	public static void greeting()
	{
		System.out.println("This is a linear systems of equation solver");
		System.out.println("\nTo input an equation to solve, follow the following format");
		System.out.println("\n*** must be a \"square\" system of equations");
		System.out.println("\nFor example, a 3 equation, 3 unknown system of equations.");

		System.out.println("\n\nex.\nAx + By + Cz = d");
		System.out.println("Dx + Ey + Fz = g\nHx + Iy + Jz = k");
		System.out.println("To solve for x,y,z of the above system of equations,\n enter the following following");
		System.out.println("(size of matrix is 3x3 so 3 is size\n\n3\nA B C\nD E F\nH I J\nd g k");
		System.out.println("\n\nThat is the size, followed by the first row of coefficents,\n continuing through "
				+ "each row of coeffieients\nfinishing with the constants on the right side of each equation");
		
	}
	
	public void run()
	{
		printGauss();
		flipGauss();
		printGauss();
		backSub();
		printResults();
	}
	
	

}
