import java.io.*;
import java.util.*;

/**
 * Problem 7576
 */
public class RottingTomato {
  private static int m, n;
  private static int[][] grid;
  private static int rotted, target;
  private static Queue<Coord> queue;

  private static final int[][] DIR = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  
  public static void main(String[] args) throws Exception {
    init();

    int result = rot();

    System.out.println(result);
  }

  private static void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    grid = new int[n][m];
    rotted = 0;
    target = 0;
    queue = new LinkedList<Coord>();

    for (int r = 0; r < n; ++r) {
      String currRow = br.readLine();
      StringTokenizer currToken = new StringTokenizer(currRow, " ");
      for (int c = 0; c < m; ++c) {
        int status = Integer.parseInt(currToken.nextToken());
        if (status >= 0) {
          target++;
        }
        if (status == 1) {
          rotted++;
          queue.add(new Coord(r, c));
        }
        grid[r][c] = status;
      }
    }
  }

  private static int rot() {
    int timestamp = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();
      
      for (int i = 0; i < size; ++i) {
        Coord currCoord = queue.poll();
        int r = currCoord.r;
        int c = currCoord.c;

        for (int j = 0; j < DIR.length; ++j) {
          int nr = r + DIR[j][0];
          int nc = c + DIR[j][1];

          if (isValidCoord(nr, nc)) {
            queue.add(new Coord(nr, nc));
            grid[nr][nc] = 1;
            rotted++;
          }
        }
      }
      timestamp++;
    }

    return rotted == target ? timestamp - 1 : -1;
  }

  private static boolean isValidCoord(int r, int c) {
    return r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 0;
  }

  private static class Coord {
    public int r, c;
  
    public Coord (int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}

