import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        for(int price : d){
            if(budget >= price) {
                budget -= price;
                answer++;
            }
            else break;
        }
        return answer;
    }
}