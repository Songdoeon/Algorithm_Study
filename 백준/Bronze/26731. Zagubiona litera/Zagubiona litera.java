import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		char[] b = new char[26];
		
		for(int i = 0; i < 26; i++) {
			b[i] = (char)(65 + i);
		}
		
		int i, j;
		for(i = 0; i < b.length; i++) {
			for(j = 0; j < a.length(); j++) {
				if(b[i] == a.charAt(j)) {
					break;
				}
			}
			
			if(j == a.length()) {
				System.out.println(b[i]);
			}
		}
		sc.close();
	}
}