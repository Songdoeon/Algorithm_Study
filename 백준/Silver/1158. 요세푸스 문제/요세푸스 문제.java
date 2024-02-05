import java.io.*;
import java.util.*;
public class Main {	
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		sb.append("<");
		for(int i = 1; i <= N; i++) {

			arr[i - 1] = i;
		}

		int idx = 0;
		for (int i = 0; i < N - 1; i++) {
			idx = (idx + M - 1) % (N - i);
            sb.append(arr[idx]).append(", ");
            System.arraycopy(arr, idx + 1, arr, idx, N - i - idx - 1);
        }
		sb.append(arr[0]);
		sb.append(">");
		System.out.println(sb);
	}

}
