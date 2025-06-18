import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 34031

public class Main {
    static String s1, s2;
    static int len1, len2;
    static long[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();
        len1 = s1.length();
        len2 = s2.length();
        count = new long[200_001];
        int value = 0;
        for (int i = 1; i <= len1; i++) {
            char c = s1.charAt(i - 1);
            if(c == '(') value += 1;
            else value -= 1;
            if(value >= 0) count[value]++;
            else break;
        }
        long ans = 0;
        value = 0;
        int min = 0;
        for (int i = 1; i <= len2; i++) {
            char c = s2.charAt(i - 1);
            if(c == '(') value += 1;
            else value -= 1;
            min = Math.min(min, value);
            if(value <= 0 && value == min) ans += count[value * -1];
        }

        System.out.println(ans);
    }
}