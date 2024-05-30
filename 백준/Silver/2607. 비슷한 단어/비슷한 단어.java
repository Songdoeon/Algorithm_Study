import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] src = new int[26];
    static int[] tgt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        N = Integer.parseInt(br.readLine());
        for (char c : br.readLine().toCharArray()) {
            src[c - 'A']++;
        }
        while (--N > 0){
            boolean up = false;
            boolean down = false;
            boolean similar = true;
            boolean change = false;
            tgt = new int[26];
            for (char c : br.readLine().toCharArray()) {
                tgt[c - 'A']++;
            }
            for (int i = 0; i < 26; i++) {
                int temp = src[i] - tgt[i];
                if(temp == 0) continue;
                if(Math.abs(temp) > 1 || change){
                    similar = false;
                    break;
                }
                if((temp == 1 && up) || (temp == -1 && down)){
                    similar = false;
                    break;
                }
                if(temp == 1) up = true;
                else if(temp == -1) down = true;
                if(up && down) change = true;
            }
            if(similar) ans++;
        }
        System.out.println(ans);
    }
}
