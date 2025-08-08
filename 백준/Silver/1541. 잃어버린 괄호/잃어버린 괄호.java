import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 14908

public class Main {
    static String info;
    static char[] ops;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        info = br.readLine();
        int ans = 0;
        boolean flag = false;
        for (String arg : info.split("-")) {
            int sum = 0;
            for (String s : arg.split("[+]")) sum += Integer.parseInt(s);
            
            if(!flag) {
                ans += sum;
                flag = true;
            }
            else ans -= sum;
        }
        System.out.println(ans);
    }
}
