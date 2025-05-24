import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        char[][] inputBoard = new char[row][col];

        // Read the board
        for (int i = 0; i < row; i++) {
            inputBoard[i] = br.readLine().toCharArray();
        }

        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                int count1 = checkBoard(inputBoard, i, j, 'W');
                int count2 = checkBoard(inputBoard, i, j, 'B');
                minCount = Math.min(minCount, Math.min(count1, count2));
            }
        }

        System.out.print(minCount);
    }

    private static int checkBoard(char[][] board, int startRow, int startCol, char firstColor) {
        int count = 0;
        char expectedColor = firstColor;

        for (int i = startRow; i < startRow + 8; i++) {
            for (int j = startCol; j < startCol + 8; j++) {
                if (board[i][j] != expectedColor) {
                    count++;
                }
                expectedColor = (expectedColor == 'W') ? 'B' : 'W';
            }
            expectedColor = (expectedColor == 'W') ? 'B' : 'W';
        }
        return count;
    }
}