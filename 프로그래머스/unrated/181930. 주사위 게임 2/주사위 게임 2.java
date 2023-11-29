class Solution {
    boolean isSame(int a, int b){
        if(a == b) return true;
        return false;
    }
    public int solution(int a, int b, int c) {
        int answer = 0;
        if(isSame(a, b) || isSame(a, c)){
            if(isSame(b, c)) answer = (3 * a) * (3 * (a * a)) * (3 * a * a * a);
            else answer = (a + b + c) * (a * a + b * b + c * c);
        }
        else if(isSame(b, c)){
            answer = (a + b + c) * (a * a + b * b + c * c);
        }
        else answer = a + b + c;
        return answer;
    }
}