import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] arr = br.readLine().toCharArray();
        int n = arr.length;
        int idx = 0;
        int num = 1;
        String s;
        while (true) {
            s = String.valueOf(num);
            int len = s.length();
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == arr[idx]) {
                    if(++idx == n) {            
                        System.out.println(num);
                        return ;
                    }
                }
            }
            num++;
        }

    }
}