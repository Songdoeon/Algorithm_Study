import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[][] tree;
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
        tree = new int[26][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            int left = st.nextToken().charAt(0) - 'A';
            int right = st.nextToken().charAt(0) - 'A';
            tree[parent][0] = left == -19 ? -1 : left;
            tree[parent][1] = right == -19 ? -1 : right;
        }
        
        preorder(0);
        sb.append('\n');
        inorder(0);
        sb.append('\n');
        postorder(0);
        sb.append('\n');

		bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}
    static void preorder(int num) {

        if(num == -1) return;
        
        sb.append((char)(num + 'A'));
        preorder(tree[num][0]);
        preorder(tree[num][1]);
        
    }
    static void inorder(int num) {
        if(num == -1) return;

        inorder(tree[num][0]);
        sb.append((char)(num + 'A'));
        inorder(tree[num][1]);
        
    }
    static void postorder(int num) {
        if(num == -1) return;

        postorder(tree[num][0]);
        postorder(tree[num][1]);
        sb.append((char)(num + 'A'));

    }
}