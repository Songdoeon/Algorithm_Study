import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int[] alpha = new int[26];
		for(int i=0; i<line.length(); i++) {
			int idx = line.charAt(i) - 'A';
			alpha[idx]++;
		}
		
		int isOne =0;
		for(int i=0; i<alpha.length; i++) if(alpha[i] % 2 != 0) isOne++;
		
		StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
		if(isOne > 1) System.out.println("I'm Sorry Hansoo");
		else {
			for(int i=0; i < 26; i++) {
				for(int r = 0; r < alpha[i]/2; r++) {
					sb.append((char)(i + 65));
                    sb2.append((char)(i + 65));
				}
			}
			sb2.reverse();

			for(int i=0; i<alpha.length; i++) {
				if(alpha[i]%2 == 1) {
					sb.append((char)(i+65));
				}
			}
			sb.append(sb2);
		    System.out.println(sb);
		}

	}
		
}