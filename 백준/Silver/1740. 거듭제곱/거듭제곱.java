import java.util.*;
import java.io.*;
public class Main{
    static long N;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Long.parseLong(br.readLine());
	    
	    long num = 1, three = 1, two = 1;
	    for(;;num++){
	        three *= 2;
	        two *= 3;
	        if(three>=N) break;
	    }
	    
	    long answer = 0;
	    for(;num>=0;num--){
	        if(three<=N) {
	            N-=three;
	            answer += two;
	        } 
	        three/=2;
	        two/=3;
	    }
	    
		System.out.println(answer);
	}
}
