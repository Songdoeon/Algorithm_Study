import java.util.*;
import java.io.*;

class Main{
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[10_001];
        boolean[] isExist = new boolean[10_001];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int floor1 = Integer.parseInt(st.nextToken());
            int floor2 = Integer.parseInt(st.nextToken());
            isExist[floor1] = true;
            isExist[floor2] = true;
            arr[floor1] = arr[floor2] = i;

        }
        int f = N % (2 * M);
        if(f == 0) f = 2 * M;
        int ans = 0;
        int idx = 1;
        while (ans != f){
            if(isExist[idx++]){
                ans++;
            }
        }
        System.out.println(arr[idx - 1]);
    }
}