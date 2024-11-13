import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		int n = 0;
		int m = 0;
		
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == ':') {
				n++;
			}
			
			if(a.charAt(i) == '_') {
				m++;
			}
		}
		int total = a.length() + n + m * 5;
		System.out.println(total);
		sc.close();
	}
}