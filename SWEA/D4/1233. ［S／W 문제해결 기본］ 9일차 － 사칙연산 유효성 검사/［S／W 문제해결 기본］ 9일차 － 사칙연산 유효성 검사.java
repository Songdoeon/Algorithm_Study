import java.io.*;
import java.util.*;

public class Solution {
	static char[] arr;
	static int N;
	static boolean check;
	static boolean check(String[] arg) {
		
		if(arg.length == 4 && Character.isDigit(arg[1].charAt(0))) {
			return false;
		}
		else if(arg.length == 2 && !Character.isDigit(arg[1].charAt(0))) {
			return false;
		}
		return true;
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int t = 1; t <= 10; t++){
			N = Integer.parseInt(br.readLine());
			check = true;
			arr = new char[N + 1];
			for(int i = 1; i <= N; i++) {
				String[] arg = br.readLine().split(" ");
				if(!check(arg)) {
					sb.append("#").append(t).append(" ").append(0).append('\n');
					check = false;
					for(int j = 0; j < N - i; j++) {
						br.readLine();
					}
					break;
				}	
			}
			if(check)sb.append("#").append(t).append(" ").append(1).append('\n');
			

		}
		System.out.println(sb);
	}

}
