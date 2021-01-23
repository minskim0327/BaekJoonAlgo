import java.io.*;
import java.util.*;

/**
 * Problem 1915
 * https://www.acmicpc.net/problem/1915
 * dp[i][j] : length of largest square from grid[i][j] to grid[n - 1][m - 1] (bottom right)
 * dp[i][j] : if grid[i][j] = 0 then 0
 *            else  1 + mininmum of dp[i + 1][j + 1], dp[i][j + 1], dp[i + 1][j] 
 * base case: dp[n][0..m] = dp[m][0..n] = 0
 */
public class LargestSquare {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  private static int n, m;
  private static int[][] grid;
  private static int[][] dp;
  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    grid = new int[n][m];
    dp = new int[n + 1][m + 1];

    for (int r = 0; r < n; ++r) {
      String currInput = br.readLine();
      for (int c = 0; c < m; ++c) {
        grid[r][c] = currInput.charAt(c) - '0';
      }
    }

    int maxLen = dp();
    int res = maxLen * maxLen;
    System.out.println(res);
  }

  private static int dp() {
    int res = 0;

    for (int r = n - 1; r >= 0; r--) {
      for (int c = m - 1; c >= 0; c--) {
        if (grid[r][c] == 0) {
          dp[r][c] = 0;
        } else {
          dp[r][c] = Math.min(dp[r + 1][c + 1], Math.min(dp[r + 1][c], dp[r][c + 1])) + 1; 
        }
        res = Math.max(res, dp[r][c]);
      }
    }

    return res;
  }
}
