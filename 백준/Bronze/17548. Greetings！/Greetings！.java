
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        sb.append('h').append("e".repeat((s.length() - 2) * 2)).append('y');
        System.out.println(sb);

    }
}