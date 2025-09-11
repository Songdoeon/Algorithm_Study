import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String s;
    static int N, idx, k;
    static boolean flag = true;

    static boolean calc(char c){
        for (int t = 0; t < k; t++) {
            if (idx >= N || s.charAt(idx) != c) {
                flag = false;
                return false;
            }
            idx++;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        N = s.length();
        idx = 0;

        while (idx < N) {
            k = 0;
            while (idx < N && s.charAt(idx) == 'w') {
                k++;
                idx++;
            }

            if (k == 0) {
                flag = false;
                break;
            }

            if (!calc('o')) break;
            if (!calc('l')) break;
            if (!calc('f')) break;
        }
        System.out.println(flag ? 1 : 0);
    }
}
