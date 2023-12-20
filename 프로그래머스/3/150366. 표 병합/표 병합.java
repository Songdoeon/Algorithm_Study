import java.util.*;
class Solution {
    int[] parent = new int[2501];
    String[] value = new String[2501];

    int find(int a) {
        if (parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b)
            parent[b] = a;
    }

    int convertNum(int x, int y) {
        int result = 50 * (x - 1);
        return result + y;
    }
    
    public String[] solution(String[] commands) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= 2500; i++) {
            parent[i] = i;
            value[i] = "";
        }
        for(String command : commands){
            String[] arg = command.split(" ");
            if(arg[0].equals("UPDATE")){
                if(arg.length == 3){
                    for(int i = 1; i <= 2500; i++) {
                        if(value[i].equals(arg[1])) value[i] = arg[2];
                    }
                }
                else{
                    int x = Integer.parseInt(arg[1]);
                    int y = Integer.parseInt(arg[2]);
                    int num = convertNum(x, y);
                    value[find(num)] = arg[3];
                }
            }
            else if(arg[0].equals("MERGE")){
                int x1 = Integer.parseInt(arg[1]);
                int y1 = Integer.parseInt(arg[2]);
                int x2 = Integer.parseInt(arg[3]);
                int y2 = Integer.parseInt(arg[4]);
                
                int n1 = convertNum(x1, y1);
                int n2 = convertNum(x2, y2);
                
                int root1 = find(n1);
                int root2 = find(n2);
                
                if(root1 == root2) continue;
                
                String rootString = value[root1].isBlank() ? value[root2] : value[root1];
                value[root1] = "";
                value[root2] = "";
                union(root1, root2);
                value[root1] = rootString;
            }
            else if (arg[0].equals("UNMERGE")) {
                int x = Integer.parseInt(arg[1]);
                int y = Integer.parseInt(arg[2]);
                int num = convertNum(x, y);
                int root = find(num);
                
                String rootString = value[root];
                value[root] = "";
                value[num] = rootString;
                List<Integer> deleteList = new ArrayList<>();
                for (int i = 1; i <= 2500; i++) {
                    if (find(i) == root)
                        deleteList.add(i);
                }
                for (Integer t : deleteList)
                    parent[t] = t;
            } 
            else if (arg[0].equals("PRINT")) {
                int x = Integer.parseInt(arg[1]);
                int y = Integer.parseInt(arg[2]);
                int num = convertNum(x, y);
                int root = find(num);
                if (value[root].isBlank())
                    result.add("EMPTY");
                else
                    result.add(value[root]);
            }
        }
        return result.toArray(new String[0]);
    }
}