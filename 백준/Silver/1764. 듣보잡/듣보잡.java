import java.io.*;
import java.util.*;

public class Main {

	
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		int answer = 0;
		for(int i = 0; i < N; i++) {
			set1.add(br.readLine());
		}
		for(int i = 0; i < M; i++) {
			set2.add(br.readLine());
		}
		set1.retainAll(set2);
		List<String> list = new ArrayList<>(set1);
		list.sort((s1, s2) -> s1.compareTo(s2));
		for(String name : list) {
			sb.append(name).append('\n');
		}
		bw.write(String.valueOf(set1.size()));
		bw.newLine();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}

