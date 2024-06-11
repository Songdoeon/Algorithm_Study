import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int pow = Integer.parseInt(st.nextToken());

        while (!set.contains(num)) {
            set.add(num);
            String s = num + "";
            num = 0;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                num += (int) Math.pow(s.charAt(i) - '0', pow);
            }
        }
        while (set.contains(num)){
            set.remove(num);
            String s = num + "";
            num = 0;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                num += (int) Math.pow(s.charAt(i) - '0', pow);
            }
        }
        System.out.println(set.size());
    }
}