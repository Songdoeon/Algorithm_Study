import java.util.*;
import java.io.*;

public class Solution {
	// 1 오른쪽 2 왼쪽 3 위
	static int[] dx = {0, 0, -1};
	static int[] dy = {1, -1,  0};
	static boolean[][] visited = new boolean[101][101];
	static int[][] map;
	static boolean outOfMap(int x, int y) {
		if(x < 1 || y < 1 || x > 100 || y > 100) return true;
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] charArr;
		int[] start = new int[2];
		
		for(int t = 1; t <= 10; t++) {
		br.readLine();
		map = new int[101][101];
             visited = new boolean[101][101];
			for(int i = 1; i <= 100; i++) {
				String str = br.readLine().replace(" ", "");
				charArr = str.toCharArray();
				for(int j = 1; j <= 100; j++) {
					map[i][j] = charArr[j - 1] - '0';
					if(map[i][j] == 2) start = new int[] {i, j};
				}
			}
			Queue<int[]> queue = new LinkedList<>();
			queue.add(start);
			int answer = 0;
			while(!queue.isEmpty()) {
				int[] point = queue.poll();
				if(point[0] == 1) answer = point[1] - 1;
				for(int i = 0; i < 3; i++) {
					int nx = point[0] + dx[i];
					int ny = point[1] + dy[i];
					if(outOfMap(nx, ny) || visited[nx][ny]) continue;
					if(map[nx][ny] == 1) {
						visited[nx][ny]= true;
						queue.add(new int[] {nx, ny});
						break;
					}
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}
}
