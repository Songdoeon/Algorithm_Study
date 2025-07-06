import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			System.out.println(String.format("%.1f", Math.abs(b - a)));
		}
	}
}