import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String minName = "", maxName = "";
        int minAge = 999_999_999, maxAge = 0;
        String[] info;
        String name;
        for (int i = 0; i < N; i++) {
            info = br.readLine().split(" ");
            name = info[0];
            int days = Integer.parseInt(info[1]);
            days += Integer.parseInt(info[2]) * 30;
            days += Integer.parseInt(info[3]) * 365;
            if(days > maxAge) {
                maxAge = days;
                maxName = name;
            }
            else if(days < minAge) {
                minAge = days;
                minName = name;
            }
        }
        System.out.println(maxName + "\n" + minName);
    }
}