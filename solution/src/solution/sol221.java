package solution;
import java.util.*;
import java.io.*;
public class sol221 {
	static ArrayList<Integer>[] section; 
	static boolean[] visit;
	static int n;
	static int[] ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		String[] s;
		ans = new int[n+1];
		visit = new boolean[n+1];
		section = new ArrayList[n+1];
		for(int i = 1; i < n+1; i++) {
			section[i] = new ArrayList<>();
		}
		for(int i = 1; i < n; i++) {
			s = br.readLine().split(" ");
			int parents = Integer.parseInt(s[0]);
			int son = Integer.parseInt(s[1]);
			
			section[parents].add(son);
			section[son].add(parents);
		}
		dfs(1);
		
		for(int i = 2; i < n+1; i++) {
			System.out.println(ans[i]);
		}
		
	}
	public static void dfs(int start) {
		visit[start] = true;
		//�迭�� �������� ���ڰ� ����� ��ġ�� �ٸ��� ������ ���� for���� ���.
		for(int i : section[start]) {
			if(section[start].get(i) != null) {
			if(!visit[i]) {
				ans[i] = start;
				//��ͷ� ���� ��ġ�� Ž��
				dfs(i);
			}
		}}
	}
}
