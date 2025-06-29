import java.io.*;
import java.util.*;

// 26260

class Node{
    int left, right;

    public Node(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    static void search(int l, int r) {
        if (l >= r) return;
        int len = r - l;
        int mid = l + (len - 1) / 2;
        
        search(l, mid);
        search(mid + 1, r);
        
        sb.append(arr[mid]).append(' ');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        int target = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == -1) arr[i] = target;
        }

        Arrays.sort(arr);

        search(0, N);

        System.out.println(sb);
    }
}
