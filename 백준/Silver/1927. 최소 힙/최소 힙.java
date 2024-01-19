import java.util.*;
import java.io.*;

public class Main {
	 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0 && !queue.isEmpty()) {
				System.out.println(queue.poll());
			}
			else if(n == 0 && queue.isEmpty()) {
				System.out.println("0");
			}
			else {
				queue.add(n);
			}
		}	
	}
}
