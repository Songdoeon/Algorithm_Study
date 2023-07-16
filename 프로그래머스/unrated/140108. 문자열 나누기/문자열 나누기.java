class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 0;
        int except = 0;
        int len = s.length();
        int index=0;
        while(index!=len){
            char word = s.charAt(index);
            for(int idx=index;idx<len;idx++){
                if(s.charAt(idx)==word){
                    same++;
                }
                else except++;
                if(same==except) {
                    index = idx+1;
                    answer++;
                    same = except = 0;
                    break;
                }
                index++;
            }
        }
        if(except!=0 || same !=0) answer++;
        return answer;
    }
}