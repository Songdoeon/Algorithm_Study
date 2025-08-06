import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 10800

class Ball{
    int color, size, idx;

    public Ball(int color, int size, int idx) {
        this.color = color;
        this.size = size;
        this.idx = idx;
    }
}
public class Main {
    static int N;
    static Ball[] balls;
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        balls = new Ball[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            balls[i] = new Ball(color, size, i);
        }
        Arrays.sort(balls, Comparator.comparingInt(o -> o.size));

        int[] size = new int[N];
        int totalSize = 0;
        int[] colorSize = new int[N + 1];

 
        for (int i = 0; i < N; i++) {
            int end = i;
            while(end < N && balls[end].size == balls[i].size)end++;

            for (int j = i; j < end; j++) {
                Ball ball = balls[j];

                size[ball.idx] = totalSize - colorSize[ball.color];
            }
            for (int j = i; j < end; j++) {
                Ball ball = balls[j];

                totalSize             += ball.size;
                colorSize[ball.color] += ball.size;
            }
            i = end - 1;
        }

        for (int i = 0; i < N; i++) sb.append(size[i]).append("\n");

        System.out.println(sb);
    }
}
