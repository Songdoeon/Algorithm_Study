import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    for(int i=1;i<=N;i++){
            sb.append("Hello World, Judge ").append(i).append("!\n");
	       }
	    
		System.out.println(sb);
	}
}
