class Solution {
    public String solution(int a, int b) {
        String[] Day = new String[] {"FRI", "SAT","SUN", "MON", "TUE", "WED", "THU"};
        int[] Days = new int[] {0,31,29,31,30,31,30,31,31,30,31,30,31};
        String answer = "";
        int num = 0;
        for(int i = 1; i < a;i++){
            num += Days[i];
        }
        num += b;
        num = (num%7)-1;
        if(num <0) num = 6;
        return Day[num];
    }
}