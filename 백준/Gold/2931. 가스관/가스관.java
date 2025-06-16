import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[][][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M][4];
        char[][] grid = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                grid[i][j] = c;
                make(i, j, c);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] != '.') continue;

                boolean[] need = new boolean[4];
                int cnt = 0;

                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    if(outOfMap(nx, ny))continue;
                    if (map[nx][ny][(d + 2) % 4]) {
                        need[d] = true;
                        cnt++;
                    }
                }

                if (cnt >= 2) {
                    char c = get(need);
                    System.out.println((i + 1) + " " + (j + 1) + " " + c);
                    return ;
                }
            }
        }
    }

    static void make(int i, int j, char c) {
        switch (c) {
            case '|':
                map[i][j][0] = true;
                map[i][j][2] = true;
                break;
            case '-':
                map[i][j][1] = true;
                map[i][j][3] = true;
                break;
            case '1':
                map[i][j][0] = true;
                map[i][j][1] = true;
                break;
            case '2':
                map[i][j][2] = true;
                map[i][j][1] = true;
                break;
            case '3':
                map[i][j][2] = true;
                map[i][j][3] = true;
                break;
            case '4':
                map[i][j][0] = true;
                map[i][j][3] = true;
                break;
            case '+':
                for (int d = 0; d < 4; d++) map[i][j][d] = true;
                break;
        }
    }

    static char get(boolean[] need) {
        if (need[0] && need[1] && need[2] && need[3]) return '+';
        if (need[0] && need[2]) return '|';
        if (need[1] && need[3]) return '-';
        if (need[0] && need[1]) return '1';
        if (need[1] && need[2]) return '2';
        if (need[2] && need[3]) return '3';
        return '4';
    }

    static boolean outOfMap(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }
}
