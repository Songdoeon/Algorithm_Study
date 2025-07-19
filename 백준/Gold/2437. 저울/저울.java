import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2437

public class Main {
    static int N;
    static int[] arr;
    static boolean visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int max = 0;
        Arrays.sort(arr);

        for (int i : arr) {
            if(i > max + 1) break;
            max += i;
        }
        System.out.println(max + 1);
    }
}