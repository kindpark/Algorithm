package solution;
import java.io.*;
import java.util.*;
public class sol235 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int length = Integer.parseInt(br.readLine());
		String ioi = br.readLine();
		int ans = 0;
		ioi += "asdasa";
		for(int i = 0; i < length-2; i++) {
			if (ioi.charAt(i+1) == 'O' && ioi.charAt(i+2) == 'I') {
                int IOI = 0;
                while (ioi.charAt(i) == 'I' && ioi.charAt(i+1) == 'O') {
                    i += 2;
                    IOI += 1;
 
                    if (ioi.charAt(i) == 'I' && IOI == n) {
                        ans += 1;
                        IOI -= 1;
                    }
                }
            }
		}
		System.out.println(ans);
	}
}
