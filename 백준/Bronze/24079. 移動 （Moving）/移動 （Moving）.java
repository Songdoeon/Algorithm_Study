import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int z = Integer.parseInt(br.readLine());
       
        System.out.println(N + b > z ? 0 : 1);
    }
}