import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Bucket{
    int a, b, c;

    public Bucket(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
public class Main {
    static int maxA, maxB, maxC;
    static boolean[][][] visited;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> pq = new TreeSet<>();
        maxA  = Integer.parseInt(st.nextToken());
        maxB = Integer.parseInt(st.nextToken());
        maxC = Integer.parseInt(st.nextToken());
        cnt = new int[maxC + 1];
        visited = new boolean[maxA + 1][maxB + 1][maxC + 1];
        Queue<Bucket> q = new ArrayDeque<>();
        Bucket buc = new Bucket(0, 0, maxC);
//        visited[0][0][maxC] = true;
        q.add(buc);
        while (!q.isEmpty()) {
            Bucket bucket = q.poll();
            int a = bucket.a;
            int b = bucket.b;
            int c = bucket.c;
            if(visited[a][b][c]) continue;
            visited[a][b][c] = true;
            if(a == 0) cnt[c]++;
//          a -> b
            if(a + b >= maxB) q.offer(new Bucket(a - (maxB - b), maxB, c));
            else q.offer(new  Bucket(0, a + b, c));
//          a -> c
            if(a + c >= maxC) q.offer(new Bucket(a - (maxC - c), b, maxC));
            else q.offer(new Bucket(0, b, a + c));

//            b -> a
            if(b + a >= maxA) q.offer(new Bucket(maxA, b - (maxA - a), c));
            else q.offer(new Bucket(a + b, 0, c));

//            b -> c
            if(b + c >= maxC) q.offer(new Bucket(a, b - (maxC - c), maxC));
            else q.offer(new Bucket(a, 0, b + c));

//            c -> a
            if(a + c >= maxA) q.offer(new Bucket(maxA, b, c - (maxA - a)));
            else q.offer(new Bucket(a + c, b, 0));

//            c -> b
            if(b + c >= maxB) q.offer(new Bucket(a, maxB, c - (maxB - b)));
            else q.offer(new Bucket(a, b + c, 0));
        }

        for (int i = 0; i <= maxC; i++) {
            if(cnt[i] != 0) sb.append(i).append(' ');
        }
        System.out.println(sb);

    }
}