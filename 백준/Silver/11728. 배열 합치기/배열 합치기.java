import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[N];
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < N && idx2 < M) {
            if (arr1[idx1] < arr2[idx2]) {
                sb.append(arr1[idx1++]).append(' ');
            }
            else {
                sb.append(arr2[idx2++]).append(' ');
            }
        }
        while (idx1 < N) {
            sb.append(arr1[idx1++]).append(' ');
        }
        while (idx2 < M) {
            sb.append(arr2[idx2++]).append(' ');
        }
        System.out.println(sb);
    }
}
