import java.io.*;

/**
 * Problem 15485
 * https://www.acmicpc.net/problem/15485
 * dp[i][j]: # of ways to achieve sum i from j..i
 * dp[i][j] = dp[i][j + 1] + dp[i - j][j + 1]
 * base case: dp[i][i] = 1
 */
public class NaturalNumberComposition {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final int MOD = 100999;
  private static final int MAX = 2000;

  private static int numTestCases;
  private static long[][] dp;

  public static void main(String[] args) throws IOException {
    numTestCases = Integer.parseInt(br.readLine());
    
    dp = new long[MAX + 1][MAX + 1];
    dp();

    for (int i = 0; i < numTestCases; ++i) {
      int num = Integer.parseInt(br.readLine());
      System.out.println(dp[num][1]);
    }
  }

  private static void dp() {  
    for (int i = 1; i <= MAX; ++i) {
      for (int j = i; j >= 1; --j) {
        if (i == j) {
          dp[i][j] = 1;
          continue;
        } 
        dp[i][j] = mod(dp[i][j + 1] + dp[i - j][j + 1]);
      }
    }
  }

  private static long mod (long num) {
    return num % MOD;
  }
}
