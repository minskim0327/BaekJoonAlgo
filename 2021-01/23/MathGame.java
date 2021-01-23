import java.io.*;

/**
 * Problem 2862
 * https://www.acmicpc.net/problem/2862
 * dp[i][j]: true if win when i coins are left and the player takes j coins, false otherwise.
 * 
 * transition function : determin condition for dp[i][j]
 * if the player takes j stones, the other player can take 1 <= x <= 2j stones
 * if i - j (remaining coins) <= 2j, dp[i][j] = false
 * else
 * dp[i][j] = !(dp[i - j][1] || dp[i - j][2] ... || dp[i - j][2j])
 * 
 * basecase: dp[1][1] = true
 */
public class MathGame {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static boolean[][] dp;
  private static int N;

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    
    dp = new boolean[N + 1][N + 1];

    int res = dp();

    System.out.println(res);
  }

  private static int dp() {  
    for (int i = 1; i <= N; ++i) {
      for (int j = 1; j <= N; ++j) {
        if (i <= j) {
          dp[i][j] = true;
          continue;
        }

        if (i - j <= 2 * j) {
          dp[i][j] = false;
          continue;
        }

        boolean canOpponentWin = false;
        for (int x = 1; x <= 2 * j; ++x) {
          canOpponentWin = canOpponentWin || dp[i - j][x];
          if (canOpponentWin) {
            break;
          }
        }

        dp[i][j] = !canOpponentWin;
      }
    }


    for (int i = 1; i <= N; ++i) {
      if (dp[N][i]) {
        return i;
      }
    }

    return -1;
  }
}
