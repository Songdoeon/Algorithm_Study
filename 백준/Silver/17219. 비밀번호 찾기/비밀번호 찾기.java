import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, String> map = new HashMap<>(2 * N);
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			String s = br.readLine();
			sb.append(map.get(s)).append("\n");
		}
		System.out.println(sb);
	}
}
