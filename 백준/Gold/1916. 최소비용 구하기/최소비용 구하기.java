import java.io.*;
import java.util.*;

class Main{
    public static class Node{
        int num, cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] costs = new int[N + 1];
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(n1).add(new Node(n2,cost));
        }
        Arrays.fill(costs, Integer.MAX_VALUE);
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

        queue.add(new Node(start,0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int point = node.num;
            int cost = node.cost;
            if(costs[point] < cost) continue;

            for(Node nextNode : graph.get(point)){
                if(costs[nextNode.num] > nextNode.cost + cost){
                    costs[nextNode.num] = nextNode.cost + cost;
                    queue.add(new Node(nextNode.num, nextNode.cost + cost));
                }
            }
        }

        System.out.println(costs[end]);
    }
}