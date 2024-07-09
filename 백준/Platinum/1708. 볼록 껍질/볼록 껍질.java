
import java.util.*;
import java.io.*;

class Pos{
    long x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
class Main {
    static int N;

    static int ccw(Pos b, Pos p1, Pos p2){
        long n = (b.x * p1.y + p1.x * p2.y + p2.x * b.y) - (p1.x * b.y + p2.x * p1.y + b.x * p2.y);
        if(n < 0) return -1;
        if(n > 0) return 1;
        return 0;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Pos> stack = new Stack<>();
        N = Integer.parseInt(st.nextToken());
        Pos[] arr = new Pos[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr, ((o1, o2) -> o1.x == o2.x ? Long.compare(o1.y, o2.y) : Long.compare(o1.x, o2.x)));
        Pos start = arr[0];

        Arrays.sort(arr, (o1, o2) -> -ccw(start , o1, o2));
        int cnt = 0;
        for (int i = 0; i <= N; i++) {
            int now = i % N;
            while(stack.size() >= 2 && ccw(stack.get(stack.size() - 2), stack.peek(), arr[now]) <= 0) {
                stack.pop();
                cnt--;
            }
            stack.push(arr[now]);
            cnt++;
        }
        System.out.println(cnt - 1);
    }
}
