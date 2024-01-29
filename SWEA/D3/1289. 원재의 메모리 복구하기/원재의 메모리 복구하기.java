import java.io.*;

public class Solution{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int answer, len, num;
		
		for(int t = 1; t <= T; t++){
			answer = 1;
            String str = br.readLine();
            len = str.length();
            num = str.indexOf("1");
            if(num == -1) answer = 0;
            else {
                char c = str.charAt(num);
            	for(int i = num; i < len - 1; i++) {
            		if(c != str.charAt(i + 1)) answer++;
                    c = str.charAt(i + 1);
            	}
            }
            System.out.println("#"+t+ " " + answer);
		}
	}
}