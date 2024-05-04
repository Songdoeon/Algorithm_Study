import java.util.*;
import java.io.*;


class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int idx = 6;
        int ans = 1;
        if(N == 1) {
            System.out.println(1);
        }
        else{
            N--;
            while (N > 0){
                N -= idx;
                idx += 6;
                ans++;
            }
            System.out.println(ans);
        }
    }
}
