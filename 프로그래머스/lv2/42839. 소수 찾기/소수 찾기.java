import java.util.*;
class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static int count = 0;
    public int solution(String numbers) {
        
        call("",numbers);
        
        for(int i : set){
            isPrime(i);
        }
        
        return count;
    }
    
    //소수 여부 확인
    public static void isPrime(int n) {
        if(n==1 || n == 0){
            return;
        }
	    for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return;
            }
	    }
        count++;
    }
    
    public static void call(String num, String nums){
        if(!num.equals("")){
            set.add(Integer.parseInt(num));
        }
        for(int i=0;i<nums.length();i++){
            call(num + nums.charAt(i), nums.substring(0,i)+nums.substring(i+1));    
        }
    }
}