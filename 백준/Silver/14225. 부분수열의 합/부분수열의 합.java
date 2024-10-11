import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] cnt = new int[20_000_001];
    static void search(int depth, int sum){
        if(depth == N) {
            cnt[sum]++;
            return ;
        }
        search(depth+1, sum + arr[depth]);
        search(depth+1, sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        search(0, 0);

        for (int i = 1; i < 20_000_001; i++) {
            if(cnt[i] == 0) {
                System.out.println(i);
                return ;
            }
        }
    }
}