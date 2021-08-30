
import java.io.*;
import java.util.*;
/**
 * 
 * @author mr938
 *	Given a m x n grid. Each cell of the grid represents a street. 
 *	The street of grid[i][j] can be:
 *	
 *	1 which means a street connecting the left cell and the right cell.
 *	2 which means a street connecting the upper cell and the lower cell.
 *	3 which means a street connecting the left cell and the lower cell.
 *	4 which means a street connecting the right cell and the lower cell.
 *	5 which means a street connecting the left cell and the upper cell.
 *	6 which means a street connecting the right cell and the upper cell.
 *
 *	You will initially start at the street of the upper-left cell (0,0). 
 *	A valid path in the grid is a path which starts from the upper left cell (0,0) 
 *	and ends at the bottom-right cell (m - 1, n - 1). The path should only follow the streets.
 */

/**
 * 
 * @author mr938
 *	1. There are some specific roads in a map, check if there is a valid path in the map.
 *	here the valid path is the path which starts from (0, 0) to (m - 1, n - 1)
 *
 *	2. Find out a way that are connected roads to go from (0, 0) to (m - 1, n - 1)
 *
 *  3. we already know each road go the specific direction
 *  	so we can keep tracking of a way on the road.
 *  	we can also know two roads are connected by supposing that move a person on the road to another road
 *  	and the person is on the another road. then, the two roads are connected
 *  	then, find out the way to go from (0, 0) to (m - 1, n - 1) by using BFS.
 *  
 *  4. BFS takes as long as the size of the map. here it takes O(n * m)
 */

class Pair{
	private int row;
	private int col;
	
	Pair(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	public int getRow() { return this.row; }
	public int getCol() { return this.col; }
}

class CheckifThereisaValidPathinaGrid_1391 {
	private static int R, C;	
	
	public static boolean hasValidPath(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Map<Integer, Integer[][]> directionsOfPath = new HashMap<>();
		
		directionsOfPath.put(1, new Integer[][]{{0, -1}, {0, 1}});
		directionsOfPath.put(2, new Integer[][]{{-1, 0}, {1, 0}});
		directionsOfPath.put(3, new Integer[][]{{0, -1}, {1, 0}});
		directionsOfPath.put(4, new Integer[][]{{0, 1}, {1, 0}});
		directionsOfPath.put(5, new Integer[][]{{0, -1}, {-1, 0}});
		directionsOfPath.put(6, new Integer[][]{{0, 1}, {-1, 0}});
		
		
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0, 0));
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			
			int row = now.getRow();
			int col = now.getCol();
		
			if(row == grid.length - 1 && col == grid[0].length - 1)
				return true;
			
			if(visited[row][col])
				continue;
			
			visited[row][col] = true;
			
			for(int i = 0 ; i < 2 ; i++) {
				int NR = row + directionsOfPath.get(grid[row][col])[i][0];
				int NC = col + directionsOfPath.get(grid[row][col])[i][1];
				
				if(NR >= 0 && NR < grid.length && NC >= 0 && NC < grid[0].length && !visited[NR][NC]) {
					if((row == NR + directionsOfPath.get(grid[NR][NC])[0][0] && col == NC + directionsOfPath.get(grid[NR][NC])[0][1]) 
							|| (row == NR + directionsOfPath.get(grid[NR][NC])[1][0] && col == NC + directionsOfPath.get(grid[NR][NC])[1][1])){
						q.offer(new Pair(NR, NC));
					}
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[][] grid = new int[R][C];
	
		for(int i = 0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < C ; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bw.write(hasValidPath(grid) + "\n");
		
		br.close();
		bw.close();
	}
}

