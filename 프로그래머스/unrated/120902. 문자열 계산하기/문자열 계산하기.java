import java.util.*;
class Solution {
    public int solution(String my_string) {
        
        String symbol = my_string.replaceAll("[0-9 ]","");
        String numb = my_string.replaceAll("[^0-9 ]","");
        String[] numbers = numb.split("  ");

        int[] nums = (int[]) Arrays.stream(numbers).mapToInt(i -> Integer.parseInt(i)).toArray();
        int answer = nums[0];
        for(int i = 0; i < symbol.length(); i++){
            if(symbol.charAt(i) == '+') answer += nums[i + 1];
            else answer -= nums[i + 1];
        }

        return answer;
    }
}