import java.util.*;
class Solution {
    Map<String, Integer> map = new HashMap<>();
    int widthMax;
    int heightMax;
    int width = 0;
    int height = 0;
    
    void widthCheck(int num){
        if(Math.abs(width+num) > Math.abs(widthMax)) return;
        else width += num;
    }
    void heightCheck(int num){
        if(Math.abs(height+num) > Math.abs(heightMax)) return;
        else height += num;
    }
    public int[] solution(String[] keyinput, int[] board) {
        
        this.widthMax = board[0] / 2;
        this.heightMax = board[1] / 2;
        for(String key : keyinput){
            switch(key){
                case "left" : widthCheck(-1);break;
                case "right" : widthCheck(1);break;
                case "up" : heightCheck(1);break;
                case "down" : heightCheck(-1);break;
            }
        }
        
        return new int[] {width, height};
    }
}