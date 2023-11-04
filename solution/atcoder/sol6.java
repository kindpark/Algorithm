package atcoder;
import java.io.*;
import java.util.*;
public class sol6 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] w = new int[n];
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			w[i] = sc.nextInt();
			x[i] = sc.nextInt();
		}
		for(int i = 0; i < 24; i++) {
			int user = 0;
			for(int j = 0; j < n; j++) {	
				//시간은 계속 흘러가니까 - i로 구현
				//닿는 만큼 더해져서 9시간 만에 가능한지 여부 확인가능
				int b = (i + x[j]) % 24;
				if((0 <= b) && (b < 9)) {
					user+=w[j];
				}
			}
			if(user > cnt) {
				cnt = user;
			}
		}
		System.out.println(cnt);
	}
}
