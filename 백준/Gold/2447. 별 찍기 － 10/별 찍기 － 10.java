import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
	static char[][] pattern;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();

		pattern = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				pattern[i][j] = ' ';
			}
		}
		
        drawPattern(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(pattern[i][j]);
            }
            sb.append('\n');
        }
		sb.setLength(sb.length() - 1);
        System.out.print(sb.toString());
    }

    static void drawPattern(int x, int y, int size) {
        if (size == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        pattern[x + i][y + j] = ' ';
                    } else {
                        pattern[x + i][y + j] = '*';
                    }
                }
            }
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                } else {
                    drawPattern(x + i * newSize, y + j * newSize, newSize);
                }
            }
        }
    }
}