import java.io.*;
import java.util.*;
class Node{
    int no, weight;

    public Node(int no, int weight) {
        this.no = no;
        this.weight = weight;
    }
}
public class Main {
    static int N, M, start, des;

    static List<Node>[] list, reverseList;
    static int[] linked, times;
    static boolean[] visited;
    static boolean[][] checked;
    static int road = 0;
    static Queue<Integer> nodeQueue = new ArrayDeque<>();
    static Node next;

    static void search(){
        nodeQueue.offer(des);
        visited[des] = true;
        while(!nodeQueue.isEmpty()) {
            int now = nodeQueue.poll();
            int size = reverseList[now].size();
            for (int i = 0; i < size; i++) {
                next = reverseList[now].get(i);
//                System.out.println(visited[next.no] + " : " + times[now] + " : " + next.weight + " + " + times[next.no]);
                if(times[now] != next.weight + times[next.no]) continue;
                road++;
                if(visited[next.no]) continue;
                visited[next.no] = true;
                nodeQueue.offer(next.no);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        visited = new boolean[N + 1];
        checked = new boolean[N + 1][N + 1];
        list = new ArrayList[N + 1];
        reverseList = new ArrayList[N + 1];
        linked = new int[N + 1];
        times = new int[N + 1];

        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[n1].add(new Node(n2, weight));
            reverseList[n2].add(new Node(n1, weight));
            linked[n2]++;
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        des = Integer.parseInt(st.nextToken());
        queue.offer(start);
        while (!queue.isEmpty()){
            int node = queue.poll();

            int size = list[node].size();
            for(int i = 0; i < size; i++){
                Node next = list[node].get(i);
                times[next.no] = Math.max(times[next.no], next.weight + times[node]);
                if(--linked[next.no] == 0) queue.offer(next.no);
            }
        }
        visited[des] = true;
        search();
        System.out.println(times[des] + "\n" + road);
    }
}
