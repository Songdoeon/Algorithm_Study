import java.io.*;
import java.util.*;

class Wall{
	int x;
	int y;
	boolean broken;
	int cnt;
	Wall(int x, int y, boolean broken, int cnt){
		this.x = x;
		this.y = y;
		this.broken = broken;
		this.cnt = cnt;
	}
}
public class Main {
	static int[] dx = {1, 0 , -1, 0};
	static int[] dy = {0, 1 , 0, -1};
	static int N;
	static int M;
	static char[][] map;
	static boolean[][][] visited;
	
	static boolean outOfMap(int x, int y) {
		if(x < 0 || x >= N || y < 0 || y >= M) return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		Queue<Wall> queue = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M][2];
		visited[0][0][0] = true;
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int answer = -1;
		
		queue.add(new Wall(0, 0, false, 1));
		while(!queue.isEmpty()) {
			Wall cur = queue.poll();
			if (cur.x == N-1 && cur.y == M-1) {
				System.out.println(cur.cnt);
				return ;
            }
			for(int i = 0; i < 4; i++) {
				int cX = cur.x + dx[i];
				int cY = cur.y + dy[i];
				if(outOfMap(cX, cY)) continue;
				int next = cur.cnt + 1;
				if(map[cX][cY] == '0') {
					if (!cur.broken && !visited[cX][cY][0]) {
						queue.add(new Wall(cX, cY, false, next));
						visited[cX][cY][0] = true;
					}
					else if (cur.broken && !visited[cX][cY][1]){
						queue.add(new Wall(cX, cY, true, next));
						visited[cX][cY][1] = true;
					}
				}
				else if(map[cX][cY] == '1') {
					if(!cur.broken) {
						queue.add(new Wall(cX, cY, true, next));
						visited[cX][cY][1] = true;
					}
				}
				
			}
		}
		System.out.println(answer);
	}
}