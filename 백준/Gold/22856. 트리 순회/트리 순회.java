import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
    int left, right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
public class Main {
    static int N, lastNode;
    static Node[] arr;
    static int ans = -1;
    static int count = 1;
    static boolean[] visited;
    static void inorder(int idx){
        Node n = arr[idx];
        if(n.left != -1){
            inorder(n.left);
        }
        lastNode = idx;
        if(n.right != -1){
            inorder(n.right);
        }
    }
    static void search(int idx){
        ans++;
        Node n = arr[idx];
        if(n.left != -1){
            if(!visited[n.left]){
                visited[n.left] = true;
                count++;
            }
            search(n.left);
            ans++;
        }
        if(n.right != -1){
            if(!visited[n.right]){
                visited[n.right] = true;
                count++;
            }
            search(n.right);
            ans++;
        }
        if(idx == lastNode && count == N){
            System.out.println(ans);
            System.exit(0);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Node[N + 1];
        visited = new boolean[N + 1];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            arr[node] = new Node(left, right);
        }
        inorder(1);
        search(1);
    }
}

