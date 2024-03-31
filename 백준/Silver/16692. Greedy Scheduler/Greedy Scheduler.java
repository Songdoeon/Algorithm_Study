import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] time = new int[N+1];
        int[] arr = new int[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min;
        for(int i = 0; i < C; i++) {
            int idx = 1;
            min = 1_000_001;
            for(int j = 1; j < N + 1; j++) {
                if(time[j] < min) {
                    min = time[j];
                    idx = j;
                }
            }
            sb.append(idx).append(' ');
            time[idx] += arr[i];
        } 
        System.out.print(sb);
    }
}