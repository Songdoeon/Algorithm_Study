import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int[] arr;
        int[] arr2;
        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            String s = st.nextToken();
            String t = st.nextToken();
            int len = s.length();
            arr = new int[len];
            arr2 = new int[len];
            int idx = 0;
            int idx2 = 0;
            for (int i = 0; i < len; i++) {
                if(s.charAt(i) == 'b') {
                    arr[idx++] = i;
                }
                if(t.charAt(i) == 'b') {
                    arr2[idx2++] = i;
                }
            }
            for (int i = 0; i < idx; i++) {
                sum += Math.abs(arr[i] - arr2[i]);
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}