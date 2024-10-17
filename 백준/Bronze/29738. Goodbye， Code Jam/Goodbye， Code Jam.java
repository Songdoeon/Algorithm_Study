import java.util.*;
import java.io.*;

public class Main
{
    static int T, N;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++){
		    N = Integer.parseInt(br.readLine());
		    if(N<=25) sb.append("Case #").append(t).append(": World Finals\n");
		    else if(N<=1000) sb.append("Case #").append(t).append(": Round 3\n");
		    else if(N<=4500) sb.append("Case #").append(t).append(": Round 2\n");
		    else sb.append("Case #").append(t).append(": Round 1\n");
		}
		
		System.out.print(sb);
	}
}
