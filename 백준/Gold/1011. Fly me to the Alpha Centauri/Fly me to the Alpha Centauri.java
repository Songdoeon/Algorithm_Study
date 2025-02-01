import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int N;
    static long[] arr = new long[10_000_000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int n = 3;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        arr[4] = 6;
        boolean flag = true;
        int idx = 5;
        while (arr[idx - 1] < Integer.MAX_VALUE) {
            if(!flag) arr[idx] += arr[idx - 1] + n++;
            else arr[idx] += arr[idx - 1] + n;
            flag = !flag;
            idx++;
        }

        while (N-- > 0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int d = end - start;

            int s = 0;
            int e = idx + 1;
            while (s < e){
                int mid = (s + e) / 2;
                if(d <= arr[mid]){
                    e = mid;
                }
                else {
                    s = mid + 1;
                }
            }
            sb.append(e).append('\n');
        }
        System.out.println(sb);
    }
}


