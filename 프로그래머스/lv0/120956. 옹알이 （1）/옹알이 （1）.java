class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        int count = 0;
        for(String str : babbling){
            str = str.replaceFirst("aya","1");
            str = str.replaceFirst("ye","1");
            str = str.replaceFirst("woo","1");
            str = str.replaceFirst("ma","1");
            if(counting(str)==true)count++;
        }
        return count;
    }
    
    boolean counting(String str){
        boolean Result = str.matches("\\d+");
        if(Result == false) return false;
        return true;
    }
}