import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new long[N + 1][2];
        long sum = 0;
        for(int i = 1; i <= N ;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
            sum +=  arr[i - 1][0] * arr[i][1] - arr[i][0] * arr[i - 1][1];
        }
        sum += arr[N][0] * arr[1][1] - arr[N][1] * arr[1][0];
        sum = Math.abs(sum);
        if(sum%2 == 1) {
            System.out.println(sum/2 + ".5");
        }else {
            System.out.println(sum/2 + ".0");
        }
    }
}

