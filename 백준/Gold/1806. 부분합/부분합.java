import java.util.*;
import java.io.*;

class Main{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arg = br.readLine().split(" ");
        int N = Integer.parseInt(arg[0]);
        int M = Integer.parseInt(arg[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        for(int i=0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 100000;
        int sum = 0;
        int start = 0;
        int end = 0;

        while(start <= N && end <= N){
            if(sum < M) sum += arr[end++];
            else if (sum >= M){
                answer = Math.min(end - start, answer);
                sum -= arr[start++];
            }
        }
        System.out.println(answer == 100000 ? 0 : answer);
    }
}