import java.io.*;
import java.util.*;

/**
 * Problem 11053
 * https://www.acmicpc.net/problem/11053
 * dp[i]: longest increasing subsequence that ends with arr[i]
 */
public class LongestIncreasingSubsequence {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  private static int n;
  private static int[] arr;
  private static int[] dp;
  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    dp = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    int res = dp();

    System.out.println(res);
  }

  private static int dp() {
    int max = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < i; ++j) {
        if (arr[i] > arr[j]) {
           dp[i] = Math.max(dp[j], dp[i]);
        }
      }
      dp[i]++;
      max = Math.max(dp[i], max);
    }

    return max;
  }
}
