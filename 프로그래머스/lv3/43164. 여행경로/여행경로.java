import java.util.*;
class Solution {
    
    String[][] tickets;
    ArrayList<String[]> answer = new ArrayList<>(); 
    
    void dfs(String route,int count,int[] visited){
        String[] args = route.split(" ");
        if(count==tickets.length){
            answer.add(route.split(" "));
            return ;
        }
        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals(args[args.length-1]) && visited[i] == 0){
                visited[i] = 1;
                dfs(route + " " + tickets[i][1],count+1,visited);
                visited[i] = 0;
            }
        }
    }
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        for(String[] arg : tickets){
            System.out.println(arg[0]+ " " + arg[1]);
        }
        this.tickets = tickets;
        int[] visited = new int[tickets.length];
        dfs("ICN",0,visited);
        return answer.get(0);
    }
}