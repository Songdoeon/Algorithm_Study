import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. N 값 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 2. 피보나치 값 만들기
        // 45까지라서 21억을 넘지 않으므로 int형으로도 커버 가능하다
        int[] arr = new int[46];

        // 3. 피보나치 초기값 설정
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 0; i < N; i++){

            sb.append(fibo(Integer.parseInt(br.readLine()), arr)).append("\n");
        }

        System.out.println(sb);

    }

    public static int fibo(int n, int[] arr){
        if(arr[n] != 0) return arr[n];

        return arr[n] = fibo(n - 1, arr) + fibo(n - 2, arr);
    }
}