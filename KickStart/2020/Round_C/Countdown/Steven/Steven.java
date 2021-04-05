import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Steven {
	public static int solve(int N, int K, int[] nums) {
		int cnt = 0;
		boolean isStart = false;
		
		for(int i = 1 ; i < N ; i++) {			
			if(nums[i-1] == K)
			    isStart = true;
			    
			if(isStart && nums[i-1] - 1 != nums[i]) 
			    isStart = false;
			
			if(isStart && nums[i] == 1) {
				cnt++;
				isStart = false;
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
			StringTokenizer st = new StringTokenizer(in.nextLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] nums = new int[N];
			
			st = new StringTokenizer(in.nextLine());
			for(int i = 0 ; i < N ; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			bw.write("Case #" + t +": " + solve(N, K, nums) + "\n");
		}
		
		bw.flush();
		
		in.close();
		bw.close();
	}

}

