import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Steven {
	private static int N;
	
	public static long solve(int[] nums) {		
		Map<Integer, Integer> preSum = new HashMap<>();
		
		int max = 0;
		for(int i = 0 ; i < N ; i++) {
			if(nums[i] >= 0) 
			    max+=nums[i];
		}
		
		long cnt = 0;
		int sum = 0;
		
		for(int i = 1 ; i <= N ; i++) {
		    preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
			sum+=nums[i-1];
			
			for(int j = 0 ; j*j <= max ; j++) {
				if(preSum.containsKey(sum - j*j))
					cnt+=preSum.get(sum-j*j);
			}
		}
		
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = in.nextInt();
		in.nextLine();
		
		for(int t = 1 ; t <= T ; t++) {
			N = in.nextInt();
			in.nextLine();
			
			StringTokenizer st = new StringTokenizer(in.nextLine());
			int[] nums = new int[N];
			
			
			for(int i = 0 ; i < N ; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			
			bw.write("Case #" + t +": " + solve(nums) + "\n");
		}
		
		bw.flush();
			
		in.close();
		bw.close();
	}
}

