import java.io.*;
import java.util.*;

public class Main{
    static int T;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            int lcm = n * (m / gcd(n, m));
            boolean flag = false;
            for(int i=x; i<=lcm; i+=n){
                int a = i%n == 0 ? n : i%n;
                int b =  i%m == 0 ? m : i%m;
                
                if(a == x && b == y){
                    sb.append(i).append("\n");
                    flag = true;
                }
            }
            if(!flag) sb.append(-1).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    public static int gcd(int x, int y){
        if(y == 0) return x;
        return gcd(y, x%y);
    }
}
