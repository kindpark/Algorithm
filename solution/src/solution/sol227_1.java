package solution;
import java.util.*;

public class sol227_1 {
	public static boolean bt(int[] a) {
		int i = a.length - 1;
		while (i > 0 && a[i - 1] >= a[i]) {
			i-=1;
		}
		if (i < 0) {
			return false;
		}
		int j = a.length - 1;

		while (a[j] <= a[i - 1]) {
			j-=1;
		}

		int temp = a[i - 1];
		a[i - 1] = a[j];
		a[j] = temp;

		j = a.length - 1;

		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return true;

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		if (bt(a)) {
			for (int i = 0; i < n; i++) {
				System.out.print(a[i] + " ");
			}
		} else {
			System.out.println(-1);
		}
	}
}
