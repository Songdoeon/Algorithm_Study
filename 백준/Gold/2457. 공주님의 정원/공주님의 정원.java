import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Project{
	int start, end;

	public Project(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class Main {
	static List<Project> projects;
	static List<Project> startProjects;
	static int N;
	static int startDay = 60;
	static int endDay = 334;
	static int answer = 1;
	static int cal(int month, int days) {
		
		int result = days;
		
		switch(month) {
			case 12 : result +=30; month--;
			case 11 : result +=31; month--;
			case 10 : result +=30; month--;
			case 9 : result +=31; month--;
			case 8 : result +=31; month--;
			case 7 : result +=30; month--;
			case 6 : result +=31; month--;
			case 5 : result +=30; month--;
			case 4 : result +=31; month--;
			case 3 : result +=28; month--;
			case 2 : result +=31; month--;
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		projects = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int startM = Integer.parseInt(st.nextToken());
			int startD = Integer.parseInt(st.nextToken());
			int endM = Integer.parseInt(st.nextToken());
			int endD = Integer.parseInt(st.nextToken());
			int start = cal(startM, startD);
			int end = cal(endM, endD);
			if(end < 60 || start > 334) continue;
			projects.add(new Project(start, end - 1));
		}
		
		Collections.sort(projects,(o1, o2) -> o1.start == o2.start ? o2.end - o1.end : o1.start - o2.start);

		int start = 60;
		int end = projects.get(0).end;
		int size = projects.size();
		
		if(projects.isEmpty() || projects.get(0).start > 60) {
			System.out.println(0);
			return ;
		}
		
		for(int i = 0; i < size; i++) {
			if(projects.get(i).start <= start) {
				end = Math.max(end, projects.get(i).end);
			}
			else {
				start = end + 1;
				answer++;
				if(projects.get(i).start <= start) {
					end = Math.max(end, projects.get(i).end);
				}
				else break;
			}
			if(end >= endDay) break;
		}
		System.out.println(end < endDay ? 0 : answer);
	}
}	
