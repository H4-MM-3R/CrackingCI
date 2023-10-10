// 1.6

import java.io.*;

public class stringCompression {
  public static void main(String[] args) {
    System.out.println("This is Empty");
  }

  /*
   * -------- Basic Iteration and Store --------
   * Time - O(P + K^2) {** p = string size, k = no.of chars **}
   * Space - O(P)
   * -----------------------------------------
   */

  String compress(String str) {
    String compressed = "";
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
      countConsecutive++;
      /*
       * **** If next char is different than current ****
       * ------------------------------------------------
       * Append this char to result.
       * -----------------------------------------------
       */
      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressed += "" + str.charAt(i) + countConsecutive;
        countConsecutive = 0;
      }
    }
    return compressed.length() < str.length() ? compressed : str;
  }

  /*
   * -------- String Builder --------
   * Time - O()
   * Space - O()
   * -----------------------------------------
   */
  String compress1(String str) {
    StringBuilder compressed = new StringBuilder();
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
      countConsecutive++;
      /*
       * **** If next char is different than current ****
       * ------------------------------------------------
       * Append this char to result.
       * -----------------------------------------------
       */
      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressed.append(str.charAt(i));
        compressed.append(countConsecutive);
        countConsecutive = 0;
      }
    }
    return compressed.length() < str.length() ? compressed.toString() : str;
  }

  /*
   * -------- Optimal --------
   * Time - O()
   * Space - O()
   * -----------------------------------------
   */
  String compress2(String str) {

    /* Check final len and returen input string if its longer */
    int finalLength = countCompression(str);
    if (finalLength >= str.length()) return str;

    StringBuilder compressed = new StringBuilder(finalLength);
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
      countConsecutive++;
      /*
       * **** If next char is different than current ****
       * ------------------------------------------------
       * Append this char to result.
       * -----------------------------------------------
       */
      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressed.append(str.charAt(i));
        compressed.append(countConsecutive);
        countConsecutive = 0;
      }
    }
    return compressed.toString();
  }

  int countCompression(String str) {
    int compressedLen = 0;
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
      countConsecutive++;
      /*
       * **** If next char is different than current ****
       * ------------------------------------------------
       * Increase the Lenght
       * -----------------------------------------------
       */
      if (i + 1 > str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressedLen += 1 + String.valueOf(countConsecutive).length();
        countConsecutive = 0;
      }
    }
    return compressedLen;
  }
}
