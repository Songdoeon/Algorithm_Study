import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14658 14:46 시작!

class Pos{
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Main{
    static int N, M, L, K;
    static Pos[] arr;

    static int p1, p2, p3, p4;
    static boolean check(Pos p){
        if(p1 <= p.x && p.x <= p2 && p3 <= p.y && p.y <= p4) return true;
        return false;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new Pos[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int ans = 0;
        for (int i = 0; i < K; i++) {
            Pos pos = arr[i];
            int cnt = 1;
            for (int j = 0; j < K; j++) {
                cnt = 0;
                p1 = Math.min(pos.x, arr[j].x);
                p2 = p1 + L;
                p3 = Math.min(pos.y, arr[j].y);
                p4 = p3 + L;
                for (int k = 0; k < K; k++) {
                    if(check(arr[k])) cnt++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        System.out.println(K - ans);
    }
}