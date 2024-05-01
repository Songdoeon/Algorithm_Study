import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int max, min;
//    static List<Integer> myCards = new ArrayList<>();
    static int[] myCards;
    static int[] parent;
    static int find(int n){
        if(n == parent[n])return n;
        return parent[n] = find(parent[n]);
    }
    static boolean union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(n1 == n2) return false;
        if(p1 > p2) parent[p2] = p1;
        else parent[p1] = p2;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        parent = new int[M];
        myCards = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            parent[i] = i;
            myCards[i] = n;
//            myCards.add(n);
        }
//        Collections.sort(myCards);
        Arrays.sort(myCards);
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = M;
            int mid;
            while (start < end){
                mid = (start + end) / 2;

                if(myCards[mid] <= n){
                    start = mid + 1;
                }
                else end = mid;
            }
            if(end != M - 1){
                union(end, parent[end]);
            }
            sb.append(myCards[parent[end]++]).append('\n');
        }
        System.out.println(sb);
    }
}