import java.util.*;
import java.io.*;

class Main {
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[10_001];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;
        arr[5] = 5;
        arr[6] = 7;
        int idx = 1;
        for (int i = 7; i <= 10_000; i++) {
            if(i % 6 == 5) idx++;
            arr[i] = arr[i - 1] + idx;
            if(i % 2 == 0 || i % 3 == 0)arr[i]++;
        }
        while (N-- > 0){
            sb.append(arr[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.println(sb.substring(0, sb.length()));
    }
}