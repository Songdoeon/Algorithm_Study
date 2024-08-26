import java.io.*;

import java.util.*;

class Main {
    static int N, M, K;
    static char[] candidates = {'P', 'S', 'R'};
    static String[] friends;
    static boolean[] dead;
    static int ans = 100_000_000;
    static char[] chars;
    static String answer = "";
    static void search(int depth, int cnt){
        if(depth > ans) return ;
        if(cnt == 0) return ;
        if(cnt <= K) {
            ans = depth;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                sb.append(chars[i]);
            }
            answer = sb.toString();
            return ;
        }
        if(depth == M) return ;
        for (int i = 0; i < 3; i++) {
            int temp = 0;
            chars[depth] = candidates[i];
            boolean[] cur = new boolean[N];
            for(int j = 0; j < N; j++){
                if(dead[j]) continue;
                if(friends[j].charAt(depth) != candidates[(i + 1) % 3]){
                    dead[j] = true;
                    cur[j] = true;
                    temp++;
                }
            }
            search(depth + 1, cnt - temp);
            for (int j = 0; j < N; j++) {
                if(cur[j] && friends[j].charAt(depth) != candidates[(i + 1) % 3]){
                    dead[j] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        friends = new String[N];
        dead = new boolean[N];
        chars = new char[M];

        for (int i = 0; i < N; i++) {
            friends[i] = br.readLine();
        }
        search(0, N);
        if(ans != 100_000_000) {
            System.out.println(ans + "\n" + answer);
        }
        else {
            System.out.println(-1);
        }
    }
}