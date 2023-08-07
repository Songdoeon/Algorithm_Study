import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        String[] args = str.split("");
        Arrays.sort(args,Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String arg : args){
            sb.append(arg);
        }
        return Long.parseLong(sb.toString());
    }
}