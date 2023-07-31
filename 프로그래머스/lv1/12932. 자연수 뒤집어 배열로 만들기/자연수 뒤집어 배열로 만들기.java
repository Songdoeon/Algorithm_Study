import java.util.*;
import java.util.stream.Stream;
class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        String sb = new StringBuilder(new String(str)).reverse().toString();
        char[] cs = sb.toCharArray();
        int[] answer = new int[cs.length];
        // int[] answer = Stream.of(cs).map(i -> i - '0').toArray();
        for(int i = 0;i < cs.length; i++){
            answer[i] = cs[i]-'0';
        }
        return answer;
    }
}