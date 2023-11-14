import java.util.*;
import java.io.*;
class Solution{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int T;
		T=Integer.valueOf(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++){
			String[] arr = br.readLine().split(" ");
            double[] arg = Arrays.stream(arr).mapToDouble(i -> Double.valueOf(i)).toArray();
            
			double num1 = (arg[2] + arg[0]) / 2;
            double answer = Math.abs(num1 - arg[1]);
			System.out.println("#"+test_case+" "+ answer);
		}
	}
}