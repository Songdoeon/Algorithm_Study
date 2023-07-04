import java.util.*;
import java.util.stream.Stream;
class Solution {
    public String solution(String s) {
        int[] num = Stream.of(s.split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int max = num[0];
        int min = num[0];
        for(int i=0;i<num.length;i++){
            max = Math.max(num[i],max);
            min = Math.min(num[i],min);
        }   

        return Integer.toString(min)+" "+Integer.toString(max);
    }
}