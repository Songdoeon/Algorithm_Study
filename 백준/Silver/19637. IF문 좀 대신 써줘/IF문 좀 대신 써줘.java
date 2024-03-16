import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(i == 0){
                arr[i] = num;
                names[i] = name;
                continue;
            }
            if(arr[i - 1] == num){
                arr[i] = num;
                names[i] = names[i - 1];
            }
            else {
                arr[i] = num;
                names[i] = name;
            }
        }
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            int n = Arrays.binarySearch(arr, num);
            if(n < 0){
                sb.append(names[Math.abs(n + 1)]).append('\n');
            }
            else sb.append(names[n]).append('\n');
        }

        System.out.println(sb);
    }
}