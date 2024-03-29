import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[][] arr = new int[N][2];
        int idx = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[idx][0] = Integer.parseInt(st.nextToken());
            arr[idx++][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        
        for(int i = 0; i < N; i++){
            sb.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');
        }
        System.out.println(sb);    
    }
}