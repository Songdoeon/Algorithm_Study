import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String word = "SciComLove";
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0){
            sb.append(word).append('\n');
        }
        System.out.println(sb);
    }
}
