import java.io.*;
import java.util.*;

class Sett{
    int a, b, c, d;

    public Sett(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}


public class Main {
    static int N, d, k, c, max;
    static int[] tgt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        tgt = new int[k + 1];
        int[] init = new int[k];
        int[] dishes = new int[d + 1];
        int result = 1;
        dishes[c] = 1;
        for (int i = 1; i <= k; i++) {
            int n = Integer.parseInt(br.readLine());
            if(i % k == 0) {
                if(dishes[n]++ == 0) result += 1;
                tgt[k] = n;
                init[i - 1] = n;
            }
            else {
                if(dishes[n]++ == 0) result += 1;
                tgt[i % k] = n;
                init[i - 1] = n;
            }
        }
        max = result;
        for (int i = k + 1; i <= N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(i % k == 0) {
                if(--dishes[tgt[k]] == 0) result -= 1;
                if(dishes[n]++ == 0) result += 1;
                tgt[k] = n;
            }
            else {
                if(--dishes[tgt[i % k]] == 0) result -= 1;
                if(dishes[n]++ == 0) result += 1;
                tgt[i % k] = n;
            }
            max = Math.max(max, result);

        }
        int idx = 0;
        for(int i = N + 1; i <= N + k; i++){
            int n = init[idx++];
            if(i % k == 0) {
                if(--dishes[tgt[k]] == 0) result -= 1;
                if(dishes[n]++ == 0) result += 1;
                tgt[k] = n;
            }
            else {
                if(--dishes[tgt[i % k]] == 0) result -= 1;
                if(dishes[n]++ == 0) result += 1;
                tgt[i % k] = n;
            }
            max = Math.max(max, result);
        }
        System.out.println(max);
    }
}
