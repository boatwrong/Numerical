import java.util.Scanner;

public class Driver {
	public static void main(String[] args)
	{
		
		Scanner in = new Scanner(System.in);
		System.out.println("Input the size of the array");
		int h = in.nextInt();

		double[][] arr = new double[h][h];
		double[][] arrCopy = new double[h][h];
		
		Test test = new Test(arr, arrCopy, h);
		
		for(int i = 0; i <h; i++)
		{
			for(int j = 0; j<h; j++)
			{
				test.inputArr(i, j, in.nextDouble());
			}
		}
		
		test.flipArr();
		test.printArr();
		
		in.close();
	}

}
