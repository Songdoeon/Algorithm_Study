import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int ans = 0;
        int s = 0;
        int e = n - 1;
        while (s < e) {
            int m = arr[s] + arr[e];
            if(m == sum) {
                while (arr[s] == arr[s + 1]){
                    s++;
                    ans++;
                }
                while (arr[e] == arr[e - 1]){
                    e--;
                    ans++;
                }
                ans++;
                s++;
            }
            else if(m < sum) s++;
            else e--;
        }
        System.out.println(ans);
    }
}
