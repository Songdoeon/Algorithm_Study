import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
    int x, y;
    int t;

    public Node(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}
public class Main {
    static int N, M, T;
    static Node[] nodes;
    static int[][] map;
    static boolean[] visited = new boolean[100_001];

    static int getDis(Node n1, Node n2) {
        int dis =  Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
        if(n1.t == 1 && n2.t == 1 && dis > T) return T;
        return dis;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        nodes = new Node[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(s, e, t);
            for (int j = 1; j <= i; j++) {
                int d = getDis(nodes[j], nodes[i]);
                map[i][j] = map[j][i] = d;
            }
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if(i == j) continue;
                    int d = map[i][k] + map[k][j];
                    if(d < map[i][j]) {
                        map[i][j] = d;
                        map[j][i] = d;
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(map[x][y]).append("\n");
        }

        System.out.println(sb);
    }
}
