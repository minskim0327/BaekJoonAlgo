import java.io.*;
import java.util.*;

/**
 * Problem 2178
 * Time Complexity: O(mn)
 * Space Complexity: O(mn)
 */
public class MazeSearch {
  private static int n, m;
  private static int[][] grid;
  private static boolean[][] visited;
  private static final int[][] DIR = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) throws Exception {
    init();

    System.out.println(solution());
  }

  private static void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    grid = new int[n][m];
    visited = new boolean[n][m];

    for (int r = 0; r < n; ++r) {
      String currRow = br.readLine();
      for (int c = 0; c < m; ++c) {
        grid[r][c] = currRow.charAt(c) - '0';
      }
    }
  }

  private static int solution() {
    Queue<Coord> queue = new LinkedList<>();
    queue.add(new Coord(0, 0));
    visited[0][0] = true;
    int res = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();
      res++;

      for (int i = 0; i < size; ++i) {
        Coord curr = queue.poll();
        if (curr.x == m - 1 && curr.y == n - 1) {
          return res;
        }

        for (int j = 0; j < DIR.length; ++j) {
          int newX = curr.x + DIR[j][1];
          int newY = curr.y + DIR[j][0];

          if (isValidCoord(newX, newY)) {
            queue.add(new Coord(newX, newY));
            visited[newY][newX] = true;
          }
        }
      }
    }

    return 0;
  }

  private static boolean isValidCoord(int x, int y) {
    return x >= 0 && x < m && y >= 0 && y < n && grid[y][x] == 1 && !visited[y][x];
  }
  private class Coord {
    public int x, y;
  
    public Coord(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}

