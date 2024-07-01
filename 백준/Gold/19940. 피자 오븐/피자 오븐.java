import java.io.*;
import java.util.*;

class Main {
    static int N;
    static final int hour = 60;
    static final int ten = 10;
    static final int minute = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int a, b, c, d, e;
        while (N-- > 0){
            a = b = c = d = e = 0;
            int num = Integer.parseInt(br.readLine());
            a = num / 60;
            num %= 60;
            if(num > 35) {
                a++;
                c = 5 - (num / 10);
                num %= 10;
                if(num < 5) {
                    c++;
                    d = num;
                }
                else{
                    e = 10 - num;
                }
            }
            else {
                b = num / 10;
                num %= 10;
                if(num <= 5) {
                    d = num;
                }
                else{
                    b++;
                    e = 10 - num;
                }
            }
            sb.append(a + " " + b + " " + c + " " + d + " " + e + "\n");
        }
        System.out.println(sb);
    }
}
