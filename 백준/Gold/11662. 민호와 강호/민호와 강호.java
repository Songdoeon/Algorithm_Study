import java.util.*;
import java.io.*;

class Pos{
    double x, y;

    public Pos(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
class Main{
    static int N;
    static int result = 0;
    static Pos[] arr;

    static double calc(double n){
        double time = n * 1e-6;
        Pos p1 = new Pos(arr[0].x + (arr[1].x - arr[0].x) * time,arr[0].y + (arr[1].y - arr[0].y) * time);
        Pos p2 = new Pos(arr[2].x + (arr[3].x - arr[2].x) * time,arr[2].y + (arr[3].y - arr[2].y) * time);
        return dist(p1, p2);
    }
    static double dist(Pos a, Pos b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new Pos[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        double lo = 0;
        double hi = 1e6;

        while (hi - lo >= 1e-6) {

            double p = (hi + 2 * lo) / 3;
            double q = (2 * hi + lo) / 3;
            if (calc(p) >= calc(q))
                lo = p;
            else
                hi = q;
        }
        double ans = Double.MAX_VALUE;
        for (int i = (int)lo; i <= hi ; i++) {
            ans = Math.min(ans, calc(i));
        }
        System.out.printf("%f", ans);
    }
}