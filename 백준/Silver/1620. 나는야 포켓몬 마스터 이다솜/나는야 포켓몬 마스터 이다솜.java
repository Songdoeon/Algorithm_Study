import java.util.*;
import java.io.*;

public class Main {
	static int numExec = 0;
	static boolean isNumber(String strValue) {
	    try {
	    	numExec = Integer.parseInt(strValue);
	      return true;
	    } catch (NumberFormatException ex) {
	      return false;
	    }
	  }

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<String, Integer> stringMap = new HashMap<>();
		Map<Integer, String> intMap = new HashMap<>();
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		for(int i = 1; i <= N; i++) {
			String exec = br.readLine();
			stringMap.put(exec, i);
			intMap.put(i, exec);
		}

		for(int i = 0; i < E; i++) {
			String exec = br.readLine();
			if(isNumber(exec)) System.out.println(intMap.get(numExec));
			else System.out.println(stringMap.get(exec));
		}
		
	}
}