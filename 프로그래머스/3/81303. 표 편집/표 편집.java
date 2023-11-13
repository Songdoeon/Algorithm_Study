import java.util.*;
class Solution {
    class Obj{
        Integer pre;
        Integer next;
        int me;
        
        Obj(int pre, int me, int next){
            this.pre = pre;
            this.next = next;
            this.me = me;
        }
    }
    Stack<Integer> stack = new Stack();
    StringBuilder sb;
    int[] prev;
    boolean[] state;
    int[] next;
    int index;
    int max;
    int[] check(int num){
        int preObj = 0;
        int nextObj = -1;
        for(int i = num + 1; i < max; i++){
            if(state[i] == true) {
                nextObj = i;
                break;
            }
        }
        for(int i = num - 1; i > 0; i--){
            if(state[i] == true) {
                preObj = i;
                break;
            }
        }

        return new int[] {preObj, nextObj};
    }
    
    void delete(){

        state[index] = false;
        sb.setCharAt(index, 'X');
        stack.push(index);

        int[] arr = new int[] {prev[index], next[index]};
        if(next[index] == -1) next[prev[index]] = -1;
        else if (prev[index] == -1) prev[next[index]] = -1;
        else {
            next[arr[0]] = next[index];
            prev[arr[1]] = prev[index];
        }
        if (next[index] == -1) { // 맨 끝에 있는 경우만 이전으로 가고
            index = prev[index];
        } else { 
            index = next[index];
        }
    }
    
    void recover(){
        int recent = stack.pop();
        sb.setCharAt(recent, 'O');
        state[recent] = true;
        int[] arr = new int[] {prev[recent], next[recent]};
        if (next[recent] == -1) { 
            next[arr[0]] = recent;
        } else if (prev[recent] == -1) {
                prev[arr[1]] = recent;
        } else { 
                next[arr[0]] = recent;
                prev[arr[1]] = recent;
            }
    }
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        sb = new StringBuilder("O".repeat(n));
        this.prev = new int[n]; 
        this.state = new boolean[n]; 
        this.next = new int[n]; 
        this.index = k;
        this.max = n;
        for(int i = 0; i < n; i++){
            prev[i] = i-1;
            state[i] = true;
            next[i] = i+1;
        }
        next[n - 1] = -1;
        
        for(String command : cmd){
            String[] arg = command.split(" ");
            
            if(arg.length == 1){
                if(arg[0].equals("C")){
                    delete();
                }
                else{
                    recover();
                }    
            }
            else{
                int count = Integer.valueOf(arg[1]);
                if(arg[0].equals("D")){
                    while(count-- > 0){
                        index = next[index];
                    }
                } 
                else {
                    while(count-- > 0){
                        index = prev[index];
                    }
                }
            }
        }
        // for(int i = 0; i < n; i++){
        //     if(state[i] == true)sb.append("O");
        //     else sb.append("X");
        // }
        return sb.toString();
    }
}