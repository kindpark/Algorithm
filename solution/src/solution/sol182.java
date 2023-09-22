package solution;
import java.io.*;
import java.util.*;

public class sol182 {
	static int t, m, n, k, cnt;
	static boolean[][] field;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Spot11> q;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static class Spot11{
		int i, j;
		Spot11(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < t; tc++) {
			cnt = 0;
			q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			field = new boolean[n][m];
			for(int v = 0; v < k; v++) {
				st = new StringTokenizer(br.readLine());
				int j = Integer.parseInt(st.nextToken());
				int i = Integer.parseInt(st.nextToken());
				field[i][j] = true;
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(field[i][j]) {
						//System.out.println(i+", "+j);
						bfs(i, j);
					}
				}
			}
			sb.append(cnt + "\n");
			
		}
		System.out.print(sb);
	}
	
	public static void bfs(int i, int j) {
		q.offer(new Spot11(i, j));
		field[i][j] = false;
		cnt++;
		while(!q.isEmpty()) {
			Spot11 s = q.poll();
			for(int k = 0; k < 4; k++) {
				int fi = s.i + dx[k];
				int fj = s.j + dy[k];
				
					if(field[fi][fj] && b(fi, fj)){
						//System.out.println(fx + ", " +fy);
						
						q.offer(new Spot11(fi, fj));
						field[fi][fj] = false;
					}
				
			}
		}
	}
	
	public static boolean b(int fi, int fj) {
		return fi >= 0 && fi < n  && fj < m && fj >= 0;
	}
	
}