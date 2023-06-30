import java.util.*;
import java.util.stream.Stream;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        String[] chars = number.split("");
        int[] num = Stream.of(number.split(""))
            .mapToInt(Integer::parseInt)
            .toArray();
        int index=0;
        int max = 0;
        int count = num.length-k;
        for(int i=0;i<count;i++){
            for(int j=index;j<=k+i;j++){
                if(num[j]>max){
                    max=num[j];
                    index=j+1;
                }
            }
            answer.append(max);
            max=0;
        }
        return answer.toString();
    }
}