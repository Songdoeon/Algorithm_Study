import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static String S;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        int len = S.length();
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) set.add(S.substring(i, j + 1));
        }
        
        System.out.println(set.size());
    }
}
