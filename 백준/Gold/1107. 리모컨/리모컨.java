import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        size = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];
        StringTokenizer st;
        if(size != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < size; i++) broken[Integer.parseInt(st.nextToken())] = true;
        }

        
        int result = Math.abs(N - 100);

        for (int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);

            boolean isBreak = false;
            for (int j = 0; j < num.length(); j++) {
                if (broken[num.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) {
                int min = Math.abs(N - i) + num.length();
                result = Math.min(min, result);
            }
        }
        System.out.println(result);
    }
}

