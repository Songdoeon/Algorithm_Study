import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Node{
    int left, right;
    int no;

    public Node(int no, int left, int right) {
        this.no = no;
        this.left = left;
        this.right = right;
    }
}
class Main {
    static int N;
    static Node root;
    static int idx;
    static int[][] width;
    static Node[] nodes;
    static void search(Node node, int dep){
        if(node.left != -1) search(nodes[node.left], dep + 1);
        width[dep][0] = Math.min(width[dep][0], idx);
        width[dep][1] = Math.max(width[dep][1], idx);
        idx++;
        if(node.right != -1) search(nodes[node.right], dep + 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] candidate = new int[N + 1];
        nodes = new Node[N + 1];
        idx = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            if(left != -1)candidate[left]++;
            if(right != -1)candidate[right]++;
            nodes[parent] = new Node(parent, left, right);
        }
        for (int i = 1; i <= N; i++) {
            if(candidate[i] == 0) {
                root = nodes[i];
                break;
            }
        }
        width = new int[N][2];
        for (int i = 0; i < N; i++) {
            width[i][0] = N + 1;
        }
        search(root, 0);
        int ans = 0;
        int ans1 = 0;
        for (int i = 0; i < N; i++) {
            int wid = width[i][1] - width[i][0];
            if(ans1 < wid){
                ans = i;
                ans1 = wid;
            }
        }
        System.out.println(ans + 1 + " " + (ans1 + 1));
    }
}