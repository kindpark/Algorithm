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
				//�ð��� ��� �귯���ϱ� - i�� ����
				//��� ��ŭ �������� 9�ð� ���� �������� ���� Ȯ�ΰ���
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
