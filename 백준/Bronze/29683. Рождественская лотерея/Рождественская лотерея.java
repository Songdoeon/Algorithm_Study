import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), a = sc.nextInt(), total = 0;
		
		for(int i = 0; i < n; i++) {
			int b = sc.nextInt();
			total += b / a;
		}
		
		System.out.println(total);
		sc.close();
	}
}