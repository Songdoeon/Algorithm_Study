import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];

        int[] test = new int[e+1];

        for (int i=1; i<=e; i++) {
            for (int j=i; j<=e; j += i) {
                test[j]++;
            }
        }

        int[][] arr = new int[e][2];
        int idx = 0;
        for (int i = 1; i<test.length; i++) {
            arr[idx++] = new int[] {i, test[i]};
        }

        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                int answer = o2[1] - o1[1];
                if (answer == 0) {
                    answer = o1[0] - o2[0];
                }
                return answer;
            }
        });

        for (int i=0; i<starts.length; i++) {
            int min = starts[i];

            for (int j=0; j<arr.length; j++) {
                if (arr[j][0] >= min) {
                    answer[i] = arr[j][0];
                    break;
                }
            }

        }

        return answer;
    }
}