class Solution {
    public int solution(int[] date1, int[] date2) {
        int a = date1[0] * 365 + date1[1]* 30 + date1[2];
        int b = date2[0] * 365 + date2[1]* 30 + date2[2];
        return a >= b ? 0 : 1;
    }
}