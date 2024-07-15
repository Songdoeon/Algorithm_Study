import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long sum = 0;

        while (N > 0){
            sum += (long) Math.pow(N--, 3);
        }
        System.out.println(sum);
    }
}