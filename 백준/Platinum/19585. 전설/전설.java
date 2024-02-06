import java.io.*;
import java.util.*;

class Node{
	boolean endPoint;
	Node[] next;
	Node(){
		next = new Node[26];
		endPoint = false;
	}
}
public class Main {	
	static int N, M, K;
	static Set<String> set = new HashSet<>();
	static String team, color, str;
	static char c;
	static int num, len;
	static boolean search(Node n) {
		len = team.length();
		for(int j = 0; j < len; j++) {
			int num = team.charAt(j) - 'a';
			if(n.endPoint && set.contains(team.substring(j))) {
				return true;
			}
			if(n.next[num] == null) return false;	
			n = n.next[num];
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Node root = new Node();
		Node n = null;
		for(int i = 0; i < N; i++) {
			color = br.readLine();
			len = color.length();
			n = root;
			for(int j = 0; j < len; j++) {
				num = color.charAt(j) - 'a';
				if(n.next[num] == null) {
					n.next[num] = new Node();
				}
				n = n.next[num];
				
			}
			n.endPoint = true;
		}
		for(int i = 0; i < M; i++) {
			set.add(br.readLine());
		}
		
		K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			team = br.readLine();
			if(search(root))bw.write("Yes\n");
			else bw.write("No\n");
		}
		
		bw.flush();
		bw.close();
	}
}
