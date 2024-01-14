import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N - 1;
        int sum;
        long answer = Long.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;
        while(start < end){
            sum = arr[start] + arr[end];
            if(answer >= Math.abs(sum)) {
                answer = Math.abs(sum);
                ans1 = start;
                ans2 = end;
            }
            if(sum >= 0) end--;
            else start++;
        }
        System.out.println(arr[ans1] + " " + arr[ans2]);
    }

}