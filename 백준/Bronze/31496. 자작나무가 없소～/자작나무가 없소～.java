import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String word = st.nextToken();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String[] arg = st.nextToken().split("_");
            int num = Integer.parseInt(st.nextToken());
            int len = arg.length;
            for (int j = 0; j < len; j++) {
                if(arg[j].equals(word)){
                    ans += num;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}