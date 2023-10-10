// 1.7

import java.io.*;

public class rotateMatrix {
  public static void main(String[] args) {
    System.out.println("This is Empty");
  }

  /*
   * -------- Iterative --------
   * Time - O(N^2)
   * Space - O(1)
   * -----------------------------------------
   */
  void rotate(int[][] matrix) {
    if (matrix.length == 0 || matrix.length != matrix[0].length) return;

    int n = matrix.length;
    for (int layer = 0; layer < n / 2; layer++) {
      int first = layer;
      int last = n - 1 - layer;
      for (int i = first; i < last; i++) {
        int offset = i - first;

        int top = matrix[first][i];

        // Left --> Top
        matrix[first][i] = matrix[last - offset][first];

        // Bottom --> Left
        matrix[last - offset][first] = matrix[last][last - offset];

        // Right --> Bottom
        matrix[last][last - offset] = matrix[i][last];

        // Top --> Right
        matrix[i][last] = top; // Right <-- saved Top
      }
    }
  }
}
