class Solution {
    public int solution(String[] order) {
        int answer = 0;
        
        for(String beverage : order){
            if(beverage.contains("americano")) answer += 4500;
            else if(beverage.contains("cafelatte")) answer += 5000;
            else answer += 4500;
        }
        return answer;
    }
}