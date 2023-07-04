class Solution {
    static int count = 0;
    public String solution(int n) {
        String[] num = new String[] {"4","1","2"};
        String answer = "";
        while(n > 0){
          answer = num[n % 3] + answer;
          n = (n - 1) / 3;
      }
        return answer;
    }
}