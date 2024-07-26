import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            String name = st.nextToken();
            if(name.equals("#"))break;
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            sb.append(name).append(' ');
            if(age > 17 || weight >= 80) sb.append("Senior");
            else sb.append("Junior");
            sb.append('\n');
            st = new StringTokenizer(br.readLine());
        }
        System.out.println(sb);
    }
}