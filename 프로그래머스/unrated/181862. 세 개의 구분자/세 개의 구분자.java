class Solution {
    public String[] solution(String myStr) {
        myStr = myStr.replaceAll("[abc]","1");
        while(myStr.startsWith("1") || myStr.endsWith("1")){
            myStr = myStr.replaceAll("^[1]|[1]$", "");    
        }
        // while(myStr.contains("11")){
            myStr = myStr.replaceAll("1+", "1"); 
        // }
        String[] answer = myStr.split("1");
        if(answer[0].equals("")) return new String[] {"EMPTY"};
        return answer;
    }
}