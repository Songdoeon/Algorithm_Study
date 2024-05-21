import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Double n = Double.parseDouble(st.nextToken());
        Double m = Double.parseDouble(st.nextToken());
        Double M = (m - n) / 400;
        Double ans = 1 + Math.pow(10, M);
        System.out.println(Math.pow(ans, -1));
    }
}