import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long ans = 0;
        long num = 1;
        long idx = 0;
        long sum;
        while ((sum = 1L << idx++) < n * 2){
            if((n & sum) > 0)ans += num;
            num *= 3;
        }
        System.out.println(ans);
    }
}