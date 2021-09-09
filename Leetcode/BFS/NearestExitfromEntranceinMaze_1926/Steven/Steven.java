
import java.util.*;
import java.io.*;


public class Steven {
	private static int[] NR = new int[] { -1, 1, 0, 0 };
	private static int[] NC = new int[] { 0, 0, -1, 1 };
	
	static class Person{
		int row, col, steps;
		
		Person(int row, int col, int steps){
			this.row = row;
			this.col = col;
			
			this.steps = steps;
		}
	}
	
	
    public static int nearestExit(char[][] maze, int[] entrance) {
    	Queue<Person> q = new LinkedList<>();
    	q.offer(new Person(entrance[0], entrance[1], 0));
    	
    	boolean[][] visited = new boolean[maze.length][maze[0].length];
    	
    	int res = maze.length * maze[0].length + 1;
    	
    	visited[entrance[0]][entrance[1]] = true;
    	
    	while(!q.isEmpty()) {
    		Person now = q.poll();
    		int nowRow = now.row;
    		int nowCol = now.col;
    		int nowSteps = now.steps;
    		
    		if((nowRow != entrance[0] || nowCol != entrance[1]) &&  
    		  (nowRow == 0 || nowRow == maze.length - 1 || nowCol == 0 || nowCol == maze[0].length - 1)) {
    			res = Math.min(res, nowSteps);
    		}
    		
    		for(int i = 0 ; i < 4 ; i++) {
    			int nextR = nowRow + NR[i];
    			int nextC = nowCol + NC[i];
    			
    			if(nextR < 0 || nextR >= maze.length || nextC < 0 || nextC >= maze[0].length || maze[nextR][nextC] == '+' || visited[nextR][nextC])
    				continue;
    			
    			visited[nextR][nextC] = true;
    			q.offer(new Person(nextR, nextC, nowSteps + 1));
    		}
    	}
    	
    	return res == maze.length * maze[0].length + 1 ? -1 : res;
    }
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		char[][] maze = new char[M][N];
		for(int i = 0 ; i < M ; i++) {
			maze[i] = br.readLine().toCharArray();
		}
		
		int[] entrance = new int[2];
		st = new StringTokenizer(br.readLine());
		entrance[0] = Integer.parseInt(st.nextToken());
		entrance[1] = Integer.parseInt(st.nextToken());
		
		bw.write(nearestExit(maze, entrance) + "\n");
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}

