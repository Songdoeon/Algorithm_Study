import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = N;
        int answer = 0;
        while(N >= 5){
            answer += N / 5;
            N = N % 5;
        }
        if(N == 0) {
            System.out.println(answer);
            return ;
        }
        else if (N >= 1 && answer != 0){
            for(int i = 0; i < 3; i++){
                if(max < N) break;
                if(N % 3 == 0) {
                    answer += N / 3;
                    N %= 3;
                    break;
                }
                answer--;
                N += 5;
            }
        }
        else{
            while(N >= 3){
                answer += N / 3;
                N = N % 3;
            }
        }
        if(N != 0)System.out.println(-1);
        else System.out.println(answer);
    }

}
