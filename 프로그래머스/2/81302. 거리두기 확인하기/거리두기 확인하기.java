import java.util.*;
class Pos{
    int x, y;
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    List<Pos> list;
    
    String[][] places;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};
    int r;
    int getDis(Pos p1, Pos p2){
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
    boolean hasPartition(Pos p1, Pos p2){
        if(p1.x == p2.x){
            if(places[r][p1.x].charAt((p1.y + p2.y) / 2) == 'X') return true;
            return false;
        }
        if(p1.y == p2.y){
            if(places[r][(p1.x + p2.x) / 2].charAt(p1.y) == 'X') return true;
            return false;
        }
        if(p1.x + 1 == p2.x && p1.y - 1 == p2.y){
            if(places[r][p1.x + 1].charAt(p1.y) != 'X') return false;
            if(places[r][p1.x].charAt(p1.y - 1) != 'X') return false;
            return true;
        }
        if(places[r][p1.x + 1].charAt(p1.y) != 'X') return false;
        if(places[r][p1.x].charAt(p1.y + 1) != 'X') return false;
        return true;
    }
    boolean check(){
        int size = list.size();
            
        for(int i = 0; i < size - 1; i++){
            Pos p1 = list.get(i);
            for(int j = i + 1; j < size; j++){
                Pos p2 = list.get(j);
                if(getDis(p1, p2) < 3 && !hasPartition(p1, p2)) {

                    return false;
                }
            }
        }
        return true;
    }
    public int[] solution(String[][] places) {
        this.places = places;
        int[] answer = new int[5];
        for(int r = 0; r < 5; r++){
            this.r = r;
            list = new ArrayList<>();
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(places[r][i].charAt(j) == 'P')list.add(new Pos(i, j));
                }
            }
            if(list.size() == 0){
                answer[r] = 1;
                continue;
            }
            if(check())answer[r] = 1;
            else answer[r] = 0;
        }

        return answer;
    }
}