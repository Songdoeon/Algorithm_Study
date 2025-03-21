import java.io.*;
import java.util.*;

class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (N >= 1){
            if(N % 2 == 0){
                N = N / 2 - 1;
                sb.append('7');
            }
            else{
                N = N / 2;
                sb.append('4');
            }
        }
        System.out.println(sb.reverse());
    }
}
