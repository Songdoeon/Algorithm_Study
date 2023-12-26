class Solution {

    public long solution(int r1, int r2) {
        long answer = 0;
        long big = (long)r2 * (long)r2;
        long small = (long)r1 * (long)r1;
        for (int i=1; i<=r2; i++) {
            long num = (long)i * (long)i;
            long num2 = (int)Math.floor((double)Math.sqrt(big - num));
            long num3 = (int)Math.ceil((double)Math.sqrt(small - num));
            answer += num2 - num3 + 1; 
            // System.out.println(i + " : " +num2 + " : " + num3 + " = " + answer);
        }
        return answer * 4;
    }
}