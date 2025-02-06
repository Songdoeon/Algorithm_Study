import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		
		double total = (a / 1000000) * 2 * 229 * 324 + (b / 1000000) * 2 * 297 * 420 + (c / 1000000) * 210 * 297;
		
		System.out.println(String.format("%.6f", total));
		sc.close();
	}
}