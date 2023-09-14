package solution;
import java.util.*;
import java.io.*;
public class sol228 {
	static int[][] ice;
	static int n, m;
	static int[] dx = {0, 1, 0, -1}; //�� �� �� ��
	static int[] dy = {1, 0, -1, 0};
	 /*== {(0,1), (1,0}, (0,-1), (-1,0)};
	 * ��ǥ�迡�� ������ 1 �����ϸ� �������� �̵�
	 * ���� �����ϸ� ���� �̵�,
	 * ���� �����ϸ� ������ �̵�
	 * ���� �����ϸ� �������� �̵�
	 * ���� �˰��ִ� 2���� ��ǥ�� �ٸ��� �����Ұ�
	 * ������ ��� �ǵ� �������. 
	*/ 
	static boolean[][] check;
	public static void bfs(int x, int y) {
		Queue<Spot> q = new LinkedList<>();
		check[y][x] = true;
		q.add(new Spot(x, y));
		while(!q.isEmpty()) {
			Spot s = q.poll();
			//4����
			for(int i = 0; i < 4; i++) {
				int xpos = s.x + dx[i];
				int ypos = s.y + dy[i];
				if(xpos < 1 || ypos < 1 || xpos > m || ypos > n ) {
					continue;
				}
				if(check[ypos][xpos]) {
					continue;
				}
				if(ice[ypos][xpos] != 0) {
					
					check[ypos][xpos] = true;
					q.add(new Spot(xpos, ypos));
				}
				
			}
		}
	}
	
	public static int meltIce() {
		int cnt = 0;
		boolean[][] c = new boolean[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(ice[i][j] != 0) {
					c[i][j] = true;
					for(int k = 0; k < 4; k++) {
						int xpos = j + dx[k];
						int ypos = i + dy[k];
				
						if(xpos < 1 || ypos < 1 || xpos > m || ypos > n){
							continue;
						}
						if(check[ypos][xpos]) {
							continue;
						}
						if(ice[ypos][xpos] == 0 && ice[i][j] > 0) {
							ice[i][j]--;
						}
					}
					if(ice[i][j] > 0) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
	public static int moveAround() {
		int cnt = 0;
		check = new boolean[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(ice[i][j] != 0 && !check[i][j]) {
					bfs(j, i);
					cnt++;
				}
			}
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ice = new int[n+1][m+1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= m; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		int num = 1;
		int breakIsland = 0;
		while(true) {
			//�������� �ʰ� ���� ���
			if(num == 0) {
				System.out.println(0);
				break;
			}
			else {
				//���� ������ ���
				breakIsland = moveAround();
				if(breakIsland >= 2) {
					System.out.println(ans);
					break;
				}
			}
			num = meltIce();
			ans++;
			breakIsland = 0;
		}
	}
}
class Spot{
	int x;
	int y;
	Spot(int x, int y){
		this.x = x;
		this.y = y;
	}
}
