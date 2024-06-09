import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int result = 0;
        for (int i = 1; i <= N; i *= 10) {
			result += N - i + 1; 
		}
		System.out.println(result);
    }
}