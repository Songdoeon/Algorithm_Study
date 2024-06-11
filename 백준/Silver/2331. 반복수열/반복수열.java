import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[500_000];
        int num = Integer.parseInt(st.nextToken());
        int pow = Integer.parseInt(st.nextToken());
        int cnt = 1;
        while (arr[num] == 0) {
            arr[num] = cnt++;
            String s = num + "";
            num = 0;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                num += (int) Math.pow(s.charAt(i) - '0', pow);
            }
        }
        System.out.println(arr[num] - 1);
    }
}