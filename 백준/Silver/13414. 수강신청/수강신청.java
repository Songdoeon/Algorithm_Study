import java.io.*;
import java.util.*;
public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < M; i++) {
            String num = br.readLine();
            set.remove(num);
            set.add(num);
        }

        for (String s : set) {
            if(N-- > 0){
                sb.append(s).append('\n');
            }
        }

        System.out.println(sb);
    }
}