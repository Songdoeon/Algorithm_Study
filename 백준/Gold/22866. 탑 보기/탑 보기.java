import java.io.*;
import java.util.*;

// 22866
class Building {
    int idx, height;

    public Building(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}
public class Main {
    static int N;
    static Building[] arr;
    static int[] count;
    static int[][] dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        arr = new Building[N + 1];
        count = new int[N + 1];
        dis = new int[N + 1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = new Building(i, Integer.parseInt(st.nextToken()));

        Deque<Building> stack = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dis[i][0] = N + 1;
            while (!stack.isEmpty() && stack.peek().height <= arr[i].height) {
                stack.pop();
            }
            count[i] += stack.size();
            if(!stack.isEmpty()) {
                dis[i][0] = Math.abs(i - stack.peek().idx);
                dis[i][1] = stack.peek().idx;
            }
            stack.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();

        stack.clear();
        for (int i = N; i >= 1; i--) {
            while (!stack.isEmpty() && stack.peek().height <= arr[i].height) {
                stack.pop();
            }
            count[i] += stack.size();
            if(!stack.isEmpty()) {
                int distance = Math.abs(stack.peek().idx - i);
                if(dis[i][0] > distance) dis[i][1] = stack.peek().idx;
            }
            stack.push(arr[i]);
        }

        for (int i = 1; i <= N; i++) {
            sb.append(count[i] == 0 ? 0 : count[i] + " " + dis[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}
