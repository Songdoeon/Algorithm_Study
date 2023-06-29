import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = -1;
        int[] student = new int[n+1];
        Arrays.fill(student,1);
        for(int i : reserve){
            student[i-1]++;
        }
        for(int i : lost){
            student[i-1]--;
        }
        if(student[0]==0){
            if(student[1]==2){
                student[0]=1;
            }
        }
        for(int i=1;i<n;i++){
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