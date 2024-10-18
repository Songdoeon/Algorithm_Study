import java.util.*;
import java.io.*;

public class Main
{
    static int T, N;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st.nextToken();
        int M = Integer.parseInt(st.nextToken());
        st.nextToken();
        int result = Integer.parseInt(st.nextToken());
		
		System.out.print(N + M == result ? "YES" : "NO");
	}
}
