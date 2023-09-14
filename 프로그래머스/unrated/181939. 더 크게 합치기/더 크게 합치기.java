class Solution {
    public int solution(int a, int b) {
        String str1 = String.valueOf(a) + String.valueOf(b);
        String str2 = String.valueOf(b) + String.valueOf(a);
        
        int num1 = Integer.valueOf(str1);
        int num2 = Integer.valueOf(str2);
        return Math.max(num1, num2);
    }
}