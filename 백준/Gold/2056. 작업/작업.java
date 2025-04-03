import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 14:25 시작
class Main{
    static int N;
    static int[] times;
    static int[] prevs;
    static List<Integer>[] list;
    static List<Integer>[] reverseList;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        times = new int[N + 1];
        prevs = new int[N + 1];
        list = new ArrayList[N + 1];
        reverseList = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> times[o1] - times[o2]);
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            if(cnt == 0) queue.offer(i);
            for (int j = 0; j < cnt; j++) {
                int next = Integer.parseInt(st.nextToken());
                list[i].add(next);
                reverseList[next].add(i);
            }
        }
        int ans = 0;

        while (!queue.isEmpty()){
            int job = queue.poll();
            for(int next : reverseList[job]){
                list[next].remove(Integer.valueOf(job));
                if(list[next].isEmpty()){
                    if(times[next] <= times[next] + times[job]) times[next] += times[job];
                    queue.add(next);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, prevs[i] + times[i]);
        }
        System.out.println(ans);
    }
}