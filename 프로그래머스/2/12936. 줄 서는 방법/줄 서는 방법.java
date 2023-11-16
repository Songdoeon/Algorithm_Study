import java.util.*;
class Solution {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long max = 1;
        for(int i = 1; i <= n; i++){
            list.add(i);
            max *= (long) i;
        }
        int index = 0;
        k--;
        
        while(index < n) {
            max /= n - index;
            answer[index++] = list.remove((int) (k / max));
            k %= max;
        }
        
        return answer;
    }
}