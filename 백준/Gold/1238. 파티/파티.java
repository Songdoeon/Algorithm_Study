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
	static Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
	static List<List<Node>> list = new ArrayList<>();
	static int N, M, des;
	static int[] goCosts;
	static int[] backCosts;

	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		des = Integer.parseInt(st.nextToken());
		int start, end, cost;
		boolean[] visited;
		
		goCosts = new int[N + 1];
		backCosts = new int[N + 1];
		int[] costs = new int[N + 1];
		Arrays.fill(costs, 1000000);
		Arrays.fill(goCosts, 1000000);
		Arrays.fill(backCosts, 1000000);
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			list.get(start).add(new Node(end, cost));
		}
		for(int i = 1; i <= N; i++) {
			queue.add(new Node(i, 0));
			Arrays.fill(costs, 1000000);
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				
				for(Node nextNode : list.get(node.des)) {
					if(costs[nextNode.des] > node.cost + nextNode.cost) {
						costs[nextNode.des] = node.cost + nextNode.cost;
						queue.add(new Node(nextNode.des, costs[nextNode.des]));
					}
				}
			}
			costs[i] = 0;
			goCosts[i] = costs[des]; 
		}
		queue.add(new Node(des, 0));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(Node nextNode : list.get(node.des)) {
				if(backCosts[nextNode.des] > node.cost + nextNode.cost) {
					backCosts[nextNode.des] = node.cost + nextNode.cost;
					queue.add(new Node(nextNode.des, backCosts[nextNode.des]));
				}
			}
		}
		
		int[] resultArr = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			resultArr[i] = goCosts[i] + backCosts[i];
		}
		int max = Arrays.stream(resultArr, 1, N + 1).max().getAsInt();
		System.out.println(max);
		br.close();
	}
}