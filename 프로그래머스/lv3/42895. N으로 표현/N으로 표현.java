import java.util.*;
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        List<HashSet<Integer>> list = new ArrayList<>();
        
        for(int i = 0;i <= 8;i++){
            list.add(new HashSet<Integer>());
        }
        list.get(1).add(N);
        if(list.get(1).contains(number)) return 1;
        for(int i = 2;i <= 8;i++){
            HashSet<Integer> total = list.get(i);
            for(int j = 1;j <= i; j++){
                HashSet<Integer> set1 = list.get(j);
                HashSet<Integer> set2 = list.get(i-j);
                
                for(int a : set1){
                    for(int b : set2){
                        total.add(a+b);
                        total.add(a-b);
                        total.add(a*b);
                        if(a != 0 && b !=0)total.add(a/b);
                    }
                }
                total.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }
            if(total.contains(number)) return i;
        }
        
        return -1;
    }
}