package solution;
import java.io.*;
public class sol225 {
	public static void main(String[] args) throws IOException {
		int g = 0;
		int k = 0;
		int[][] LCS;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String a = br.readLine();
		String b = br.readLine();
		LCS = new int[a.length()+1][b.length()+1];
		for(int i = 0; i < a.length(); i++) {
			for(int j = g; j < b.length(); j++) {
				if(a.indexOf(a.charAt(i))<= j) {
					if(a.charAt(i) == b.charAt(j)) {
						k = j;
						g = i;
						sb.append(b.charAt(j));
						break;
					}
				}
			}
		}
		System.out.println(sb);
		bw.write(String.valueOf(sb.length()));
		bw.flush();
	}
}
