import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) throws Exception
    {
    	Scanner sc = new Scanner(System.in);
    	int arr[] = new int[10];
    	int sum = 0;
    	for(int i = 0; i < 10; ++i) arr[i] = sc.nextInt();
    	for(int i = 0; i < 10; ++i)
    	{
    		int temp = sum;
    		sum += arr[i];
    		if(sum > 100) 
    		{
    			if(Math.abs(100-temp) >= Math.abs(100-sum)) System.out.print(sum);
    			else System.out.print(temp);
    			System.exit(0);
    		}
    	}
    	System.out.print(sum);
    }
}