package solution;
import java.util.*;
import java.io.*;
public class sol229 {
	static int n, h, w, ans;
	static Queue<Spot1> q;
	static String[][] map;
	static boolean[][] check;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void bfs(int x, int y) {
		q.add(new Spot1(x, y));
		while(!q.isEmpty()) {
			Spot1 s = q.poll();
			for(int i = 0; i < 4; i++) {
				int px = s.x + dx[i];
				int py = s.y + dy[i];
				String f = String.valueOf(n);
				if(map[py][px].equals(f)) {
					break;
				}
				
				if(px < 1 || py < 1 || px > h || py > w) {
					continue;
				}
				if(check[py][px] || map[py][px].equals("X")) {
					continue;
				}
				q.add(new Spot1(px, py));
				map[py][px] = map[s.y][s.x];
				check[py][px] = true;
				ans++;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] num;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int lx = 0, ly = 0;
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new String[h+1][w+1];
		check = new boolean[h+1][w+1];

		for(int i = 1; i < h+1; i++) {
			num = br.readLine().split("");
			for(int j = 1; j < w+1; j++) {
				map[i][j] = num[j-1];
				if(map[i][j].equals("S")){
					lx = j;
					ly = i;
				}
			}
		}
		q = new LinkedList<>();
		check[1][1] = true;
		bfs(lx, ly);
		System.out.println(ans);
	}
}
class Spot1{
	int x;
	int y;
	Spot1(int x, int y){
		this.x = x;
		this.y = y;
	}
}