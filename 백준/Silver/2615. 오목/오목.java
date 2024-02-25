import java.io.*;
import java.util.*;
public class Main {

	static int[] dx = {1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1};
	static int[][] map;
	static int[] point;
	static int win = 0;
	static int cur;
	static boolean outOfMap(int x, int y) {
		if(x < 0 || x >= 19 || y < 0 || y >= 19) return true;
		return false;
	}
	static void search(int depth, int x, int y, int target, int dir) {
		if(outOfMap(x, y)) return ;
		cur = map[x][y];
		if(cur == 0 || cur != target) return ;
		if(depth == 5 && cur == target) {
			if(!outOfMap(x + dx[dir], y + dy[dir]) &&
					map[x + dx[dir]][y + dy[dir]] == cur) return ;
			if(!outOfMap(x - (dx[dir] * 5), y - (dy[dir] * 5)) &&
					map[x - (dx[dir] * 5)][y - (dy[dir] * 5)] == cur) return ;
			point = new int[] {x - (dx[dir] * 4) + 1, y - (dy[dir] * 4) + 1};
			win = target;
		}
		if(depth == 6) return ;
		search(depth + 1, x + dx[dir], y + dy[dir], target, dir);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		map = new int[19][19];
		
		for(int i = 0; i < 19; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				for(int k = 0; k < 4; k++) {
					search(1, i, j, map[i][j], k);
				}
			}
		}
		System.out.println(win);
		if(win != 0) bw.write(point[0] + " " + point[1]);
		bw.flush();
		bw.close();
		br.close();
	}
}