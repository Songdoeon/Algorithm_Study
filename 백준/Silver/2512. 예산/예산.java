import java.io.*;
import java.util.*;
class Main {
    static int N;
    static int sum;
    static int[] arr;
    static boolean check(int charge){
        int tempSum = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i] < charge) tempSum += arr[i];
            else tempSum += charge;
        }
        if(tempSum > sum) return false;
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int end = 0;
        int total = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
            end = Math.max(end, arr[i]);
        }
        sum = Integer.parseInt(br.readLine());
        if(total <= sum){
            System.out.println(end);
            return ;
        }
        int s = 0;
        int e = end;
        int mid = 0;
        while (s < e){
            mid = (s + e) / 2;
            if(check(mid)){
                s = mid + 1;
            }
            else {
                e = mid;
            }
        }
        System.out.println(check(mid) ? mid : mid - 1);
    }
}
