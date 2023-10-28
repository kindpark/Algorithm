package atcoder;
import java.io.*;
import java.util.*;
public class sol1 {
	public static void main(String[] args) throws IOException{
		int[][] arr = new int[16][16];
		arr[1][2] = arr[2][1] = 1;
		arr[1][3] = arr[3][1] = 1;
		arr[2][4] = arr[4][2] = 1;
		arr[2][5] = arr[5][2] = 1;
		arr[3][6] = arr[6][1] = 1;
		arr[3][7] = arr[7][3] = 1;
		arr[4][8] = arr[8][4] = 1;
		arr[4][9] = arr[9][4] = 1;
		arr[5][10] = arr[10][5] = 1;
		arr[5][11] = arr[11][5] = 1;
		arr[6][12] = arr[12][6] = 1;
		arr[6][13] = arr[13][6] = 1;
		arr[7][14] = arr[14][7] = 1;
		arr[7][15] = arr[15][7] = 1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		if(arr[a][b] == 1|| arr[b][a] == 1) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
}
