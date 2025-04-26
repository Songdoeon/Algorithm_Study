import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int[] arr = new int[10];
 
		int val = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
 
		String str = String.valueOf(val);
        int len = str.length();
		for (int i = 0; i < len; i++) {
			arr[(str.charAt(i) - 48)]++;
		}
 
		for(int i = 0; i < 10; i++){
            sb.append(arr[i]).append('\n');
        }
         System.out.println(sb);
	}
}