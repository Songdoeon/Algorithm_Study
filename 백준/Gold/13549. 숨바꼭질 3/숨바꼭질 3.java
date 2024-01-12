import java.io.*;
import java.util.*;

class Node {
	public int position;
	public int time;

	public Node (int position, int time) {
		this.position = position;
		this.time = time;
	}
}

public class Main {
	static int n, k;
	static int minTime;	

	static final int MAX_POSITION = 100_000;
	static final int INF = 100_000;
	static int[] time = new int[MAX_POSITION + 1];
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);

	static void dijkstra() {

		Arrays.fill(time, INF);
		time[n] = 0;
		pq.add(new Node(n, 0));

		while (!pq.isEmpty()) {
			Node current = pq.remove();


			if (time[current.position] < current.time)
				continue;

			int np1 = current.position - 1;

			if (isValid(np1) && time[np1] > current.time + 1) {
				time[np1] = current.time + 1;
				pq.add(new Node(np1, time[np1]));
			}

			int np2 = current.position + 1;
			if (isValid(np2) && time[np2] > current.time + 1) {
				time[np2] = current.time + 1;
				pq.add(new Node(np2, time[np2]));
			}

			int np3 = current.position * 2;
			if (isValid(np3) && time[np3] > current.time) {
				time[np3] = current.time;
				pq.add(new Node(np3, time[np3]));
			}
		}
	}

	static boolean isValid(int position) {
		return 0 <= position && position <= MAX_POSITION;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
		);
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		if (n >= k)
			minTime = n - k;
		else {
			dijkstra();
			minTime = time[k];
		}

		System.out.println(minTime);
	}
}