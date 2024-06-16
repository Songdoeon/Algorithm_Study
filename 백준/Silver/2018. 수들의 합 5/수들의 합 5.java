import java.io.*;

class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(1);
            return ;
        }
        if(N == 2){
            System.out.println(1);
            return ;
        }
        if(N == 3){
            System.out.println(2);
            return ;
        }
        int s = 1;
        int e = 3;
        long sum = 3;
        int ans = 1;
        while (e != N){
//            System.out.println(sum);
            if(sum > N) {
                sum -= s++;
            }
            else if(sum < N) {
                sum += e++;
            }
            else {
                ans++;
                sum -= s++;
                sum += e++;
            }
        }
        System.out.println(ans);
    }
}