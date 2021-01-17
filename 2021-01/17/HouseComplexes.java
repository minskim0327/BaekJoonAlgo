import java.io.*;
import java.util.*;

/**
 * Problem 2667
 * https://www.acmicpc.net/problem/2667
 * Time Complexity: O(mn)
 * Space Complexity: O(mn)
 */

 public class HouseComplexes {
  private static int n;
  private static int[][] grid;
  private static Queue<Integer> pq;

  private static final int[][] DIR = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) throws Exception {
    init();

    countComplexes();

    System.out.println(pq.size());

    while (!pq.isEmpty()) {
      System.out.println(pq.poll());
    }
  }

  private static void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    grid = new int[n][n];
    
    pq = new PriorityQueue<Integer>();

    for (int r = 0; r < n; ++r) {
      String str = br.readLine();
      for (int c = 0; c < n; ++c) {
        grid[r][c] = str.charAt(c) - '0';
      }
    }
  }

  private static void countComplexes() {
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        if (grid[r][c] == 1) {
          bfs(r, c);
        }
      }
    }
  }

  private static void bfs(int r, int c) {
    int complexSize = 0;

    Queue<Coord> queue = new LinkedList<>();
    queue.add(new Coord(r, c));
    grid[r][c] = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; ++i) {
        Coord currCoord = queue.poll();

        for (int j = 0; j < DIR.length; ++j) {
          int nr = currCoord.r + DIR[j][0];
          int nc = currCoord.c + DIR[j][1];

          if (isValidCoord(nr, nc)) {
            queue.add(new Coord(nr, nc));
            grid[nr][nc] = 0;
          }
        }
        complexSize++;
      }
    }

    pq.offer(complexSize);
  }

  private static boolean isValidCoord(int r, int c) {
    return r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 1;
  }

  private static class Coord {
    public int r, c;
  
    public Coord (int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}
