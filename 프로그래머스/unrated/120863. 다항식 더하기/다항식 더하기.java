class Solution {
    public String solution(String polynomial) {
        int x = 0;
        int num = 0;
        String[] args = polynomial.split(" \\+ ");
        for(String str : args){
            if(str.endsWith("x")){
                if(str.length() == 1) x++;
                else x += Integer.valueOf(str.substring(0, str.length() - 1));
            } 
            else num += Integer.valueOf(str);
        }
        if(x == 0) return ""+num;
        if(x == 1 && num == 0) return "x";
        if(num == 0) return x + "x";
        if(x == 1) return "x + " + num;
        
        return x + "x + " + num;
    }
}