import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] sourArr = new int[N]; 
		int[] bitterArr = new int[N]; 
		int count = 1 << N;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sourArr[i] = Integer.parseInt(st.nextToken());
			bitterArr[i] = Integer.parseInt(st.nextToken());
		}
		int min = Integer.MAX_VALUE;
		int sour, bitter;
        if(N == 1) {
            System.out.println(Math.abs(sourArr[0] - bitterArr[0]));
            return ;
        }
		for(int i = 1; i < count; i++) {
			sour = 1;
			bitter = 0;
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) == (1 << j)) {
					sour *= sourArr[j];
					bitter += bitterArr[j];
				}
			}
			min = Math.min(min, Math.abs(sour - bitter));
            if(min == 0) {
                System.out.println(0);
                return ;
            }
		}
		System.out.println(min);
	}
}