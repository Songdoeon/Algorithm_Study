import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        int len1 = s1.length;
        int len2 = s2.length;
        int max = 0;
        int[][] map = new int[len1 + 1][len2 + 1];

        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(s1[i - 1] == s2[j - 1]) {
                    map[i][j] = map[i - 1][j - 1] + 1;
                    max = Math.max(max, map[i][j]);
                }
            }
        }

        System.out.println(max);
    }
}