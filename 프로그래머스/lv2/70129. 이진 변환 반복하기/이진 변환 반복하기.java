class Solution {
    public int[] solution(String s) {
        int count = 0;
        int sum = 0;
        int before, after;
        while(!s.equals("1")){
            before = s.length();
            s = s.replace("0","");
            after = s.length();
            sum += before - after;
            s = Integer.toBinaryString(after);
            count++;
        }
        return new int[] {count, sum};
    }
}