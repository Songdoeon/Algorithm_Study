import java.io.*;
import java.util.*;

public class Main extends Exception {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int STR = Integer.parseInt(st.nextToken());
        int DEX = Integer.parseInt(st.nextToken());
        int INT = Integer.parseInt(st.nextToken());
        int LUK = Integer.parseInt(st.nextToken());
        int avg = Integer.parseInt(st.nextToken());

        int current = (STR + DEX + INT + LUK);

        int answer = (avg * 4 - current);

        if (current >= avg * 4){
            answer = 0;
        }

        sb.append(answer);
        System.out.println(sb.toString());
    }
}