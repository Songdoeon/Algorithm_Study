import java.io.*;

// 15927

public class Main {
    static int N;
    static String s;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        N = s.length();

        int i = 0, j = N - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                System.out.println(N);
                return;
            }
        }

        boolean flag = true;
        for (int k = 1; k < N; k++) {
            if (s.charAt(k) != s.charAt(0)) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? -1 : N - 1);
    }
}
