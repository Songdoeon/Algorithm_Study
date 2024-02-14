import java.io.*;
import java.util.*;

public class Main {
    static int[] point = new int[] {0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int x = 0;
        int y = 0;
        N = (int) Math.pow(2, N);
        if(r < N / 2) point[0] = 0;
        else point[0] = 1;
        if(c < N / 2) point[1] = 0;
        else  point[1] = 1;

        while(true){
            if(N == 1) break;

            N /= 2;

            if( r < y + N){
                if(c >= x + N){
                    ans += N * N;
                    x += N;
                }
            }
            else{
                if(c < x + N){
                    ans += N * N * 2;
                    y += N;
                }
                else{
                    ans += N * N * 3;
                    y += N;
                    x += N;
                }
            }

            if(r <= N) point[0] = 0;
            else point[0] = 1;
            if(c <= N) point[1] = 0;
            else  point[1] = 1;
        }

        System.out.println(ans);

    }
}
