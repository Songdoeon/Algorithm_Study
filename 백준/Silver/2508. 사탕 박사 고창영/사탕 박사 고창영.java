import java.io.*;
import java.util.*;
class Main {
    static int T, N, M;

    static int[] row = {'<', 'o', '>'};
    static int[] column = {'^', 'o', 'v'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        char[][] map;
        for (int t = 0; t < T; t++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int cnt = 0;
            map = new char[N][M];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == row[0] &&
                            j >= 2  &&
                            map[i][j - 1] == row[1] &&
                            map[i][j - 2] == row[2]) cnt++;
                    else if(map[i][j] == column[0] &&
                            i >= 2  &&
                            map[i - 1][j] == column[1] &&
                            map[i - 2][j] == column[2]) cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}