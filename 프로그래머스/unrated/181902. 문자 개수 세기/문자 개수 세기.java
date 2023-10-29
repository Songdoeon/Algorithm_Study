class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for(int i = 0; i < my_string.length(); i++){
            int n = Integer.valueOf(my_string.charAt(i));
            if(n > 96) answer[n - 71]++;
            else answer[n - 65]++;          
        }
        return answer;
    }
}