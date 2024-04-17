import java.io.*;
import java.util.*;

public class Main{

    static int N;
    static char[] charArr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        charArr = br.readLine().toCharArray();
        int len = charArr.length;
        int[][] arr = new int[3][len + 1];
        for (int i = 0; i < len; i++) {
            arr[2][i + 1] = arr[2][i];
            arr[1][i + 1] = arr[1][i];
            if(charArr[i] == '(') arr[0][i + 1] = arr[0][i] + 1;
            else {
                arr[0][i + 1] = arr[0][i] - 1;
                if(arr[1][i + 1] > arr[0][i + 1])arr[1][i + 1] = arr[0][i + 1];
                if(charArr[i - 1] == '('){
                    if(arr[0][i] > 1){
                        arr[1][i + 1] = arr[0][i + 1];
                        arr[2][i + 1] += (arr[0][i] - 1 - arr[1][i]) * 2;
                        arr[2][i + 1] += arr[1][i] < 1 ? 0 : arr[1][i];
                    }
                }
            }
        }

        System.out.println(arr[2][len]);
    }
}