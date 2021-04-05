import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Steven{
	private static long BOUNDARY = 1000000000;
	
	public static long[] solve(char[] ins, long[] directions, boolean[] visited, int now) {
		if(now >= ins.length)
			return directions;
		
		if (!visited[now]) {
			visited[now] = true;
			
			if (ins[now] == '(') {
				long[] nDirections = solve(ins, new long[] { 0, 0, 0, 0 }, visited, now + 1);

				long num = ins[now - 1] - '0';

				for (int i = 0; i < 4; i++) {
					directions[i] += (nDirections[i] * num);

					if (directions[i] > BOUNDARY)
						directions[i] %= BOUNDARY;
				}
			} else if (ins[now] == ')')
				return directions;
			
			if(ins[now] == 'E') directions[0]++;
			if(ins[now] == 'W') directions[1]++;
			if(ins[now] == 'S') directions[2]++;
			if(ins[now] == 'N') directions[3]++;
		}
		
		return solve(ins, directions, visited, now + 1);
	}
	
	public static void main(String[] args) throws Exception{		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = in.nextInt();
		in.nextLine();
		
		for(int t = 1 ; t <= T ; t++) {
			
			String instruction = in.nextLine();
			
            long[] res = solve(instruction.toCharArray(), new long[] {0, 0, 0, 0}, new boolean[instruction.length()], 0);
           
            long x = (res[0] - res[1]) + 1;
            long y = (res[2] - res[3]) + 1;

            if(x <= 0) x+=BOUNDARY;
            else if(x > BOUNDARY) x = x % BOUNDARY;
            if(y <= 0) y+=BOUNDARY;
            else if(y > BOUNDARY) y = y % BOUNDARY;

            bw.write("Case #" + t + ": " + x + " " + y + "\n");
		}
		
		bw.flush();
		
		in.close();
		bw.close();
	}
}

