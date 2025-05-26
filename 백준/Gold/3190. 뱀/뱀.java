import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int boardSize = Integer.parseInt(br.readLine());
		int applePosCount = Integer.parseInt(br.readLine());
		
		boolean[][] applePos = new boolean[boardSize+1][boardSize+1];
		for (int i = 0; i < applePosCount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
			applePos[row][col] = true;
		}
		
		int operationCount = Integer.parseInt(br.readLine());
		HashMap<Integer, Character> operationBySec = new HashMap<>();
		for (int i = 0; i < operationCount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char operation = st.nextToken().charAt(0);
			operationBySec.put(time,operation);
		}
		br.close();
		
		SnakeGame sg = new SnakeGame(boardSize, boardSize, applePos);
		while(!sg.isGameEnd) {
			Character operation = operationBySec.get(sg.elapsedSec);
			sg.move(operation);
		}
		
		System.out.print(sg.elapsedSec);
	}
}


class SnakeGame {
	boolean isGameEnd = false;
	
	int mapXSize;
	int mapYSize;
	
	int elapsedSec = 0;
	
	// snake 위치
	Deque<int[]> pos = new ArrayDeque<>();

	// snake 방향
	int currDirection = 0; // 0 1 2 3 => R D L U
	int[][] nextPosByDirection = new int[][] { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
	
	// 사과 위치
	boolean[][] applePos;
	
	// 생성자
	public SnakeGame(int mapXSize, int mapYSize, boolean[][] applePos) {
		this.mapXSize = mapXSize;
		this.mapYSize = mapYSize;
		this.applePos = applePos;
		pos.add(new int[] {1, 1});
	}	
	
	// 이동
	public void move(Character operation) {
		elapsedSec++;		
		if (operation != null) changeDirection(operation);
		
		// 머리 이동
		int[] head = pos.peek();
		int[] next = nextPosByDirection[currDirection];
		int newHeadX = head[0] + next[0];
		int newHeadY = head[1] + next[1];
				
		// 새로운 머리 벽 충돌 확인
		if (newHeadX > mapXSize || newHeadX < 1 || newHeadY > mapYSize || newHeadY < 1) {
			isGameEnd = true;
			return;
		}		
		
		// 머리 업데이트
		pos.addFirst(new int[] {newHeadX, newHeadY});
		
		// 자신과 충돌 확인
		Iterator<int[]> bodyIterator = pos.iterator();
		bodyIterator.next();
		while(bodyIterator.hasNext()) {
			int[] body = bodyIterator.next();
			if(newHeadX == body[0] && newHeadY == body[1]) {
				isGameEnd = true;
				return;
			}
		}
		
		// 몸통 업데이트
		boolean ateApple = applePos[newHeadX][newHeadY];
		if (!ateApple) {
			pos.removeLast();
		} else {
			applePos[newHeadX][newHeadY] = false;
		}
	}
	
	// 방향 전환
	private void changeDirection(char operation) {
		if (operation == 'L') currDirection = (currDirection - 1 + 4) % 4;
		else currDirection = (currDirection + 1) % 4;
	}
}
