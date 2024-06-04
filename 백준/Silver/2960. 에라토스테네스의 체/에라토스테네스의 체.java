import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = new int[nums[0] + 1];

        for (int i = 2; i <= nums[0]; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= nums[0]; i++) {
            if (arr[i] == 0) continue;
            for (int j = i; j <= nums[0]; j+=i) {
                if (arr[j] != 0) {
                    arr[j] = 0;
                    nums[1]--;
                    if (nums[1] == 0) {
                        System.out.print(j);
                        return;
                    }
                }
            }
        }
    }
}
