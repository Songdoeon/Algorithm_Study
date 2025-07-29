import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 25918

public class Main {
    static int N;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N % 2 != 0){
            System.out.println(-1);
            return ;
        }

        arr = br.readLine().toCharArray();

        int balance = 0;
        int maxDepth = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == '(') balance++;
            else balance--;
            maxDepth = Math.max(maxDepth, Math.abs(balance));
        }

        System.out.println(balance != 0 ? -1 : maxDepth);
    }
}
