import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 18310

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);

        System.out.print(arr[(N - 1) / 2]);
    }
}
