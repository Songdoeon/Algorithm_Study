import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
 
class Solution{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int test_case = 1; test_case <= T; test_case++){
            System.out.println("#" + test_case);
 
            int size = Integer.parseInt(br.readLine());
            int[][] arr = new int[size][size];
            for(int i = 0; i < size; i++){
                int[] tempArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                arr[i] = tempArr;
            }
            StringBuilder sb = new StringBuilder();
            size--;
            for(int i = 0; i <= size; i++){
                for(int idx = 0; idx <= size; idx++){
                    sb.append(arr[size - idx][i]);
                }
                sb.append(" ");
                for(int idx = 0; idx <= size; idx++){
                    sb.append(arr[size - i][size - idx]);
                }
                sb.append(" ");
                for(int idx = 0; idx <= size; idx++){
                    sb.append(arr[idx][size - i]);
                }
                System.out.println(sb.toString());
                sb.setLength(0);
            }
        }
    }
}