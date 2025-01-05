import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        int len = word.length() - 1;
        int a = 0;
        int b = 0;
        int c = 0;
        int ans = 0;
        for (int i = len; i >= 0; i--) {
            char ch = word.charAt(i);
            if(ch == 'C') c++;
            else if(ch == 'B'){
                b++;
                if(c > 0){
                    c--;
                    b--;
                    ans++;
                }
            }
            else{
                a++;
                if(b > 0){
                    a--;
                    b--;
                    ans++;
                }
            }
        }
       System.out.println(ans);
    }
}