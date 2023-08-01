class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        int count = 0;
        for(String str : babbling){
            str = str.replaceAll("aya","1");
            str = str.replaceAll("ye","2");
            str = str.replaceAll("woo","3");
            str = str.replaceAll("ma","4");
            if(counting(str)==true)count++;
        }
        return count;
    }
    
    boolean counting(String str){
        boolean Result = str.matches("\\d+");
        boolean Result1 = str.matches(".*11.*");
        boolean Result2 = str.matches(".*22.*");
        boolean Result3 = str.matches(".*33.*");
        boolean Result4 = str.matches(".*44.*");
        if(Result == false) return false;
        if(Result1 == true || Result2 == true || Result3 == true || Result4 == true) return false;
        
        return true;
    }
}