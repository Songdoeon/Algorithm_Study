import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static String word;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        int len = word.length();
        int a = 0;
        int b = 0;
        int c = 0;
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
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
        a = b = c = 0;
        int ans2 = 0;
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if(ch == 'A') a++;
            else if(ch == 'B'){
                b++;
                if(a > 0){
                    a--;
                    b--;
                    ans2++;
                }
            }
            else{
                c++;
                if(b > 0){
                    b--;
                    c--;
                    ans2++;
                }
            }
        }
        System.out.println(Math.max(ans, ans2));
    }
}