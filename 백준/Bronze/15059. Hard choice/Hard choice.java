import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer sts = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i = 0; i < 3; i++){
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(sts.nextToken());
            if(n2 > n1) sum += n2 - n1;
        }
        System.out.println(sum);
    }
}