import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	static int N,M;
	static char[] dna;
	static int[] count;
	static char[] str;
	static boolean check() {
		for(int i = 0; i < 4; i++) {
			if(count[i] > 0) return false;
		}
		return true;
	}
	static void plus(int idx) {
		switch(str[idx]) {
			case 'A' : count[0]--;break;
			case 'C' : count[1]--;break;
			case 'G' : count[2]--;break;
			case 'T' : count[3]--;break;
		}
	}
	static void minus(int idx) {
		switch(str[idx]) {
		case 'A' : count[0]++;break;
		case 'C' : count[1]++;break;
		case 'G' : count[2]++;break;
		case 'T' : count[3]++;break;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dna = new char[] {'A', 'C', 'G', 'T'};
		count = new int[4];
		int start = 0;
		int end = M;
		int answer = 0;
		str = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < M; i++) {
			plus(i);
		}
		if(check()) answer++;
		while(end < N) {
			plus(end++);
			minus(start++);
			if(check()) answer++;
		}
		System.out.println(answer);
	}
}