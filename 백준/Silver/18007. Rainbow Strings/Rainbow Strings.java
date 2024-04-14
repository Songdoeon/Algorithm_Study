import java.util.*;
import java.io.*;

class Main {
    static int N;
    static String string;
    static final int MOD = 11_092_019;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        string = br.readLine();
        N = string.length();
        int[] arr = new int[27];
        long sum = 1;
        for (int i = 0; i < N; i++) {
            arr[string.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 27; i++) {
            sum = (sum * (arr[i] + 1)) % MOD;
        }
        System.out.println(sum);
    }
}