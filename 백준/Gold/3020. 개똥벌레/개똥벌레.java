import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] up, down;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        up = new int[M + 2];
        down = new int[M + 2];
        for(int i=1; i<=(N)/2; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = M-Integer.parseInt(br.readLine())+1;
            down[a]++;
            up[b]++;
        }
        for(int i=1; i<=M; i++) {
            down[i] += down[i-1];
        }

        for(int i=M; i>=1; i--) {
            up[i] += up[i+1];
        }

        int min = N;
        int cnt=0;
        for(int i=1; i<M+1; i++) {
            int dif = (down[M]-down[i-1]) + (up[1]-up[i+1]);

            if(dif<min) {
                min = dif;
                cnt=1;
            }else if(dif == min) cnt++;
        }
        System.out.println(min +" " + cnt);
    }
}