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

	static int max = 0;
	static int N;
	static Node node;
	static boolean[] visited;
	static void search(Node tempNode, int tempMax) {
		if(max < tempMax) {
			max = Math.max(max, tempMax);
			node = tempNode;
		}

		for(Node nextNode : list.get(tempNode.des)) {
			if(visited[nextNode.des]) continue;
			visited[nextNode.des] = true;
			search(nextNode, tempMax + nextNode.cost);
			visited[nextNode.des] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int n1, n2, cost;
		max = 0;
		visited = new boolean[N + 1];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			n1 = Integer.parseInt(st.nextToken());
			while((n2 = Integer.parseInt(st.nextToken())) != -1) {
				cost = Integer.parseInt(st.nextToken());
				list.get(n1).add(new Node(n2, cost));
			}
		}
		node = new Node(1, 0);
		
		Arrays.fill(visited, false);
		visited[1] = true;
		search(node, 0);

		Arrays.fill(visited, false);
		visited[node.des] = true;
		search(node, 0);

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
		br.close();
	}
}