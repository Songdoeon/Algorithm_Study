import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	static int N,M;
	static char[] dna;
	static int[] count = new int[26];
	static char[] str;
	static boolean check() {
		return count[0] <= 0 && count[2] <= 0 && 
				count[6] <= 0 && count[19] <= 0;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dna = new char[] {'A', 'C', 'G', 'T'};
		int start = 0;
		int end = M;
		int answer = 0;
		str = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());

		count[0] = Integer.parseInt(st.nextToken());
		count[2] = Integer.parseInt(st.nextToken());
		count[6] = Integer.parseInt(st.nextToken());
		count[19] = Integer.parseInt(st.nextToken());
		for(int i = 0; i < M; i++) {
			count[str[i]-'A']--;
		}
		if(check()) answer++;
		while(end < N) {
			count[str[end++] - 'A']--;
			count[str[start++] - 'A']++;
			if(check()) answer++;
		}
		System.out.println(answer);
	}
}