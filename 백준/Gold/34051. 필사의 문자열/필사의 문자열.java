import java.io.BufferedReader;
import java.io.InputStreamReader;

// 34051

public class Main {
    static int N;
    static String str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        char[] arr = new char[N];

        arr[N - 1] = str.charAt(N - 1);
        for (int i = N - 2; i >= 0; i--) arr[i] = (char) Math.max(arr[i + 1], str.charAt(i));

        String best = str;
        boolean flag = false;
        for (int i = 0; i < N - 1; i++) {
            char target = arr[i];
            if(str.charAt(i) < target){
                for (int j = N - 1; j > i; j--) {
                    if (str.charAt(j) != target) continue;
                    String cand = str.substring(0, i)
                            + new StringBuilder(str.substring(i, j + 1)).reverse()
                            + str.substring(j + 1);
                    if (cand.compareTo(best) > 0) best = cand;
                    flag = true;
                }
                break;
            }
        }
        System.out.println(flag ? best : str);
    }
}