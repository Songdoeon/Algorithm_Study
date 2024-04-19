import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static boolean isPrime(int num){
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        for(int i = 3; i <= (int) Math.sqrt(num); i += 2){
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
    static boolean isPalindrome(int n){
        String str = String.valueOf(n);
        int len = str.length();
        int start = 0;
        int end = len - 1;
        while (start <= end){
            if(str.charAt(start++) != str.charAt(end--))return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        if(N == 1){
            System.out.println(2);
            return ;
        }
        while (true){
            if(isPrime(N) && isPalindrome(N)) break;
            N++;
        }
        System.out.print(N);
    }
}