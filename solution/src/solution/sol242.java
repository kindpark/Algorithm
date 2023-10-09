package solution;
import java.util.*;
import java.io.*;
public class sol242 {
	/*
	public static void main(String[] args) throws IOException{
		
	}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		int ans = 0;
		int n = Integer.parseInt(br.readLine());
		int[][] db = new int[10][4];
		for(int i = 0; i < 10; i++) {
			int p = i;
			for(int j = 0; j < 4; j++) {
				String pp = String.valueOf(p);
				db[i][j] = pp.charAt(pp.length() - 1) - '0';
				p = p * i;
			}
		}
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			if(b % 4 == 1) {
				ans = db[a % 10][0];
			}
			else if(b % 4 == 2) {
				ans = db[a][1];
			}
			else if(b % 4 == 3) {
				ans = db[a][2];
			}
			else if(b % 4 == 0){
				ans = db[a][3];
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb.toString());
	}
	*/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int a,b,r;
		for(int j=0;j<T;j++) {
			a=s.nextInt();
			b=s.nextInt();
			r=1;
			
			for (int i=0;i<b;i++) {
				r = (r * a) % 10;
			}
			if(r==0) {
				r=10;
			}
			System.out.println(r);
		}
		s.close();
	}
	
}
