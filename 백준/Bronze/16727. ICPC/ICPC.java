import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int p1 = sc.nextInt();
		int s1 = sc.nextInt();
		int s2 = sc.nextInt();
		int p2 = sc.nextInt();
		
		if(p1 + p2 > s1 + s2) {
			System.out.println("Persepolis");
		}else if(p1 + p2 < s1 + s2) {
			System.out.println("Esteghlal");
		}else {
			if(s1 > p2) {
				System.out.println("Esteghlal");
			}else if(p2 > s1) {
				System.out.println("Persepolis");
			}else {
				System.out.println("Penalty");
			}
		}
		sc.close();
	}
}