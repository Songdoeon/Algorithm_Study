import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = -2;
        int[] student = new int[n+2];
        Arrays.fill(student,1);
        for(int i : reserve){
            student[i]++;
        }
        for(int i : lost){
            student[i]--;
        }
        for(int i=1;i<=n;i++){
            if(student[i]==0){
                if(student[i-1]==2){
                    student[i-1]--;
                    student[i]++;
                }
                else if(student[i+1]==2){
                    student[i+1]--;
                    student[i]++;
                }
            }
        }
        for(int i : student){
            System.out.println(i);
            if(i>=1)answer++;
        }
        return answer;
    }
}