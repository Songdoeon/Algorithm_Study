import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        Arrays.fill(arr, 2);
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) continue;
            for (int j = i; j <= n; j += i) {
                if(arr[j] == 0) continue;
                arr[j] = 0;
                if (--m == 0) {
                    System.out.print(j);
                    return;
                }
            }
        }
    }
}
