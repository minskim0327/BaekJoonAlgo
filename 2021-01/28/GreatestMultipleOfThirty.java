import java.io.*;
import java.util.*;

/**
 * Problem 10610
 * https://www.acmicpc.net/problem/10610
 */
public class GreatestMultipleOfThirty {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final String ERROR_VAL = "-1";

  private static Queue<Character> pq;
  private static int digitSum;
  private static boolean hasZero = false;

  public static void main(String[] args) throws IOException {
    char[] arr = br.readLine().toCharArray();
    pq = new PriorityQueue<>((a, b) -> b.compareTo(a));

    for (char c : arr) {
      if (!hasZero && c == '0') {
        hasZero = true;
      }
      int digit = c - '0';
      digitSum += digit;
      pq.offer(c);
    }

    if (!hasZero || digitSum % 3 != 0) {
      System.out.println(ERROR_VAL);
      return;
    }

    while (!pq.isEmpty()) {
      System.out.print(pq.poll());
    }
    System.out.println();
  }
}
