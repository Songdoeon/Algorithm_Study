import java.util.*;
class Solution {
    int getTime(String str){
         return Integer.parseInt(str.substring(0, 2)) * 60 + Integer.parseInt(str.substring(3, 5));
    }
    String getAns(int time){
        int min = time / 60;
        int sec = time % 60;
        String m = min < 10 ? "0"+min : String.valueOf(min);
        String s = sec < 10 ? "0"+sec : String.valueOf(sec);
        return m +":"+ s;
    }
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int end = getTime(video_len);
        int idx = getTime(pos);
        int op_s = getTime(op_start);
        int op_e = getTime(op_end);
        if(op_s <= idx && idx <= op_e) idx = op_e;
        for(String command : commands){
            if(command.equals("next")){
                idx += 10;
                if(idx > end)idx = end;
            }
            else if(command.equals("prev")){
                idx-=10;
                if(idx < 0)idx = 0;
            }
            if(op_s <= idx && idx <= op_e) idx = op_e;
        }
        return getAns(idx);
    }
}