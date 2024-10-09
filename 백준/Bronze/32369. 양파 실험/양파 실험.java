import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main {
    static int N, A, B;
    static char[][][] visited;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int a = 1;
        int b = 1;
        for (int i = 0; i < N; i++) {
            a += A;
            b += B;
            if(a < b){
                int temp = b;
                b = a;
                a = temp;
            }
            else if(a == b){
                b--;
            }
        }

        System.out.println(a + " " + b);
    }
}