import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int max, min;

    static int[] myCards;
    static int[] parent;
    static int find(int n){
        if(n == parent[n])return n;
        return parent[n] = find(parent[n]);
    }
    static void union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1 > p2) parent[p2] = p1;
        else parent[p1] = p2;

    }
    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        StringBuilder sb = new StringBuilder();
        N = in.nextInt();
        M = in.nextInt();
        K = in.nextInt();
        parent = new int[M];
        myCards = new int[M];
        boolean[] isExist = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            parent[i] = i;
            isExist[in.nextInt()] = true;
        }
        int idx = 0;

        for (int i = 1; i <= N; i++) {
            if(isExist[i]) myCards[idx++] = i;
        }
        for (int i = 0; i < K; i++) {
            int n = in.nextInt();

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
    static class Reader {
        final int SIZE = 1 << 13;
        byte[] buffer = new byte[SIZE];
        int index, size;

        int nextInt() throws Exception {
            int n = 0;
            byte c;
            while ((c = read()) <= 32);
            do n = (n << 3) + (n << 1) + (c & 15);
            while (isNumber(c = read()));
            return n;
        }

        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        byte read() throws Exception {
            if (index == size) {
                size = System.in.read(buffer, index = 0, SIZE);
                if (size < 0)
                    buffer[0] = -1;
            }
            return buffer[index++];
        }
    }
}