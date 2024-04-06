import java.util.*;
import java.io.*;


class Main{
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr,(o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb.charAt(0) == '0' ? 0 : sb);
    }
}