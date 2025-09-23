import java.io.*;
import java.util.*;

class Pos {
    int x, y, idx;
    Pos(int x, int y, int idx){
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
}

public class Main {
    static int N;
    static int search(int[] a, int key){
        int l = 0, r = a.length;
        while(l < r){
            int m = (l + r) >>> 1;
            if (a[m] < key) l = m + 1;
            else r = m;
        }
        return l;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        Pos[] arr = new Pos[N];

        int[] xs = new int[N];
        int[] ys = new int[N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Pos(x, y, i + 1);
            xs[i] = x;
            ys[i] = y;
        }

        Arrays.sort(xs);
        Arrays.sort(ys);

        long[] psx = new long[N + 1];
        long[] psy = new long[N + 1];
        for (int i = 1; i <= N; i++){
            psx[i] = psx[i - 1] + xs[i - 1];
            psy[i] = psy[i - 1] + ys[i - 1];
        }

        long best = Long.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for (Pos p : arr){

            int ax = search(xs, p.x);
            long leftX  = (long)p.x * ax - psx[ax];
            long rightX = (psx[N] - psx[ax]) - (long)p.x * (N - ax);
            long sx = leftX + rightX;


            int ay = search(ys, p.y);
            long leftY  = (long)p.y * ay - psy[ay];
            long rightY = (psy[N] - psy[ay]) - (long)p.y * (N - ay);
            long sy = leftY + rightY;

            long total = sx + sy;
            if (total < best || (total == best && p.idx < ans)){
                best = total;
                ans = p.idx;
            }
        }

        System.out.println(ans);
    }
}
