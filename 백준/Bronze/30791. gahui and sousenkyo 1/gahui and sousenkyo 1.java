import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] a = new int[5];
		for(int i = 0; i < 5; i++) {
			a[i] = sc.nextInt();
		}
		
		int count = 0;
		for(int i = 1; i < 5; i++) {
			if(a[0] - a[i] <= 1000) {
				count++;
			}
		}
		System.out.println(count);
		sc.close();
	}
}