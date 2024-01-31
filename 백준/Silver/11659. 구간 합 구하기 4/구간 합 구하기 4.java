import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] arg = br.readLine().split(" ");
		N = Integer.parseInt(arg[0]);
		M = Integer.parseInt(arg[1]);
		StringTokenizer st;
		int[] arr = new int[N + 1];
		int[] sumArr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sumArr[i] = arr[i] + sumArr[i - 1];
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start =Integer.parseInt(st.nextToken());
			int end =Integer.parseInt(st.nextToken());

			sb.append(sumArr[end] - sumArr[start] + arr[start]).append('\n');
		}
		System.out.println(sb);
	}
}