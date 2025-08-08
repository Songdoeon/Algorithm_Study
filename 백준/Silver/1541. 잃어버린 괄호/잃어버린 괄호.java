import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 14908

public class Main {
    static String info;
    static char[] ops;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        info = br.readLine();
        ops = info.replaceAll("[^+-]", "").toCharArray();
        int len = ops.length;
        nums = new int[len + 1];
        int idx = 0;

        for (String num : info.split("[+-]")) nums[idx++] = Integer.parseInt(num);
        int ans = nums[0];
        for (int i = 0; i < len; i++) {
            if(ops[i] == '+') ans += nums[i + 1];
            else{
                int j = i;
                int tempSum = 0;
                while(j < len - 1 && ops[j + 1] != '-') j++;
                for (int k = i; k <= j; k++) {
                    tempSum += nums[k + 1];
                }
                i = j;
                ans -= tempSum;
            }
        }
        System.out.println(ans);
    }
}
