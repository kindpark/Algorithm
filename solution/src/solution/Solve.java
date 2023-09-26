package solution;
import java.io.*;
import java.util.*;

public class Solve {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] iceberg;
	static boolean[][] check;
	static int n, m;
	static Queue<Po> q;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		iceberg = new int[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= m; j++) {
				iceberg[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		move();
	}
	public static void bfs(int x, int y) {
		q = new LinkedList<>();
		check = new boolean[n+1][m+1];
		check[y][x] = true;
		q.add(new Po(x, y));
		while(q.isEmpty()) {
			Po p = q.poll();
			for(int i = 0; i < 4; i++) {
				int px = p.x + dx[i];
				int py = p.y + dy[i];
				
				if(px < 1 || py < 1 || px > m || py > n) {
					continue;
				}
				if(check[py][px]) {
					continue;
				}
				if(iceberg[py][px] != 0) {
					check[py][px] = true;
					
					q.add(new Po(px, py));
				}
			}
		}
	}
	public static int move() {
		int cnt = 0;
		check = new boolean[n+1][m+1];
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < m+1; j++) {
				if(!check[j][i] && iceberg[j][i] != 0)
					bfs(j, i);
					cnt++;
			}
		}
		return cnt;
	}
	public static int melt(int x, int y) {
		q.add(new Po(x, y));
		check = new boolean[n+1][m+1];
		int melt = 0;
		while(q.isEmpty()) {
			Po p = q.poll();
			for(int i = 0; i < 4; i++) {
				int px = p.x + dx[i];
				int py = p.x + dy[i];
				
				if(px < 1 || py < 1 || px > m || py > n) {
					continue;
				}
				if(iceberg[py][px] == 0) {
					continue;
				}
				
			}
		}
	}
}
class Po{
	int x, y;
	Po(int x, int y){
		this.x = x;
		this.y = y;
	}
}