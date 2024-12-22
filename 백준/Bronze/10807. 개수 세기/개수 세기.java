import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int count = 0;						 // b 와 일치할시 갯수를 올리는 변수
        int N = sc.nextInt();
        int[] arr = new int[N];				 // 배열 생성, 길이는 N만큼

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();			
        }
        int b = sc.nextInt();				

        for(int j = 0; j < arr.length; j++){ 
            if(b == arr[j]){				
                count++;
            }
        }
        System.out.println(count);
    }
}