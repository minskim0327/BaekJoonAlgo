import java.io.*;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Problem 1181
 * https://www.acmicpc.net/problem/1181
 */
public class SortWords {
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  private static int numWords;
  private static Queue<String> priorityQueue;
  private static Set<String> words;

  public static void main(String[] args) throws IOException {
    numWords = Integer.parseInt(br.readLine());
    
    priorityQueue = new PriorityQueue<String>(
      (a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length()
    );
    words = new HashSet<String>();
    insertWordsIntoQueue();

    while (!priorityQueue.isEmpty()) {
      System.out.println(priorityQueue.poll());
    }
  } 

  private static void insertWordsIntoQueue() throws IOException {
    for (int i = 0; i < numWords; ++i) {
      String st = br.readLine();
      if (words.contains(st)) {
        continue;
      }
      words.add(st);
      priorityQueue.offer(st);
    }
  }
}
