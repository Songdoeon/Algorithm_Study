import java.util.*;
class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        List<Integer> list = new ArrayList<>();
        int a = slicer[0];
        int b = slicer[1] + 1;
        int c = slicer[2];
        switch(n) {
            case 1 : return Arrays.copyOf(num_list, b);
            case 2 : return Arrays.copyOfRange(num_list, a, num_list.length);
            case 3 : return Arrays.copyOfRange(num_list, a, b);
            case 4 : for(int i = a; i < b; i +=c){
                        list.add(num_list[i]);
                        }break;
        }
        return list.stream().mapToInt(i ->i).toArray();
    }
}