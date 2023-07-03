import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int answer = nums.length/2;
        for(int i : nums){
            set.add(i);
        }
        if(set.size()<answer){
            answer = set.size();
        }
        return answer;
    }
}