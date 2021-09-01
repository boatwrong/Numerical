import java.util.Scanner;

public class Driver {
	public static void main(String[] args)
	{
		
		Scanner in = new Scanner(System.in);
		System.out.println("Input the size of the array");
		int h = in.nextInt();

		double[][] arr = new double[h][h];
		double[] answers = new double[h];
		
		Test test = new Test(arr, answers, h);
		
		for(int i = 0; i <h; i++)
		{
			for(int j = 0; j<h; j++)
			{
				test.inputArr(i, j, in.nextDouble());
			}
		}
		
		for(int j = 0; j<h; j++)
		{
			test.inputAnswers(j, in.nextDouble());
		}
		
		
		test.flipArr();
		test.printArr();
		
		in.close();
	}

}
