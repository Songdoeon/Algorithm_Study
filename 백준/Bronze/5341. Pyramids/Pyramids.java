import java.util.*;
import java.io.*;

public class Main {
    static int N;

    static int calc(int n){
        int ret = n;
        while (n-- > 1){
            ret += n;
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        while (!(line = br.readLine()).equals("0")) {
            int n = Integer.parseInt(line);
            sb.append(calc(n)).append('\n');
        }
        System.out.println(sb);
    }
}