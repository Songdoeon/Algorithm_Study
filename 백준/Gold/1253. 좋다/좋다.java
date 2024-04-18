import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[]  arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;
            while (start < end){
                int sum = arr[start] + arr[end];
                if(start == i){
                    if(sum <= arr[i]){
                        start++;
                    }
                    else end--;
                    continue;
                }
                if(end == i){
                    if(sum < arr[i]){
                        start++;
                    }
                    else end--;
                    continue;
                }
                if(sum == arr[i]) {
                    ans++;
                    break;
                }
                if(sum < arr[i]) start++;
                else end--;
            }
        }
        System.out.println(ans);
    }
}