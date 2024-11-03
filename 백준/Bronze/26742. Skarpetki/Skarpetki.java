import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] socks = br.readLine().toCharArray();

        int whiteCount = 0;
        int blackCount = 0;

        for (char c : socks) {
            if (c == 'B') {
                whiteCount++;
            } else {
                blackCount++;
            }
        }

        int pair = whiteCount / 2 + blackCount / 2;
        System.out.println(pair);
    }
}