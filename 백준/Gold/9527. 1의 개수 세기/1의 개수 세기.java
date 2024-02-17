import java.util.*;
import java.io.*;

class Main{
    static long N, M;
    static long MOD = 2;

    static long check(long num){
        MOD = 2;
        long result = 0;
        num++;
        while (MOD <= num){
            if(num == MOD) result += (MOD / 2);
            else {
                if(num % MOD >= (MOD / 2))result += num % MOD - (MOD / 2);
                result += (num / MOD) * (MOD / 2);
            }

            MOD *= 2;
        }

        if(num % MOD >= (MOD / 2))result += num % MOD - (MOD / 2);

        return result;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        long a = check(N - 1);
        long b = check(M);
        System.out.println(b - a);
    }
}