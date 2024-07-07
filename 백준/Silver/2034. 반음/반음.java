import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] arr;
    static int[] starts = {0, 2, 3, 5 ,7, 8, 10};
    static char[] chars = {'A', 'X', 'B', 'C', 'X', 'D', 'X', 'E', 'F', 'X', 'G', 'X',};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        boolean flag;
        for (int i = 0; i < 7; i++) {
            int idx = starts[i];
            flag = false;
            for (int j = 0; j < N; j++) {
                if(chars[idx] =='X'){
                    flag = true;
                    break;
                }
                idx += arr[j];
                idx %= 12;
                if(idx < 0) idx += 12;
            }
            if (!flag && chars[idx] != 'X') {
                sb.append(chars[starts[i]]).append(' ');
                sb.append(chars[idx]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
