import java.io.*;
import java.util.*;

class Office{
    int x, y;

    public Office(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, x, y;
    static Office[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long total = 0;
        arr = new Office[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            total += y;
            arr[i] = new Office(x, y);
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o.x));
        int s = 0;
        int e = N - 1;
        long cnt = 0;
        long flag = (total + 1) / 2;

        while (s < e){
            cnt += arr[s].y;
            if(cnt < flag) s++;
            else break;
        }
        System.out.println(arr[s].x);
    }
}