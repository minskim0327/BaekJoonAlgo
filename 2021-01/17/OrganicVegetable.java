import java.io.*;
import java.util.*;

/**
 * Problem 1012
 * https://www.acmicpc.net/problem/1012
 * Time Complexity: O(mn)
 * Space Complexity: O(mn)
 */
public class OrganicVegetable {
  private static int n, m;
  private static boolean[][] grid;

  private static final int[][] DIR = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception {
    int numFields = Integer.parseInt(br.readLine());

    for (int i = 0; i < numFields; ++i) {
      int numWorms = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      int numVegetables = Integer.parseInt(st.nextToken());

      grid = new boolean[n][m];

      for (int j = 0; j < numVegetables; ++j) {
        st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        grid[r][c] = true;
      }
      
      for (int r = 0; r < n; ++r) {
        for (int c = 0; c < m; ++c) {
          if (grid[r][c]) {
            numWorms++;
            bfs(r, c);
          }
        }
      }

      System.out.println(numWorms);
    }
  }

  private static void bfs(int r, int c) {
    Queue<Coord> queue = new LinkedList<>();
    queue.add(new Coord(r, c));
    grid[r][c] = false;

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; ++i) {
        Coord curr = queue.poll();

        for (int j = 0; j < DIR.length; ++j) {
          int nr = curr.r + DIR[j][0];
          int nc = curr.c + DIR[j][1];

          if (isValidCoord(nr, nc)) {
            queue.add(new Coord(nr, nc));
            grid[nr][nc] = false;
          }
        }
      }
    }

  }
  private static boolean isValidCoord(int r, int c) {
    return r >= 0 && r < n && c >= 0 && c < m && grid[r][c]; 
  }

  private static class Coord {
    public int r, c;
  
    public Coord(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}
