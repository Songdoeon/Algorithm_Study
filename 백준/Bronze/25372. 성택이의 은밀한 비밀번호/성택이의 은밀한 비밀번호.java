import java.io.*;

public class Main {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int input;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < N; i++) {
			input = bf.readLine().length();
			
			sb.append(6 <= input && input <= 9 ? "yes\n" : "no\n");
		}
		
		System.out.print(sb);
	}
}