import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String exec = br.readLine();
            if(exec.equals("ENTER")) {
                ans += set.size();
                set = new HashSet<>();
            }
            else set.add(exec);
        }
        System.out.println(ans + set.size());
    }
}