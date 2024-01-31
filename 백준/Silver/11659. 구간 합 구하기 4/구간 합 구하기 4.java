import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start =Integer.parseInt(st.nextToken());
			int end =Integer.parseInt(st.nextToken());

			sb.append(arr[end] - arr[start - 1]).append('\n');
		}
		System.out.println(sb);
	}
}