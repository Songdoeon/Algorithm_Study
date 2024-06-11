import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		HashMap<String, Integer> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int N = Integer.parseInt(br.readLine());
			int num = 0;
			while(N-->0) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				int id = Integer.parseInt(st.nextToken());
				int idx = num;
				if(map.containsKey(s)) {
					idx = map.get(s);
					if(list.get(idx)>id) list.set(idx, id);
				}
				else {
					map.put(s, idx);
					list.add(id);
					num++;
				}
			}
			Collections.sort(list);
			for(int m : list) sb.append(m).append(" ");
			sb.append("\n");
			map.clear();
			list.clear();
		}
		System.out.print(sb);
	}
}
