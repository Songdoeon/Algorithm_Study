import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            
            if(n1 < n2) sb.append("NO BRAINS").append('\n');
            else sb.append("MMM BRAINS").append('\n');
        }
        System.out.println(sb);
    }
}