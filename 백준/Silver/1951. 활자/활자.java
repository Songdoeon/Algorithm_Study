import java.io.*;
import java.util.*;

public class Main {
    static long N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        long result = 0;
        long len;
        while (N > 9){
            len = Long.toString(N).length();
            result += (long) ((N - Math.pow(10, len - 1) + 1) * len);
            N = (long) Math.pow(10, len - 1) - 1;
        }
        result += N;
        System.out.println(result % 1234567);
    }
}