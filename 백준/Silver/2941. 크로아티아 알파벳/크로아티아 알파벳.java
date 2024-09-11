import java.io.*;

public class Main {
    static int answer = 0;
    static String input;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();

        int len = input.length();

        input = input.replace("dz=", ".");

        answer += (len - input.length()) / 2;
        len = input.length();

        input = input.replace("c=", ".");

        answer += (len - input.length());
        len = input.length();
        input = input.replace("c-", ".");

        answer += (len - input.length());
        len = input.length();
        input = input.replace("d-", ".");

        answer += (len - input.length());
        len = input.length();
        input = input.replace("lj", ".");

        answer += (len - input.length());
        len = input.length();
        input = input.replace("nj", ".");

        answer += (len - input.length());
        len = input.length();
        input = input.replace("s=", ".");

        answer += (len - input.length());
        len = input.length();
        input = input.replace("z=", ".");

        answer += (len - input.length());
        
        input = input.replace(".", "");
        System.out.println(answer + input.length());
    }
}
