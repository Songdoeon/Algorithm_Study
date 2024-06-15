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
    static int depth;
    static int[][] arr;
    static int idx;
    static int[][] width;
    static Map<Integer, Node> map = new HashMap<>();

    static void search(Node node, int dep){
        if(node.no == -1) return ;
        depth = Math.max(dep, depth);

        if(map.containsKey(node.left)) search(map.get(node.left), dep + 1);
        width[dep][0] = Math.min(width[dep][0], idx); 
        width[dep][1] = Math.max(width[dep][1], idx);
//        arr[dep][idx++] = node.no;
        idx++;
        if(map.containsKey(node.right)) search(map.get(node.right), dep + 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] candidate = new int[N + 1];
        depth = 0;
        idx = 0;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            if(left != -1)candidate[left]++;
            if(right != -1)candidate[right]++;
            map.put(parent, new Node(parent, left, right));

        }
        for (int i = 1; i <= N; i++) {
            if(candidate[i] == 0) {
                root = map.get(i);
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
        for (int i = 0; i <= depth; i++) {
            int wid = width[i][1] - width[i][0];
            if(ans1 < wid){
                ans = i;
                ans1 = wid;
            }
        }

        System.out.println(ans + 1 + " " + (ans1 + 1));
    }
}