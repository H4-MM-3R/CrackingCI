// 1.8

import java.io.*;

public class zeroMatrix {
  public static void main(String[] args) {
    System.out.println("This is Empty");
  }

  /*
   * -------- Brute Force --------
   * Time - O(N^2)
   * Space - O(N)
   * -----------------------------------------
   */
  void setZeroes(int[][] matrix) {
    boolean[] row = new boolean[matrix.length];
    boolean[] col = new boolean[matrix[0].length];

    // Store the Row and Column index with value 0
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          row[i] = true;
          col[j] = true;
        }
      }
    }

    // Nullify Rows
    for (int i = 0; i < row.length; i++) {
      if (row[i]) nullifyRow(matrix, i);
    }

    // Nullify Columns
    for (int i = 0; i < col.length; i++) {
      if (col[i]) nullifyColumn(matrix, i);
    }
  }

  void nullifyRow(int[][] matrix, int row) {
    for (int j = 0; j < matrix[0].length; j++) {
      matrix[row][j] = 0;
    }
  }

  void nullifyColumn(int[][] matrix, int col) {
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][col] = 0;
    }
  }

  /*
   * -------- Space Optimization --------
   * Time - O(N^2)
   * Space - O(1)
   * -----------------------------------------
   */
  void setZeroes1(int[][] matrix) {
    boolean rowHasZero = false;
    boolean colHasZero = false;

    /*
     * Check if first row has a zero
     */
    for (int j = 0; j < matrix[0].length; j++) {
      if (matrix[0][j] == 0) {
        rowHasZero = true;
        break;
      }
    }

    /*
     * Check if first column has a zero
     */
    for (int i = 0; i < matrix.length; i++) {
      if (matrix[i][0] == 0) {
        colHasZero = true;
        break;
      }
    }

    /*
     * Check for Zeroes in the rest of array
     */
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    /*
     * Nullify rows based on values in first row
     */
    for (int i = 1; i < matrix[0].length; i++) {
      if (matrix[0][j] == 0) nullifyColumn(matrix, i);
    }

    /*
     * Nullify columns based on values in first column
     */
    for (int i = 1; i < matrix.length; i++) {
      if (matrix[i][0] == 0) nullifyRow(matrix, i);
    }

    /*
     * Nullify first row
     */
    if (rowHasZero) nullifyRow(matrix, 0);

    /*
     * Nullify first column
     */
    if (colHasZero) nullifyColumn(matrix, 0);
  }
}
