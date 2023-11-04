package atcoder;
import java.util.Scanner;

public class sol4 {

    // 9 * 9 ������
    static int[][] sudoku = new int[9][9];
    static boolean[] check;
    public static void main(String[] args) {
        //1. �׽�Ʈ ���̽� ���� �Է�
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < sudoku.length; i++)
            for (int j = 0; j < sudoku[i].length; j++)
                sudoku[i][j] = sc.nextInt();
            if (check() && check1() && check2()) {
                System.out.println("Yes");
            } 
            else {
            	System.out.println("No");     
            }
    }

    //1. ������ ���� ��� ���� 45���� Ȯ���ϴ� �޼ҵ�
    private static boolean check() {
        for (int i = 0; i < 9; i++) {
            check = new boolean[10]; 
            for (int j : sudoku[i]) {
                if (check[j] || j == 0) {
                	return false;
                }
                check[j] = true;
            }
        }
        return true;
    }

    //2. ������ ���� ��� ���� 45���� Ȯ���ϴ� �޼ҵ�
    private static boolean check1() {
        for (int j = 0; j < 9; j++) {
            check = new boolean[10];
            for (int i = 0; i < 9; i++) {
                if (check[sudoku[i][j]] || sudoku[i][j] == 0) return false;
                check[sudoku[i][j]] = true;
            }
        }
        return true;
    }

    //3. 3 * 3 ���簢���� ��� ���� 45���� Ȯ���ϴ� �޼ҵ�
    private static boolean check2() {
        for (int x = 0; x < 9; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                if (!check3(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    //4.���簢������ üũ�ϴ� �޼ҵ�
    private static boolean check3(int x, int y) {
        int squaredRow = x + 3;
        int squaredColumn = y + 3;

        check = new boolean[10];

        for (int i = x; i < squaredRow; i++) {
            for (int j = y; j < squaredColumn; j++) {
                if (check[sudoku[i][j]] || sudoku[i][j] == 0) {
                	return false;
                }
                check[sudoku[i][j]] = true;
            }
        }
        return true;
    }
}