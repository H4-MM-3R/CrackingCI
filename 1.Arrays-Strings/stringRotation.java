// 1.9

import java.io.*;

public class stringRotation {
  public static void main(String[] args) {
    System.out.println("This is Empty");
  }

  /*
   * -----------------
   * Time - O(N)
   * Space - O(N)
   * -----------------
   */
  boolean isRotation(String s1, String s2) {
    int len = s1.length();

    /*
     * Check that strings are equal lenght and not empty
     */
    if (len == s2.length() && len > 0) {

      /*
       * Concatenate s1 with itself within new buffer
       */
      String s1s1 = s1 + s1;
      return isSubsstring(s1s1, s2);
    }
    return false;
  }
}
