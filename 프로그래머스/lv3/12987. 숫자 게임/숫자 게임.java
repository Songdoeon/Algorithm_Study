import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int num = A.length;
        PriorityQueue<Integer> Aq = new PriorityQueue<>();
        PriorityQueue<Integer> Bq = new PriorityQueue<>();
        
        for(int i = 0; i < num; i++){
            Aq.add(A[i]);
            Bq.add(B[i]);
        }
        
        while(!Bq.isEmpty() && !Aq.isEmpty()){
            if(Aq.peek() < Bq.peek()){
                answer++;
                Aq.remove();
                Bq.remove();
            }
            else if(Aq.peek() == Bq.peek()){
                Bq.remove();
            }
            else Bq.remove();
        }
        
        
        return answer;
    }
}