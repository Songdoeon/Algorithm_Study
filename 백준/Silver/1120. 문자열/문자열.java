import java.io.*;
import java.util.*;


class Main {
    static int score, N, P;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] arr1 = st.nextToken().toCharArray();
        char[] arr2 = st.nextToken().toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        int ans = 0;
        for (int i = 0; i <= len2 - len1; i++) {
            int temp = 0;
            for (int j = i; j < len1 + i; j++) {
                if(arr1[j - i] == arr2[j]) temp++;
            }
            ans = Math.max(ans, temp);
        }
        System.out.println(len1 - ans);
    }
}