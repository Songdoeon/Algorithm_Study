import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, len, sLen1, sLen2, i;
    static char[] s1, s2, target;
    static StringBuilder sb = new StringBuilder();
    static boolean find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> q = new ArrayDeque<>();
        N = Integer.parseInt(st.nextToken());
        for (i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            find = false;
            s1 = st.nextToken().toCharArray();
            s2 = st.nextToken().toCharArray();
            sLen1 = s1.length;
            sLen2 = s2.length;
            target = st.nextToken().toCharArray();
            boolean[][] visited = new boolean[sLen1 + 1][sLen2 + 1];
            len = target.length;
            q = new ArrayDeque<>();
            q.offer(new int[] {0, 0, 0});
            visited[0][0] = true;
            while (!q.isEmpty()){
                int[] info = q.poll();
//                System.out.println(info[1] + " " + info[2]);
                if(info[0] == len){
                    find = true;
                    break;
                }
                char c = target[info[0]];
                if(info[1] < sLen1 && c == s1[info[1]] && !visited[info[1] + 1][info[2]]) {
                    visited[info[1] + 1][info[2]] = true;
                    q.offer(new int[] {info[0] + 1, info[1] + 1, info[2]});
                }
                if(info[2] < sLen2 && c == s2[info[2]] && !visited[info[1]][info[2] + 1]){
                    visited[info[1]][info[2] + 1] = true;
                    q.offer(new int[] {info[0] + 1, info[1], info[2] + 1});
                }
            }
            if(!find){
                sb.append("Data set ").append(i).append(": no").append('\n');
            } else{
                sb.append("Data set ").append(i).append(": yes").append('\n');
            }
        }
        System.out.println(sb);
    }
}
