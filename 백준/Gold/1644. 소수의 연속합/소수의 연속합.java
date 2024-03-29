import java.util.*;
import java.io.*;

class Main{
    static List<Integer> primeList = new ArrayList<>();

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
    static void fillPrime(int num){
        for(int i = 2; i <= num; i++){
            if(isPrime(i)) primeList.add(i);
        }
    }

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        StringTokenizer st;
        int start = 0;
        int end = 1;
        fillPrime(N);
        int len = 0;
        int sum = 0;
        if(N != 1) {
            len = primeList.size();
            sum = primeList.get(start);
        }

        while(start < len && end <= len){
            if(sum < N) {
                if(end == len) break;
                sum += primeList.get(end++);
            }
            else if(sum == N) {
                sum -= primeList.get(start++);
                answer++;
            }
            else {
                sum -= primeList.get(start++);
            }
        }
        System.out.println(answer);
    }
}