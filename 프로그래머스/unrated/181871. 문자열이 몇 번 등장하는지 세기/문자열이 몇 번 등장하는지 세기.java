class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int len = myString.length();
        for(int i = 0; i < len; i++){
            if(myString.contains(pat)) {
                int index = myString.indexOf(pat);
                myString = myString.substring(index + 1);
                answer++;
            }
            
        }
        return answer;
    }
}