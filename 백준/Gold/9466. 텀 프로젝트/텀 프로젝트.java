import java.util.*;
import java.io.*;

class Main{
    static BitSet visited, selected;
    static int[] arr;
    static int ans;
    static void search(int idx){
        if(selected.get(idx)) return ;
        if(visited.get(idx)) {
            selected.set(idx);
            ans++;
        }
        visited.set(idx);
        search(arr[idx]);
        selected.set(idx);
        visited.flip(idx);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            ans = 0;
            arr = new int[N + 1];
            visited = new BitSet(N + 1);
            selected = new BitSet(N + 1);
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i] = n;
            }
            for (int i = 1; i <= N; i++) {
                if(selected.get(i)) continue;
                search(i);
            }
            sb.append(N - ans).append('\n');
        }
        System.out.println(sb);
    }
}