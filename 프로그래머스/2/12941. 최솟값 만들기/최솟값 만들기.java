import java.util.*;
import java.util.stream.Stream;
class Solution{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int len = A.length;
        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
        for(int Index = 0;Index < len;Index++){
            a.add(A[Index]);
            b.add(B[Index]);
        }
        while(!a.isEmpty()){
            answer += a.remove() * b.remove();
        }

        return answer;
    }
}