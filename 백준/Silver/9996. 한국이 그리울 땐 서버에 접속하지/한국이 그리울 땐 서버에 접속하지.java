import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String[] arg;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        arg = line.split("\\*");
        StringBuilder sb = new StringBuilder();
        int min = arg[0].length() + arg[1].length();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int len = s.length();
            if(s.length() < min){
                sb.append("NE").append('\n');
                continue;
            }
            int idx1 = s.indexOf(arg[0]);
            int idx2 = s.lastIndexOf(arg[1]);
            if(idx1 == 0 && idx2 == len - arg[1].length()) sb.append("DA");
            else sb.append("NE");
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
