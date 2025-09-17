import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2812

public class Main {
    static int N, M;
    static char[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = br.readLine().toCharArray();
        
        int idx = 0;
        char[] stack = new char[N];
        for (int i = 0; i < N; i++) {
            char c = arr[i];
            while(idx > 0 && M > 0 && stack[idx - 1] < c){
                idx--;
                M--;
            }
            stack[idx++] = c;
        }
        
        idx -= M;

        for (int i = 0; i < idx; i++) sb.append(stack[i]);
        System.out.println(sb);
    }
}
