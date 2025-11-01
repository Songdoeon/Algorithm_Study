import java.util.Scanner;

public class Main {	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		int c=scanner.nextInt();
		int k=scanner.nextInt();
		int p=scanner.nextInt();
		
		int num=0;
		
		for(int i=1;i<c+1;i++) {
			num=num+(k*i)+p*(i*i);
		}
		System.out.println(num);
    }
}