import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 1;
        while (!st.nextToken().equals("0")){
            sb.append("Case " + idx++).append(": Sorting... done!").append("\n");
            st = new StringTokenizer(br.readLine());
        }
        System.out.println(sb);
    }
}
