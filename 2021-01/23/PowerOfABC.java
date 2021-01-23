import java.io.*;

/**
 * Problem 15485
 * https://www.acmicpc.net/problem/15485
 * dp[i][j]: # of satisfying patterns before index i that end with character j (j is either a, b, c)
 * dp[i][j]: if character is 
 *           a -> dp[i][0] = dp[i - 1][0] * 2 + 1
 *           b -> dp[i][1] = dp[i - 1][0] + dp[i - 1][1] * 2
 *           c -> dp[i][2] = dp[i - 1][1] + dp[i - 1][2] * 2
 */
public class PowerOfABC {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final int NUM_ALPAHABET = 3;
  private static final long MOD = 1000000007;

  private static int n;
  private static char[] input;
  private static long[][] dp;

  public static void main(String[] args) throws IOException {
    input = br.readLine().toCharArray();
    n = input.length;

    dp = new long[n + 1][NUM_ALPAHABET];

    long res = dp();
  
    System.out.println(res);
  }

  private static long dp() {
    long count = 0;

    for (int i = 0; i < n; ++i) {
      // preset
      for (int j = 0; j < NUM_ALPAHABET; ++j) {
        dp[i + 1][j] = dp[i][j];
      }

      int charStatus = input[i] - 'a';

      if (charStatus == 0) {
        dp[i + 1][charStatus] = mod(dp[i][0] * 2 + 1);
      } else {
        dp[i + 1][charStatus] = mod(dp[i][charStatus - 1] + 2 * dp[i][charStatus]);
        if (charStatus == NUM_ALPAHABET - 1) {
          count = dp[i + 1][charStatus];
        }
      }
    }

    return count;
  }

  private static long mod (long num) {
    return num % MOD;
  }
}
