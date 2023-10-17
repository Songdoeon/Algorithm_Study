import java.util.*;
class Solution {
    class Music{
        int time;
        String name;
        
        Music(int time, String name){
            this.time = time;
            this.name = name;
        }
    }
    String music(int time, String musicInfo){
        StringBuilder sb = new StringBuilder();
        int len = musicInfo.length();
        sb.append(musicInfo.charAt(0));
        if(musicInfo.charAt(1) == '#') time++;
        for(int i = 1; i < time; i++){
            char c = musicInfo.charAt(i % len);
            sb.append(c);
            if(musicInfo.charAt((i+1) % len) == '#') time++;
        }
        return sb.toString();
    }
    int time(String start, String end){
        String[] s = start.split(":");
        String[] e = end.split(":");
        int startTime = Integer.valueOf(s[0]) * 60 + Integer.valueOf(s[1]);
        int endTime = Integer.valueOf(e[0]) * 60 + Integer.valueOf(e[1]);
        return endTime - startTime;
    }
    public String solution(String m, String[] musicinfos) {
        List<Music> list = new ArrayList<>();
        String answer = "(None)";
        for(String musicInfo : musicinfos){
            String[] args = musicInfo.split(",");
            int time = time(args[0], args[1]);
            String music = music(time, args[3]);
            String tempMusic = m + "#";
            System.out.println(music);
            if(music.contains(tempMusic)) music = music.replaceAll(tempMusic,"");
            if(music.contains(m)) list.add(new Music(time, args[2]));
        }
        list.sort((o1, o2) -> o2.time - o1.time);
        if(list.size()==0) return answer;
        return list.get(0).name;
    }
}