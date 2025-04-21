import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int ds = sc.nextInt();
		int ys = sc.nextInt();
		int dm = sc.nextInt();
		int ym = sc.nextInt();
		
		int s = ys - ds;
		int m = ym - dm;
		
		while(s != m) {
			if(s < m) {
				s += ys;
			}else {
				m += ym;
			}
		}
		System.out.println(s);
		sc.close();
	}
}