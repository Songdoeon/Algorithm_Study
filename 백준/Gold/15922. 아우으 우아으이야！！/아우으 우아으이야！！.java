import java.io.*;
import java.util.*;

// 2170 : 16:42 시작

public class Main {
    static int N;
    static int[][] info;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        info = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(info, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int end = info[0][1];
        int ans = info[0][1] - info[0][0];
        for (int i = 1; i < N; i++) {
            int s = info[i][0];
            int e = info[i][1];
            if(end <= s){
                ans += e - s;
                end = e;
            }
            else if(end < e){
                ans += e - end;
                end = e;
            }
        }
        System.out.println(ans);
    }
}

