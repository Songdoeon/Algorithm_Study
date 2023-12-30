class Solution {
    public int solution(String number) {
        int len = number.length();
        int answer = 0;
        for(int i = 0; i < len; i++){
            char c = number.charAt(i);
            answer += c - '0';
        }
        return answer % 9;
    }
}