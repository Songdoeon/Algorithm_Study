class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int a1 = Integer.parseInt(a + ""+b);
        int a2 = a * b * 2;
        return a1 > a2 ? a1 : a2;
    }
}