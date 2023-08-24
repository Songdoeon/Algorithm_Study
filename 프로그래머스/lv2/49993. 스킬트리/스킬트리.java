import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String skill_tree : skill_trees){
            skill_tree = skill_tree.replaceAll("[^" + skill + "]","");
            // System.out.println(skill_tree);
            if(skill.indexOf(skill_tree) == 0) answer++;
        }
        return answer;
    }
}