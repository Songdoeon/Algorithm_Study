import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        int size = numbers.length;
        int answer = 0;
        for(int idx=0;idx<10;idx++){
            set.add(idx);
        }
        
        for(int idx=0;idx<size;idx++){
            set.remove(numbers[idx]);
        }
        Iterator iter = set.iterator();
        while(iter.hasNext()){
            int next = (int)iter.next();
            answer += next;
        }
        
        return answer;
    }
}