import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 25918

public class Main {
    static int A, B;
    static StringBuilder sb = new StringBuilder();
    static void search(int num){
        if(num < B) {
            sb.append(num).append(' ');
            return ;
        }
        search(num / B);
        sb.append(num % B).append(' ');
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = m - 1; i > 0; i--) {
            int n = Integer.parseInt(st.nextToken());
            sum += n * Math.pow(A, i);
        }
        sum += Integer.parseInt(st.nextToken());
        search(sum);
        System.out.println(sb);
    }
}

