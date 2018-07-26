import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matrix 
{
	public static void main(String[] args)
	{
		String matrixPath = args[0];
		String vectorPath = args[1];
		try
		{
			Scanner s1 = new Scanner(new File(matrixPath));
			Scanner s2 = new Scanner(new File(vectorPath));
			
			while(s1.hasNextLine())
			{
				String matrix = s1.nextLine();
				String vector = s2.nextLine();
				
				MatrixThread t = new MatrixThread(matrix, vector);
				t.start();
				
			}
			
			s1.close();
			s2.close();
	
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File not found!");
		}
	}
	
}
