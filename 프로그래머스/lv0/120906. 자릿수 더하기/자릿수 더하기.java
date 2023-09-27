class Solution {
    public int solution(int n) {
        String num = String.valueOf(n);
        int len = num.length();
        int answer = 0;        
        for(int idx = 0; idx < len; idx++){
            answer += num.charAt(idx) - '0';
        }

        return answer;
    }
}