// 1.5

import java.io.*;

public class oneAway {
  public static void main(String[] args) {
    System.out.println("This is Empty");
  }

  /*
   * -------- Brute Force --------
   * Time - O(N)
   * Space - O(1)
   * -----------------------------------------
   */
  boolean oneEditAway(String first, String second) {

    if (first.length() == second.length()) {
      return oneEditReplace(first, second); // Condition - 1

    } else if (first.length() + 1 == second.length()) {
      return oneEditInsert(first, second); // Condition - 2
    } else if (first.length() - 1 == second.length()) {
      return oneEditInsert(second, first); // Condition - 2
    }
    return false;
  }

  /*
   * ------Condition_1------
   * REPLACEMENT
   * ------------------------
   */

  boolean oneEditReplace(String s1, String s2) {
    boolean foundDiffernce = false;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (foundDiffernce) return false;
        foundDiffernce = true;
      }
    }
    return true;
  }

  /*
   * ------Condition_2------
   * insertion
   * ------------------------
   */

  boolean oneEditInsert(String s1, String s2) {
    int idx1 = 0;
    int idx2 = 0;
    while (idx2 < s2.length() && idx1 < s1.length()) {
      if (s1.charAt(idx1) != s2.charAt(idx2)) {
        if (idx1 != idx2) return false;
        idx2++;
      } else {
        idx1++;
        idx2++;
      }
    }
    return true;
  }

  /*
   * -------- Both Conditions in Same Function --------
   * Time - O(N)
   * Space - O(1)
   * -----------------------------------------
   */

  boolean oneEditAway1(String first, String second) {

    /* Length Check */

    if (Math.abs(first.length() - second.length()) > 1) return false;

    /* Get Shorter and Longer String */
    String s1 = first.length() < second.length() ? first : second;
    String s2 = first.length() < second.length() ? second : first;

    int idx1 = 0;
    int idx2 = 0;

    boolean foundDiffernce = false;
    while (idx2 < s2.length() && idx1 < s1.length()) {
      if (s1.charAt(idx1) != s2.charAt(idx2)) {

        /* Ensure that this is the first diffeence found */

        if (foundDiffernce) return false;
        foundDiffernce = true;

        /* On replace, move shorter pointer */

        if (s1.length() == s2.length()) idx1++;

      } else {

        /* if Matching, move shorter pointer */

        idx1++;
      }

      /* Always move pointer for Longer String */

      idx2++;
    }
    return true;
  }
}
