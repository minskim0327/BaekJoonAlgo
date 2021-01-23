import java.io.*;

/**
 * Problem 11726
 * https://www.acmicpc.net/problem/11726
 * dp[i]= # of ways to fill tiles from 1..ith grid
 * dp[i]= dp[i - 1] + dp[i - 2]
 * fibonacci
 * base: dp[1] = 1, dp[2] = 2
 */
public class FillTiles {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final int MOD = 10007;

  private static int n;
  private static int[] dp;

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    
    dp = new int[n];
    dp[0] = 1;

    if (n > 1) {
      dp[1] = 2;

      for (int i = 2; i < n; ++i) {
        dp[i] = mod(dp[i - 1] + dp[i - 2]);
      }
    }

    System.out.println(dp[n - 1]);
  }


  private static int mod (int num) {
    return num % MOD;
  }
}
