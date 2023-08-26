class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int index = section[0];
        int end = section[section.length - 1];
        for(int i : section){
            if(index > end) break;
            if(index <= i) index = i;
            if(index > i) continue;
            index += m;
            answer++;
            
        }
        return answer;
    }
}