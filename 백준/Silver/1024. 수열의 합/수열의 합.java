import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		while(true) {
			int min = N / L - ((L - 1) / 2);
			if(min < 0 || L > 100) {
				sb.append(-1);
				break;
			}
			
			int sum = (min*2+L-1)*L/2;
			
			if(sum == N) {
				for (int i = 0; i < L; i++) sb.append((min+i) + " ");
                break;
			}
			L++;
		}
		System.out.println(sb);
	}

}