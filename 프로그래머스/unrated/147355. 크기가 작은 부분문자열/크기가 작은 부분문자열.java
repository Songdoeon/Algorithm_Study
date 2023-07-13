class Solution {
    public int solution(String t, String p) {
        int length = p.length();
        // long num1 = Long.parseLong(t);
        long num2 = Long.parseLong(p);
        int answer = 0;
        // if(num1<num2) return 0;
        for(int i=0;i<=(t.length()-length);i++){
            if(Long.parseLong(t.substring(i,length+i))<=num2){
                answer++;
                }
        }
        return answer;
    }
}