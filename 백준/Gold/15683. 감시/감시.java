import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Pos {
    int x, y, type;

    public Pos(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.type = t;
    }
}

public class Main {
    static int N, M, cam;
    static int[][] map, tempMap;
    static int result = 64;
    static List<Pos> cameraList;

    static void search(int depth, String type, String mask) {
        if (depth == cam) {
            for (int i = 0; i < depth; i++) {
                int camType = type.charAt(i) - '0';
                int camMask = mask.charAt(i) - '0';
                switch (camType) {
                    case 1:
                        seeing1(cameraList.get(i), camMask);
                        break;
                    case 2:
                        seeing2(cameraList.get(i), camMask);
                        break;
                    case 3:
                        seeing3(cameraList.get(i), camMask);
                        break;
                    case 4:
                        seeing4(cameraList.get(i), camMask);
                        break;
                    case 5:
                        seeing5(cameraList.get(i));
                        break;
                }
            }

            result = Math.min(countMap(), result);
            backToMap();
            return;
        }
        for (int j = 1; j <= (cameraList.get(depth).type == 5 ? 1 :
                                cameraList.get(depth).type == 2 ? 2 : 4); j++) {
            search(depth + 1, type + cameraList.get(depth).type, mask + j);
        }
    }

    static int countMap() {
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M ;j++){
                if(tempMap[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    static void backToMap() {
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, tempMap[i], 0, M);
        }
    }

    static void markVisibility(int x, int y, int dx, int dy, int dir) {
        while (!outOfMap(x, y) && map[x][y] != 6) {
            if(map[x][y] > 0 && map[x][y] < 6){

            }
            else if (map[x][y] == 0) {
                tempMap[x][y] = 7;
            }
            x += dx;
            y += dy;
        }
    }

    static void seeing4(Pos pos, int dir) {
        int x = pos.x, y = pos.y;

        if (dir == 1) {
            markVisibility(x, y + 1, 0, 1, 1);
            markVisibility(x + 1, y, 1, 0, 2);
            markVisibility(x, y - 1, 0, -1, 3);
        } else if (dir == 2) {
            markVisibility(x + 1, y, 1, 0, 1);
            markVisibility(x, y + 1, 0, 1, 2);
            markVisibility(x - 1, y, -1, 0, 3);
        } else if (dir == 3) {
            markVisibility(x, y + 1, 0, 1, 1);
            markVisibility(x - 1, y, -1, 0, 3);
            markVisibility(x, y - 1, 0, -1, 2);
        } else if (dir == 4) {
            markVisibility(x + 1, y, 1, 0, 1);
            markVisibility(x, y - 1, 0, -1, 3);
            markVisibility(x - 1, y, -1, 0, 2);
        }
    }

    static void seeing5(Pos pos) {
        int x = pos.x, y = pos.y;
        markVisibility(x + 1, y, 1, 0, 1);
        markVisibility(x - 1, y, -1, 0, 2);
        markVisibility(x, y + 1, 0, 1, 3);
        markVisibility(x, y - 1, 0, -1, 4);
    }

    static void seeing3(Pos pos, int dir) {
        int x = pos.x, y = pos.y;

        if (dir == 1) {
            markVisibility(x + 1, y, 1, 0, 2);
            markVisibility(x, y + 1, 0, 1, 1);
        } else if (dir == 2) {
            markVisibility(x + 1, y, 1, 0, 1);
            markVisibility(x, y - 1, 0, -1, 2);
        } else if (dir == 3) {
            markVisibility(x - 1, y, -1, 0, 3);
            markVisibility(x, y + 1, 0, 1, 1);
        } else if (dir == 4) {
            markVisibility(x - 1, y, -1, 0, 1);
            markVisibility(x, y - 1, 0, -1, 3);
        }
    }

    static void seeing2(Pos pos, int dir) {
        int x = pos.x, y = pos.y;

        if (dir == 1) {
            markVisibility(x + 1, y, 1, 0, 1);
            markVisibility(x - 1, y, -1, 0, 2);
        } else if (dir == 2) {
            markVisibility(x, y - 1, 0, -1, 1);
            markVisibility(x, y + 1, 0, 1, 2);
        }
    }

    static void seeing1(Pos pos, int dir) {
        int x = pos.x, y = pos.y;

        if (dir == 1) {
            markVisibility(x, y + 1, 0, 1, 1);
        } else if (dir == 2) {
            markVisibility(x, y - 1, 0, -1, 2);
        } else if (dir == 3) {
            markVisibility(x + 1, y, 1, 0, 3);
        } else if (dir == 4) {
            markVisibility(x - 1, y, -1, 0, 4);
        }
    }

    static boolean outOfMap(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        tempMap = new int[N][M];
        cameraList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n >= 1 && n < 6) {
                    cameraList.add(new Pos(i, j, n));
                    cam++;
                }
                map[i][j] = n;
                tempMap[i][j] = n;
            }
        }

        search(0, "", "");
        System.out.println(result);
    }
}