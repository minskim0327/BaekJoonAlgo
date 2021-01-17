import java.io.*;
import java.util.*;

/**
 * Problem 2606
 * https://www.acmicpc.net/problem/2606
 */
public class ComputerVirus {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private static int numComputers, numConnections;
  private static boolean[] infectionStatus; // true: infected, false: not infected
  private static boolean[][] grid;


  public static void main(String[] args) throws Exception {
    numComputers = Integer.parseInt(br.readLine());
    numConnections = Integer.parseInt(br.readLine());

    infectionStatus = new boolean[numComputers];
    grid = new boolean[numComputers][numComputers];

    for (int line = 0; line < numConnections; ++line) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken()) - 1;
      int c = Integer.parseInt(st.nextToken()) - 1;

      grid[r][c] = true;
      grid[c][r] = true;
    }

    int startInfection = 1;

    int infected = bfs(startInfection - 1);
    System.out.println(infected);

  }

  private static int bfs (int start) {
    int numInfected = 0;

    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    infectionStatus[start] = true;

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; ++i) {
        int index = queue.poll();

        for (int j = 0; j < numComputers; ++j) {
          if (grid[index][j] && !infectionStatus[j]) {
            queue.add(j);
            infectionStatus[j] = true;
            numInfected++;
          }
        }
      }
    }
    
    return numInfected;
  }
}
