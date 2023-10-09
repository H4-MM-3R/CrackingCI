// 1.2

import java.io.*;
import java.util.Arrays;

public class checkPermutation {
  public static void main(String[] args) {
    System.out.println("This is Empty");
  }

  /*
   * -------- Sort the Strings --------
   * Time - O(N log N)
   * Space - O(N)
   * -----------------------------------------
   */
  boolean permutation(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    return sort(s).equals(sort(t));
  }

  String sort(String s) {
    char[] content = s.toCharArray();
    Arrays.sort(content);
    return new String(content);
  }

  /*
   * -------- Check Character Counts --------
   * Time - O(N) -----> { where N is max(s.length, t.length) }
   * Space - O(1)
   * -----------------------------------------
   */
  boolean permutation1(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] letters = new int[128]; // -----> Assuming chars are ASCII

    char[] s_array = s.toCharArray();
    for (cher c : s_array) { // -----> count number of each char in s.
      letters[c]++;
    }

    for (int i = 0; i < t.length(); i++) {
      int c = (int) t.charAt(1);
      letters[c]--;
      if (letters[c] < 0) {
        return false;
      }
    }
    return true;
  }
}
