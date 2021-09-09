import java.util.Scanner;

public class Driver {
	public static void main(String[] args)
	{
		
		System.out.println("Testing Source Control in vscode");
		System.out.println("x");
		
		Scanner in = new Scanner(System.in);
		Test.greeting();
		int h = in.nextInt();

		double[][] arr = new double[h][h];
		double[] answers = new double[h];
		double[] results = new double[h];
		
		Test test = new Test(arr, answers, results, h);
		
		for(int i = 0; i <h; i++)
		{
			for(int j = 0; j<h; j++)
			{
				test.inputGauss(i, j, in.nextDouble());
			}
		}
		
		for(int j = 0; j<h; j++)
		{
			test.inputAnswers(j, in.nextDouble());
		}
		
		test.printGauss();
		test.flipGauss();
		test.printGauss();
		
		test.backSub();
		
		test.printResults();
		
		
		in.close();

	}

}
