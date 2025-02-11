import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[] inorder, postorder;
    static int[] idxArr;
    static StringBuilder sb = new StringBuilder();

    static void search(int inS, int inE, int postS, int postE){
        if(inE < inS || postE < postS) return ;
        int root = postorder[postE];
        int i = idxArr[root];

        sb.append(root).append(" ");

        int len = i - inS;
        search(inS, i - 1, postS, postS + len - 1);
        search(i + 1, inE, postS + len, postE - 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        inorder = new int[N + 1];
        postorder = new int[N + 1];
        idxArr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            postorder[i] = Integer.parseInt(st1.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            idxArr[inorder[i]] = i;
        }
        search(1, N, 1, N);
        System.out.println(sb);
    }
}