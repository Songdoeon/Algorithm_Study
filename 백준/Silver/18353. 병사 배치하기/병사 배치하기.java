import java.io.*;
import java.util.*;

class Main{
    static int N;
    static int[] arr, result;
    static int idx;
    static int search(int n){
        int start = 0;
        int end = idx + 1;
        while (start < end){
            int mid = (start + end) / 2;
            if(n <= result[mid]){
                start = mid + 1;
            }
            else end = mid;
        }
        return end;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        result[0] = arr[0];
        idx = 0;
        for (int i = 1; i < N; i++) {
            if(result[idx] <= arr[i]){
                int index = search(arr[i]);
                result[index] = arr[i];
            }
            else{
                result[++idx] = arr[i];
            }
        }
        System.out.println(N - idx - 1);
    }
}