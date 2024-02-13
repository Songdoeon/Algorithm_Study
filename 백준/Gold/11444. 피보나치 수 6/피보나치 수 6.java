import java.io.*;
import java.util.*;
public class Main {
	static final int MOD = 1_000_000_007;
    
	static long[][] mul(long[][] X, long[][] R){
		long[][] C = {{0, 0}, {0, 0}};

	    for(int i=0; i<2; i++)
	        for(int j=0; j<2; j++)
	            for(int k=0; k<2; k++)
	                C[i][j] = (C[i][j] + X[i][k]*R[k][j]) % MOD;

	    return C;
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
