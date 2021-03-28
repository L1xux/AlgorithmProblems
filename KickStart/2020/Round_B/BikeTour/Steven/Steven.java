import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Steven {

    private static int N;

    public static int solve(int[] map){
            int cnt = 0;

            for(int i = 1 ; i < N - 1 ; i++){
                    if(map[i] > map[i-1] && map[i] > map[i+1])
                            cnt++;
            }

            return cnt;
    }

    public static void main(String[] args) throws Exception{
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int testCase = in.nextInt();
            for(int t = 1 ; t <= testCase ; t++){
                    N = in.nextInt();
                    int[] map = new int[N];
                    int cnt = 0;

                    for(int i = 0 ; i < N ; i++){
                            map[i] = in.nextInt();
                    }

                    bw.write("Case #" + t + ": " + solve(map) + "\n");
            }

            bw.flush();

            in.close();
            bw.close();
    }
}

