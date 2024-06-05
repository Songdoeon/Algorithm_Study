import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while(n-- > 0){
            String s = br.readLine();
            sb.append(s).append(' ').append(s).append('\n');
        }
        System.out.println(sb);
    }
}
