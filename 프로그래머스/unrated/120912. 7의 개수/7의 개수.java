class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for(int num : array){
            String str = "" + num;
            int len = str.length();
            
            for(int i = 0; i < len; i++){
                char c = str.charAt(i);
                if(c == '7') answer++;
            }
        }
        return answer;
    }
}