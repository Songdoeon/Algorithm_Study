import java.io.BufferedReader;
import java.io.InputStreamReader;

// 2232 - 11:40 시작

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 1; i <= N + 1; i++) {
            if(flag){
                if (arr[i - 1] >= arr[i]) {
                    flag = false;
                    sb.append(i - 1).append('\n');
                }
            }
            if(arr[i - 1] <= arr[i]){
                flag = true;
            }
        }
        System.out.println(sb);


    }
}