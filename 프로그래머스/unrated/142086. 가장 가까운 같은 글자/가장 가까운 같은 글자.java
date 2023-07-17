class Solution {
    public int[] solution(String s) {
        int len = s.length();
        int[] answer = new int[len];
        //처음은 무조건 -1
        answer[0] = -1;
        for(int idx = 1;idx < len; idx++){
            String tempString = s.substring(0,idx);
            int point = tempString.lastIndexOf(s.charAt(idx));
            if(point == -1) answer[idx]=-1;
            else{
                answer[idx] = idx-point;
            }
        }
        return answer;
    }
}