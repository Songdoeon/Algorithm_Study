import java.io.*;
import java.util.*;

class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>(Arrays.asList("Never gonna give you up",
                "Never gonna let you down",
                "Never gonna run around and desert you",
                "Never gonna make you cry",
                "Never gonna say goodbye",
                "Never gonna tell a lie and hurt you",
                "Never gonna stop"));
        int N = Integer.parseInt(br.readLine());
        while (N --> 0){
            if (!set.contains(br.readLine())){
                System.out.println("Yes");
                return ;
            }
        }
        System.out.println("No");
    }
}
