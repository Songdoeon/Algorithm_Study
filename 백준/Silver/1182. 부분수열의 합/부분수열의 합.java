import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int sum = Integer.parseInt(st.nextToken());

		int count = 1 << N;
		int answer = 0;
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int total;
		for(int i = 1; i < count; i++) {
			total = 0;
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) == (1 << j)) {
					total += arr[j];
				}
			}
			if(total == sum)answer++;
		}
		System.out.println(answer);
	}
}