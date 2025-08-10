import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1079

public class Main {
    static int N, I;
    static int[] score;
    static int[][] info;
    static boolean[] visited;
    static int ans = 0;
    static int kill(){
        int ret = -1;
        int point = -1;
        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            if(score[i] > point){
                ret = i;
                point = score[i];
            }
        }
        return ret;
    }

    static void calc(int idx){
        for (int i = 0; i < N; i++) {
            if(visited[i])continue;
            score[i] += info[idx][i];
        }
    }
    static void undo(int idx){
        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;
            score[i] -= info[idx][i];
        }
    }
    static void search(int idx, int cnt){
        if(idx == 1){
            ans = Math.max(ans, cnt);
            return ;
        }
        if(idx % 2 == 0){
            for (int i = 0; i < N; i++) {
                if(i == I) continue;
                if(visited[i])continue;
                visited[i] = true;
                calc(i);
                search(idx - 1, cnt + 1);
                undo(i);
                visited[i] = false;
            }
        }
        else {
            int dead = kill();

            if(dead == I) {
                ans = Math.max(ans, cnt);
                return ;
            }

            visited[dead] = true;
            search(idx - 1, cnt);
            visited[dead] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        score = new int[N];
        info = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        I = Integer.parseInt(br.readLine());

        search(N, 0);

        System.out.println(ans);
    }
}
