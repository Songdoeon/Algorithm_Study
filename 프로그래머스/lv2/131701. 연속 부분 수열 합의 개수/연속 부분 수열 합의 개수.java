import java.util.*;
class Solution {
    
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int length = elements.length;
        
        for(int idx = 0; idx < length; idx++){
            sum = elements[idx];
            set.add(sum);
            for(int idx2 = idx+1; idx2 < idx + length; idx2++){
                sum += elements[idx2 % length];
                set.add(sum);
            }
        }
        
        // Iterator<Integer> iter = set.iterator();
        // while(iter.hasNext()) System.out.println(iter.next());
        return set.size();
    }
}