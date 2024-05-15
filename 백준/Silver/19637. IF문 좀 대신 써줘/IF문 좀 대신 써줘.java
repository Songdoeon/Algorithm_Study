import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        String[] names = new String[N];
        st = new StringTokenizer(br.readLine());
        String name = st.nextToken();
        int num = Integer.parseInt(st.nextToken());
        arr[0] = num;
        names[0] = name;
        int n;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            num = Integer.parseInt(st.nextToken());
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
            num = Integer.parseInt(br.readLine());
            n = Arrays.binarySearch(arr, num);
            sb.append(n < 0 ? names[Math.abs(n + 1)] : names[n]).append('\n');
        }

        System.out.println(sb);
    }
}