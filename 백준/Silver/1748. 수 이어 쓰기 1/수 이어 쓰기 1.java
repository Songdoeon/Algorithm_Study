import java.io.*;
import java.util.*;

public class Main {

    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int plus = 1;
        int num = 10;
        for(int i = 1; i <= N; i++) {
            if(i%num == 0) {
                plus++;
                num *= 10;
            }
            count += plus;
        }
        System.out.println(count);
    }
}