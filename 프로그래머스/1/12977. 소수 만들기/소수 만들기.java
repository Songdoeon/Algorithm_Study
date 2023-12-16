import java.util.*;
class Solution {
    class Pair{
        int a = 0;
        int b = 0;
        int c = 0;

        List<Integer> list = new ArrayList<>();
        Pair(){
            
        }
        Pair(Pair pair){
            a = pair.a;
            b = pair.b;
            c = pair.c;
        }
        void add(int num){
            list.add(num);
        }
        void remove(int num){
            list.remove(Integer.valueOf(num));
        }
        void sort(){
            list.sort((o1, o2) -> o1 - o2);
            a = list.get(0);
            b = list.get(1);
            c = list.get(2);
        }
        @Override
        public boolean equals(Object obj) {
            if(obj == this) return true;
            if(!(obj instanceof Pair)) return false;
            Pair p = (Pair) obj;

            return a == p.a && b == p.b &&
                    c == p.c;
        }
        @Override
        public int hashCode() {
            return Objects.hash(a,b,c);
        }

    }
    Set<Pair> set = new HashSet<>();
    int[] nums;
    int len;
    boolean check(int num){
        for(int i = 2; i <= (int)Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
    
    void search(int depth, int sum, boolean[] visited, Pair pair){
        if(depth > 3)return ;
        if(depth == 3 && check(sum)){

            pair.sort();
            
            set.add(new Pair(pair));
            return ;
        }
        for(int i = depth; i < len; i++){
            if(!visited[i]){
                visited[i] = true;
                pair.add(nums[i]);
                search(depth + 1, sum + nums[i], visited, pair);
                pair.remove(nums[i]);
                visited[i] = false;
            }
        }

    }
    public int solution(int[] nums) {

        len = nums.length;
        this.nums = nums;
        boolean[] visited = new boolean[len];

        search(0,0,visited,new Pair());

        return set.size();
    }
}