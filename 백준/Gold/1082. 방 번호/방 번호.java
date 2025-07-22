import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1082

public class Main {
    static int N, M, len;
    static int min, minZero;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    static void search(int idx, int sum){
        if(idx >= len) return ;

        int change = len - idx - 1;
        for (int i = 0; i < N; i++) {
            if(idx == 0 && arr[i][1] == 0 && len > 0) continue;
            int c = arr[i][0];

            if(sum + c + change * min > M) continue;
            sb.append(arr[i][1]);
            search(idx + 1, sum + c);
            break;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        min = 51;
        minZero = 51;
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
            min = Math.min(min, arr[i][0]);
            if(i != 0) minZero = Math.min(minZero, arr[i][0]);
        }
        M = Integer.parseInt(br.readLine());
        if(minZero > M){
            System.out.println(0);
            return ;
        }
        len = (M - minZero) / min + 1;
        Arrays.sort(arr, (a, b) ->  b[1] - a[1]);
        search(0, 0);

        System.out.println(sb);
    }
}