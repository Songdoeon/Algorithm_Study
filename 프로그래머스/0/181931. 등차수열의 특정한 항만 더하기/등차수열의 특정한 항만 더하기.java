class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int idx = a;
        int len = included.length;
        for(int i = 0; i < len; i++){
            if(included[i])answer += idx;
            idx += d;
        }
        return answer;
    }
}