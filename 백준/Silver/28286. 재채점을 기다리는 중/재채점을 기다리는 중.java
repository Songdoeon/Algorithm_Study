import java.util.*;
import java.io.*;


class Main{
    static int N, K;
    static int[][] arr;
    static int result = 0;
    static void search(int ansIdx, int myIdx, int cnt, int item){
        if(item > K) return ;
        if(myIdx >= N || ansIdx == N){
            result = Math.max(cnt, result);
            return ;
        }
        if(arr[0][ansIdx] == arr[1][myIdx])
            search(ansIdx + 1, myIdx + 1, cnt + 1, item);
        else{
            search(ansIdx + 1, myIdx + 1, cnt, item);
            search(ansIdx + 1, myIdx, cnt, item + 1);
            search(ansIdx, myIdx + 1, cnt, item + 1);
        }
        
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[2][N];

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, 0, 0, 0);
        System.out.println(result);
    }
}
