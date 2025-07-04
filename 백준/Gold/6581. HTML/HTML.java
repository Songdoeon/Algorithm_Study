import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6581

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        int curLen = 0;
        while((line=br.readLine())!=null) {
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                if(s.equals("<br>")){
                    sb.append('\n');
                    curLen = 0;
                }
                else if(s.equals("<hr>")){
                    if(curLen != 0) sb.append('\n');
                    for (int i = 0; i < 80; i++) sb.append('-');
                    sb.append('\n');
                    curLen = 0;
                }
                else{
                    int len = s.length();
                    if(curLen == 0){
                        sb.append(s);
                        curLen = len;
                    }else if(curLen + len + 1 <= 80){
                        sb.append(' ').append(s);
                        curLen += len + 1;
                    }
                    else{
                        sb.append('\n');
                        sb.append(s);
                        curLen = len;
                    }

                }
            }

        }
        System.out.println(sb);
    }
}
