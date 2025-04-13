import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Objects;
import java.util.StringTokenizer;

class Edge {
    int s, e, status;
    public Edge(int s, int e, int status) {
        this.s = s;
        this.e = e;
        this.status = status;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        Edge edge = (Edge) o;
        return s == edge.s && e == edge.e && status == edge.status;
    }
    @Override
    public int hashCode() {
        return Objects.hash(s, e, status);
    }
}

class Node {
    int next, status;
    public Node(int next, int status) {
        this.next = next;
        this.status = status;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return next == node.next && status == node.status;
    }
    @Override
    public int hashCode() {
        return Objects.hash(next, status);
    }
}

public class Main {
    static int N, M;
    static Map<Integer, Edge> map = new HashMap<>();
    static List<Integer> roots = new ArrayList<>();
    static Map<Integer, Map<Node, Integer>> nodes = new HashMap<>();
    static Map<Integer, Map<Node, Integer>> reverseNodes = new HashMap<>();
    static Set<Integer> objects = new HashSet<>();

    static void add(int n, String status) {
        if (status.equals("ROOT")) roots.add(n);
        nodes.put(n, new HashMap<>());
        reverseNodes.put(n, new HashMap<>());
        objects.add(n);
    }

    static void addEdgeToMap(Map<Node, Integer> m, Node node) {
        m.put(node, m.getOrDefault(node, 0) + 1);
    }

    static void removeEdgeFromMap(Map<Node, Integer> m, Node node) {
        if (m.containsKey(node)) {
            int cnt = m.get(node);
            if (cnt > 1)
                m.put(node, cnt - 1);
            else
                m.remove(node);
        }
    }

    static void removeEdge(int n) {
        Edge e = map.get(n);
        if (e == null) return;
        if (nodes.containsKey(e.s))
            removeEdgeFromMap(nodes.get(e.s), new Node(e.e, e.status));
        if (reverseNodes.containsKey(e.e))
            removeEdgeFromMap(reverseNodes.get(e.e), new Node(e.s, e.status));
        map.remove(n);
    }

    static int search(int threshold) {
        Queue<Integer> q = new ArrayDeque<>(roots);
        Set<Integer> visited = new HashSet<>(roots);
        int cnt = q.size();
        while(!q.isEmpty()){
            int cur = q.poll();
            if (!nodes.containsKey(cur)) continue;
            for (Node node : nodes.get(cur).keySet()){
                if (visited.contains(node.next)) continue;
                if (node.status < threshold) continue;
                visited.add(node.next);
                cnt++;
                q.add(node.next);
            }
        }
        // 도달하지 못한(쓰레기) 객체 제거
        List<Integer> toRemove = new ArrayList<>();
        for (Integer obj : objects) {
            if (!visited.contains(obj))
                toRemove.add(obj);
        }
        for (Integer rem : toRemove) {
            if (reverseNodes.containsKey(rem)) {
                for (Node node : reverseNodes.get(rem).keySet()) {
                    if (nodes.containsKey(node.next))
                        removeEdgeFromMap(nodes.get(node.next), new Node(rem, node.status));
                }
                reverseNodes.remove(rem);
            }
            if (nodes.containsKey(rem)) {
                for (Node node : nodes.get(rem).keySet()) {
                    if (reverseNodes.containsKey(node.next))
                        removeEdgeFromMap(reverseNodes.get(node.next), new Node(rem, node.status));
                }
                nodes.remove(rem);
            }
        }
        objects = visited;
        return cnt;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            add(n, st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String exec = st.nextToken();
            if (exec.equals("MADE")) {
                int n = Integer.parseInt(st.nextToken());
                add(n, st.nextToken());
            } else if (exec.equals("ADD")) {
                int n = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int edgeStatus = st.nextToken().equals("=>") ? 2 : 1;
                int e = Integer.parseInt(st.nextToken());
                Edge edge = new Edge(s, e, edgeStatus);
                map.put(n, edge);
                if (nodes.containsKey(s))
                    addEdgeToMap(nodes.get(s), new Node(e, edgeStatus));
                else {
                    Map<Node, Integer> newMap = new HashMap<>();
                    newMap.put(new Node(e, edgeStatus), 1);
                    nodes.put(s, newMap);
                }
                if (reverseNodes.containsKey(e))
                    addEdgeToMap(reverseNodes.get(e), new Node(s, edgeStatus));
                else {
                    Map<Node, Integer> newMap = new HashMap<>();
                    newMap.put(new Node(s, edgeStatus), 1);
                    reverseNodes.put(e, newMap);
                }
            } else if (exec.equals("m")) {
                sb.append(search(1)).append('\n');
            } else if (exec.equals("M")) {
                sb.append(search(2)).append('\n');
            } else {
                removeEdge(Integer.parseInt(st.nextToken()));
            }
        }
        System.out.println(sb);
    }
}
