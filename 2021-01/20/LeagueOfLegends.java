import java.io.*;
import java.util.*;

/**
 * Problem 17271
 * https://www.acmicpc.net/problem/17271
 * n: # of total seconds
 * m: # seconds for second skill : 2 <= m <= 100
 * dp[i]: # of skill combinations when i seconds are given
 * dp[i] = dp[i - 1] + dp[i - m]
 * dp[0] = dp[1] = 1
 */
public class LeagueOfLegends {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final int MOD = 1000000007;
  private static long dp[];
  private static int timeLimit;
  private static int first = 1;
  private static int second;
  
  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    timeLimit = Integer.parseInt(st.nextToken());
    second = Integer.parseInt(st.nextToken());

    // initialize dp array
    dp = new long[timeLimit + 1];
    dp[0] = 1;
    dp[1] = 1;
    
    dp();

    System.out.println(dp[timeLimit]);
  }

  private static void dp() {
    for (int i = 2; i <= timeLimit; ++i) {
      dp[i] = i - second >= 0 ? mod(dp[i - first] + dp[i - second]) : mod(dp[i - first]);
    }
  }

  private static long mod(long n) {
    return n % MOD;
  }
}
