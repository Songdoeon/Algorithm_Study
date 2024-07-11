import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 91;
        n += Integer.parseInt(br.readLine());
        n += Integer.parseInt(br.readLine()) * 3;
        n += Integer.parseInt(br.readLine());

        System.out.println("The 1-3-sum is " + n);
    }
}