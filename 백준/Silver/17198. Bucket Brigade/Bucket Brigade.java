import java.io.*;
import java.util.*;

public class Main {
    static char[][] graph = new char[10][10];
    static boolean[][] visited = new boolean[10][10];
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static Queue<int[]> queue = new LinkedList<>();
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 10; i++) {
            String input = br.readLine();
            for (int j = 0; j < 10; j++) {
                graph[i][j] = input.charAt(j);
                if (graph[i][j] == 'L') {
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        bfs();
        System.out.println(answer - 1); // B 제외하고 출력해줘야함


    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int cows = tmp[2];
            if (graph[x][y] == 'B') {
                answer = Math.min(answer, cows);
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < 10 && ny >= 0 && ny < 10) { // graph 내부안에서만 가능
                    if (!visited[nx][ny]) { // 방문하지 않은 지역
                        if (graph[nx][ny] != 'R') { // 돌이 있을 경우 돌아가야함
                            visited[nx][ny] = true; // 방문한곳으로 표시
                            queue.add(new int[]{nx, ny, cows + 1}); // 소의 개수를 1씩 늘림
                        }
                    }
                }
            }
        }
    }
}