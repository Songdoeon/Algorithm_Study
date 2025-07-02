import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 2871

public class Main {
    static int N;
    static int[] count = new int[26];
    static int[] mine, yours;
    static char[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arr = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            queue.offer(new int[] { (arr[i] - 'a'), i});
        }
        mine = new int[26];
        yours = new int[26];
        int rIdx = N - 1;
        N /= 2;

        while(N-- > 0){
            while(visited[rIdx])rIdx--;

            yours[arr[rIdx] - 'a']++;
            visited[rIdx] = true;
            rIdx--;

            while (!queue.isEmpty()){
                int[] cur = queue.poll();
                if(visited[cur[1]]) continue;
                visited[cur[1]] = true;
                sb.append((char)(cur[0] + 'a'));
                mine[cur[0]]++;
                break;
            }
        }
        for (int i = 0; i < 26; i++) {
            if(i != 25 && mine[i] == yours[i])continue;
            sb.insert(0, mine[i] > yours[i] ? "DA\n" : "NE\n");
            break;
        }
        System.out.println(sb);
    }
}
