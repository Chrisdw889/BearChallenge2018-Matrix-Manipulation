import java.util.ArrayList;

public class MatrixThread extends Thread 
{
	String matrix;
	String vector;
	
	public MatrixThread(String matrix, String vector)
	{
		this.matrix = matrix;
		this.vector = vector;
	}
	
	@Override
	public void run()
	{
		String[][] matrix = parseMatrix(this.matrix);
		String[] vector = parseVector(this.vector);
		
		String out = summedOutput(matrix, vector);
		
		System.out.println(out + "\n");
	}
	
	private String[][] parseMatrix(String matrix)
	{
		String[] a = matrix.split("\\], \\[");
		int length = a.length;
		String[][] m = new String[length][length];
		for(int i = 0; i<length; i++) 
		{
			String[] tmp = a[i].split("\\), \\(");
			
			for (int j = 0; j < tmp.length; j++) 
			{
				tmp[j] = tmp[j].replaceAll("[(\\[)*(\\])*(\\()*(\\))*( )*]", "");
			}
			
//			printArr(tmp);
			
			for(int j=0; j<tmp.length; j++)
			{
				String[] tmp2 = tmp[j].split(",");
				int pos = Integer.parseInt(tmp2[0]);
				String val = tmp2[1];
				m[i][pos] = val; 
			}
		}
		
//		printArr(m);
		
		return m;
	}
	
	private String[] parseVector(String vector)
	{
		String[] v = vector.split(", ");
		for (int i = 0; i<v.length; i++) 
		{
			v[i] = v[i].replace("'", "");
			v[i] = v[i].replace("[", "");
			v[i] = v[i].replace("]", "");
		}
		
//		printArr(v);
		
		return v;
	}
	
	private String summedOutput(String[][] matrix, String[] vector)
	{
		int size = matrix.length;
		double[][] dMat = cast(matrix);
		double[] dVec = cast(vector);
		double[][] summedMat = new double[size][size];
		String toReturn = "";
		double sum= 0.0;
		
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				summedMat[i][j] = dMat[i][j] * dVec[j];
			}
		}
		
		for(double[] row : summedMat)
		{
			for(double el : row)
			{
				sum += el;
			}
		}
		
		
		return sum + "";
	}
	
	public void printArr(String[] arr)
	{
		for(String e : arr)
		{
			System.out.println(e);
		}
	}
	
	public double[][] cast(String[][] mat)
	{
		int size = mat.length;
		double[][] newArr = new double[size][size];
		
		for(int i=0; i<size; i++) 
		{
			for(int j=0; j<size; j++)
			{
				if(mat[i][j] == null)
					newArr[i][j] = 0.0;
				else
					newArr[i][j] = Double.parseDouble(mat[i][j]);
			}
		}
		
		return newArr;
	}
	
	public double[] cast(String[] vec)
	{
		int size = vec.length;
		double[] newArr = new double[size];
		
		for(int i=0; i<size; i++)
		{
			newArr[i] = Double.parseDouble(vec[i]);
		}
		
		return newArr;
	}
	
	public String stringMat(double[][] arr)
	{
		String result = "";
		
		for(double[] row : arr)
		{
			for(double e : row)
			{
				result += e + " ";
			}
			result += "\n";
		}
		
		return result;
	}
	
	public void printArr(String[][] arr)
	{
		for(String[] row : arr)
		{
			for(String e : row)
			{
				System.out.print(e + " ");
			}
			System.out.println();
		}
	}
}
