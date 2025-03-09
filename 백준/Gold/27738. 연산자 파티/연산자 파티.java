import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, A, B, C, D, E, F;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        long X = 0;
        int i = N / F * F;
        while (++i <= N){
            if(i % A == 0) X += i;
            if(i % B == 0) X %= i;
            if(i % C == 0) X &= i;
            if(i % D == 0) X ^= i;
            if(i % E == 0) X |= i;
        }
        System.out.println(X);
    }
}
