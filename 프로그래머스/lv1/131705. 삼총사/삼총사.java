class Solution {
    public int solution(int[] number) {
        int len = number.length;
        int answer = 0;
        for(int idx =0; idx<len;idx++){
            for(int jdx = idx+1;jdx < len;jdx++){
                for(int kdx = jdx+1;kdx<len;kdx++){
                    if(number[idx]+number[jdx]+number[kdx] == 0) answer++;
                }
            }
        }
        return answer;
    }
}