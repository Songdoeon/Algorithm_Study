import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            String s = st.nextToken();
            String t = st.nextToken();
            int len = s.length();
            List<Integer> list = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if(s.charAt(i) == 'b') list.add(i);
                if(t.charAt(i) == 'b') list2.add(i);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sum += Math.abs(list.get(i) - list2.get(i));
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}