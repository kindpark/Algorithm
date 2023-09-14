package solution;
import java.io.*;
import java.util.*;
public class sol223_1 {
	static ArrayList<Integer>[] vertex;
	static Queue<Integer> q;
	static int[] check;
	static String ans;
	static int v;
	public static void bfs(int v) {
		check[v] = 1;
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			vertex = new ArrayList[v+1];
			check = new int[v+1];
			for(int l = 1; l < v+1; l++) {
				vertex[l] = new ArrayList<>();
			}
			int e = Integer.parseInt(st.nextToken());
			for(int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				vertex[x].add(y);
				vertex[y].add(x);
			}
			ans = "";
			//ÆÇº°
			
			System.out.println(ans);
			ans = "";
		}
	}
}
