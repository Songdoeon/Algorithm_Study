import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static double N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Double.parseDouble(st.nextToken());
        M = Double.parseDouble(st.nextToken());
        System.out.println(N + M - Math.sqrt((Math.pow(N, 2) + Math.pow(M, 2))));
    }
}