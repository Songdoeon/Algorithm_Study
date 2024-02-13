import java.io.*;
import java.util.*;
public class Main {
	static final int MOD = 1_000_000_007;
    
	static long[][] mul(long[][] X, long[][] R){
		return new long[][] {{(X[0][0] * R[0][0] + X[0][1] * R[1][0]) % MOD,
							(X[0][0] * R[0][1] + X[0][1] * R[1][1]) % MOD},
							{(X[1][0] * R[0][0] + X[1][1] * R[1][0]) % MOD,
								(X[1][0] * R[0][1] + X[1][1] * R[1][1]) % MOD}
		};
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long[][] X = new long[][] {{1,1}, {1,0}};
        long[][] E = new long[][] {{1,0}, {0,1}};
        
        while(N > 0) {
        	if(N % 2 == 1) E = mul(X, E);
        	X = mul(X, X);
        	N /= 2;
        }

        System.out.println(E[0][1]);
    }
}
