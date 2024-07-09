import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[2000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = 1;
        }
        for (int i = 1000; i < 2000; i++) {
            arr[i] = 1000;
        }
        long sum = 1;
        int start = 0;
        int end = 0;

        while (start <= end){
            if(sum == N) break;
            if(sum < N){
                sum += arr[++end];
            }
            else{
                sum -= arr[start++];
            }
        }
        sb.append(end - start + 1).append('\n');
        for (int i = start; i <= end; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);
    }

}