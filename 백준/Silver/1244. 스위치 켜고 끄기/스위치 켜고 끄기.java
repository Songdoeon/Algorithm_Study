import java.util.*;
import java.io.*;

public class Main {
	static boolean[] switchArr;
	static int N;
	static StringBuilder sb = new StringBuilder();
	// 1 남자
	static void man(int num) {
        int x = num;
		while(num <= N) {
			switchArr[num] = !switchArr[num];
			num += x;
		}
	}
	// 0 여자
	static void woman(int num) {		
        switchArr[num] = !switchArr[num];
		int start = num - 1;
		int end = num + 1;
        while(start > 0 && end <= N){
            if(switchArr[start] == switchArr[end]){
                switchArr[start] = !switchArr[start--];
                switchArr[end] = !switchArr[end++];
            }
            else break;
        }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		switchArr = new boolean[N + 1]; 
		int student, gender;
		for(int i = 1; i <= N; i++) {
			String token = st.nextToken();
			switchArr[i] = token.equals("1") ? true : false; 
		}
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			gender = Integer.parseInt(st.nextToken());
			student = Integer.parseInt(st.nextToken());
			if(gender == 1) man(student);
			else woman(student);
		}
		for(int i = 1; i <= N; i++) {
			int num = switchArr[i] == true ? 1 : 0;
			sb.append(num).append(" ");
            if(i % 20 == 0) sb.append('\n');
		}
		System.out.println(sb);
	}
}
