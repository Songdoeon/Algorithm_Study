import java.util.*;
import java.io.*;

class Node{
	int v;
	int cost;
	
	Node(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
}

public class Main {
	static List<List<Node>> graph = new ArrayList<>();
	static int[] costs;
	static final int INF = 200000000;
	static boolean[] visited;
	static int search(int v1, int v2) {
		Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
		Arrays.fill(costs, INF);
		Arrays.fill(visited, false);
		
		costs[v1] = 0;
		
		queue.add(new Node(v1, 0));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int v = node.v;
			int cost = node.cost;
			if(visited[v]) continue;
            if(v == v2)break;
	        visited[v] = true;
			for(Node nextNode : graph.get(v)) {
				if(costs[nextNode.v] > nextNode.cost + cost) {
					costs[nextNode.v] = nextNode.cost + cost;
					queue.add(new Node(nextNode.v, nextNode.cost + cost));
				}
			}
		}
		return costs[v2];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		costs = new int[N + 1];
		Arrays.fill(costs, 200000000);
		
        		 
		for(int i = 0; i <= N; i++) {
	       graph.add(new ArrayList<>());
	    }
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(new Node(v2, cost));
			graph.get(v2).add(new Node(v1, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int line1 = search(1,v1);
		line1 += search(v1,v2);
		line1 += search(v2,N);
		
		int line2 = search(1,v2);
		line2 += search(v2,v1);
		line2 += search(v1,N);
		int answer = Math.min(line1, line2) >= INF ? -1 : Math.min(line1,  line2);
		System.out.println(answer);
	}
}


