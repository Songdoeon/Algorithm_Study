import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> keyword = new HashSet<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N ; i++) {
            keyword.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String[] words = br.readLine().split(",");
            int len = words.length;

            for (int j = 0; j < len; j++) {
                keyword.remove(words[j]);
            }
            sb.append(keyword.size()).append('\n');
        }
        System.out.println(sb);
    }
}