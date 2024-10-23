import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] cnt = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(N == 1) {
            System.out.println(1);
            return ;
        }
        int ans = 1;
        int s = 0;
        int e = 2;
        cnt[arr[0]]++;
        cnt[arr[1]]++;
        int count = 0;
        if(arr[0] == arr[1]) count++;
        else if(arr[0] != arr[1]) count = 2;
        while (e < N) {
            int num = arr[e];
            if(++cnt[num] == 1){
                count++;
            }
            if(count > 2){
                if(--cnt[arr[s++]] == 0){
                    count--;
                }
            }
            ans = Math.max(ans, e - s);
            e++;
        }
        System.out.println(ans + 1);
    }
}


