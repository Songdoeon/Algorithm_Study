import java.util.*;
import java.io.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;
        while((line = br.readLine()) != null && !line.isEmpty()) {
            st = new StringTokenizer(line);
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append('\n');
        }
        System.out.println(sb);
    }
}
