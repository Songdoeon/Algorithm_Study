import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < len; i++){          
            answer.add(num_list[i]);            
        }

        if(num_list[len - 1] > num_list[len - 2]){
            answer.add(num_list[len - 1] - num_list[len - 2]);
        } else {
            answer.add(num_list[len - 1] * 2);
        }


        return answer.stream().mapToInt(i -> i).toArray();
    }
}