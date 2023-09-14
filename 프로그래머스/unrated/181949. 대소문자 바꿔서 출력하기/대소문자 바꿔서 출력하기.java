import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++){
            Character c = str.charAt(i);
            if(Character.isUpperCase(c))sb.append(Character.toLowerCase(c));
            else sb.append(Character.toUpperCase(c));
        }
        System.out.println(sb.toString());
        
    }
}