import java.util.*;
import java.io.*;

class Node{
	int des;
	int cost;
	
	Node(int des, int cost){
		this.des = des;
		this.cost = cost;
	}
}

public class Main {
	static List<List<Node>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		int start = Integer.parseInt(br.readLine());
		int[] costs = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
		Arrays.fill(costs, 200000);
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(n1).add(new Node(n2, cost));
		}
		queue.add(new Node(start, 0));
		costs[start] = 0;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
            if(visited[node.des]) continue;
            visited[node.des] = true;
			for(Node nextNode : list.get(node.des)) {
				if(costs[nextNode.des] > costs[node.des] + nextNode.cost) {
					costs[nextNode.des] = costs[node.des] + nextNode.cost;
					queue.add(new Node(nextNode.des, costs[nextNode.des]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			if(costs[i] == 200000) sb.append("INF").append('\n');
			else sb.append(costs[i]).append('\n');
		}
		bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
}